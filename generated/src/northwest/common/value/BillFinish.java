package northwest.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillFinish implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** full constructor */
    public BillFinish(Date createdDate, northwest.common.value.Bill bill) {
        this.createdDate = createdDate;
        this.bill = bill;
    }

    /** default constructor */
    public BillFinish() {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("createdDate", getCreatedDate())
            .append("bill", getBill())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
