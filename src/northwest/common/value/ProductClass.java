package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.List;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String id; 
    
    
    /** nullable persistent field */
    private String className;
    
    /** nullable persistent field */
    private List expectionFlows;

    /** full constructor */
    public ProductClass(String className) {
        this.className = className;
    }

    /** Labor constructor */
    public ProductClass() {
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public List getExpectionFlows() {
        return this.expectionFlows;
    }

    public void setExpectionFlows(List expectionFlows) {
        this.expectionFlows = expectionFlows;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("className", getClassName())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
