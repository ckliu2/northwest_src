package northwest.common.value;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;
import com.common.value.Member;

/** @author Hibernate CodeGenerator */
public class ProductUnitX implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    String id;

	private String name;

	int count;
	
	public ProductUnitX(){
		
	}

    /** default constructor */
    public ProductUnitX(String id,String name) {
    	this.id=id;
    	this.name=name;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
