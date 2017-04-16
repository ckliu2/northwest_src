package northwest.common.value;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String productName;

    /** nullable persistent field */
    private String unit;

    /** nullable persistent field */
    private northwest.common.value.ProductClass productClass;
    private Long productClassId;

    /** nullable persistent field */
    private northwest.common.value.ProductUnit productUnit;
    private Long productUnitId;

    /** nullable persistent field */
    private List combine;

    /** full constructor */
    public Product(String productName, String unit, northwest.common.value.ProductClass productClass, northwest.common.value.ProductUnit productUnit, List combine) {
        this.productName = productName;
        this.unit = unit;
        this.productClass = productClass;
        this.productUnit = productUnit;
        this.combine = combine;
    }

    /** default constructor */
    public Product() {
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public northwest.common.value.ProductUnit getProductUnit() {
        return this.productUnit;
    }

    public void setProductUnit(northwest.common.value.ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    public Long getProductUnitId() {
        if (this.productUnit != null && this.productUnit.getId() != null)
            return productUnit.getId();
        return this.productUnitId;
    }

    public void setProductUnitId(Long id) {
        this.productUnitId = id;
    }

    public List getCombine() {
        return this.combine;
    }

    public void setCombine(List combine) {
        this.combine = combine;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("productName", getProductName())
            .append("unit", getUnit())
            .append("productClass", getProductClass())
            .append("productUnit", getProductUnit())
            .append("combine", getCombine())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
