package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProfitFee implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Integer billDate;

    /** nullable persistent field */
    private Integer localtotal;

    /** nullable persistent field */
    private Integer localtax;

    /** nullable persistent field */
    private Integer sumfee;

    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** full constructor */
    public ProfitFee(Integer billDate, Integer localtotal, Integer localtax, Integer sumfee, northwest.common.value.Bill bill) {
        this.billDate = billDate;
        this.localtotal = localtotal;
        this.localtax = localtax;
        this.sumfee = sumfee;
        this.bill = bill;
    }

    /** default constructor */
    public ProfitFee() {
    }

    public Integer getBillDate() {
        return this.billDate;
    }

    public void setBillDate(Integer billDate) {
        this.billDate = billDate;
    }

    public Integer getLocaltotal() {
        return this.localtotal;
    }

    public void setLocaltotal(Integer localtotal) {
        this.localtotal = localtotal;
    }

    public Integer getLocaltax() {
        return this.localtax;
    }

    public void setLocaltax(Integer localtax) {
        this.localtax = localtax;
    }

    public Integer getSumfee() {
        return this.sumfee;
    }

    public void setSumfee(Integer sumfee) {
        this.sumfee = sumfee;
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
            .append("billDate", getBillDate())
            .append("localtotal", getLocaltotal())
            .append("localtax", getLocaltax())
            .append("sumfee", getSumfee())
            .append("bill", getBill())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
