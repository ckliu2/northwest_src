package northwest.common.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PostProductions implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private northwest.common.value.BillSchedule billschedule;
    private Long billscheduleId;

    /** full constructor */
    public PostProductions(Date createdDate, Member member, northwest.common.value.BillSchedule billschedule) {
        this.createdDate = createdDate;
        this.member = member;
        this.billschedule = billschedule;
    }

    /** default constructor */
    public PostProductions() {
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public northwest.common.value.BillSchedule getBillschedule() {
        return this.billschedule;
    }

    public void setBillschedule(northwest.common.value.BillSchedule billschedule) {
        this.billschedule = billschedule;
    }

    public Long getBillscheduleId() {
        if (this.billschedule != null && this.billschedule.getId() != null)
            return billschedule.getId();
        return this.billscheduleId;
    }

    public void setBillscheduleId(Long id) {
        this.billscheduleId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("billschedule", getBillschedule())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
