package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CustomerStandardCost implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Float cost;

    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private Long customerId;

    /** nullable persistent field */
    private northwest.common.value.Product product;
    private Long productId;

    /** full constructor */
    public CustomerStandardCost(Float cost, northwest.common.value.Customer customer, northwest.common.value.Product product) {
        this.cost = cost;
        this.customer = customer;
        this.product = product;
    }

    /** default constructor */
    public CustomerStandardCost() {
    }

    public Float getCost() {
        return this.cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
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
            .append("cost", getCost())
            .append("customer", getCustomer())
            .append("product", getProduct())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
