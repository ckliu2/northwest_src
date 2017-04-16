package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProfitDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	/** nullable persistent field */
	private String salesNo;

	/** nullable persistent field */
	private Integer item;

	private Integer rowNo;

	private Integer purchaseRowNo;

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
	private Integer profit;

	/** nullable persistent field */
	private Float profitPerc;

	/** nullable persistent field */
	private northwest.common.value.Profit project;
	private Long projectId;

	/** nullable persistent field */
	private northwest.common.value.Product product;
	private Long productId;

	ProductClass productClass;
	Long productClassId;

	String billDate;

	String descript;

	int discount;

	Profit profitNo;

	boolean standcost;

	Float unit1, unit2, unit3;

	/** Labor constructor */
	public ProfitDetail() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public northwest.common.value.Profit getProject() {
		return this.project;
	}

	public void setProject(northwest.common.value.Profit project) {
		this.project = project;
	}

	public northwest.common.value.Product getProduct() {
		return this.product;
	}

	public void setProduct(northwest.common.value.Product product) {
		this.product = product;
	}

	public ProductClass getProductClass() {
		return productClass;
	}

	public void setProductClass(ProductClass productClass) {
		this.productClass = productClass;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Long getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(Long productClassId) {
		this.productClassId = productClassId;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getRowNo() {
		return rowNo;
	}

	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}

	public Integer getPurchaseRowNo() {
		return purchaseRowNo;
	}

	public void setPurchaseRowNo(Integer purchaseRowNo) {
		this.purchaseRowNo = purchaseRowNo;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Profit getProfitNo() {
		return profitNo;
	}

	public void setProfitNo(Profit profitNo) {
		this.profitNo = profitNo;
	}

	public boolean isStandcost() {
		return standcost;
	}

	public void setStandcost(boolean standcost) {
		this.standcost = standcost;
	}

	public Float getUnit1() {
		return unit1;
	}

	public void setUnit1(Float unit1) {
		this.unit1 = unit1;
	}

	public Float getUnit2() {
		return unit2;
	}

	public void setUnit2(Float unit2) {
		this.unit2 = unit2;
	}

	public Float getUnit3() {
		return unit3;
	}

	public void setUnit3(Float unit3) {
		this.unit3 = unit3;
	}

	public String toString() {
		return new ToStringBuilder(this).append("salesNo", getSalesNo()).append("item", getItem()).append("salesDetail", getSalesDetail()).append("salesItemMark", getSalesItemMark()).append("salesPrice", getSalesPrice()).append("salesCost", getSalesCost()).append("buyNo", getBuyNo()).append("company", getCompany()).append("purchasePrice", getPurchasePrice()).append("purchaseDetail", getPurchaseDetail()).append("purchaseItemMark", getPurchaseItemMark()).append("profit", getProfit()).append("profitPerc", getProfitPerc()).append("project", getProject()).append("product", getProduct()).toString();
	}

	public String getCaption_() {
		return toString();
	}

}
