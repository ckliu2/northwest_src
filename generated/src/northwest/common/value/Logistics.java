package northwest.common.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Logistics implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String code;

    /** nullable persistent field */
    private String otherBills;

    /** persistent field */
    private String sender;

    /** persistent field */
    private String senderPhone;

    /** persistent field */
    private String senderAddress;

    /** nullable persistent field */
    private String senderMemo;

    /** persistent field */
    private String recipient;

    /** persistent field */
    private String recipientPhone;

    /** persistent field */
    private String recipientAddress;

    /** persistent field */
    private Date serviceDate;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private AppProperty time;
    private Long timeId;

    /** full constructor */
    public Logistics(String code, String otherBills, String sender, String senderPhone, String senderAddress, String senderMemo, String recipient, String recipientPhone, String recipientAddress, Date serviceDate, Date lastModifiedDate, Date createdDate, northwest.common.value.Bill bill, Member member, AppProperty time) {
        this.code = code;
        this.otherBills = otherBills;
        this.sender = sender;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.senderMemo = senderMemo;
        this.recipient = recipient;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
        this.serviceDate = serviceDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.bill = bill;
        this.member = member;
        this.time = time;
    }

    /** default constructor */
    public Logistics() {
    }

    /** minimal constructor */
    public Logistics(String code, String sender, String senderPhone, String senderAddress, String recipient, String recipientPhone, String recipientAddress, Date serviceDate, Date lastModifiedDate, Date createdDate, northwest.common.value.Bill bill, Member member, AppProperty time) {
        this.code = code;
        this.sender = sender;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.recipient = recipient;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
        this.serviceDate = serviceDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.bill = bill;
        this.member = member;
        this.time = time;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOtherBills() {
        return this.otherBills;
    }

    public void setOtherBills(String otherBills) {
        this.otherBills = otherBills;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderPhone() {
        return this.senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return this.senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderMemo() {
        return this.senderMemo;
    }

    public void setSenderMemo(String senderMemo) {
        this.senderMemo = senderMemo;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientPhone() {
        return this.recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Date getServiceDate() {
        return this.serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
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

    public AppProperty getTime() {
        return this.time;
    }

    public void setTime(AppProperty time) {
        this.time = time;
    }

    public Long getTimeId() {
        if (this.time != null && this.time.getId() != null)
            return time.getId();
        return this.timeId;
    }

    public void setTimeId(Long id) {
        this.timeId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("code", getCode())
            .append("otherBills", getOtherBills())
            .append("sender", getSender())
            .append("senderPhone", getSenderPhone())
            .append("senderAddress", getSenderAddress())
            .append("senderMemo", getSenderMemo())
            .append("recipient", getRecipient())
            .append("recipientPhone", getRecipientPhone())
            .append("recipientAddress", getRecipientAddress())
            .append("serviceDate", getServiceDate())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("bill", getBill())
            .append("member", getMember())
            .append("time", getTime())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
