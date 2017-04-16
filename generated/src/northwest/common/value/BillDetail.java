package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Integer fromRow;

    /** nullable persistent field */
    private Integer price;

    /** nullable persistent field */
    private Float width;

    /** nullable persistent field */
    private Float heigh;

    /** nullable persistent field */
    private Float visibleWidth;

    /** nullable persistent field */
    private Float visibleHeigh;

    /** nullable persistent field */
    private Integer calcArea;

    /** nullable persistent field */
    private Integer area;

    /** nullable persistent field */
    private Integer quantity;

    /** nullable persistent field */
    private Integer basicQuantity;

    /** nullable persistent field */
    private String detail;

    /** nullable persistent field */
    private String itemRemark;

    /** nullable persistent field */
    private Integer paperPrice;

    /** nullable persistent field */
    private Float amount;

    /** nullable persistent field */
    private String complete;

    /** nullable persistent field */
    private String uncomplete;

    /** nullable persistent field */
    private northwest.common.value.Product product;
    private Long productId;

    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** full constructor */
    public BillDetail(Integer fromRow, Integer price, Float width, Float heigh, Float visibleWidth, Float visibleHeigh, Integer calcArea, Integer area, Integer quantity, Integer basicQuantity, String detail, String itemRemark, Integer paperPrice, Float amount, String complete, String uncomplete, northwest.common.value.Product product, northwest.common.value.Bill bill) {
        this.fromRow = fromRow;
        this.price = price;
        this.width = width;
        this.heigh = heigh;
        this.visibleWidth = visibleWidth;
        this.visibleHeigh = visibleHeigh;
        this.calcArea = calcArea;
        this.area = area;
        this.quantity = quantity;
        this.basicQuantity = basicQuantity;
        this.detail = detail;
        this.itemRemark = itemRemark;
        this.paperPrice = paperPrice;
        this.amount = amount;
        this.complete = complete;
        this.uncomplete = uncomplete;
        this.product = product;
        this.bill = bill;
    }

    /** default constructor */
    public BillDetail() {
    }

    public Integer getFromRow() {
        return this.fromRow;
    }

    public void setFromRow(Integer fromRow) {
        this.fromRow = fromRow;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Float getWidth() {
        return this.width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeigh() {
        return this.heigh;
    }

    public void setHeigh(Float heigh) {
        this.heigh = heigh;
    }

    public Float getVisibleWidth() {
        return this.visibleWidth;
    }

    public void setVisibleWidth(Float visibleWidth) {
        this.visibleWidth = visibleWidth;
    }

    public Float getVisibleHeigh() {
        return this.visibleHeigh;
    }

    public void setVisibleHeigh(Float visibleHeigh) {
        this.visibleHeigh = visibleHeigh;
    }

    public Integer getCalcArea() {
        return this.calcArea;
    }

    public void setCalcArea(Integer calcArea) {
        this.calcArea = calcArea;
    }

    public Integer getArea() {
        return this.area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getBasicQuantity() {
        return this.basicQuantity;
    }

    public void setBasicQuantity(Integer basicQuantity) {
        this.basicQuantity = basicQuantity;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getItemRemark() {
        return this.itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public Integer getPaperPrice() {
        return this.paperPrice;
    }

    public void setPaperPrice(Integer paperPrice) {
        this.paperPrice = paperPrice;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getComplete() {
        return this.complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getUncomplete() {
        return this.uncomplete;
    }

    public void setUncomplete(String uncomplete) {
        this.uncomplete = uncomplete;
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
            .append("fromRow", getFromRow())
            .append("price", getPrice())
            .append("width", getWidth())
            .append("heigh", getHeigh())
            .append("visibleWidth", getVisibleWidth())
            .append("visibleHeigh", getVisibleHeigh())
            .append("calcArea", getCalcArea())
            .append("area", getArea())
            .append("quantity", getQuantity())
            .append("basicQuantity", getBasicQuantity())
            .append("detail", getDetail())
            .append("itemRemark", getItemRemark())
            .append("paperPrice", getPaperPrice())
            .append("amount", getAmount())
            .append("complete", getComplete())
            .append("uncomplete", getUncomplete())
            .append("product", getProduct())
            .append("bill", getBill())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
