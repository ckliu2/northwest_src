package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CustomerStandardCost implements Serializable {

    private static final long serialVersionUID = 1L;

	Long id;
    
    /** nullable persistent field */
    private Float cost;

    /** nullable persistent field */
    private northwest.common.value.Customer customer;
    private String customerId;

    /** nullable persistent field */
    private northwest.common.value.Product product;
    private String productId;

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

    public String getCustomerId() {
        if (this.customer != null && this.customer.getId() != null)
            return customer.getId();
        return this.customerId;
    }

    public void setCustomerId(String id) {
        this.customerId = id;
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
            .append("cost", getCost())
            .append("customer", getCustomer())
            .append("product", getProduct())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
