package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class StandardCost implements Serializable {

    private static final long serialVersionUID = 1L;   


    Long id;
    
    /** nullable persistent field */
    private String salesNo;

    /** nullable persistent field */
    private float cost;


    /** nullable persistent field */
    private northwest.common.value.Product product;
    private String productId;

    

    public String getSalesNo() {
        return this.salesNo;
    }

    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public northwest.common.value.Product getProduct() {
        return this.product;
    }

    public void setProduct(northwest.common.value.Product product) {
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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
