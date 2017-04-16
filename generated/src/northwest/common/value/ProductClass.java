package northwest.common.value;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductClass implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String className;

    /** nullable persistent field */
    private List expectionFlows;

    /** full constructor */
    public ProductClass(String className, List expectionFlows) {
        this.className = className;
        this.expectionFlows = expectionFlows;
    }

    /** default constructor */
    public ProductClass() {
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List getExpectionFlows() {
        return this.expectionFlows;
    }

    public void setExpectionFlows(List expectionFlows) {
        this.expectionFlows = expectionFlows;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("className", getClassName())
            .append("expectionFlows", getExpectionFlows())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
