package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.*;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.base.value.*;
import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.opensymphony.xwork.ActionContext;
import com.base.httpupload4j.SmartUpload;
import com.base.util.Tools;
import com.base.value.Function;

public class BillAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Bill bill;
	private BillFiles billFiles;
	private String[] stepIds;
	private Long[] billGroupAuthorityIds, drawingsFilesIds;
	private Set<Group> newGroups = new HashSet();
	private String[] billDetailIds;
	private java.io.File fileImageDiagram;
	private String fileImageDiagramContentType, fileImageDiagramFileName, removeImageDiagram;
	private java.io.File fileCheckDiagram;
	private String fileCheckDiagramContentType, fileCheckDiagramFileName, removeCheckDiagram;
	private java.io.File fileCompletionphoto1;
	private BillSchedule billSchedule;
	private CustomerDetail customerDetail;
	private String completionTime, check2, check5, productId, outputTime, productionTime, deliveryTime, arrival,
			uploadDrawingsTime, customerId = "";
	private java.io.File fileDrawing;
	private String fileDrawingContentType, fileDrawingFileName, removeDrawing;
	private int condition, xorx;
	private String billNo = "", cfinish;
	private Product product = new Product();
	private Long groupId;
	private String productName;
	private Group group;
	private int state;
	private int count = 1;
	private BillFinish finish;
	private String id, pageName, pageNo;
	private java.io.File fileDoc1;
	private String fileDoc1ContentType, fileDoc1FileName, removeDoc1;
	private java.io.File fileDoc2;
	private String fileDoc2ContentType, fileDoc2FileName, removeDoc2;
	private java.io.File fileDoc3;
	private String fileDoc3ContentType, fileDoc3FileName, removeDoc3;
	private java.io.File fileDoc4;
	private String fileDoc4ContentType, fileDoc4FileName, removeDoc4;
	private java.io.File fileDoc5;
	private String fileDoc5ContentType, fileDoc5FileName, removeDoc5;
	private java.io.File fileDoc6;
	private String fileDoc6ContentType, fileDoc6FileName, removeDoc6;
	boolean status;
	int myPageIndex = 0, myPageSize = 0;
	int fromRow1 = 0, fromRow2 = 0;
	String startDate, endDate;

	public BillAction() {
		log = LogFactory.getLog(northwest.common.web.action.BillAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("BILL");
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill val) {
		bill = val;
	}

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String edit() {
		if (bill == null) {
			bill = new Bill();
		} else if (bill.getId() != null) {
			bill = getGenericManager().getBillById(bill.getId());
		} else {
		}
		beanToForm();
		checkBillFinish(); // 判斷是否結案

		try {
			billSchedule = getGenericManager().getBillScheduleById(billSchedule.getId());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return SUCCESS;
	}

	public void checkBillFiles() {
		billFiles = getGenericManager().getBillFilesByBill(bill);
		System.out.println("checkBillFiles()...");
		if (billFiles == null) {
			billFiles = new BillFiles();
			billFiles.setBill(bill);
			getGenericManager().saveBillFilesByBill(billFiles);
		} else {
			System.out.println("billfiles!=null");
		}
		System.out.println("checkBillFiles billFiles.id=" + billFiles.getId() + "--billFiles.getBill().getId()="
				+ billFiles.getBill().getId());
	}

	public String edit1() {
		System.out.println("edit1()..");
		if (bill == null) {
			bill = new Bill();
		} else if (bill.getId() != null) {
			bill = getGenericManager().getBillById(bill.getId());
		} else {
		}
		beanToForm();
		getSession().removeAttribute("checkfinish");
		// checkBillFinish();

		checkBillFiles(); // 訂單客戶提供資料

		System.out.println("edit1() billFiles.id=" + billFiles.getId() + "--billFiles.getBill().getId()="
				+ billFiles.getBill().getId());

		return SUCCESS;
	}

	public String editDrawing() {
		if (bill == null) {
			bill = new Bill();
		} else if (bill.getId() != null) {
			bill = getGenericManager().getBillById(bill.getId());
		}

		System.out.println("editDrawing() billSchedule.getBillDetailId()=" + billSchedule.getBillDetailId());
		billSchedule = getGenericManager().getBillScheduleById(billSchedule.getBillDetailId());

		System.out.println("editDrawing....bill.getId()=" + bill.getId());
		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		formToBean();
		return SUCCESS;
	}

	public String save() {
		appendXworkParam("bill.id=" + bill.getId());
		checkBillFinish(); // 判斷是否結案
		saveFileToLocal(fileDoc1FileName, fileDoc1, getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getId());
		saveFileToLocal(fileDoc2FileName, fileDoc2, getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getId());
		saveFileToLocal(fileDoc3FileName, fileDoc3, getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getId());
		saveFileToLocal(fileDoc4FileName, fileDoc4, getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getId());
		saveFileToLocal(fileDoc5FileName, fileDoc5, getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getId());
		saveFileToLocal(fileDoc6FileName, fileDoc6, getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getId());
		getGenericManager().saveBillFiles(billFiles);
		return SUCCESS;
	}

	public void checkBillFinish() {
		/*
		 * cfinish=(String)getSession().getAttribute("checkfinish");
		 * System.out.println("cfinish="+cfinish); if(cfinish == null ){
		 * List<Group> groups=getObject_BillGroupAuthorityList();
		 * if(groups!=null &&groups.size()>0){
		 * group=groups.get(groups.size()-1);
		 * System.out.println("checkBillFinish group="+group.getGroupKey());
		 * //判斷是否全部處理完畢 List<BillDetail>
		 * al=getGenericManager().getBillScheduleListByCondition
		 * (Long.parseLong(group.getGroupNameEn()),null,false);
		 * 
		 * finish=getGenericManager().getBillFinishByBill(bill);
		 * if(al.size()==0){ System.out.println(bill.getId()+" 已結案..!");
		 * 
		 * if(finish==null){ finish =new BillFinish(); finish.setBill(bill);
		 * finish.setCreatedDate(Tools.getCurrentTimestamp());
		 * getGenericManager().saveBillFinish(finish); } }else{
		 * if(finish!=null){ getGenericManager().removeBillFinish(finish); }
		 * System.out.println(bill.getId()+"未結案!"); } //判斷是否全部處理完畢 } }
		 */
	}

	public boolean isBillFinish(String id) {
		bill = getGenericManager().getBillById(id);
		finish = getGenericManager().getBillFinishByBill(bill);
		if (finish != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public boolean inputValidation(Bill val) {
		return true;
	}

	public String[] getStepIds() {
		return stepIds;
	}

	public void setStepIds(String[] stepIds) {
		this.stepIds = stepIds;
	}

	public String queryBillList() {
		// 預設顯示自己的群組
		getSession().setAttribute("checkfinish", "1");
		if (groupId == null) {
			group = getMemberRole();
			groupId = group.getId();
		}
		// 預設顯示自己的群組
		System.out.println("queryBillList groupId=" + groupId);
		return SUCCESS;
	}

	public String list() {
		if (condition == 0) {
			condition = 2;
		}
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		billAuthority(); // 新增訂單流程設定
		// groupBillAuthority(); //新增訂單群組流程設定
		stepflow(); // 流程進度設定

		billFiles = getGenericManager().getBillFilesById(billFiles.getId());

		if (getRemoveDoc1() != null && getRemoveDoc1().length() > 0) {
			billFiles.setDoc1(computeUploadedFile(fileDoc1FileName, fileDoc1));
			removeUploadedFile(getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getDoc1Id(),
					billFiles.getDoc1FileName());
		} else {
			if (billFiles.getDoc1Id() != null)
				billFiles.setDoc1(getGenericManager().getUploadedFileById(billFiles.getDoc1Id()));
			else
				billFiles.setDoc1(computeUploadedFile(fileDoc1FileName, fileDoc1));
		}

		if (getRemoveDoc2() != null && getRemoveDoc2().length() > 0) {
			billFiles.setDoc2(computeUploadedFile(fileDoc2FileName, fileDoc2));
			removeUploadedFile(getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getDoc2Id(),
					billFiles.getDoc2FileName());
		} else {
			if (billFiles.getDoc2Id() != null)
				billFiles.setDoc2(getGenericManager().getUploadedFileById(billFiles.getDoc2Id()));
			else
				billFiles.setDoc2(computeUploadedFile(fileDoc2FileName, fileDoc2));
		}

		if (getRemoveDoc3() != null && getRemoveDoc3().length() > 0) {
			billFiles.setDoc3(computeUploadedFile(fileDoc3FileName, fileDoc3));
			removeUploadedFile(getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getDoc3Id(),
					billFiles.getDoc3FileName());
		} else {
			if (billFiles.getDoc3Id() != null)
				billFiles.setDoc3(getGenericManager().getUploadedFileById(billFiles.getDoc3Id()));
			else
				billFiles.setDoc3(computeUploadedFile(fileDoc3FileName, fileDoc3));
		}

		if (getRemoveDoc4() != null && getRemoveDoc4().length() > 0) {
			billFiles.setDoc4(computeUploadedFile(fileDoc4FileName, fileDoc4));
			removeUploadedFile(getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getDoc4Id(),
					billFiles.getDoc4FileName());
		} else {
			if (billFiles.getDoc4Id() != null)
				billFiles.setDoc4(getGenericManager().getUploadedFileById(billFiles.getDoc4Id()));
			else
				billFiles.setDoc4(computeUploadedFile(fileDoc4FileName, fileDoc4));
		}

		if (getRemoveDoc5() != null && getRemoveDoc5().length() > 0) {
			billFiles.setDoc5(computeUploadedFile(fileDoc5FileName, fileDoc5));
			removeUploadedFile(getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getDoc5Id(),
					billFiles.getDoc5FileName());
		} else {
			if (billFiles.getDoc5Id() != null)
				billFiles.setDoc5(getGenericManager().getUploadedFileById(billFiles.getDoc5Id()));
			else
				billFiles.setDoc5(computeUploadedFile(fileDoc5FileName, fileDoc5));
		}

		if (getRemoveDoc6() != null && getRemoveDoc6().length() > 0) {
			billFiles.setDoc6(computeUploadedFile(fileDoc6FileName, fileDoc6));
			removeUploadedFile(getTextWithArgs("billFiles.uploadDoc.dir"), billFiles.getDoc6Id(),
					billFiles.getDoc6FileName());
		} else {
			if (billFiles.getDoc6Id() != null)
				billFiles.setDoc6(getGenericManager().getUploadedFileById(billFiles.getDoc6Id()));
			else
				billFiles.setDoc6(computeUploadedFile(fileDoc6FileName, fileDoc6));
		}

	}

	public String saveStep() {
		stepflow(); // 流程進度設定

		// 預設顯示自己的群組
		condition = 1;
		group = getMemberRole();
		groupId = group.getId();
		// 預設顯示自己的群組

		return SUCCESS;
	}

	public void stepflow() {

		if (stepIds != null) {
			for (int i = 0; i < stepIds.length; i++) {
				String u = stepIds[i];
				String step = u.substring(u.indexOf("*") + 1, u.length());
				String id = u.substring(0, u.indexOf("*"));
				System.out.println(id + "--" + step);
				BillSchedule obj = getGenericManager().getBillScheduleById(id);
				SessionUser s = (SessionUser) getSession().getAttribute("user");
				Member member = s.getMember();
				Date now = Tools.getCurrentTimestamp();
				Long groupId = 0L;
				switch (Integer.parseInt(step)) {
				case 1:
					groupId = 6L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep1() == false) {
						obj.setStep1(true);
						obj.setCheck1(now);
						obj.setChecker1(member);
					}
					break;
				case 2:
					groupId = 7L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep2() == false) {
						obj.setStep2(true);
						obj.setCheck2(now);
						obj.setChecker2(member);
					}
					break;
				case 3:
					groupId = 8L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep3() == false) {
						obj.setStep3(true);
						obj.setCheck3(now);
						obj.setChecker3(member);
					}
					break;
				case 4:
					groupId = 9L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep4() == false) {
						obj.setStep4(true);
						obj.setCheck4(now);
						obj.setChecker4(member);
					}
					break;
				case 5:
					groupId = 10L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep5() == false) {
						obj.setStep5(true);
						obj.setCheck5(now);
						obj.setChecker5(member);
					}
					break;
				case 6:
					groupId = 11L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep6() == false) {
						obj.setStep6(true);
						obj.setCheck6(now);
						obj.setChecker6(member);
					}
					break;
				case 7:
					groupId = 12L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep7() == false) {
						obj.setStep7(true);
						obj.setCheck7(now);
						obj.setChecker7(member);
					}
					break;
				case 8:
					groupId = 13L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep8() == false) {
						obj.setStep8(true);
						obj.setCheck8(now);
						obj.setChecker8(member);
					}
					break;
				case 9:
					groupId = 14L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep9() == false) {
						obj.setStep9(true);
						obj.setCheck9(now);
						obj.setChecker9(member);
					}
					break;
				case 10:
					groupId = 15L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep10() == false) {
						obj.setStep10(true);
						obj.setCheck10(now);
						obj.setChecker10(member);
					}
					break;
				case 11:
					groupId = 17L;
					if (getGenericManager().isSettingPermissions(member,
							getGenericManager().getGroupById(groupId)) == false && obj.getStep11() == false) {
						obj.setStep11(true);
						obj.setCheck11(now);
						obj.setChecker11(member);
					}
					break;

				}
				getGenericManager().saveBillSchedule(obj);
			}
		}
	}

	public void billAuthority() {
		System.out.println("billAuthority()..");

		// remove
		List<BillAuthority> b = getGenericManager().getBillAuthorityListByBill(bill);
		for (int i = 0; i < b.size(); i++) {
			BillAuthority obj = (BillAuthority) b.get(i);
			getGenericManager().removeBillAuthority(obj);
		}
		// add
		Set groups = getGenericManager().getGroupListByIds(billGroupAuthorityIds);
		if (groups != null) {
			Iterator i = groups.iterator();
			while (i.hasNext()) {
				Group g = (Group) i.next();
				String groupKey = g.getGroupKey();
				int step = Integer.parseInt(groupKey.substring(2, 4));
				// System.out.println("groupKey="+groupKey+"----step="+step);
				BillAuthority ba = new BillAuthority();
				ba.setBill(bill);
				ba.setGroup(g);
				getGenericManager().saveBillAuthority(ba);
			}
		}

	}

	public void groupBillAuthority() {
		// remove
		List<BillDetail> d1 = getGenericManager().getBillDetailListByBillNo(bill.getId());
		for (int k = 0; k < d1.size(); k++) {
			BillDetail obj = (BillDetail) d1.get(k);
			BillSchedule s = getGenericManager().getBillScheduleByBillDetail(obj);
			s.setStep1(false);
			s.setStep2(false);
			s.setStep3(false);
			s.setStep4(false);
			s.setStep5(false);
			s.setStep6(false);
			s.setStep7(false);
			s.setStep8(false);
			s.setStep9(false);
			s.setStep10(false);
			s.setStep11(false);
			s.setStep12(false);
			getGenericManager().saveBillSchedule(s);

		}

		// add
		Set groups = getGenericManager().getGroupListByIds(billGroupAuthorityIds);
		if (groups != null) {
			Iterator i = groups.iterator();
			while (i.hasNext()) {
				Group g = (Group) i.next();
				String groupKey = g.getGroupKey();
				int step = Integer.parseInt(groupKey.substring(2, 4));
				// System.out.println("groupKey="+groupKey+"----step="+step);

				List<BillDetail> d = getGenericManager().getBillDetailListByBillNo(bill.getId());
				for (int j = 0; j < d.size(); j++) {
					BillDetail obj = (BillDetail) d.get(j);
					BillSchedule s = getGenericManager().getBillScheduleByBillDetail(obj);
					switch (step) {
					case 1:
						s.setStep1(true);
						break;
					case 2:
						s.setStep2(true);
						break;
					case 3:
						s.setStep3(true);
						break;
					case 4:
						s.setStep4(true);
						break;
					case 5:
						s.setStep5(true);
						break;
					case 6:
						s.setStep6(true);
						break;
					case 7:
						s.setStep7(true);
						break;
					case 8:
						s.setStep8(true);
						break;
					case 9:
						s.setStep9(true);
						break;
					case 10:
						s.setStep10(true);
						break;
					case 11:
						s.setStep11(true);
						break;
					case 12:
						s.setStep12(true);
						break;
					}
					// 更新步驟
					getGenericManager().saveBillSchedule(s);
				}
				// 更新步驟
			}
		}

	}

	public List<Customer> getCustomerList() {
		return getGenericManager().getCustomerList(); // TODO
	}

	public List<Bill> getBillList() {
		int pageIndex = getPageIndex();
		int pageSize = getPageSize();

		Customer customer = getGenericManager().getCustomerById(customerId);

		// test

		System.out
				.println("startDate=" + startDate + "--endDate=" + endDate + "--state=" + state + "--billNo=" + billNo);

		List<Bill> al = getGenericManager().getBillListByCondition(customer, billNo.trim(), state, startDate, endDate,
				pageSize, pageIndex);
		int resultSize = getGenericManager().getBillListByCondition(customer, billNo.trim(), state, startDate, endDate);
		getSession().setAttribute("RESULT_SIZE", new Integer(resultSize));

		return al;
	}

	public List<Group> getStepList(BillSchedule billSchedule) {
		List<BillAuthority> al = getGenericManager().getBillAuthorityListByBill(billSchedule.getBillDetail().getBill());
		ArrayList<Group> stepList = new ArrayList<Group>();
		for (int i = 0; i < al.size(); i++) {
			BillAuthority obj = (BillAuthority) al.get(i);
			Group g = obj.getGroup();
			stepList.add(g);
		}
		return stepList;
	}

	public List<BillDetail> getBillDetailListByBillNo(String BillNo, String groupId) {
		ArrayList<BillDetail> ls = new ArrayList<BillDetail>();
		List<BillDetail> al = getGenericManager().getBillDetailListByBillNo(BillNo);
		Group group = getGenericManager().getGroupById(Long.parseLong(groupId));

		int j = 1;
		for (int i = 0; i < al.size(); i++) {
			BillDetail b = al.get(i);
			BillSchedule s = getGenericManager().getBillScheduleByBillDetail(b);
			boolean result, result1, result2, result3;
			// 是否ByPass
			result = getPass(b.getId(), groupId);

			// 上一步驟是否已確認
			result1 = false;
			result2 = false;

			// 判斷是否第一步驟
			Group firstGroup = getStepList(s).get(0);

			// 如果上一個流程未完成不能修改
			Group g = getGenericManager().previousStep(s, group);
			int step = Integer.parseInt(g.getGroupNameEn());
			switch (step) {
			case 1:
				result1 = s.getStep1();
				break;
			case 2:
				result1 = s.getStep2();
				break;
			case 3:
				result1 = s.getStep3();
				break;
			case 4:
				result1 = s.getStep4();
				break;
			case 5:
				result1 = true;
				// result1=s.getStep5();
				break;
			case 6:
				result1 = s.getStep6();
				break;
			case 7:
				result1 = s.getStep7();
				break;
			case 8:
				result1 = s.getStep8();
				break;
			case 9:
				result1 = s.getStep9();
				break;
			case 10:
				result1 = s.getStep10();
				break;
			case 11:
				result1 = s.getStep11();
				break;
			case 12:
				result1 = s.getStep12();
				break;
			}

			// 如果該流程已經選過就不要出現
			int step1 = Integer.parseInt(group.getGroupNameEn());
			switch (step1) {
			case 1:
				result2 = s.getStep1();
				break;
			case 2:
				result2 = s.getStep2();
				break;
			case 3:
				result2 = s.getStep3();
				break;
			case 4:
				result2 = s.getStep4();
				break;
			case 5:
				result2 = false;
				// result1=s.getStep5();
				break;
			case 6:
				result2 = s.getStep6();
				break;
			case 7:
				result2 = s.getStep7();
				break;
			case 8:
				result2 = s.getStep8();
				break;
			case 9:
				result2 = s.getStep9();
				break;
			case 10:
				result2 = s.getStep10();
				break;
			case 11:
				result2 = s.getStep11();
				break;
			case 12:
				result2 = s.getStep12();
				break;
			}

			// 如果是第一個步驟
			if (firstGroup.getGroupKey().equals(group.getGroupKey())) {
				result1 = true;
			}
			
			//如果上個流程PASS就OK
			boolean previousStepPasss=getPass(b.getId(), String.valueOf(g.getId()));
			if(previousStepPasss){
				result1 = true;
			}

			System.out.println("s.getId()=" + s.getId() +  "FromRow=" + s.getBillDetail().getFromRow()  + "---result=" + result + "--result1=" + result1 + "-result2="
					+ result2 + "--g=" + g.getGroupName() + "--firstGroup=" + firstGroup.getGroupName() + "--group="
					+ group.getGroupName());

			if (result == false && result1 == true && result2 == false) {
				ls.add(b);
				j++;
			}

		}
		return ls;
	}

	public List<BillDetail> getSelectedBillDetailIds(String BillNo, String groupId) {
		ArrayList<BillDetail> ls = new ArrayList<BillDetail>();
		List<BillDetail> al = getGenericManager().getBillDetailListByBillNo(BillNo);
		Group group = getGenericManager().getGroupById(Long.parseLong(groupId));

		int j = 1;
		for (int i = 0; i < al.size(); i++) {
			BillDetail b = al.get(i);
			BillSchedule s = getGenericManager().getBillScheduleById(b.getId());
			boolean result, result1;
			result = getPass(b.getId(), groupId);
			/****/
			result1 = false;
			switch (Integer.parseInt(group.getGroupNameEn())) {
			case 1:
				result1 = s.getStep1();
				break;
			case 2:
				result1 = s.getStep2();
				break;
			case 3:
				result1 = s.getStep3();
				break;
			case 4:
				result1 = s.getStep4();
				break;
			case 5:
				result1 = s.getStep5();
				break;
			case 6:
				result1 = s.getStep6();
				break;
			case 7:
				result1 = s.getStep7();
				break;
			case 8:
				result1 = s.getStep8();
				break;
			case 9:
				result1 = s.getStep9();
				break;
			case 10:
				result1 = s.getStep10();
				break;
			case 11:
				result1 = s.getStep11();
				break;
			case 12:
				result1 = s.getStep12();
				break;
			}
			if (result == false && result1 == true) {
				ls.add(b);
				// System.out.println(j+":"+b.getProduct().getProductName());
				j++;
			}
			// System.out.println(b.getId());
		}
		return ls;
	}

	/*
	 * public List<BillDetail> getBillDetailListByBillNo(String BillNo,String
	 * groupId){ int pageIndex=getPageIndex(); int pageSize=getPageSize();
	 * List<BillDetail> al;
	 * 
	 * ArrayList<BillDetail> ls=new ArrayList<BillDetail>();
	 * getSession().removeAttribute("products");
	 * bill=getGenericManager().getBillById(BillNo);
	 * al=getGenericManager().getBillDetailListByBillNo
	 * (bill,pageSize,pageIndex); //排除BYPASS
	 * System.out.println("getBillDetailListByBillNo..."); for(int
	 * i=0;i<al.size();i++){ BillDetail b=al.get(i);
	 * System.out.println(b.getId()); } System.out.println("----------------");
	 * for(int i=0;i<al.size();i++){ BillDetail b=al.get(i); boolean result;
	 * result=getPass(b.getId(),groupId);
	 * System.out.println(b.getId()+"--"+result); if(result==false){ ls.add(b);
	 * } } //排除BYPASS int
	 * resultSize=getGenericManager().getBillDetailListByBillNo(BillNo).size();
	 * getSession().setAttribute("RESULT_SIZE", new Integer(resultSize));
	 * getSession().setAttribute("products", ls); return ls; }
	 */

	public int getBillDetailListByBill(String BillNo) {
		return getGenericManager().getBillDetailListByBillNo(BillNo).size();
	}

	public List<BillDetail> getBillDetailListByBillNo(String BillNo) {
		int pageIndex = getPageIndex();
		int pageSize = getPageSize();
		myPageIndex = getPageIndex();
		myPageSize = getPageSize();
		List<BillDetail> al;
		getSession().removeAttribute("products");
		bill = getGenericManager().getBillById(BillNo);
		Member w = null;
		try {
			w = getGenericManager().getMemberById(billSchedule.getWorkerId());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		int resultSize;
		if (w != null) {
			System.out.println("w=" + w.getName());
			al = getGenericManager().getBillDetailListByBillNo(bill, pageSize, pageIndex, w);
			resultSize = getGenericManager().getBillDetailListByBillNoWorker(bill, w);
		} else {
			System.out.println("w==null");
			al = getGenericManager().getBillDetailListByBillNo(bill, pageSize, pageIndex);
			resultSize = getGenericManager().getBillDetailListByBillNo(BillNo).size();
		}
		// al=getGenericManager().getBillDetailListByBillNo(bill,pageSize,pageIndex);
		getSession().setAttribute("RESULT_SIZE", new Integer(resultSize));
		getSession().setAttribute("products", al);

		if (fromRow1 != 0 && fromRow2 != 0) {
			System.out.println("BillAction fromRow1=" + fromRow1 + "---fromRow2=" + fromRow2);
			al = getGenericManager().getBillDetailListByBillNo(BillNo, fromRow1, fromRow2);
		}

		return al;
	}

	public List<BillDetail> getBillDetailListByProducts() {
		List<BillDetail> al;
		al = (List<BillDetail>) getSession().getAttribute("products");
		return al;
	}

	public List<BillDetail> getBillDetailListByProducts(String groupId) {
		List<BillDetail> obj = (List<BillDetail>) getSession().getAttribute("products");
		return obj;
	}

	/*
	 * public List<BillDetail> getBillDetailListByProducts(String groupId){
	 * ArrayList<BillDetail> ls =new ArrayList<BillDetail>(); boolean r;
	 * List<BillDetail>
	 * obj=(List<BillDetail>)getSession().getAttribute("products");
	 * 
	 * int pageIndex=getPageIndex(); int pageSize=getPageSize();
	 * List<BillDetail> al=obj;
	 * //System.out.println("pageIndex="+pageIndex+"---pageSize="+pageSize);
	 * //List<BillDetail> al=obj.subList(pageSize * pageIndex, pageSize);
	 * group=getGenericManager().getGroupById(Long.parseLong(groupId)); for(int
	 * i=0;i<al.size();i++){ BillDetail b=al.get(i);
	 * r=b.getProduct().getProductClass().getExpectionFlows().contains(group);
	 * if(r==false){ ls.add(b); } }
	 * 
	 * int toIndex,formIndex; if( (ls.size()-(pageSize * pageIndex))<pageSize ){
	 * toIndex=(pageSize * pageIndex) + (ls.size()-(pageSize * pageIndex));
	 * }else{ toIndex=(pageSize * pageIndex)+pageSize; } formIndex=pageSize *
	 * pageIndex;
	 * //System.out.println("al.size="+ls.size()+"  formIndex="+(pageSize *
	 * pageIndex)+"  toIndex="+toIndex); return ls.subList(formIndex, toIndex);
	 * }
	 */

	public BillSchedule getBillSchedule() {
		return billSchedule;
	}

	public void setBillSchedule(BillSchedule billSchedule) {
		this.billSchedule = billSchedule;
	}

	public void setInitialBillSchedule(String id) {
		getGenericManager().initialBillSchedule(id);
	}

	public BillSchedule getBillScheduleById(String id) {
		BillSchedule b = getGenericManager().getBillScheduleById(id);
		// System.out.println("getBillScheduleById count="+count);
		count++;
		return b;
	}

	public List<Group> getBillGroupAuthorityList() {
		List groups = getGenericManager().getBillGroupAuthority();
		groups.removeAll(getObject_BillGroupAuthorityList());
		return groups;
	}

	public List<Group> getGroupList() {
		List groups = getGenericManager().getBillGroupAuthority();
		group = getGenericManager().getGroupByGroupKey("CK12");
		groups.remove(group);
		return groups;
	}

	public List<Group> getObject_BillGroupAuthorityList() {
		ArrayList<Group> al = new ArrayList<Group>();
		ArrayList<String> ts = new ArrayList<String>();
		List<BillAuthority> ba = getGenericManager().getBillAuthorityListByBill(bill);
		for (int i = 0; i < ba.size(); i++) {
			BillAuthority b = (BillAuthority) ba.get(i);
			Group g = b.getGroup();
			ts.add(g.getGroupKey());
		}
		Collections.sort(ts);

		for (int j = 0; j < ts.size(); j++) {
			Group g = getGenericManager().getGroupByGroupKey(ts.get(j));
			al.add(g);
		}

		return al;
	}

	public Long[] getBillGroupAuthorityIds() {
		return billGroupAuthorityIds;
	}

	public void setBillGroupAuthorityIds(Long[] billGroupAuthorityIds) {
		this.billGroupAuthorityIds = billGroupAuthorityIds;
	}

	public String[] getBillDetailIds() {
		return billDetailIds;
	}

	public void setBillDetailIds(String[] billDetailIds) {
		this.billDetailIds = billDetailIds;
	}

	public List<BillAuthority> getBillAuthorityListByBill(String bill) {
		List<BillAuthority> objList = getGenericManager().getBillAuthorityListByBill(bill);
		for (int i = 0; i < objList.size(); i++) {
			BillAuthority obj = (BillAuthority) objList.get(i);
			int complete = getGenericManager().getAllCompleteStatusByBill(obj.getBill(), obj.getGroup(), true);
			int uncomplete = getGenericManager().getAllCompleteStatusByBill(obj.getBill(), obj.getGroup(), false);
			obj.setComplete(complete);
			obj.setUncomplete(uncomplete);
			// System.out.println(obj.getGroup().getGroupNameEn()+"
			// complete="+complete+"---uncomplete="+uncomplete);
		}

		return objList;
	}

	public boolean isStepEnabled(String billNo, String groupId) {
		Bill bill = getGenericManager().getBillById(billNo);
		Group group = getGenericManager().getGroupById(Long.parseLong(groupId));
		return getGenericManager().isStepEnabled(bill, group);
	}

	public boolean isSettingPermissions(String groupId) {
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		Group group = getGenericManager().getGroupById(Long.parseLong(groupId));
		return getGenericManager().isSettingPermissions(s.getMember(), group);
	}

	public boolean getRecordEditable(String billScheduleId, String gid, boolean isPermissions) {

		boolean result;
		BillSchedule billSchedule = getGenericManager().getBillScheduleById(billScheduleId);
		Group group = getGenericManager().getGroupById(Long.parseLong(gid));
		Group previousGroup = getGenericManager().previousStep(billSchedule, group);

		Product product = billSchedule.getBillDetail().getProduct();
		boolean s = billSchedule.getBillDetail().getProduct().getProductClass().getExpectionFlows()
				.contains(previousGroup);

		boolean b = getGenericManager().isEnabledEdit1(billSchedule, previousGroup);
		if (s == true) {
			result = false;
		} else {
			if (b == true) {
				result = false;
			} else {
				result = true;
			}
		}

		if (isPermissions == true) {
			result = true;
		}

		System.out.println("group=" + group.getGroupName() + "----previousGroup=" + previousGroup.getGroupName()
				+ "--b=" + b + "---result=" + result);
		return result;
	}

	public boolean getPass(String billScheduleId, String gid) {
		boolean result = false;
		try {
			Group group = getGenericManager().getGroupById(Long.parseLong(gid));
			BillSchedule billSchedule = getGenericManager().getBillScheduleById(billScheduleId);
			// System.out.println("getPass
			// ProductClassID="+billSchedule.getBillDetail().getProduct().getProductClass().getId()+"--groupid="+group.getId());
			List ls = billSchedule.getBillDetail().getProduct().getProductClass().getExpectionFlows();
			if (ls != null) {
				result = ls.contains(group);
			}
		} catch (Exception e) {
			result = false;
			// System.out.println("getPass error="+e.toString());
		}
		return result;
	}

	public String isDisabled(boolean r) {
		if (r == true) {
			return "disabled";
		} else {
			return "";
		}
	}

	public BillFiles getBillFiles() {
		return billFiles;
	}

	public void setBillFiles(BillFiles billFiles) {
		this.billFiles = billFiles;
	}

	public void setFileDrawing(java.io.File val) {
		fileDrawing = val;
	}

	public java.io.File getFileDrawing() {
		return fileDrawing;
	}

	public void setFileDrawingContentType(String val) {
		fileDrawingContentType = val;
	}

	public String getFileDrawingContentType() {
		return fileDrawingContentType;
	}

	public void setFileDrawingFileName(String val) {
		fileDrawingFileName = val;
	}

	public String getFileDrawingFileName() {
		return fileDrawingFileName;
	}

	public void setRemoveDrawing(String val) {
		removeDrawing = val;
	}

	public String getRemoveDrawing() {
		return removeDrawing;
	}

	public Long[] getDrawingsFilesIds() {
		return drawingsFilesIds;
	}

	public void setDrawingsFilesIds(Long[] drawingsFilesIds) {
		this.drawingsFilesIds = drawingsFilesIds;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public String getCheck2() {
		return check2;
	}

	public void setCheck2(String check2) {
		this.check2 = check2;
	}

	public String getCheck5() {
		return check5;
	}

	public void setCheck5(String check5) {
		this.check5 = check5;
	}

	public String getOutputTime() {
		return outputTime;
	}

	public void setOutputTime(String outputTime) {
		this.outputTime = outputTime;
	}

	public String getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getUploadDrawingsTime() {
		return uploadDrawingsTime;
	}

	public void setUploadDrawingsTime(String uploadDrawingsTime) {
		this.uploadDrawingsTime = uploadDrawingsTime;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public void setFileImageDiagram(java.io.File val) {
		fileImageDiagram = val;
	}

	public java.io.File getFileImageDiagram() {
		return fileImageDiagram;
	}

	public void setFileImageDiagramContentType(String val) {
		fileImageDiagramContentType = val;
	}

	public String getFileImageDiagramContentType() {
		return fileImageDiagramContentType;
	}

	public void setFileImageDiagramFileName(String val) {
		fileImageDiagramFileName = val;
	}

	public String getFileImageDiagramFileName() {
		return fileImageDiagramFileName;
	}

	public void setRemoveImageDiagram(String val) {
		removeImageDiagram = val;
	}

	public String getRemoveImageDiagram() {
		return removeImageDiagram;
	}

	public void setFileCheckDiagram(java.io.File val) {
		fileCheckDiagram = val;
	}

	public java.io.File getFileCheckDiagram() {
		return fileCheckDiagram;
	}

	public void setFileCheckDiagramContentType(String val) {
		fileCheckDiagramContentType = val;
	}

	public String getFileCheckDiagramContentType() {
		return fileCheckDiagramContentType;
	}

	public void setFileCheckDiagramFileName(String val) {
		fileCheckDiagramFileName = val;
	}

	public String getFileCheckDiagramFileName() {
		return fileCheckDiagramFileName;
	}

	public void setRemoveCheckDiagram(String val) {
		removeCheckDiagram = val;
	}

	public String getRemoveCheckDiagram() {
		return removeCheckDiagram;
	}

	public String saveBillOutputDevice() {
		System.out.println(
				"saveBillOutputDevice()...bill.getId()=" + bill.getId() + "---" + billSchedule.getOutputDevice());

		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule s = getGenericManager().getBillScheduleByBillDetail(obj);
			s.setOutputDevice(billSchedule.getOutputDevice());
			s.setOutputEquipment(getGenericManager().getOutputEquipmentById(billSchedule.getOutputEquipmentId()));
			getGenericManager().saveBillSchedule(s);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public String saveCheck1() {
		System.out.println("saveCheck1()...bill.getId()=" + bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);
			b.setStep1(true);
			b.setCheck1(Tools.convertToDateTime(completionTime));
			b.setChecker1(s.getMember());
			b.setFileName(billSchedule.getFileName());
			b.setCustomerScreen(getGenericManager().getCustomerScreenById(billSchedule.getCustomerScreenId()));
			b.setWorker(getGenericManager().getMemberById(billSchedule.getWorkerId()));
			b.setCosts(billSchedule.getCosts());
			getGenericManager().saveBillSchedule(b);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public String saveCheck5() {
		System.out.println("saveCheck5()...bill.getId()=" + bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);

			if (!check5.equals("") && check5 != null) {
				b.setStep5(true);
				b.setCheck5(Tools.convertToDateTime(check5));
				b.setChecker5(s.getMember());
			}

			// 如果有審核的話
			if (!check2.equals("") && check2 != null) {
				b.setStep2(true);
				b.setCheck2(Tools.convertToDateTime(check2));
				b.setChecker2(s.getMember());
			}
			// 如果有審核的話

			getGenericManager().saveBillSchedule(b);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public String saveCheck6() {
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		if (!bill.getId().equals("")) {
			System.out.println("saveCheck6()...bill.getId()=" + bill.getId());
			saveFileToLocal1(fileImageDiagramFileName, fileImageDiagram,
					getTextWithArgs("billSchedule.uploadImageDiagram.dir"), bill.getId() + "_ImageDiagram");
			saveFileToLocal1(fileCheckDiagramFileName, fileCheckDiagram,
					getTextWithArgs("billSchedule.uploadCheckDiagram.dir"), bill.getId() + "_CheckDiagram");

			for (int i = 0; i < billDetailIds.length; i++) {
				String id = billDetailIds[i];
				BillDetail obj = getGenericManager().getBillDetailById(id);
				BillSchedule billSchedule = getGenericManager().getBillScheduleByBillDetail(obj);
				billSchedule.setImageDiagram(computeUploadedFile(fileImageDiagramFileName, fileImageDiagram));
				billSchedule.setCheckDiagram(computeUploadedFile(fileCheckDiagramFileName, fileCheckDiagram));
				billSchedule.setStep6(true);
				billSchedule.setCheck6(Tools.getCurrentTimestamp());
				billSchedule.setChecker6(s.getMember());
				getGenericManager().saveBillSchedule(billSchedule);
			}
			appendXworkParam("bill.id=" + bill.getId());
			appendXworkParam("reload=Y");
			return SUCCESS;
		} else {
			ArrayList<String> ls = new ArrayList<String>();
			for (int i = 0; i < billDetailIds.length; i++) {
				String id = billDetailIds[i];
				BillDetail obj = getGenericManager().getBillDetailById(id);
				String billNo = obj.getBill().getId();
				if (ls.contains(billNo) == false) {
					ls.add(billNo);
				}
				System.out.println("billNo=" + billNo);
			}
			// 複製對稿圖檔上傳&示意圖上傳
			for (int j = 0; j < ls.size(); j++) {
				if (j == 0) {
					saveFileToLocal1(fileImageDiagramFileName, fileImageDiagram,
							getTextWithArgs("billSchedule.uploadImageDiagram.dir"), ls.get(j) + "_ImageDiagram");
					saveFileToLocal1(fileCheckDiagramFileName, fileCheckDiagram,
							getTextWithArgs("billSchedule.uploadCheckDiagram.dir"), ls.get(j) + "_CheckDiagram");
				} else {
					try {
						File imageDiagram = new File(getText("billSchedule.uploadImageDiagram.filepath") + "//"
								+ ls.get(0) + "_ImageDiagram//" + fileImageDiagramFileName);
						File imageDiagramTarget = new File(getText("billSchedule.uploadImageDiagram.filepath") + "//"
								+ ls.get(j) + "_ImageDiagram//", fileImageDiagramFileName);
						fileCopy(imageDiagram, imageDiagramTarget, getText("billSchedule.uploadImageDiagram.filepath")
								+ "//" + ls.get(j) + "_ImageDiagram//");

						File checkDiagram = new File(getText("billSchedule.uploadCheckDiagram.filepath") + "//"
								+ ls.get(0) + "_CheckDiagram//" + fileCheckDiagramFileName);
						File checkDiagramTarget = new File(getText("billSchedule.uploadCheckDiagram.filepath") + "//"
								+ ls.get(j) + "_CheckDiagram//", fileCheckDiagramFileName);
						fileCopy(checkDiagram, checkDiagramTarget, getText("billSchedule.uploadCheckDiagram.filepath")
								+ "//" + ls.get(j) + "_CheckDiagram//");

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
			}

			// 更新STATUS
			for (int i = 0; i < billDetailIds.length; i++) {
				String id = billDetailIds[i];
				BillDetail obj = getGenericManager().getBillDetailById(id);
				BillSchedule billSchedule = getGenericManager().getBillScheduleByBillDetail(obj);
				billSchedule.setImageDiagram(computeUploadedFile(fileImageDiagramFileName, fileImageDiagram));
				billSchedule.setCheckDiagram(computeUploadedFile(fileCheckDiagramFileName, fileCheckDiagram));
				billSchedule.setStep6(true);
				billSchedule.setCheck6(Tools.getCurrentTimestamp());
				billSchedule.setChecker6(s.getMember());
				getGenericManager().saveBillSchedule(billSchedule);
			}
			appendXworkParam("reload=Y");
			return SUCCESS;
		}
	}

	public String saveCheck7() {
		System.out.println("saveCheck7()...bill.getId()=" + bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);
			b.setOutputTime(Tools.convertToDateTime(outputTime));
			b.setOutputDevice(billSchedule.getOutputDevice());
			b.setOutputEquipment(getGenericManager().getOutputEquipmentById(billSchedule.getOutputEquipmentId()));
			b.setStep7(true);
			b.setCheck7(Tools.getCurrentTimestamp());
			b.setChecker7(s.getMember());
			getGenericManager().saveBillSchedule(b);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}
	
	
	public String saveCheck9() {
		System.out.println("saveCheck9()...bill.getId()=" + bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);			
			b.setPostProductionsEqt(getGenericManager().getOutputEquipmentById(billSchedule.getPostProductionsEqtId()));			
			b.setStep9(true);
			b.setCheck9(Tools.getCurrentTimestamp());
			b.setChecker9(s.getMember());
			getGenericManager().saveBillSchedule(b);
			
			//savePostProductions
			PostProductions p=new PostProductions();
			p.setBillschedule(b);
			p.setMember(s.getMember());
			p.setCreatedDate(Tools.getCurrentTimestamp());
			getGenericManager().savePostProductions(p);
			
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public String saveCheck8() {
		System.out.println("saveCheck8()...bill.getId()=" + bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);
			b.setStep8(true);
			b.setCheck8(Tools.convertToDateTime(productionTime));
			b.setChecker8(s.getMember());
			getGenericManager().saveBillSchedule(b);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public String saveCheck11() {
		System.out.println("saveCheck11()...bill.getId()=" + bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);
			b.setIsSend(getGenericManager().getAppPropertyById(billSchedule.getIsSendId()));
			b.setFreight(getGenericManager().getFreightById(billSchedule.getFreightId()));
			b.setFreightNo(billSchedule.getFreightNo());
			b.setArrival(Tools.convertToDateTime(arrival));
			b.setIsSendTime(Tools.getCurrentTimestamp());
			b.setStep11(true);
			b.setCheck11(Tools.getCurrentTimestamp());
			b.setChecker11(s.getMember());
			getGenericManager().saveBillSchedule(b);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public String saveCheck12() {
		saveFileToLocal1(fileDrawingFileName, fileDrawing, getTextWithArgs("billSchedule.fileDrawing.dir"),
				bill.getId());
		SessionUser s = (SessionUser) getSession().getAttribute("user");

		if (billDetailIds != null) {
			for (int i = 0; i < billDetailIds.length; i++) {
				String id = billDetailIds[i];
				BillDetail obj = getGenericManager().getBillDetailById(id);
				BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);
				b.setUploadDrawingsTime(Tools.convertToDateTime(uploadDrawingsTime));
				b.setDrawingsMemo(billSchedule.getDrawingsMemo());
				b.setStep12(true);
				b.setChecker12(s.getMember());
				b.setCheck12(Tools.getCurrentTimestamp());

				// 上傳施工照

				ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
				if (drawingsFilesIds != null) {
					for (int j = 0; j < drawingsFilesIds.length; j++) {
						// System.out.println("drawingsFilesIds="+drawingsFilesIds[j]);
						UploadedFile file = getGenericManager().getUploadedFileById(drawingsFilesIds[j]);
						al.add(file);
					}
				}
				if (fileDrawing != null) {
					UploadedFile u = computeUploadedFile(fileDrawingFileName, fileDrawing);
					getGenericManager().saveUploadedFile(u);
					al.add(u);
				}
				for (int k = 0; k < al.size(); k++) {
					UploadedFile us = (UploadedFile) al.get(k);
					System.out.println("al=" + us.getId());
				}
				/*
				 * //上傳施工照的第一張自動取代丈量照的第一張 if(al.size()>0){ CustomerDetail
				 * cd=b.getCustomerScreen().getCustomerDetail(); if(cd!=null){
				 * UploadedFile f=al.get(0); cd.setPhoto1(f);
				 * getGenericManager().saveCustomerDetail(cd);
				 * 
				 * try{ String
				 * fileName=getText("billSchedule.fileDrawing.filepath"
				 * )+bill.getId()+"//"+f.getFileName(); File file=new
				 * File(fileName);
				 * //System.out.println(fileName+"--file.length()="
				 * +file.length()+"---cd.getId()="+cd.getId()); String
				 * filePath=getText
				 * ("billSchedule.fileDrawingToCustomerDetail.filepath"
				 * )+cd.getId()+"//";
				 * //System.out.println("filePath="+filePath); File target = new
				 * File(filePath, file.getName());
				 * 
				 * InputStream in = new FileInputStream(file); OutputStream out
				 * = new FileOutputStream(target); byte[] buf = new byte[1024];
				 * int len; while ((len = in.read(buf)) > 0){ out.write(buf, 0,
				 * len); } in.close(); out.close(); }catch(Exception e){
				 * System.out.println(e.toString()); } } }
				 * //上傳施工照的第一張自動取代丈量照的第一張
				 */
				b.setDrawingsFiles(al);
				// 上傳施工照

				getGenericManager().saveBillSchedule(b);
			}

		}

		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("billSchedule.billDetailId=" + billSchedule.getBillDetailId());
		// appendXworkParam("reload=Y");
		System.out.println(
				"bill.getId()=" + bill.getId() + "  billSchedule.billDetailId=" + billSchedule.getBillDetailId());
		return SUCCESS;
	}

	/*
	 * public String saveCheck12(){ saveFileToLocal1(fileDrawingFileName,
	 * fileDrawing,
	 * getTextWithArgs("billSchedule.fileDrawing.dir"),bill.getId());
	 * 
	 * SessionUser s=(SessionUser)getSession().getAttribute("user");
	 * 
	 * if(billDetailIds!=null){ for(int i=0;i<billDetailIds.length;i++){ String
	 * id=billDetailIds[i]; BillDetail
	 * obj=getGenericManager().getBillDetailById(id); BillSchedule
	 * b=getGenericManager().getBillScheduleByBillDetail(obj);
	 * b.setUploadDrawingsTime(Tools.convertToDateTime(uploadDrawingsTime));
	 * b.setDrawingsMemo(billSchedule.getDrawingsMemo()); b.setStep12(true);
	 * b.setChecker12(s.getMember()); b.setCheck12(Tools.getCurrentTimestamp());
	 * 
	 * 
	 * //上傳施工照 ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
	 * if(drawingsFilesIds!=null){ for(int j=0;j<drawingsFilesIds.length;j++){
	 * //System.out.println("drawingsFilesIds="+drawingsFilesIds[j]);
	 * UploadedFile
	 * file=getGenericManager().getUploadedFileById(drawingsFilesIds[j]);
	 * al.add(file); } } if(fileDrawing!=null){ UploadedFile
	 * u=computeUploadedFile(fileDrawingFileName, fileDrawing);
	 * getGenericManager().saveUploadedFile(u); al.add(u); } for(int
	 * k=0;k<al.size();k++){ UploadedFile us=(UploadedFile)al.get(k);
	 * System.out.println("al="+us.getId()); }
	 * 
	 * //上傳施工照的第一張自動取代丈量照的第一張 if(al.size()>0){ CustomerDetail
	 * cd=b.getCustomerScreen().getCustomerDetail(); if(cd!=null){ UploadedFile
	 * f=al.get(0); cd.setPhoto1(f); getGenericManager().saveCustomerDetail(cd);
	 * 
	 * try{ String
	 * fileName=getText("billSchedule.fileDrawing.filepath")+bill.getId
	 * ()+"//"+f.getFileName(); File file=new File(fileName);
	 * //System.out.println
	 * (fileName+"--file.length()="+file.length()+"---cd.getId()="+cd.getId());
	 * String
	 * filePath=getText("billSchedule.fileDrawingToCustomerDetail.filepath"
	 * )+cd.getId()+"//"; //System.out.println("filePath="+filePath); File
	 * target = new File(filePath, file.getName());
	 * 
	 * InputStream in = new FileInputStream(file); OutputStream out = new
	 * FileOutputStream(target); byte[] buf = new byte[1024]; int len; while
	 * ((len = in.read(buf)) > 0){ out.write(buf, 0, len); } in.close();
	 * out.close(); }catch(Exception e){ System.out.println(e.toString()); } } }
	 * //上傳施工照的第一張自動取代丈量照的第一張
	 * 
	 * b.setDrawingsFiles(al); //上傳施工照
	 * 
	 * getGenericManager().saveBillSchedule(b); } }
	 * 
	 * 
	 * appendXworkParam("bill.id="+bill.getId());
	 * //appendXworkParam("billSchedule.billDetailId="
	 * +billSchedule.getBillDetailId()); appendXworkParam("reload=Y");
	 * System.out
	 * .println("bill.getId()="+bill.getId()+"  billSchedule.billDetailId="
	 * +billSchedule.getBillDetailId()); return SUCCESS; }
	 */

	public String saveBillDeliveryTimeTime() {
		System.out.println("saveBillDeliveryTimeTime()...bill.getId()=" + bill.getId());

		for (int i = 0; i < billDetailIds.length; i++) {
			String id = billDetailIds[i];
			BillDetail obj = getGenericManager().getBillDetailById(id);
			BillSchedule b = getGenericManager().getBillScheduleByBillDetail(obj);
			SessionUser s = (SessionUser) getSession().getAttribute("user");
			b.setDeliveryTime(Tools.convertToDateTime(deliveryTime));
			b.setChecker10(s.getMember());
			b.setStep10(true);
			getGenericManager().saveBillSchedule(b);
		}
		appendXworkParam("bill.id=" + bill.getId());
		appendXworkParam("reload=Y");
		return SUCCESS;
	}

	public List<Freight> getFreightList() {
		return getGenericManager().getFreightList();
	}

	public List<Member> getWorkerList() {
		Group g = getGenericManager().getGroupById(16L);
		ArrayList<Member> al = new ArrayList<Member>();
		Set members = g.getMembers();
		if (members != null) {
			Iterator i = members.iterator();
			while (i.hasNext()) {
				Member m = (Member) i.next();
				al.add(m);
			}
		}
		Collections.sort(al, new Comparator() {
			public int compare(Object o1, Object o2) {
				Member p1 = (Member) o1;
				Member p2 = (Member) o2;
				return p1.getName().compareTo(p2.getName());
			}
		});
		return al;
	}

	public List<AppProperty> getIsSendList() {
		return super.getAppPropertyList("send.mothod");
	}

	public List<CustomerDetail> getCustomerAddressList(String BillNo) {
		Bill bill = getGenericManager().getBillById(BillNo);
		Customer customer = bill.getCustomer();
		return getGenericManager().getCustomerDetailListByCustomerNo(customer);
	}

	public CustomerDetail getCustomerDetailById() {
		return getGenericManager().getCustomerDetailById(customerDetail.getId());
	}

	public boolean isEnabledEdit(String billScheduleId, String groupKey) {
		System.out.println("isEnabledEdit=  billScheduleId==" + billScheduleId + "  groupKey=" + groupKey);
		BillSchedule b = getGenericManager().getBillScheduleById(billScheduleId);
		Group g = getGenericManager().getGroupById(Long.parseLong(groupKey));
		return getGenericManager().isEnabledEdit(b, g);
	}

	public List<CustomerScreen> getCustomerScreenListByBill(String billNo) {
		Bill bill = getGenericManager().getBillById(billNo);
		return getGenericManager().getCustomerScreenListByBill(bill);
	}

	public List<OutputEquipment> getOutputEquipmentList() {
		return getGenericManager().getOutputEquipmentList();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCfinish() {
		return cfinish;
	}

	public void setCfinish(String cfinish) {
		this.cfinish = cfinish;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<ProductCombine> getProductCombineList() {
		System.out.println("getProductCombineList productId=" + productId);
		ArrayList<ProductCombine> al = new ArrayList<ProductCombine>();
		Product p = getGenericManager().getProductById(productId);
		List s = p.getCombine();
		for (int i = 0; i < s.size(); i++) {
			ProductCombine combine = (ProductCombine) s.get(i);
			System.out.println("combine=" + combine);
			al.add(combine);
		}
		return al;
	}

	public List<Meter> getBillScheduleListByCondition() {
		group = getGenericManager().getGroupById(groupId);
		product = getGenericManager().getProductById(productId);
		boolean result;
		if (condition == 1) {
			result = true;
		} else {
			result = false;
		}
		int pageIndex = getPageIndex("idx");
		int pageSize = getPageSize();
		// System.out.println("getBillScheduleListByCondition
		// pageIndex="+pageIndex+"----pageSize="+pageSize);
		List<Meter> alist;
		alist = getGenericManager().getMeterListByCondition(Long.parseLong(group.getGroupNameEn()), product, result,
				pageSize, pageIndex);
		int resultSize = getGenericManager()
				.getMeterListByCondition(Long.parseLong(group.getGroupNameEn()), product, result).size();
		getSession().setAttribute("RESULT_SIZE", new Integer(resultSize));

		List<BillDetail> ls = new ArrayList<BillDetail>();
		for (int i = 0; i < alist.size(); i++) {
			BillDetail b = alist.get(i).getBilldetail();
			System.out.println("getBillScheduleListByCondition products=" + b.getId());
			ls.add(b);
		}
		getSession().setAttribute("products", ls);

		return alist;
	}

	public List getDrawingsFilesList() {
		return billSchedule.getDrawingsFiles();
	}

	public List<Product> getProductList() {
		String productName = product.getProductName();
		return getGenericManager().getProductListByCondition(product.getProductName(), product.getProductName());
	}

	public static void main(String args[]) {
		System.out.println("中文 Reflection..");
		try {
			Class aClass = Viewer.class;
			Field field = aClass.getField("view1");

			Viewer objectInstance = new Viewer();
			/*
			 * Object value = field.get(objectInstance);
			 * System.out.println(value); field.set(objectInstance, false);
			 */
			Object value1 = field.get(objectInstance);
			System.out.println(value1);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/*
	 * public String saveCheck12(){ saveFileToLocal1(fileDrawingFileName,
	 * fileDrawing,
	 * getTextWithArgs("billSchedule.fileDrawing.dir"),bill.getId());
	 * SessionUser s=(SessionUser)getSession().getAttribute("user");
	 * if(billDetailIds!=null){ for(int i=0;i<billDetailIds.length;i++){ String
	 * id=billDetailIds[i]; BillDetail
	 * obj=getGenericManager().getBillDetailById(id); BillSchedule
	 * b=getGenericManager().getBillScheduleByBillDetail(obj);
	 * b.setUploadDrawingsTime(Tools.convertToDateTime(uploadDrawingsTime));
	 * b.setDrawingsMemo(billSchedule.getDrawingsMemo()); b.setStep12(true);
	 * b.setChecker12(s.getMember()); b.setCheck12(Tools.getCurrentTimestamp());
	 * 
	 * 
	 * //上傳施工照 ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
	 * if(drawingsFilesIds!=null){ for(int j=0;j<drawingsFilesIds.length;j++){
	 * //System.out.println("drawingsFilesIds="+drawingsFilesIds[j]);
	 * UploadedFile
	 * file=getGenericManager().getUploadedFileById(drawingsFilesIds[j]);
	 * al.add(file); } } if(fileDrawing!=null){ UploadedFile
	 * u=computeUploadedFile(fileDrawingFileName, fileDrawing);
	 * getGenericManager().saveUploadedFile(u); al.add(u); } for(int
	 * k=0;k<al.size();k++){ UploadedFile us=(UploadedFile)al.get(k);
	 * System.out.println("al="+us.getId()); }
	 * 
	 * //上傳施工照的第一張自動取代丈量照的第一張 if(al.size()>0){ CustomerDetail
	 * cd=b.getCustomerScreen().getCustomerDetail(); if(cd!=null){ UploadedFile
	 * f=al.get(0); cd.setPhoto1(f); getGenericManager().saveCustomerDetail(cd);
	 * 
	 * try{ String
	 * fileName=getText("billSchedule.fileDrawing.filepath")+bill.getId
	 * ()+"//"+f.getFileName(); File file=new File(fileName);
	 * //System.out.println
	 * (fileName+"--file.length()="+file.length()+"---cd.getId()="+cd.getId());
	 * String
	 * filePath=getText("billSchedule.fileDrawingToCustomerDetail.filepath"
	 * )+cd.getId()+"//"; //System.out.println("filePath="+filePath); File
	 * target = new File(filePath, file.getName());
	 * 
	 * InputStream in = new FileInputStream(file); OutputStream out = new
	 * FileOutputStream(target); byte[] buf = new byte[1024]; int len; while
	 * ((len = in.read(buf)) > 0){ out.write(buf, 0, len); } in.close();
	 * out.close(); }catch(Exception e){ System.out.println(e.toString()); } } }
	 * //上傳施工照的第一張自動取代丈量照的第一張
	 * 
	 * b.setDrawingsFiles(al); //上傳施工照 getGenericManager().saveBillSchedule(b);
	 * } }
	 * 
	 * appendXworkParam("bill.id="+bill.getId());
	 * appendXworkParam("billSchedule.billDetailId="
	 * +billSchedule.getBillDetailId()); appendXworkParam("reload=Y");
	 * System.out
	 * .println("bill.getId()="+bill.getId()+"  billSchedule.billDetailId="
	 * +billSchedule.getBillDetailId()); return SUCCESS; }
	 */

	public String uploadFiles() {
		/*
		 * ActionContext ctx = ActionContext.getContext(); HttpServletRequest
		 * request = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		 * 
		 * Enumeration e=request.getParameterNames();
		 * while(e.hasMoreElements()){ String para=(String)e.nextElement();
		 * //System.out.println("para="+para); if(para.equals("Filename")){
		 * String name=request.getParameter(para);
		 * System.out.println("Parameter="
		 * +para+"  value="+request.getParameter(para) );
		 * //saveFileToLocal1(name, Filename,
		 * getTextWithArgs("billSchedule.uploadImageDiagram.dir"
		 * ),"99_ImageDiagram"); } }
		 */

		return SUCCESS;
	}

	public String deleteStep() {
		System.out.println(
				"bill.id" + bill.getId() + " id=" + id + "--" + id + "--pageName=" + pageName + "  pageNo=" + pageNo);
		return SUCCESS;
	}

	public void setFileDoc1(java.io.File val) {
		fileDoc1 = val;
	}

	public java.io.File getFileDoc1() {
		return fileDoc1;
	}

	public void setFileDoc1ContentType(String val) {
		fileDoc1ContentType = val;
	}

	public String getFileDoc1ContentType() {
		return fileDoc1ContentType;
	}

	public void setFileDoc1FileName(String val) {
		fileDoc1FileName = val;
	}

	public String getFileDoc1FileName() {
		return fileDoc1FileName;
	}

	public void setRemoveDoc1(String val) {
		removeDoc1 = val;
	}

	public String getRemoveDoc1() {
		return removeDoc1;
	}

	public void setFileDoc2(java.io.File val) {
		fileDoc2 = val;
	}

	public java.io.File getFileDoc2() {
		return fileDoc2;
	}

	public void setFileDoc2ContentType(String val) {
		fileDoc2ContentType = val;
	}

	public String getFileDoc2ContentType() {
		return fileDoc2ContentType;
	}

	public void setFileDoc2FileName(String val) {
		fileDoc2FileName = val;
	}

	public String getFileDoc2FileName() {
		return fileDoc2FileName;
	}

	public void setRemoveDoc2(String val) {
		removeDoc2 = val;
	}

	public String getRemoveDoc2() {
		return removeDoc2;
	}

	public void setFileDoc3(java.io.File val) {
		fileDoc3 = val;
	}

	public java.io.File getFileDoc3() {
		return fileDoc3;
	}

	public void setFileDoc3ContentType(String val) {
		fileDoc3ContentType = val;
	}

	public String getFileDoc3ContentType() {
		return fileDoc3ContentType;
	}

	public void setFileDoc3FileName(String val) {
		fileDoc3FileName = val;
	}

	public String getFileDoc3FileName() {
		return fileDoc3FileName;
	}

	public void setRemoveDoc3(String val) {
		removeDoc3 = val;
	}

	public String getRemoveDoc3() {
		return removeDoc3;
	}

	public void setFileDoc4(java.io.File val) {
		fileDoc4 = val;
	}

	public java.io.File getFileDoc4() {
		return fileDoc4;
	}

	public void setFileDoc4ContentType(String val) {
		fileDoc4ContentType = val;
	}

	public String getFileDoc4ContentType() {
		return fileDoc4ContentType;
	}

	public void setFileDoc4FileName(String val) {
		fileDoc4FileName = val;
	}

	public String getFileDoc4FileName() {
		return fileDoc4FileName;
	}

	public void setRemoveDoc4(String val) {
		removeDoc4 = val;
	}

	public String getRemoveDoc4() {
		return removeDoc4;
	}

	public void setFileDoc5(java.io.File val) {
		fileDoc5 = val;
	}

	public java.io.File getFileDoc5() {
		return fileDoc5;
	}

	public void setFileDoc5ContentType(String val) {
		fileDoc5ContentType = val;
	}

	public String getFileDoc5ContentType() {
		return fileDoc5ContentType;
	}

	public void setFileDoc5FileName(String val) {
		fileDoc5FileName = val;
	}

	public String getFileDoc5FileName() {
		return fileDoc5FileName;
	}

	public void setRemoveDoc5(String val) {
		removeDoc5 = val;
	}

	public String getRemoveDoc5() {
		return removeDoc5;
	}

	public void setFileDoc6(java.io.File val) {
		fileDoc6 = val;
	}

	public java.io.File getFileDoc6() {
		return fileDoc6;
	}

	public void setFileDoc6ContentType(String val) {
		fileDoc6ContentType = val;
	}

	public String getFileDoc6ContentType() {
		return fileDoc6ContentType;
	}

	public void setFileDoc6FileName(String val) {
		fileDoc6FileName = val;
	}

	public String getFileDoc6FileName() {
		return fileDoc6FileName;
	}

	public void setRemoveDoc6(String val) {
		removeDoc6 = val;
	}

	public String getRemoveDoc6() {
		return removeDoc6;
	}

	public int getXorx() {
		return xorx;
	}

	public void setXorx(int xorx) {
		this.xorx = xorx;
	}

	public List<ProcessState> getProcessStateList() {
		group = getGenericManager().getGroupById(groupId);
		if (xorx == 1) {
			status = true;
		} else {
			status = false;
		}

		if (group == null) {
			return getGenericManager().getProcessStateList();
		} else {
			return getGenericManager().getProcessStateList(billNo, group, status, 1, billSchedule.getWorkerId());
		}
	}

	public String worker(String name) {
		String value = "";
		System.out.println("worker()..");
		try {
			char u = ';';
			String c = String.valueOf(u);
			StringTokenizer st = new StringTokenizer(name, c, false);
			while (st.hasMoreTokens()) {
				String token = String.valueOf(st.nextToken());
				Member m = getGenericManager().getMemberById(token);
				value += m.getName() + ";";
				System.out.println("worker()..token=" + token);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return value;
	}

	public int getMyPageIndex() {
		return myPageIndex;
	}

	public void setMyPageIndex(int myPageIndex) {
		this.myPageIndex = myPageIndex;
	}

	public int getMyPageSize() {
		return myPageSize;
	}

	public void setMyPageSize(int myPageSize) {
		this.myPageSize = myPageSize;
	}

	public int getFromRow1() {
		return fromRow1;
	}

	public void setFromRow1(int fromRow1) {
		this.fromRow1 = fromRow1;
	}

	public int getFromRow2() {
		return fromRow2;
	}

	public void setFromRow2(int fromRow2) {
		this.fromRow2 = fromRow2;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void exportExcel() {
		String sql = " SELECT *  FROM WorkFlowStatus WHERE billNo LIKE'%" + billNo + "%' ORDER BY billNo DESC ";
		System.out.println(sql);
		getGenericManager().exportExcel(sql, "report1.xls");
	}

	public void exportExcel2() {
		String sql = " SELECT *  FROM StatisticsReport WHERE billNo LIKE'%" + billNo + "%' ORDER by BillNO,SN ASC ";
		System.out.println(sql);
		getGenericManager().exportExcel(sql, "report2.xls");
	}

	public List<BillQA> getBillQAList(String id) {
		System.out.println("getBillQAList id=" + id);
		bill = getGenericManager().getBillById(id);
		return getGenericManager().getBillQAList(bill);
	}

	public String billJSON() {
		System.out.println("billJSON billNo=" + billNo);
		JSONArray ja = new JSONArray();
		try {			
			    List<Bill> ls ;
			    if(billNo.equals("")){
			    	ls = new ArrayList<Bill>();
			    }else{
			    	ls = getGenericManager().getBillByNo(billNo);
			    }
				
				for (int i = 0; i < ls.size(); i++) {
					bill = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("id", bill.getId());
					jo.put("text", bill.getId());
					jo.put("customer", (bill.getCustomer() != null) ? bill.getCustomer().getName() : "");
					jo.put("saleman", (bill.getCustomer().getSaleman() != null) ? bill.getCustomer().getSaleman().getName() : "");
					jo.put("remark", bill.getRemark());
					if(bill.getId().equals(billNo)){
						jo.put("selected", true);
					}					
					ja.put(jo);  //.getSaleman().getName()
				}
			
		} catch (Exception e) {
			System.out.println("billJSON=" + e.toString());
		}
		return ja.toString();
	}

}
