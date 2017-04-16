package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class SenderDB implements Serializable {

    private static final long serialVersionUID = 1L;

	Long id;
    
    /** persistent field */
    private String sender;

    /** persistent field */
    private String senderPhone;

    /** persistent field */
    private String senderAddress;

    /** nullable persistent field */
    private String senderMemo;

    /** full constructor */
    public SenderDB(String sender, String senderPhone, String senderAddress, String senderMemo) {
        this.sender = sender;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.senderMemo = senderMemo;
    }

    /** default constructor */
    public SenderDB() {
    }

    /** minimal constructor */
    public SenderDB(String sender, String senderPhone, String senderAddress) {
        this.sender = sender;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderPhone() {
        return this.senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return this.senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderMemo() {
        return this.senderMemo;
    }

    public void setSenderMemo(String senderMemo) {
        this.senderMemo = senderMemo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sender", getSender())
            .append("senderPhone", getSenderPhone())
            .append("senderAddress", getSenderAddress())
            .append("senderMemo", getSenderMemo())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
