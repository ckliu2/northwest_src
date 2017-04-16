package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProfitFee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String id;

	Bill bill;

	/** nullable persistent field */
    private Integer billDate;

    /** nullable persistent field */
    private Integer localtotal;

    /** nullable persistent field */
    private Integer localtax;

    /** nullable persistent field */
    private Integer sumfee;

    /** full constructor */
    public ProfitFee(Integer billDate, Integer localtotal, Integer localtax, Integer sumfee) {
        this.billDate = billDate;
        this.localtotal = localtotal;
        this.localtax = localtax;
        this.sumfee = sumfee;
    }

    /** default constructor */
    public ProfitFee() {
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
    
    public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("billDate", getBillDate())
            .append("localtotal", getLocaltotal())
            .append("localtax", getLocaltax())
            .append("sumfee", getSumfee())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
