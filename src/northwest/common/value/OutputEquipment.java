package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class OutputEquipment implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String memo;

	private Integer maxChi,hourChi;

    /** full constructor */
    public OutputEquipment(String name, String memo) {
        this.name = name;
        this.memo = memo;
    }

    /** Labor constructor */
    public OutputEquipment() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getMaxChi() {
        return this.maxChi;
    }

    public void setMaxChi(Integer maxChi) {
        this.maxChi = maxChi;
    }
    
    public Integer getHourChi() {
		return hourChi;
	}

	public void setHourChi(Integer hourChi) {
		this.hourChi = hourChi;
	}
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("name", getName())
            .append("memo", getMemo())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
