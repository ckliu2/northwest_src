package com.cip.value;

import com.common.value.Member;
import java.io.Serializable;
import northwest.common.value.Customer;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class OrderBill extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    
    /** nullable persistent field */
    private Integer flag;

    /** nullable persistent field */
    private String billNo;

    /** nullable persistent field */
    private String billDate;

    /** nullable persistent field */
    private String addressID;

    /** nullable persistent field */
    private String zipCode;

    /** nullable persistent field */
    private String custAddress;

    /** nullable persistent field */
    private String linkMan;

    /** nullable persistent field */
    private String linkManProf;

    /** nullable persistent field */
    private String linkTelephone;

    /** nullable persistent field */
    private String detail;

    /** nullable persistent field */
    private String projectName;

    /** nullable persistent field */
    private com.cip.value.Project project;
    private String projectId;

    /** nullable persistent field */
    private Customer customer;
    private String customerId;

    /** nullable persistent field */
    private Member salesMan;
    private String salesManId;

    /** nullable persistent field */
    private Member maker;
    private String makerId;

    /** full constructor */
    public OrderBill(Integer flag, String billNo, String billDate, String addressID, String zipCode, String custAddress, String linkMan, String linkManProf, String linkTelephone, String detail, String projectName, com.cip.value.Project project, Customer customer, Member salesMan, Member maker) {
        this.flag = flag;
        this.billNo = billNo;
        this.billDate = billDate;
        this.addressID = addressID;
        this.zipCode = zipCode;
        this.custAddress = custAddress;
        this.linkMan = linkMan;
        this.linkManProf = linkManProf;
        this.linkTelephone = linkTelephone;
        this.detail = detail;
        this.projectName = projectName;
        this.project = project;
        this.customer = customer;
        this.salesMan = salesMan;
        this.maker = maker;
    }

    /** default constructor */
    public OrderBill() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getBillNo() {
        return this.billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillDate() {
        return this.billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getAddressID() {
        return this.addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCustAddress() {
        return this.custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getLinkMan() {
        return this.linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkManProf() {
        return this.linkManProf;
    }

    public void setLinkManProf(String linkManProf) {
        this.linkManProf = linkManProf;
    }

    public String getLinkTelephone() {
        return this.linkTelephone;
    }

    public void setLinkTelephone(String linkTelephone) {
        this.linkTelephone = linkTelephone;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public com.cip.value.Project getProject() {
        return this.project;
    }

    public void setProject(com.cip.value.Project project) {
        this.project = project;
    }

    public String getProjectId() {
        if (this.project != null && this.project.getId() != null)
            return project.getId();
        return this.projectId;
    }

    public void setProjectId(String id) {
        this.projectId = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
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

    public Member getSalesMan() {
        return this.salesMan;
    }

    public void setSalesMan(Member salesMan) {
        this.salesMan = salesMan;
    }

    public String getSalesManId() {
        if (this.salesMan != null && this.salesMan.getId() != null)
            return salesMan.getId();
        return this.salesManId;
    }

    public void setSalesManId(String id) {
        this.salesManId = id;
    }

    public Member getMaker() {
        return this.maker;
    }

    public void setMaker(Member maker) {
        this.maker = maker;
    }

    public String getMakerId() {
        if (this.maker != null && this.maker.getId() != null)
            return maker.getId();
        return this.makerId;
    }

    public void setMakerId(String id) {
        this.makerId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("flag", getFlag())
            .append("billNo", getBillNo())
            .append("billDate", getBillDate())
            .append("addressID", getAddressID())
            .append("zipCode", getZipCode())
            .append("custAddress", getCustAddress())
            .append("linkMan", getLinkMan())
            .append("linkManProf", getLinkManProf())
            .append("linkTelephone", getLinkTelephone())
            .append("detail", getDetail())
            .append("projectName", getProjectName())
            .append("project", getProject())
            .append("customer", getCustomer())
            .append("salesMan", getSalesMan())
            .append("maker", getMaker())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
