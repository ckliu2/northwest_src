package northwest.common.value;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CustomerScreen implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String memo;
    
    /** nullable persistent field */
    private String name;

	/** nullable persistent field */
    private northwest.common.value.CustomerDetail customerDetail;
    private Long customerDetailId;

    /** nullable persistent field */
    private List customerScreenFiles;

    /** full constructor */
    public CustomerScreen(String memo, northwest.common.value.CustomerDetail customerDetail, List customerScreenFiles) {
        this.memo = memo;
        this.customerDetail = customerDetail;
        this.customerScreenFiles = customerScreenFiles;
    }

    /** Labor constructor */
    public CustomerScreen() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
		return name;
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

    public northwest.common.value.CustomerDetail getCustomerDetail() {
        return this.customerDetail;
    }

    public void setCustomerDetail(northwest.common.value.CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public Long getCustomerDetailId() {
        if (this.customerDetail != null && this.customerDetail.getId() != null)
            return customerDetail.getId();
        return this.customerDetailId;
    }

    public void setCustomerDetailId(Long id) {
        this.customerDetailId = id;
    }

    public List getCustomerScreenFiles() {
        return this.customerScreenFiles;
    }

    public void setCustomerScreenFiles(List customerScreenFiles) {
        this.customerScreenFiles = customerScreenFiles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("memo", getMemo())
            .append("customerDetail", getCustomerDetail())
            .append("customerScreenFiles", getCustomerScreenFiles())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
