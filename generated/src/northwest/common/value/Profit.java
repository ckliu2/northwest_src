package northwest.common.value;

import com.common.value.Member;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Profit implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String projectNo;

    /** nullable persistent field */
    private String projectName;

    /** nullable persistent field */
    private String billNo;

    /** nullable persistent field */
    private String salesNo;

    /** nullable persistent field */
    private Integer salesPrice;

    /** nullable persistent field */
    private Integer salesCost;

    /** nullable persistent field */
    private Integer purchase;

    /** nullable persistent field */
    private Integer profit;

    /** nullable persistent field */
    private Integer discount;

    /** nullable persistent field */
    private Integer recdiscount;

    /** nullable persistent field */
    private BigDecimal profitPerc;
    private Long profitPercId;

    /** nullable persistent field */
    private String billDate;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private Boolean standcost;

    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private Long customerId;

    /** nullable persistent field */
    private Member salesmen;
    private Long salesmenId;

    /** full constructor */
    public Profit(String projectNo, String projectName, String billNo, String salesNo, Integer salesPrice, Integer salesCost, Integer purchase, Integer profit, Integer discount, Integer recdiscount, BigDecimal profitPerc, String billDate, String remark, Boolean standcost, northwest.common.value.Customer customer, Member salesmen) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.billNo = billNo;
        this.salesNo = salesNo;
        this.salesPrice = salesPrice;
        this.salesCost = salesCost;
        this.purchase = purchase;
        this.profit = profit;
        this.discount = discount;
        this.recdiscount = recdiscount;
        this.profitPerc = profitPerc;
        this.billDate = billDate;
        this.remark = remark;
        this.standcost = standcost;
        this.customer = customer;
        this.salesmen = salesmen;
    }

    /** default constructor */
    public Profit() {
    }

    public String getProjectNo() {
        return this.projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBillNo() {
        return this.billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
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

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getRecdiscount() {
        return this.recdiscount;
    }

    public void setRecdiscount(Integer recdiscount) {
        this.recdiscount = recdiscount;
    }

    public BigDecimal getProfitPerc() {
        return this.profitPerc;
    }

    public void setProfitPerc(BigDecimal profitPerc) {
        this.profitPerc = profitPerc;
    }

    public Long getProfitPercId() {
        if (this.profitPerc != null && this.profitPerc.getId() != null)
            return profitPerc.getId();
        return this.profitPercId;
    }

    public void setProfitPercId(Long id) {
        this.profitPercId = id;
    }

    public String getBillDate() {
        return this.billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getStandcost() {
        return this.standcost;
    }

    public void setStandcost(Boolean standcost) {
        this.standcost = standcost;
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

    public Member getSalesmen() {
        return this.salesmen;
    }

    public void setSalesmen(Member salesmen) {
        this.salesmen = salesmen;
    }

    public Long getSalesmenId() {
        if (this.salesmen != null && this.salesmen.getId() != null)
            return salesmen.getId();
        return this.salesmenId;
    }

    public void setSalesmenId(Long id) {
        this.salesmenId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("projectNo", getProjectNo())
            .append("projectName", getProjectName())
            .append("billNo", getBillNo())
            .append("salesNo", getSalesNo())
            .append("salesPrice", getSalesPrice())
            .append("salesCost", getSalesCost())
            .append("purchase", getPurchase())
            .append("profit", getProfit())
            .append("discount", getDiscount())
            .append("recdiscount", getRecdiscount())
            .append("profitPerc", getProfitPerc())
            .append("billDate", getBillDate())
            .append("remark", getRemark())
            .append("standcost", getStandcost())
            .append("customer", getCustomer())
            .append("salesmen", getSalesmen())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
