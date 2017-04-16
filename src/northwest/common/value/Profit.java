package northwest.common.value;

import com.common.value.Member;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.math.BigDecimal;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Profit implements Serializable {

    private static final long serialVersionUID = 1L;

    int pid;

    private String id;

    String projectNo;

    String projectName;

    /** nullable persistent field */
    private String salesNo;

    String billNo;

    /** nullable persistent field */
    private Integer salesPrice;

    /** nullable persistent field */
    private Integer salesCost;

    /** nullable persistent field */
    private Integer purchase;

    /** nullable persistent field */
    private Integer profit;

	Integer fee;
    
    Integer recdiscount;

    /** nullable persistent field */
    private BigDecimal profitPerc;

    /** nullable persistent field */
    private String billDate;

    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private Long customerId;

    /** nullable persistent field */
    private Member salesmen;
    private Long salesmenId;

    int discount;

    String remark;

    boolean standcost;

    /** full constructor */
    public Profit(String salesNo, Integer salesPrice, Integer salesCost,
	    Integer purchase, Integer profit, BigDecimal profitPerc,
	    String billDate, northwest.common.value.Customer customer,
	    Member salesmen) {
	this.salesNo = salesNo;
	this.salesPrice = salesPrice;
	this.salesCost = salesCost;
	this.purchase = purchase;
	this.profit = profit;
	this.profitPerc = profitPerc;
	this.billDate = billDate;
	this.customer = customer;
	this.salesmen = salesmen;
    }

    /** Labor constructor */
    public Profit() {
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getProjectNo() {
	return projectNo;
    }

    public void setProjectNo(String projectNo) {
	this.projectNo = projectNo;
    }

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    public String getSalesNo() {
	return this.salesNo;
    }

    public void setSalesNo(String salesNo) {
	this.salesNo = salesNo;
    }

    public Integer getSalesPrice() {
	return this.salesPrice;
    }

    public void setSalesPrice(Integer salesPrice) {
	this.salesPrice = salesPrice;
    }

    public Integer getSalesCost() {
	return this.salesCost;
    }

    public void setSalesCost(Integer salesCost) {
	this.salesCost = salesCost;
    }

    public Integer getPurchase() {
	return this.purchase;
    }

    public void setPurchase(Integer purchase) {
	this.purchase = purchase;
    }

    public Integer getProfit() {
	return this.profit;
    }

    public void setProfit(Integer profit) {
	this.profit = profit;
    }

    public BigDecimal getProfitPerc() {
	return this.profitPerc;
    }

    public void setProfitPerc(BigDecimal profitPerc) {
	this.profitPerc = profitPerc;
    }

    public String getBillDate() {
	return this.billDate;
    }

    public void setBillDate(String billDate) {
	this.billDate = billDate;
    }

    public northwest.common.value.Customer getCustomer() {
	return this.customer;
    }

    public void setCustomer(northwest.common.value.Customer customer) {
	this.customer = customer;
    }

    public Member getSalesmen() {
	return this.salesmen;
    }

    public void setSalesmen(Member salesmen) {
	this.salesmen = salesmen;
    }

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
    }

    public int getPid() {
	return pid;
    }

    public void setPid(int pid) {
	this.pid = pid;
    }
    
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
    
    public boolean isStandcost() {
        return standcost;
    }

    public void setStandcost(boolean standcost) {
        this.standcost = standcost;
    }
    
    public Integer getRecdiscount() {
        return recdiscount;
    }

    public void setRecdiscount(Integer recdiscount) {
        this.recdiscount = recdiscount;
    }
    
    public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}
    
    public String toString() {
	return new ToStringBuilder(this).append("salesNo", getSalesNo())
		.append("salesPrice", getSalesPrice())
		.append("salesCost", getSalesCost())
		.append("purchase", getPurchase())
		.append("profit", getProfit())
		.append("profitPerc", getProfitPerc())
		.append("billDate", getBillDate())
		.append("customer", getCustomer())
		.append("salesmen", getSalesmen()).toString();
    }

    public String getCaption_() {
	return toString();
    }

}
