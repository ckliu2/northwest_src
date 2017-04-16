package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductCombine implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Integer amount;

    /** persistent field */
    private northwest.common.value.Product product;
    private String productId;

    /** full constructor */
    public ProductCombine(Integer amount, northwest.common.value.Product product) {
        this.amount = amount;
        this.product = product;
    }

    /** Labor constructor */
    public ProductCombine() {
    }

    /** minimal constructor */
    public ProductCombine(northwest.common.value.Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("amount", getAmount())
            .append("product", getProduct())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }
    


}
