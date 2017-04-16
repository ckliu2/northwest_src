package northwest.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Freight implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private String contactName;

    /** persistent field */
    private String contactCellphone;

    /** persistent field */
    private String contactPhone;

    /** persistent field */
    private String contactEmail;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** full constructor */
    public Freight(String name, String contactName, String contactCellphone, String contactPhone, String contactEmail, Date lastModifiedDate, Date createdDate) {
        this.name = name;
        this.contactName = contactName;
        this.contactCellphone = contactCellphone;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    /** default constructor */
    public Freight() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactCellphone() {
        return this.contactCellphone;
    }

    public void setContactCellphone(String contactCellphone) {
        this.contactCellphone = contactCellphone;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("contactName", getContactName())
            .append("contactCellphone", getContactCellphone())
            .append("contactPhone", getContactPhone())
            .append("contactEmail", getContactEmail())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
