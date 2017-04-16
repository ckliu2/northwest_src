package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class StandardCost implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String salesNo;

    /** nullable persistent field */
    private Float cost;

    /** nullable persistent field */
    private northwest.common.value.Product product;
    private Long productId;

    /** full constructor */
    public StandardCost(String salesNo, Float cost, northwest.common.value.Product product) {
        this.salesNo = salesNo;
        this.cost = cost;
        this.product = product;
    }

    /** default constructor */
    public StandardCost() {
    }

    public String getSalesNo() {
        return this.salesNo;
    }

    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo;
    }

    public Float getCost() {
        return this.cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("salesNo", getSalesNo())
            .append("cost", getCost())
            .append("product", getProduct())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
