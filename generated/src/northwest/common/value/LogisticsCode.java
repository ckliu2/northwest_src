package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class LogisticsCode implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String code;

    /** persistent field */
    private northwest.common.value.Logistics logistics;
    private Long logisticsId;

    /** full constructor */
    public LogisticsCode(String code, northwest.common.value.Logistics logistics) {
        this.code = code;
        this.logistics = logistics;
    }

    /** default constructor */
    public LogisticsCode() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public northwest.common.value.Logistics getLogistics() {
        return this.logistics;
    }

    public void setLogistics(northwest.common.value.Logistics logistics) {
        this.logistics = logistics;
    }

    public Long getLogisticsId() {
        if (this.logistics != null && this.logistics.getId() != null)
            return logistics.getId();
        return this.logisticsId;
    }

    public void setLogisticsId(Long id) {
        this.logisticsId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("code", getCode())
            .append("logistics", getLogistics())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
