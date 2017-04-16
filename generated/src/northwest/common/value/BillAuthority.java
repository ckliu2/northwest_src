package northwest.common.value;

import com.base.value.Group;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillAuthority implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** nullable persistent field */
    private Group group;
    private Long groupId;

    /** full constructor */
    public BillAuthority(northwest.common.value.Bill bill, Group group) {
        this.bill = bill;
        this.group = group;
    }

    /** default constructor */
    public BillAuthority() {
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

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getGroupId() {
        if (this.group != null && this.group.getId() != null)
            return group.getId();
        return this.groupId;
    }

    public void setGroupId(Long id) {
        this.groupId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bill", getBill())
            .append("group", getGroup())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
