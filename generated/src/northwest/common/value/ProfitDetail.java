package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProfitDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String salesNo;

    /** nullable persistent field */
    private Integer item;

    /** nullable persistent field */
    private Integer rowNo;

    /** nullable persistent field */
    private String salesDetail;

    /** nullable persistent field */
    private String salesItemMark;

    /** nullable persistent field */
    private Integer salesPrice;

    /** nullable persistent field */
    private Integer salesCost;

    /** nullable persistent field */
    private String buyNo;

    /** nullable persistent field */
    private String company;

    /** nullable persistent field */
    private Integer purchasePrice;

    /** nullable persistent field */
    private String purchaseDetail;

    /** nullable persistent field */
    private String purchaseItemMark;

    /** nullable persistent field */
    private Integer purchaseRowNo;

    /** nullable persistent field */
    private Integer discount;

    /** nullable persistent field */
    private Integer profit;

    /** nullable persistent field */
    private Float profitPerc;

    /** nullable persistent field */
    private String billDate;

    /** nullable persistent field */
    private String descript;

    /** nullable persistent field */
    private Boolean standcost;

    /** nullable persistent field */
    private Float unit1;

    /** nullable persistent field */
    private Float unit2;

    /** nullable persistent field */
    private Float unit3;

    /** nullable persistent field */
    private northwest.common.value.ProductClass productClass;
    private Long productClassId;

    /** nullable persistent field */
    private northwest.common.value.Profit project;
    private Long projectId;

    /** nullable persistent field */
    private northwest.common.value.Product product;
    private Long productId;

    /** nullable persistent field */
    private northwest.common.value.Profit profitNo;
    private Long profitNoId;

    /** full constructor */
    public ProfitDetail(String salesNo, Integer item, Integer rowNo, String salesDetail, String salesItemMark, Integer salesPrice, Integer salesCost, String buyNo, String company, Integer purchasePrice, String purchaseDetail, String purchaseItemMark, Integer purchaseRowNo, Integer discount, Integer profit, Float profitPerc, String billDate, String descript, Boolean standcost, Float unit1, Float unit2, Float unit3, northwest.common.value.ProductClass productClass, northwest.common.value.Profit project, northwest.common.value.Product product, northwest.common.value.Profit profitNo) {
        this.salesNo = salesNo;
        this.item = item;
        this.rowNo = rowNo;
        this.salesDetail = salesDetail;
        this.salesItemMark = salesItemMark;
        this.salesPrice = salesPrice;
        this.salesCost = salesCost;
        this.buyNo = buyNo;
        this.company = company;
        this.purchasePrice = purchasePrice;
        this.purchaseDetail = purchaseDetail;
        this.purchaseItemMark = purchaseItemMark;
        this.purchaseRowNo = purchaseRowNo;
        this.discount = discount;
        this.profit = profit;
        this.profitPerc = profitPerc;
        this.billDate = billDate;
        this.descript = descript;
        this.standcost = standcost;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.unit3 = unit3;
        this.productClass = productClass;
        this.project = project;
        this.product = product;
        this.profitNo = profitNo;
    }

    /** default constructor */
    public ProfitDetail() {
    }

    public String getSalesNo() {
        return this.salesNo;
    }

    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo;
    }

    public Integer getItem() {
        return this.item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getRowNo() {
        return this.rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public String getSalesDetail() {
        return this.salesDetail;
    }

    public void setSalesDetail(String salesDetail) {
        this.salesDetail = salesDetail;
    }

    public String getSalesItemMark() {
        return this.salesItemMark;
    }

    public void setSalesItemMark(String salesItemMark) {
        this.salesItemMark = salesItemMark;
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

    public String getBuyNo() {
        return this.buyNo;
    }

    public void setBuyNo(String buyNo) {
        this.buyNo = buyNo;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseDetail() {
        return this.purchaseDetail;
    }

    public void setPurchaseDetail(String purchaseDetail) {
        this.purchaseDetail = purchaseDetail;
    }

    public String getPurchaseItemMark() {
        return this.purchaseItemMark;
    }

    public void setPurchaseItemMark(String purchaseItemMark) {
        this.purchaseItemMark = purchaseItemMark;
    }

    public Integer getPurchaseRowNo() {
        return this.purchaseRowNo;
    }

    public void setPurchaseRowNo(Integer purchaseRowNo) {
        this.purchaseRowNo = purchaseRowNo;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getProfit() {
        return this.profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Float getProfitPerc() {
        return this.profitPerc;
    }

    public void setProfitPerc(Float profitPerc) {
        this.profitPerc = profitPerc;
    }

    public String getBillDate() {
        return this.billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getDescript() {
        return this.descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Boolean getStandcost() {
        return this.standcost;
    }

    public void setStandcost(Boolean standcost) {
        this.standcost = standcost;
    }

    public Float getUnit1() {
        return this.unit1;
    }

    public void setUnit1(Float unit1) {
        this.unit1 = unit1;
    }

    public Float getUnit2() {
        return this.unit2;
    }

    public void setUnit2(Float unit2) {
        this.unit2 = unit2;
    }

    public Float getUnit3() {
        return this.unit3;
    }

    public void setUnit3(Float unit3) {
        this.unit3 = unit3;
    }

    public northwest.common.value.ProductClass getProductClass() {
        return this.productClass;
    }

    public void setProductClass(northwest.common.value.ProductClass productClass) {
        this.productClass = productClass;
    }

    public Long getProductClassId() {
        if (this.productClass != null && this.productClass.getId() != null)
            return productClass.getId();
        return this.productClassId;
    }

    public void setProductClassId(Long id) {
        this.productClassId = id;
    }

    public northwest.common.value.Profit getProject() {
        return this.project;
    }

    public void setProject(northwest.common.value.Profit project) {
        this.project = project;
    }

    public Long getProjectId() {
        if (this.project != null && this.project.getId() != null)
            return project.getId();
        return this.projectId;
    }

    public void setProjectId(Long id) {
        this.projectId = id;
    }

    public northwest.common.value.Product getProduct() {
        return this.product;
    }

    public void setProduct(northwest.common.value.Product product) {
        this.product = product;
    }

    public Long getProductId() {
        if (this.product != null && this.product.getId() != null)
            return product.getId();
        return this.productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public northwest.common.value.Profit getProfitNo() {
        return this.profitNo;
    }

    public void setProfitNo(northwest.common.value.Profit profitNo) {
        this.profitNo = profitNo;
    }

    public Long getProfitNoId() {
        if (this.profitNo != null && this.profitNo.getId() != null)
            return profitNo.getId();
        return this.profitNoId;
    }

    public void setProfitNoId(Long id) {
        this.profitNoId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("salesNo", getSalesNo())
            .append("item", getItem())
            .append("rowNo", getRowNo())
            .append("salesDetail", getSalesDetail())
            .append("salesItemMark", getSalesItemMark())
            .append("salesPrice", getSalesPrice())
            .append("salesCost", getSalesCost())
            .append("buyNo", getBuyNo())
            .append("company", getCompany())
            .append("purchasePrice", getPurchasePrice())
            .append("purchaseDetail", getPurchaseDetail())
            .append("purchaseItemMark", getPurchaseItemMark())
            .append("purchaseRowNo", getPurchaseRowNo())
            .append("discount", getDiscount())
            .append("profit", getProfit())
            .append("profitPerc", getProfitPerc())
            .append("billDate", getBillDate())
            .append("descript", getDescript())
            .append("standcost", getStandcost())
            .append("unit1", getUnit1())
            .append("unit2", getUnit2())
            .append("unit3", getUnit3())
            .append("productClass", getProductClass())
            .append("project", getProject())
            .append("product", getProduct())
            .append("profitNo", getProfitNo())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
