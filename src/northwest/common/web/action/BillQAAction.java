package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.Group;

public class BillQAAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private BillQA billQA;
	private Long[] selectedBillQAIds;
	Bill bill;
	String billno, customerId, startDate, endDate, notificationsIds[];
	Customer customer;
	Member member;
	int query;

	public BillQAAction() {
		log = LogFactory.getLog(northwest.common.web.action.BillQAAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("BILLQA");
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BillQA getBillQA() {
		return billQA;
	}

	public void setBillQA(BillQA val) {
		billQA = val;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String[] getNotificationsIds() {
		return notificationsIds;
	}

	public void setNotificationsIds(String[] notificationsIds) {
		this.notificationsIds = notificationsIds;
	}

	public int getQuery() {
		return query;
	}

	public void setQuery(int query) {
		this.query = query;
	}

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String delete() {
		billQA = getGenericManager().getBillQAById(billQA.getId());
		appendXworkParam("bill.id=" + billQA.getBill().getId());
		System.out.println("delete billQA.getBillId=" + billQA.getBill().getId());
		getGenericManager().removeBillQA(billQA.getId());
		return DELETE;
	}

	public String edit() {
		if (billQA == null) {
			billQA = new BillQA();
			bill = getGenericManager().getBillById(bill.getId());
			billQA.setBill(bill);
		} else if (billQA.getId() != null) {
			billQA = getGenericManager().getBillQAById(billQA.getId());
			bill = billQA.getBill();
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedBillQAIds != null && selectedBillQAIds.length > 0) {
			BillQA obj = getGenericManager().getBillQAById(selectedBillQAIds[0]);
			obj.setId(null);
			billQA = obj;
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
			if (inputValidation(billQA) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(BillQA val) {
		return true;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (billQA.getId() == null) {
			billQA.setCreatedDate(ts);
		}
		billQA.setLastModifiedDate(ts);
		billQA.setMember(getSessionUser().getMember());
		getGenericManager().saveBillQA(billQA);
		// email
		sendEmail(billQA);

		System.out.println("query=" + query);
		if (query == 1) {
			System.out.println("return NONE");
			return "none";
		} else {
			appendXworkParam("bill.id=" + billQA.getBill().getId());
			return SUCCESS;
		}

	}

	public void sendEmail(BillQA billQA) {
		try {
			List<Member> ls = billQA.getNotifications();
			String subject = "[" + billQA.getBillId() + "] 訂單QA通知";
			String content = "[時間] : " + Tools.formatSimpleDate1(Tools.getCurrentTimestamp()) + "<p>"
					+ "[訂單編號] : " + billQA.getBillId() + "<p>" + "[客戶] : "
					+ billQA.getBill().getCustomer().getName() + "<p>" + "[人員] : "
					+ billQA.getMember().getName() + "<p>" + "[客戶反應問題] : " + billQA.getQuestion() + "<p>"
					+ "[處理方式] :" + billQA.getAnswer();
			
			for (Member member : ls) {
				System.out.println("sendEmail name=" + member.getName() + "--" + member.getEmail());
				if (Tools.isValidEmailAddress(member.getEmail())) {
					
					getGenericManager().sendEmail(member.getEmail(), subject, content);
				}
			}
			
			//外加寄送給yimin@cip.com.tw / ken@cip.com.tw
			getGenericManager().sendEmail("yimin@cip.com.tw", subject, content);
			getGenericManager().sendEmail("ken@cip.com.tw", subject, content);
		} catch (Exception e) {
			System.out.println("sendEmail err=" + e.toString());
		}
	}

	public String list() {
		try {
			System.out.println("list bill.getId()=" + bill.getId());
			bill = getGenericManager().getBillById(bill.getId());
		} catch (Exception e) {
		}
		return SUCCESS;
	}

	protected void beanToForm() {
		if (billQA.getNotifications() != null) {
			Set<Member> s = new HashSet();
			List ls = billQA.getNotifications();
			for (int i = 0; i < ls.size(); i++) {
				member = (Member) ls.get(i);
				s.add(member);
			}
			notificationsIds = getGenericManager().getIdsFromMemberList(s);
		}
	}

	protected void formToBean() {
		log.info("enter formToBean()");

		List<Member> ls = new ArrayList<Member>();
		Set s = getGenericManager().getMemberListByIds(notificationsIds);
		if (s != null) {
			Iterator i = s.iterator();
			while (i.hasNext()) {
				member = (Member) i.next();
				ls.add(member);
			}
		}

		billQA.setNotifications(ls);
		billQA.setBill(getGenericManager().getBillById(billQA.getBillId()));
		log.info("exit formToBean()");
	}

	public List<Customer> getCustomerList() {
		return getGenericManager().getCustomerList(); // TODO
	}

	public List<Bill> getBillList() {
		return getGenericManager().getBillList(); // TODO
	}

	public List<BillQA> getBillQAList() {
		bill = getGenericManager().getBillById(bill.getId());
		return getGenericManager().getBillQAList(bill);
	}

	public List<BillQA> getBillQAListQuery() {
		if (customerId != null) {
			customer = getGenericManager().getCustomerById(customerId);
		}
		return getGenericManager().getBillQAList(startDate, endDate, billno, customer);
	}

	public void setSelectedBillQAIds(Long[] val) {
		selectedBillQAIds = val;
	}

	public Long[] getSelectedBillQAIds() {
		return selectedBillQAIds;
	}

	public List getMemberList() {
		List gl = getGenericManager().getMemberList();
		return removeFromList(gl, billQA.getNotifications());
	}

	public List getObject_memberList() {
		return (billQA.getNotifications() == null) ? new java.util.ArrayList() : billQA.getNotifications();
	}
}
