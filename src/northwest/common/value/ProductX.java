package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.*;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductX implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    
    private String pid;  

	private String productId;  

	private String productName;

    /** nullable persistent field */
    private String unit;
    
    /** nullable persistent field */
    private ProductClass productClass;
    private String productClassId;

	Product product;

	int sumQuantity;
    int sumBasicQuantity;
	int sumNumber;

    
    /** nullable persistent field */
    private List combine;

    /** full constructor */
    public ProductX(String productName, String unit) {
        this.productName = productName;
        this.unit = unit;
    }

    /** Labor constructor */
    public ProductX() {
    }

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
    public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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
    
    public ProductClass getProductClass() {
        return this.productClass;
    }

    public void setProductClass(ProductClass productClass) {
        this.productClass = productClass;
    }
    
    public List getCombine() {
        return this.combine;
    }

    public void setCombine(List combine) {
        this.combine = combine;
    }

    public String getProductClassId() {
        if (this.productClass != null && this.productClass.getId() != null)
            return productClass.getId();
        return this.productClassId;
    }

    public void setProductClassId(String id) {
        this.productClassId = id;
    }
    
    public int getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(int sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public int getSumBasicQuantity() {
		return sumBasicQuantity;
	}

	public void setSumBasicQuantity(int sumBasicQuantity) {
		this.sumBasicQuantity = sumBasicQuantity;
	}
	
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
    public int getSumNumber() {
		return sumNumber;
	}

	public void setSumNumber(int sumNumber) {
		this.sumNumber = sumNumber;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("productName", getProductName())
            .append("unit", getUnit())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
