package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    String id;

	private String name;

	int count;

    /** full constructor */
    public ProductUnit(String id,String name) {
        this.id = id;
        this.name = name;
    }

    /** default constructor */
    public ProductUnit() {
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
