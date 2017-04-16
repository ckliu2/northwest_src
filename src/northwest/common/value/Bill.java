package northwest.common.value;

import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;
import java.util.Set;

import com.base.util.Tools;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;   

	private String id;    
    private String projectName;  
	private String remark;
	private String userDef2;
	String billDate;
	private Timestamp completionTime;
	boolean state;
	
    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private String customerId;

    /** full constructor */
    public Bill(String projectName, northwest.common.value.Customer customer) {
        this.projectName = projectName;
        this.customer = customer;
    }

    /** Labor constructor */
    public Bill() {    
    	
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public northwest.common.value.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(northwest.common.value.Customer customer) {
        this.customer = customer;
    }

    public String getCustomerId() {
        if (this.customer != null && this.customer.getId() != null)
            return customer.getId();
        return this.customerId;
    }

    public void setCustomerId(String id) {
        this.customerId = id;
    }

	public Timestamp getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Timestamp completionTime) {
		this.completionTime = completionTime;
	}
	
	public String getUserDef2() {
		return userDef2;
	}

	public void setUserDef2(String userDef2) {
		this.userDef2 = userDef2;
	}
	
	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("projectName", getProjectName())
            .append("customer", getCustomer())
            .toString();
    }
    
    public String getCaption_() {
        return toString();
    }

}
