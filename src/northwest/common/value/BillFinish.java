package northwest.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillFinish implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long id;  
	
    /** persistent field */
    private Date createdDate;
    
	private Bill bill;

    /** full constructor */
    public BillFinish(Bill bill,Date createdDate) {
        this.createdDate = createdDate;
        this.bill = bill;
    }

    /** Labor constructor */
    public BillFinish() {
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("createdDate", getCreatedDate())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
