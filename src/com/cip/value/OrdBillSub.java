package com.cip.value;

import com.base.value.AppProperty;

import java.io.Serializable;

import northwest.common.value.Product;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class OrdBillSub extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    
    /** nullable persistent field */
    private Integer flag;

    /** nullable persistent field */
    private Integer rowNO;

    /** nullable persistent field */
    private Integer width;

    /** nullable persistent field */
    private Integer heigh;

    /** nullable persistent field */
    private Integer vwidth;

    /** nullable persistent field */
    private Integer vheigh;

    /** nullable persistent field */
    private String calcDisp;

    /** nullable persistent field */
    private Integer calcArea;

    /** nullable persistent field */
    private Integer paperPrice;

    /** nullable persistent field */
    private Integer paperCount;

    /** nullable persistent field */
    private Integer sprice;

    /** nullable persistent field */
    private Integer amount;

    /** nullable persistent field */
    private Integer squantity;

    /** nullable persistent field */
    private Integer quantity;

    /** nullable persistent field */
    private Integer equantity;

    /** nullable persistent field */
    private String preInDate;

    /** nullable persistent field */
    private Boolean isGift;

    /** nullable persistent field */
    private Integer qtyRemain;

    /** nullable persistent field */
    private String detail;

    /** nullable persistent field */
    private String itemRemark;

    /** nullable persistent field */
    private com.cip.value.OrderBill orderBill;
    private Long orderBillId;

    /** nullable persistent field */
    private Product product;
    private String productId;

    /** nullable persistent field */
    private AppProperty crement;
    private Long crementId;

    /** full constructor */
    public OrdBillSub(Integer flag, Integer rowNO, Integer width, Integer heigh, Integer vwidth, Integer vheigh, String calcDisp, Integer calcArea, Integer paperPrice, Integer paperCount, Integer sprice, Integer amount, Integer squantity, Integer quantity, Integer equantity, String preInDate, Boolean isGift, Integer qtyRemain, String detail, String itemRemark, com.cip.value.OrderBill orderBill, Product product, AppProperty crement) {
        this.flag = flag;
        this.rowNO = rowNO;
        this.width = width;
        this.heigh = heigh;
        this.vwidth = vwidth;
        this.vheigh = vheigh;
        this.calcDisp = calcDisp;
        this.calcArea = calcArea;
        this.paperPrice = paperPrice;
        this.paperCount = paperCount;
        this.sprice = sprice;
        this.amount = amount;
        this.squantity = squantity;
        this.quantity = quantity;
        this.equantity = equantity;
        this.preInDate = preInDate;
        this.isGift = isGift;
        this.qtyRemain = qtyRemain;
        this.detail = detail;
        this.itemRemark = itemRemark;
        this.orderBill = orderBill;
        this.product = product;
        this.crement = crement;
    }

    /** default constructor */
    public OrdBillSub() {
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

    public Integer getRowNO() {
        return this.rowNO;
    }

    public void setRowNO(Integer rowNO) {
        this.rowNO = rowNO;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeigh() {
        return this.heigh;
    }

    public void setHeigh(Integer heigh) {
        this.heigh = heigh;
    }

    public Integer getVwidth() {
        return this.vwidth;
    }

    public void setVwidth(Integer vwidth) {
        this.vwidth = vwidth;
    }

    public Integer getVheigh() {
        return this.vheigh;
    }

    public void setVheigh(Integer vheigh) {
        this.vheigh = vheigh;
    }

    public String getCalcDisp() {
        return this.calcDisp;
    }

    public void setCalcDisp(String calcDisp) {
        this.calcDisp = calcDisp;
    }

    public Integer getCalcArea() {
        return this.calcArea;
    }

    public void setCalcArea(Integer calcArea) {
        this.calcArea = calcArea;
    }

    public Integer getPaperPrice() {
        return this.paperPrice;
    }

    public void setPaperPrice(Integer paperPrice) {
        this.paperPrice = paperPrice;
    }

    public Integer getPaperCount() {
        return this.paperCount;
    }

    public void setPaperCount(Integer paperCount) {
        this.paperCount = paperCount;
    }

    public Integer getSprice() {
        return this.sprice;
    }

    public void setSprice(Integer sprice) {
        this.sprice = sprice;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSquantity() {
        return this.squantity;
    }

    public void setSquantity(Integer squantity) {
        this.squantity = squantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getEquantity() {
        return this.equantity;
    }

    public void setEquantity(Integer equantity) {
        this.equantity = equantity;
    }

    public String getPreInDate() {
        return this.preInDate;
    }

    public void setPreInDate(String preInDate) {
        this.preInDate = preInDate;
    }

    public Boolean getIsGift() {
        return this.isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public Integer getQtyRemain() {
        return this.qtyRemain;
    }

    public void setQtyRemain(Integer qtyRemain) {
        this.qtyRemain = qtyRemain;
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

    public com.cip.value.OrderBill getOrderBill() {
        return this.orderBill;
    }

    public void setOrderBill(com.cip.value.OrderBill orderBill) {
        this.orderBill = orderBill;
    }

    public Long getOrderBillId() {
        if (this.orderBill != null && this.orderBill.getId() != null)
            return orderBill.getId();
        return this.orderBillId;
    }

    public void setOrderBillId(Long id) {
        this.orderBillId = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductId() {
        if (this.product != null && this.product.getId() != null)
            return product.getId();
        return this.productId;
    }

    public void setProductId(String id) {
        this.productId = id;
    }

    public AppProperty getCrement() {
        return this.crement;
    }

    public void setCrement(AppProperty crement) {
        this.crement = crement;
    }

    public Long getCrementId() {
        if (this.crement != null && this.crement.getId() != null)
            return crement.getId();
        return this.crementId;
    }

    public void setCrementId(Long id) {
        this.crementId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("flag", getFlag())
            .append("rowNO", getRowNO())
            .append("width", getWidth())
            .append("heigh", getHeigh())
            .append("vwidth", getVwidth())
            .append("vheigh", getVheigh())
            .append("calcDisp", getCalcDisp())
            .append("calcArea", getCalcArea())
            .append("paperPrice", getPaperPrice())
            .append("paperCount", getPaperCount())
            .append("sprice", getSprice())
            .append("amount", getAmount())
            .append("squantity", getSquantity())
            .append("quantity", getQuantity())
            .append("equantity", getEquantity())
            .append("preInDate", getPreInDate())
            .append("isGift", getIsGift())
            .append("qtyRemain", getQtyRemain())
            .append("detail", getDetail())
            .append("itemRemark", getItemRemark())
            .append("orderBill", getOrderBill())
            .append("product", getProduct())
            .append("crement", getCrement())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
