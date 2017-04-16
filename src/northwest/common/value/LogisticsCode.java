package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.*;

/** @author Hibernate CodeGenerator */
public class LogisticsCode implements Serializable {

    private static final long serialVersionUID = 1L;
    
	Long id;
    
    /** persistent field */
    private String code;
    
	Logistics logistics;

    /** full constructor */
    public LogisticsCode(String code) {
        this.code = code;
    }

    /** default constructor */
    public LogisticsCode() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("code", getCode())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
