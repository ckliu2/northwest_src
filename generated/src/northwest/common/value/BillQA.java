package northwest.common.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillQA implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String question;

    /** nullable persistent field */
    private String answer;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** nullable persistent field */
    private Member member;
    private Long memberId;

    /** nullable persistent field */
    private List notifications;

    /** full constructor */
    public BillQA(String question, String answer, Date lastModifiedDate, Date createdDate, northwest.common.value.Bill bill, Member member, List notifications) {
        this.question = question;
        this.answer = answer;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.bill = bill;
        this.member = member;
        this.notifications = notifications;
    }

    /** default constructor */
    public BillQA() {
    }

    /** minimal constructor */
    public BillQA(Date lastModifiedDate, Date createdDate) {
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
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

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public northwest.common.value.Bill getBill() {
        return this.bill;
    }

    public void setBill(northwest.common.value.Bill bill) {
        this.bill = bill;
    }

    public Long getBillId() {
        if (this.bill != null && this.bill.getId() != null)
            return bill.getId();
        return this.billId;
    }

    public void setBillId(Long id) {
        this.billId = id;
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getMemberId() {
        if (this.member != null && this.member.getId() != null)
            return member.getId();
        return this.memberId;
    }

    public void setMemberId(Long id) {
        this.memberId = id;
    }

    public List getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List notifications) {
        this.notifications = notifications;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("question", getQuestion())
            .append("answer", getAnswer())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("bill", getBill())
            .append("member", getMember())
            .append("notifications", getNotifications())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
