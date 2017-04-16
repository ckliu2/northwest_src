package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.*;
import com.base.value.BaseObject;
import com.common.value.Member;

/** @author Hibernate CodeGenerator */
public class BillQA implements Serializable {

	Long id;

	private static final long serialVersionUID = 1L;
	/** nullable persistent field */
	private String question;

	/** nullable persistent field */
	private String answer;

	/** nullable persistent field */
	private northwest.common.value.Bill bill;
	private String billId;

	Date lastModifiedDate, createdDate;

	Member member;

	List notifications;

	String notificationMembers;

	/** full constructor */
	public BillQA(String question, String answer, northwest.common.value.Bill bill) {
		this.question = question;
		this.answer = answer;
		this.bill = bill;
	}

	/** default constructor */
	public BillQA() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public northwest.common.value.Bill getBill() {
		return this.bill;
	}

	public void setBill(northwest.common.value.Bill bill) {
		this.bill = bill;
	}

	public String getBillId() {
		if (this.bill != null && this.bill.getId() != null)
			return bill.getId();
		return this.billId;
	}

	public void setBillId(String id) {
		this.billId = id;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List getNotifications() {
		return notifications;
	}

	public void setNotifications(List notifications) {
		this.notifications = notifications;
	}

	public String getNotificationMembers() {
		String names = "";
		List<Member> ls = notifications;
		for (Member member : ls) {
			names += member.getName() + " , ";
		}
		return names;
	}

	public String toString() {
		return new ToStringBuilder(this).append("question", getQuestion()).append("answer", getAnswer())
				.append("bill", getBill()).toString();
	}

	public String getCaption_() {
		return toString();
	}

}
