package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.*;

import java.io.File;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

import jxl.*;
import jxl.write.*;

public class LogisticsAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Logistics logistics, logistics1;
	private String serviceDate;
	private Long[] selectedLogisticsIds;
	String keyword, startDate, endDate, ids;
	LogisticsCode code;
	Long logisticsId;
	SenderDB senderDB;
	private java.io.File fileExcel;
	private String fileExcelContentType, fileExcelFileName;

	public LogisticsAction() {
		log = LogFactory.getLog(northwest.common.web.action.LogisticsAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("LOGISTICS");
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics val) {
		logistics = val;
	}

	public SenderDB getSenderDB() {
		return senderDB;
	}

	public void setSenderDB(SenderDB senderDB) {
		this.senderDB = senderDB;
	}

	public LogisticsCode getCode() {
		return code;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setCode(LogisticsCode code) {
		this.code = code;
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

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeLogistics(logistics.getId());
		return DELETE;
	}

	public String edit() {
		if (logistics == null) {
			logistics = new Logistics();
		} else if (logistics.getId() != null) {
			logistics = getGenericManager().getLogisticsById(logistics.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedLogisticsIds != null && selectedLogisticsIds.length > 0) {
			Logistics obj = getGenericManager().getLogisticsById(selectedLogisticsIds[0]);
			obj.setId(null);
			logistics = obj;
		}
		beanToForm();

		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		if (getDelete() != null) {
			return delete();
		} else {
			formToBean();
			if (inputValidation(logistics) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Logistics val) {
		return true;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (logistics.getId() == null) {
			logistics.setCreatedDate(ts);
			logistics.setMember(getSessionUser().getMember());
		}
		logistics.setLastModifiedDate(ts);
		getGenericManager().saveLogistics(logistics);
		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		serviceDate = Tools.dateToString(logistics.getServiceDate());
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		logistics.setServiceDate(Tools.convertToDate(serviceDate));
		logistics.setBill(getGenericManager().getBillById(logistics.getBillId()));
		logistics.setMember(getGenericManager().getMemberById(logistics.getMemberId()));
		logistics.setTime(getAppPropertyById(logistics.getTimeId()));
		System.out.println("logistics.getFreightCompanyId()=" + logistics.getFreightCompanyId());
	}

	public void setServiceDate(String val) {
		serviceDate = val;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public List<Bill> getBillList() {
		return getGenericManager().getBillList(); // TODO
	}

	public List<AppProperty> getTimeList() {
		return super.getAppPropertyList("logistics.time");
	}

	public void setSelectedLogisticsIds(Long[] val) {
		selectedLogisticsIds = val;
	}

	public Long[] getSelectedLogisticsIds() {
		return selectedLogisticsIds;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(Long logisticsId) {
		this.logisticsId = logisticsId;
	}

	public Logistics getLogisticsById() {
		if (logistics.getId() != null) {
			logistics = getGenericManager().getLogisticsById(logistics.getId());
		} else {
			logistics = new Logistics();
			logistics.setFreight("�Ѧ��f�B");
			logistics.setSender("��_�v��");
			logistics.setSenderPhone("02-25978757");
			logistics.setSenderAddress("10491�x�_�����s��������19��21��");
		}
		return logistics;
	}

	public String logisticsListJSON() {
		System.out.println("logisticsListJSON keyword=" + keyword + "---startDate=" + startDate + "--endDate=" + endDate);
		JSONObject mainObj = new JSONObject();
		try {
			List<Logistics> ls = getGenericManager().getLogisticsList(keyword, Tools.convertToDate(startDate), Tools.convertToDate(endDate));
			JSONArray ja = new JSONArray();
			for (int i = 0; i < ls.size(); i++) {
				logistics = ls.get(i);
				JSONObject jo = new JSONObject();
				jo.put("id", logistics.getId());
				jo.put("freight", (logistics.getFreightCompany() != null) ? logistics.getFreightCompany().getValueTw() : "");
				jo.put("freightCompany", (logistics.getFreightCompany() != null) ? logistics.getFreightCompanyId() : "");
				jo.put("freightRPT", (logistics.getFreightCompany() != null) ? logistics.getFreightCompany().getValueUs() : "");
				jo.put("code", logistics.getCode());
				jo.put("billno", logistics.getBillId());
				jo.put("otherBills", logistics.getOtherBills());
				jo.put("customer", logistics.getBill().getCustomer().getName());
				jo.put("saleman", logistics.getBill().getCustomer().getSaleman().getName());
				jo.put("sender", logistics.getSender());
				jo.put("senderPhone", logistics.getSenderPhone());
				jo.put("senderAddress", logistics.getSenderAddress());
				jo.put("senderMemo", logistics.getSenderMemo());
				jo.put("recipient", logistics.getRecipient());
				jo.put("recipientPhone", logistics.getRecipientPhone());
				jo.put("recipientAddress", logistics.getRecipientAddress());
				jo.put("serviceDate", Tools.dateToString(logistics.getServiceDate()));
				jo.put("time", logistics.getTime().getValueTw());
				jo.put("member", logistics.getMember().getName());
				jo.put("lastModifiedDate", Tools.formatSimpleDate1(logistics.getLastModifiedDate()));
				jo.put("createdUser", (logistics.getCreatedUser() != null) ? logistics.getCreatedUser().getName() : "");
				jo.put("createdDate", Tools.formatSimpleDate1(logistics.getCreatedDate()));
				jo.put("memo", logistics.getMemo());
				ja.put(jo);
			}
			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);

		} catch (Exception e) {
			System.out.println("logisticsListJSON **** " + e.toString());
		}
		return mainObj.toString();
	}

	public String deleteLogisticsJSON() {
		System.out.println("deleteLogisticsJSON *****ids=" + ids);
		try {
			String[] tokens = ids.split(",");
			for (int i = 0; i < tokens.length; i++) {
				System.out.println("tokens===" + tokens[i]);
				logistics = getGenericManager().getLogisticsById(Long.parseLong(tokens[i]));
				getGenericManager().removeLogisticsCode(logistics);
				getGenericManager().removeLogistics(logistics.getId());
			}
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("deleteLogisticsJSON **** " + e.toString());
			return INPUT;
		}

	}

	public String getLastCode(Long id) {
		try {
			System.out.println("getLastCode id=" + id);
			AppProperty freightCompany = getGenericManager().getAppPropertyById(id);
			code = getGenericManager().getLastOneLogisticsCode(freightCompany);
			int c = Integer.parseInt(code.getCode()) + 1;
			return Tools.IntegerFormart(10, c);
		} catch (Exception e) {
			return "";
		}
	}

	public java.io.File getFileExcel() {
		return fileExcel;
	}

	public void setFileExcel(java.io.File fileExcel) {
		this.fileExcel = fileExcel;
	}

	public String getFileExcelContentType() {
		return fileExcelContentType;
	}

	public void setFileExcelContentType(String fileExcelContentType) {
		this.fileExcelContentType = fileExcelContentType;
	}

	public String getFileExcelFileName() {
		return fileExcelFileName;
	}

	public void setFileExcelFileName(String fileExcelFileName) {
		this.fileExcelFileName = fileExcelFileName;
	}

	public String logisticsLastCodeJSON() {
		System.out.println("logisticsLastCodeJSON");
		String no = "";
		try {
			System.out.println("FreightCompanyId id=" + logistics.getFreightCompanyId());
			AppProperty freightCompany = getGenericManager().getAppPropertyById(logistics.getFreightCompanyId());
			code = getGenericManager().getLastOneLogisticsCode(freightCompany);
			int c = Integer.parseInt(code.getCode()) + 1;
			no = String.valueOf(c);
		} catch (Exception e) {
			System.out.println("logisticsLastCodeJSON error= " + e.toString());
		}
		return no;
	}

	public String recipientDBJSON() {
		System.out.println("recipientDBJSON");
		JSONObject mainObj = new JSONObject();
		try {
			List<RecipientDB> ls = getGenericManager().getRecipientDBList(keyword);
			JSONArray ja = new JSONArray();
			for (int i = 0; i < ls.size(); i++) {
				RecipientDB r = ls.get(i);
				JSONObject jo = new JSONObject();
				jo.put("id", r.getId());
				jo.put("text", r.getRecipient());
				jo.put("recipient", r.getRecipient());
				jo.put("recipientPhone", r.getRecipientPhone());
				jo.put("recipientAddress", r.getRecipientAddress());
				ja.put(jo);
			}
			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("recipientDBJSON error= " + e.toString());
		}
		return mainObj.toString();
	}

	public String senderDBJSON() {
		System.out.println("senderDBJSON");
		JSONObject mainObj = new JSONObject();
		try {
			List<SenderDB> ls = getGenericManager().getSenderDBList(keyword);
			JSONArray ja = new JSONArray();
			for (int i = 0; i < ls.size(); i++) {
				senderDB = ls.get(i);
				JSONObject jo = new JSONObject();
				jo.put("id", senderDB.getId());
				jo.put("text", senderDB.getSender());
				jo.put("sender", senderDB.getSender());
				jo.put("senderPhone", senderDB.getSenderPhone());
				jo.put("senderAddress", senderDB.getSenderAddress());
				ja.put(jo);
			}
			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("senderDBJSON error= " + e.toString());
		}
		return mainObj.toString();
	}

	public String saveLogisticsJSON() {
		System.out.println("saveLogisticsJSON *****");
		try {
			if (logistics.getId() == null) {
				logistics1 = new Logistics();
			} else if (logistics.getId() != null) {
				logistics1 = getGenericManager().getLogisticsById(logistics.getId());
			}
			logistics1.setOtherBills(logistics.getOtherBills());
			logistics1.setCode(logistics.getCode());
			logistics1.setMember(getSessionUser().getMember());
			logistics1.setBill(getGenericManager().getBillById(logistics.getBillId()));
			logistics1.setSender(logistics.getSender());
			logistics1.setSenderPhone(logistics.getSenderPhone());
			logistics1.setSenderAddress(logistics.getSenderAddress());

			logistics1.setRecipient(logistics.getRecipient());
			logistics1.setRecipientPhone(logistics.getRecipientPhone());
			logistics1.setRecipientAddress(logistics.getRecipientAddress());

			logistics1.setServiceDate(Tools.convertToDate(serviceDate));
			logistics1.setTime(getAppPropertyById(logistics.getTimeId()));

			logistics1.setCreatedDate(Tools.getCurrentTimestamp());
			logistics1.setLastModifiedDate(Tools.getCurrentTimestamp());

			logistics1.setFreightCompany(getAppPropertyById(logistics.getFreightCompanyId()));

			logistics1.setCreatedUser(getSessionUser().getMember());

			logistics1.setMemo(logistics.getMemo());

			// save Logistics
			getGenericManager().saveLogistics(logistics1);

			// save LogisticsCode
			code = new LogisticsCode();
			code.setCode(logistics.getCode());
			code.setLogistics(logistics1);
			code.setFreightCompany(getAppPropertyById(logistics.getFreightCompanyId()));
			getGenericManager().saveLogisticsCode(code);

			return SUCCESS;
		} catch (Exception e) {
			System.out.println("saveLogisticsJSON **** " + e.toString());
			return INPUT;
		}

	}

	// logisticExcelExportJSON()
	public String logisticExcelExportJSON() {
		System.out.println("logisticExcelExportJSON *****");
		try {
			Long id = 1L;
			AppProperty freightCompany = getAppPropertyById(logistics.getFreightCompanyId());
			System.out.println("freightCompany=" + freightCompany.getValueTw() + "--FreightCompanyId=" + logistics.getFreightCompanyId());
			saveFileToLocal("logisticExcel.xls", fileExcel, getTextWithArgs("logistics.upload.dir"), id);

			// File inputWorkbook = new File(inputFile);

			File ff = new File(getTextWithArgs("logistics.upload.dir"));
			File target = new File(ff, "\\1\\logisticExcel.xls");
			// File target = new
			// File("D://mycase//tomcat//northwest//upload//1//logisticExcel.xlsx");
			// Workbook w = Workbook.getWorkbook(new
			// File("D://mycase//tomcat//northwest//upload//1//logisticExcel.xls"));

			Workbook w = Workbook.getWorkbook(target);
			Sheet sheet = w.getSheet(0);

			System.out.println("sheet.getColumns()=" + sheet.getColumns() + "--sheet.getRows()=" + sheet.getRows());

			for (int i = 0; i < sheet.getRows(); i++) {

				logistics1 = new Logistics();
				logistics1.setFreightCompany(freightCompany);

				for (int j = 0; j < sheet.getColumns(); j++) {
					if (i > 0) {

						Cell cell = sheet.getCell(j, i);
						String value = cell.getContents().toString();
						System.out.println("i=" + i + "---j=" + j + "----" + value);
						try {

							switch (j) {
							case 0:
								try {
									logistics1.setBill(getGenericManager().getBillById(value));
								} catch (Exception e) {
								}
								break;

							case 1:
								logistics1.setOtherBills(value);
								break;

							case 2:
								logistics1.setMemo(value);
								break;

							case 3:
								logistics1.setSender(value);
								break;

							case 4:
								logistics1.setSenderPhone(value);
								break;

							case 5:
								logistics1.setSenderAddress(value);
								break;

							case 6:
								logistics1.setRecipient(value);
								break;

							case 7:
								logistics1.setRecipientPhone(value);
								break;

							case 8:
								logistics1.setRecipientAddress(value);
								break;

							case 9:
								try {
									logistics1.setServiceDate(Tools.convertToDate(value));
								} catch (Exception e) {
								}
								break;

							case 10:
								// logistics1
								if (value.equals("�W��")) {
									logistics1.setTime(getAppPropertyById(31L));
								} else {
									logistics1.setTime(getAppPropertyById(32L));
								}
								break;
							}

							// code
							LogisticsCode lc = getGenericManager().getLastOneLogisticsCode(freightCompany);
							int cx = Integer.parseInt(lc.getCode()) + 1;
							String no = String.valueOf(cx);

							// member
							logistics1.setMember(getSessionUser().getMember());
							logistics1.setCode(no);
							logistics1.setLastModifiedDate(Tools.getCurrentTimestamp());
							logistics1.setCreatedDate(Tools.getCurrentTimestamp());
							logistics1.setCreatedUser(getSessionUser().getMember());

							// save Logistics
							getGenericManager().saveLogistics(logistics1);

							// save LogisticsCode
							code = new LogisticsCode();
							code.setCode(no);
							code.setLogistics(logistics1);
							code.setFreightCompany(freightCompany);
							getGenericManager().saveLogisticsCode(code);

						} catch (Exception e) {
							System.out.println(e.toString());
						}

					}
				}
			}

			/*
			 * // �s�Wlogistics logistics1 = new Logistics();
			 * logistics1.setOtherBills(logistics.getOtherBills());
			 * logistics1.setCode(logistics.getCode());
			 * logistics1.setMember(getSessionUser().getMember());
			 * logistics1.setBill(getGenericManager().getBillById(logistics.
			 * getBillId())); logistics1.setSender(logistics.getSender());
			 * logistics1.setSenderPhone(logistics.getSenderPhone());
			 * logistics1.setSenderAddress(logistics.getSenderAddress());
			 * 
			 * logistics1.setRecipient(logistics.getRecipient());
			 * logistics1.setRecipientPhone(logistics.getRecipientPhone());
			 * logistics1.setRecipientAddress(logistics.getRecipientAddress());
			 * 
			 * logistics1.setServiceDate(Tools.convertToDate(serviceDate));
			 * logistics1.setTime(getAppPropertyById(logistics.getTimeId()));
			 * 
			 * logistics1.setCreatedDate(Tools.getCurrentTimestamp());
			 * logistics1.setLastModifiedDate(Tools.getCurrentTimestamp());
			 * 
			 * logistics1.setFreightCompany(getAppPropertyById(logistics.
			 * getFreightCompanyId()));
			 * 
			 * logistics1.setCreatedUser(getSessionUser().getMember());
			 * 
			 * logistics1.setMemo(logistics.getMemo());
			 * 
			 * // save Logistics getGenericManager().saveLogistics(logistics1);
			 * 
			 * // save LogisticsCode code = new LogisticsCode();
			 * code.setCode(logistics.getCode()); code.setLogistics(logistics1);
			 * code.setFreightCompany(getAppPropertyById(logistics.
			 * getFreightCompanyId()));
			 * getGenericManager().saveLogisticsCode(code);
			 */

			w.close();

			/*
			 * private java.io.File fileExcel; private String
			 * fileExcelContentType, fileExcelFileName;
			 */
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("logisticExcelExportJSON **** " + e.toString());
			return INPUT;
		}
	}

}
