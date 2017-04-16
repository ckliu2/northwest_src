package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String name;

    /** full constructor */
    public ProductUnit(String name) {
        this.name = name;
    }

    /** default constructor */
    public ProductUnit() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
