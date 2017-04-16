package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class RecipientDB implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String recipient;

    /** persistent field */
    private String recipientPhone;

    /** persistent field */
    private String recipientAddress;

    /** full constructor */
    public RecipientDB(String recipient, String recipientPhone, String recipientAddress) {
        this.recipient = recipient;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
    }

    /** default constructor */
    public RecipientDB() {
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientPhone() {
        return this.recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recipient", getRecipient())
            .append("recipientPhone", getRecipientPhone())
            .append("recipientAddress", getRecipientAddress())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
