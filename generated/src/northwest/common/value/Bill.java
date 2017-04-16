package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String projectName;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private String userDef2;

    /** nullable persistent field */
    private String billDate;

    /** nullable persistent field */
    private Boolean state;

    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private Long customerId;

    /** full constructor */
    public Bill(String projectName, String remark, String userDef2, String billDate, Boolean state, northwest.common.value.Customer customer) {
        this.projectName = projectName;
        this.remark = remark;
        this.userDef2 = userDef2;
        this.billDate = billDate;
        this.state = state;
        this.customer = customer;
    }

    /** default constructor */
    public Bill() {
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserDef2() {
        return this.userDef2;
    }

    public void setUserDef2(String userDef2) {
        this.userDef2 = userDef2;
    }

    public String getBillDate() {
        return this.billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public Boolean getState() {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public northwest.common.value.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(northwest.common.value.Customer customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        if (this.customer != null && this.customer.getId() != null)
            return customer.getId();
        return this.customerId;
    }

    public void setCustomerId(Long id) {
        this.customerId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("projectName", getProjectName())
            .append("remark", getRemark())
            .append("userDef2", getUserDef2())
            .append("billDate", getBillDate())
            .append("state", getState())
            .append("customer", getCustomer())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
