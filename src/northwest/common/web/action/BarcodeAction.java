package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class BarcodeAction extends CommonActionSupport {
	String barcode;
	Member member;
	Group group;
	String selectmode, optionmode;
	String code;
	Long step;
	Freight freight;

	public Freight getFreight() {
		return freight;
	}

	public void setFreight(Freight freight) {
		this.freight = freight;
	}

	public JSONArray status() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jo = new JSONObject();
		try {
			String complete = getGenericManager().getBillScheduleByCode(code).getBillDetail().getComplete();
			jo.accumulate("complete", complete);

			String uncomplete = getGenericManager().getBillScheduleByCode(code).getBillDetail().getUncomplete();
			jo.accumulate("uncomplete", uncomplete);

			jsonArray.put(jo);
		} catch (Exception e) {
			System.out.println("status error =" + e.toString());
		}
		return jsonArray;
	}

	public JSONArray barcode() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jo = new JSONObject();
		try {
			String smode = "SELECT1,SELECT2,SELECT3,DELETE";
			if (smode.indexOf(barcode) != -1) {
				// System.out.println("smode..");
				if (barcode.equals("DELETE")) {
					getSession().setAttribute("optionmode", "DELETE");
				} else {
					// System.out.println("session="+barcode);
					getSession().setAttribute("selectmode", barcode);
					getSession().removeAttribute("optionmode");
				}
				jo.accumulate("returnValue", "mode");
				jo.accumulate("optionmode", String.valueOf(getSession().getAttribute("optionmode")));
				jo.accumulate("selectmode", String.valueOf(getSession().getAttribute("selectmode")));

			} else {
				int b = barcode.indexOf("-");
				if (b == -1) {
					Member user = getGenericManager().getMemberById(barcode);
					System.out.println("login user=" + user.getName());
					if (user != null) {
						getSession().setAttribute("user", copyToSessionUser(user));
						member = user;
						jo.accumulate("returnValue", "login-success");
						jo.accumulate("username", user.getName());
					} else {
						jo.accumulate("returnValue", "login-fail");
					}

				} else {
					selectmode = String.valueOf(getSession().getAttribute("selectmode"));
					// System.out.println("selectmode="+selectmode);

					if (selectmode.equals("null")) {
						jo.accumulate("returnValue", "barcode-error-selectmode");
					} else {

						SessionUser s = (SessionUser) getSession().getAttribute("user");
						if (s == null) {
							jo.accumulate("returnValue", "login-index");
						} else {
							BillSchedule billSchedule = getGenericManager().getBillScheduleByCode(barcode);
							
							System.out.println("barcode() billSchedule ===== " + billSchedule.getId());
							
							if (billSchedule.getId() != null) {

								Vector groups = groups(billSchedule);
								boolean previous = Boolean.parseBoolean(String.valueOf(groups.get(1)));

								System.out.println("previous=====" + previous + "---groups.get(1)=" + groups.get(1));

								// 如果護膜不再流程管控裡
								System.out.println("step=" + step);
								if (step != 0) {
									group = getGenericManager().getGroupById(step);
								}

								if (group != null) {
									if (selectmode.equals("SELECT1")) {
										List<JSONObject> al = select1(billSchedule);
										for (int i = 0; i < al.size(); i++) {
											jsonArray.put(al.get(i));
										}
									}

									if (selectmode.equals("SELECT2")) {
										JSONObject p = select2(billSchedule);
										jsonArray.put(p);
									}

									if (selectmode.equals("SELECT3")) {
										// System.out.println("barcode()
										// select3");
										List<JSONObject> al = select3(billSchedule);
										for (int i = 0; i < al.size(); i++) {
											jsonArray.put(al.get(i));
										}
									}

									jo.accumulate("groups", groups.get(0));
									jo.accumulate("billno", billSchedule.getBillDetail().getBillId());

								} else {

									if (previous == true) {

										if (selectmode.equals("SELECT1")) {
											List<JSONObject> al = select1(billSchedule);
											for (int i = 0; i < al.size(); i++) {
												jsonArray.put(al.get(i));
											}
										}

										if (selectmode.equals("SELECT2")) {
											System.out.println("previous==true - SELECT2");
											JSONObject p = select2(billSchedule);
											jsonArray.put(p);
										}

										if (selectmode.equals("SELECT3")) {
											// System.out.println("barcode()
											// select3");
											List<JSONObject> al = select3(billSchedule);
											for (int i = 0; i < al.size(); i++) {
												jsonArray.put(al.get(i));
											}
										}

										jo.accumulate("groups", groups.get(0));
										jo.accumulate("billno", billSchedule.getBillDetail().getBillId());

									} else {
										System.out.println("barcode() workflow-error");
										jo.accumulate("returnValue", "workflow-error");
									}

								}

							} else {
								jo.accumulate("returnValue", "barcode-fail");
							}
						}
					}
					getSession().removeAttribute("optionmode");
				}
			}
			jsonArray.put(jo);
		} catch (Exception e) {
			jo.accumulate("returnValue", "format-fail");
			jsonArray.put(jo);
			System.out.println("barcode error.." + e.toString());
		}
		return jsonArray;
	}

	public List<Group> getStepList(BillSchedule billSchedule) {
		List<BillAuthority> al = getGenericManager().getBillAuthorityListByBill(billSchedule.getBillDetail().getBill());
		ArrayList<Group> stepList = new ArrayList<Group>();
		for (int i = 0; i < al.size(); i++) {
			BillAuthority obj = (BillAuthority) al.get(i);
			Group g = obj.getGroup();
			stepList.add(g);
		}
		Collections.sort(stepList, new GroupComparator());
		return stepList;
	}

	public List<Group> getDeleteStepList(BillSchedule billSchedule) {
		return getGenericManager().getDeleteStepList(billSchedule);
	}

	public List<BillSchedule> sameProductItemMark(BillSchedule billSchedule) {
		List<BillSchedule> ls = getGenericManager().getSameProductItemMarkList(billSchedule);
		for (int i = 0; i < ls.size(); i++) {
			barcodeActive(ls.get(i));
		}
		return ls;
	}

	public void saveFreightJSON() {
		try {
			System.out.println("saveFreightJSON freight.id=" + freight.getId());
			freight = getGenericManager().getFreightById(freight.getId());
			getSession().setAttribute("freight", "freight");
		} catch (Exception e) {
			System.out.println("saveFreightJSON err=" + e.toString());
		}
	}

	// 單選
	public List<JSONObject> select1(BillSchedule billSchedule) {
		ArrayList<JSONObject> al = new ArrayList<JSONObject>();
		try {
			List<BillSchedule> ls = getGenericManager().getSameProductList(billSchedule);
			for (int i = 0; i < ls.size(); i++) {
				JSONObject p = new JSONObject();
				BillSchedule d = ls.get(i);
				Vector vc = barcodeActive(d);
				String memo = String.valueOf(vc.get(0));
				String optionCode = String.valueOf(vc.get(1));
				p.accumulate("returnValue", "barcode-success");
				p.accumulate("productNo", d.getBillDetail().getBill().getId());
				p.accumulate("productId", d.getBillDetail().getProduct().getId());
				p.accumulate("productName", d.getBillDetail().getProduct().getProductName());
				p.accumulate("fromRow", d.getBillDetail().getFromRow());
				p.accumulate("width", d.getBillDetail().getWidth());
				p.accumulate("heigh", d.getBillDetail().getHeigh());
				p.accumulate("visibleWidth", d.getBillDetail().getVisibleWidth());
				p.accumulate("visibleHeigh", d.getBillDetail().getVisibleHeigh());
				p.accumulate("quantity", d.getBillDetail().getQuantity());
				p.accumulate("itemRemark", d.getBillDetail().getItemRemark());
				p.accumulate("outputEquipment", d.getOutputEquipment() != null ? d.getOutputEquipment().getName() : "");
				p.accumulate("postProductionsEqt", d.getPostProductionsEqt() != null ? d.getPostProductionsEqt().getName() : "");
				String freight = d.getFreight() != null ? d.getFreight().getName() + "(" + d.getFreightNo() + ")" : "";
				p.accumulate("freight", freight);
				p.accumulate("memo", memo);
				p.accumulate("optionCode", optionCode);
				p.accumulate("code", d.getCode());
				al.add(p);
			}
		} catch (Exception e) {
			System.out.println("select1=" + e.toString());
		}
		return al;
	}

	// 單選
	public JSONObject select2(BillSchedule billSchedule) {
		JSONObject p = new JSONObject();
		try {
			System.out.println("select2..");
			Vector vc = barcodeActive(billSchedule);
			String memo = String.valueOf(vc.get(0));
			String optionCode = String.valueOf(vc.get(1));
			p.accumulate("returnValue", "barcode-success");
			p.accumulate("productNo", billSchedule.getBillDetail().getBill().getId());
			p.accumulate("productId", billSchedule.getBillDetail().getProduct().getId());
			p.accumulate("productName", billSchedule.getBillDetail().getProduct().getProductName());
			p.accumulate("fromRow", billSchedule.getBillDetail().getFromRow());
			p.accumulate("width", billSchedule.getBillDetail().getWidth());
			p.accumulate("heigh", billSchedule.getBillDetail().getHeigh());
			p.accumulate("visibleWidth", billSchedule.getBillDetail().getVisibleWidth());
			p.accumulate("visibleHeigh", billSchedule.getBillDetail().getVisibleHeigh());
			p.accumulate("quantity", billSchedule.getBillDetail().getQuantity());
			p.accumulate("itemRemark", billSchedule.getBillDetail().getItemRemark());
			p.accumulate("outputEquipment", billSchedule.getOutputEquipment() != null ? billSchedule.getOutputEquipment().getName() : "");
			p.accumulate("postProductionsEqt", billSchedule.getPostProductionsEqt() != null ? billSchedule.getPostProductionsEqt().getName() : "");
			String freight = billSchedule.getFreight() != null ? billSchedule.getFreight().getName() + "(" + billSchedule.getFreightNo() + ")" : "";
			p.accumulate("freight", freight);
			p.accumulate("memo", memo);
			p.accumulate("optionCode", optionCode);
			p.accumulate("code", billSchedule.getCode());

		} catch (Exception e) {
			System.out.println("select2=" + e.toString());
		}
		return p;

	}

	// 選取品名+細項描述
	public List<JSONObject> select3(BillSchedule billSchedule) {
		ArrayList<JSONObject> al = new ArrayList<JSONObject>();
		try {
			List<BillSchedule> ls = getGenericManager().getSameProductItemMarkList(billSchedule);
			System.out.println("select3 ls.size=" + ls.size());
			for (int i = 0; i < ls.size(); i++) {
				JSONObject p = new JSONObject();
				BillSchedule d = ls.get(i);
				// System.out.println(d.getId());
				Vector vc = barcodeActive(d);
				String memo = String.valueOf(vc.get(0));
				String optionCode = String.valueOf(vc.get(1));
				p.accumulate("returnValue", "barcode-success");
				p.accumulate("productNo", d.getBillDetail().getBill().getId());
				p.accumulate("productId", d.getBillDetail().getProduct().getId());
				p.accumulate("productName", d.getBillDetail().getProduct().getProductName());
				p.accumulate("fromRow", d.getBillDetail().getFromRow());
				p.accumulate("width", d.getBillDetail().getWidth());
				p.accumulate("heigh", d.getBillDetail().getHeigh());
				p.accumulate("visibleWidth", d.getBillDetail().getVisibleWidth());
				p.accumulate("visibleHeigh", d.getBillDetail().getVisibleHeigh());
				p.accumulate("quantity", d.getBillDetail().getQuantity());
				p.accumulate("itemRemark", d.getBillDetail().getItemRemark());
				p.accumulate("outputEquipment", d.getOutputEquipment() != null ? d.getOutputEquipment().getName() : "");
				p.accumulate("postProductionsEqt", d.getPostProductionsEqt() != null ? d.getPostProductionsEqt().getName() : "");
				String freight = d.getFreight() != null ? d.getFreight().getName() + "(" + d.getFreightNo() + ")" : "";
				p.accumulate("freight", freight);
				p.accumulate("memo", memo);
				p.accumulate("optionCode", optionCode);
				p.accumulate("code", d.getCode());
				al.add(p);
			}
		} catch (Exception e) {
			System.out.println("select3=" + e.toString());
		}
		return al;
	}

	public boolean getPass(String billScheduleId, String gid) {
		boolean result = false;
		try {
			Group group = getGenericManager().getGroupById(Long.parseLong(gid));
			BillSchedule billSchedule = getGenericManager().getBillScheduleById(billScheduleId);
			List ls = billSchedule.getBillDetail().getProduct().getProductClass().getExpectionFlows();
			if (ls != null) {
				result = ls.contains(group);
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public Vector groups(BillSchedule billSchedule) {
		String groups = "";
		boolean previous = false;

		Vector vc = new Vector();
		try {
			SessionUser s = (SessionUser) getSession().getAttribute("user");
			List<Group> ls = getStepList(billSchedule);
			for (int j = 0; j < ls.size(); j++) {
				Group g = ls.get(j);
				boolean auth = checkGroup(s, g.getGroupKey());
				System.out.println("groups g=" + g.getGroupKey());
				if (auth == true) {
					boolean enabledEdit = getGenericManager().isEnabledEdit(billSchedule, g);

					if (enabledEdit == true) {
						groups += g.getGroupName() + "、";
						previous = true;
					}

					System.out.println("GroupKey=" + g.getGroupKey() + "--auth=" + auth + "--enabledEdit=" + enabledEdit);
				} 
			}
		} catch (Exception e) {
			System.out.println("groups=" + e.toString());
		}
		vc.add(groups);
		vc.add(previous);
		return vc;
	}

	public Vector barcodeActive(BillSchedule billSchedule) {
		System.out.println("barcodeActive....");

		Vector vc = new Vector();
		String memo = "";
		String optionCode = "";
		try {
			SessionUser s = (SessionUser) getSession().getAttribute("user");
			String optionmode;
			List<Group> ls;
			try {
				optionmode = String.valueOf(getSession().getAttribute("optionmode"));
			} catch (Exception e) {
				optionmode = "";
			}

			if (optionmode.equals("DELETE")) {
				ls = getDeleteStepList(billSchedule);
			} else {
				ls = getStepList(billSchedule);
			}

			// 如果是流程權限
			if (step != 0) {
				group = getGenericManager().getGroupById(step);
				System.out.println("流程權限 group=" + group);
				ls = new ArrayList<Group>();
				ls.add(group);
			}

			System.out.println("ls.size()=" + ls.size());

			boolean barcode = true;
			for (int j = 0; j < ls.size(); j++) {
				Group g = ls.get(j);
				// 如果是護膜不卡流程
				if (g.getGroupKey().equals("cuticle")) {
					System.out.println("group is cuticle");
					if (optionmode.equals("DELETE")) {
						getGenericManager().saveBarcodeCuticle(billSchedule, s.getMember(), false);
						memo = "已刪除";
						optionCode = "delete";
					} else {
						getGenericManager().saveBarcodeCuticle(billSchedule, s.getMember(), true);
						memo = "已完成";
						optionCode = "barcode-ok";
					}
				} else {

					System.out.println("group is not cuticle");

					boolean auth = checkGroup(s, g.getGroupKey());
					
					System.out.println("group is not cuticle auth="+auth);
					
					if (auth == true) {
						boolean enabledEdit = getGenericManager().isEnabledEdit(billSchedule, g);
						
						System.out.println("group is not cuticle enabledEdit="+enabledEdit);
						
						if (enabledEdit == true) {
							Vector alreadyEdits = getGenericManager().isAlreadyEdits(billSchedule, g);
							// System.out.println(billSchedule.getId()+"--"+alreadyEdits.get(0)+"--"+alreadyEdits.get(1));
							// String
							// optionmode=String.valueOf(getSession().getAttribute("optionmode"));

							if (optionmode.equals("DELETE")) {
								boolean deleteAuth = getGenericManager().Checker(billSchedule, s.getMember(), g);
								// System.out.println("deleteAuth="+deleteAuth);
								if (deleteAuth == true) {
									getGenericManager().deleteBarcode(billSchedule, g);
									memo = "已刪除";
									optionCode = "delete";
								} else {
									memo += String.valueOf(alreadyEdits.get(1));
									optionCode = "delete-fail";
								}
							} else {
								boolean r = Boolean.parseBoolean(String.valueOf(alreadyEdits.get(0)));
								// 已有人完成不能覆蓋要顯示
								if (r == true) {
									memo = String.valueOf(alreadyEdits.get(1));
									optionCode = "overwrite-fail";

									// 後製
									try {
										OutputEquipment outputEquipment = (OutputEquipment) getSession().getAttribute("outputEquipment");
										if (outputEquipment != null && g.getGroupKey().equals("CK09")) {
											PostProductions(billSchedule, s.getMember());
										}
									} catch (Exception e) {
										System.out.println("saveOutputEquipment 後製 err=" + e.toString());
									}

									// 出件
									try {
										Freight freight = (Freight) getSession().getAttribute("freight");
										String freightNo = (String) getSession().getAttribute("freightNo");
										if (freight != null && g.getGroupKey().equals("CK11")) {
											saveFreight(billSchedule, freight, freightNo);
										}
									} catch (Exception e) {
										System.out.println("saveOutputEquipment 後製 err=" + e.toString());
									}

								} else { // 沒有人已完成才可以覆蓋

									if (barcode) {
										getGenericManager().saveBarcode(billSchedule, s.getMember(), g);

										// 輸出
										try {
											OutputEquipment outputEquipment = (OutputEquipment) getSession().getAttribute("outputEquipment");
											if (outputEquipment != null && g.getGroupKey().equals("CK07")) {
												System.out.println("barcode / outputEquipment.name =" + outputEquipment.getName());
												billSchedule.setOutputEquipment(outputEquipment);
												getGenericManager().saveBillSchedule(billSchedule);
											}
										} catch (Exception e) {
											System.out.println("saveOutputEquipment 輸出 err=" + e.toString());
										}

										// 後製
										try {
											OutputEquipment outputEquipment = (OutputEquipment) getSession().getAttribute("outputEquipment");
											if (outputEquipment != null && g.getGroupKey().equals("CK09")) {
												PostProductions(billSchedule, s.getMember());
											}
										} catch (Exception e) {
											System.out.println("saveOutputEquipment 後製 err=" + e.toString());
										}

										// 出件
										try {
											Freight freight = (Freight) getSession().getAttribute("freight");
											String freightNo = (String) getSession().getAttribute("freightNo");
											if (freight != null && g.getGroupKey().equals("CK11")) {
												saveFreight(billSchedule, freight, freightNo);
											}
										} catch (Exception e) {
											System.out.println("saveOutputEquipment 後製 err=" + e.toString());
										}
										barcode = false;
									}
									memo = "已完成";
									optionCode = "barcode-ok";

								}
							}
						} else {
							memo = "上一個步驟尚未完成!";
							optionCode = "workflow-error";
						}
						// System.out.println("GroupKey="+g.getGroupKey()+"--auth="+auth+"--enabledEdit="+enabledEdit);
					}

				}

			}
			System.out.println("--------------------------------------------");

		} catch (Exception e) {
			System.out.println("barcodeActive error=" + e.toString());
		}
		vc.add(memo);
		vc.add(optionCode);
		return vc;
	}

	public void saveFreight(BillSchedule billSchedule, Freight freight, String freightNo) {
		try {
			billSchedule.setFreight(freight);
			billSchedule.setFreightNo(freightNo);
			getGenericManager().saveBillSchedule(billSchedule);
		} catch (Exception e) {
			System.out.println("saveFreight 出件 err=" + e.toString());
		}
	}

	public void PostProductions(BillSchedule billSchedule, Member member) {
		try {
			System.out.println("saveOutputEquipment " + billSchedule.getId());
			OutputEquipment outputEquipment = (OutputEquipment) getSession().getAttribute("outputEquipment");
			if (outputEquipment != null) {
				System.out.println("barcode / outputEquipment.name =" + outputEquipment.getName());
				billSchedule.setPostProductionsEqt(outputEquipment);
				getGenericManager().saveBillSchedule(billSchedule);
			}

			// 如果是後製,可多人選取
			PostProductions p = new PostProductions();
			p.setMember(member);
			p.setBillschedule(billSchedule);
			p.setCreatedDate(Tools.getCurrentTimestamp());
			getGenericManager().savePostProductions(p);

		} catch (Exception e) {
			System.out.println("saveOutputEquipment 後製 err=" + e.toString());
		}
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getSelectmode() {
		return selectmode;
	}

	public void setSelectmode(String selectmode) {
		this.selectmode = selectmode;
	}

	public String getOptionmode() {
		return optionmode;
	}

	public void setOptionmode(String optionmode) {
		this.optionmode = optionmode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getStep() {
		return step;
	}

	public void setStep(Long step) {
		this.step = step;
	}

	public String list() {
		return SUCCESS;
	}

	// 擁有流程權限
	public List<JSONObject> getUserOwnStepList() {
		ArrayList<JSONObject> al = new ArrayList<JSONObject>();
		try {
			SessionUser s = (SessionUser) getSession().getAttribute("user");
			ArrayList<Group> ls = new ArrayList<Group>();
			ls.add(getGenericManager().getGroupByGroupKey("CK06"));
			ls.add(getGenericManager().getGroupByGroupKey("CK07"));
			ls.add(getGenericManager().getGroupByGroupKey("cuticle"));
			ls.add(getGenericManager().getGroupByGroupKey("CK09"));
			ls.add(getGenericManager().getGroupByGroupKey("CK10"));
			Collections.sort(ls, new GroupComparator());
			for (int i = 0; i < ls.size(); i++) {
				Group g = ls.get(i);
				boolean auth = checkGroup(s, g.getGroupKey());
				if (auth == true) {
					JSONObject p = new JSONObject();
					p.accumulate("id", g.getId());
					p.accumulate("groupName", g.getGroupNameCh());
					al.add(p);
				}
			}
		} catch (Exception e) {
			System.out.println("getUserOwnStepList error=" + e.toString());
		}
		return al;
	}

}
