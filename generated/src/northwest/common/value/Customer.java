package northwest.common.value;

import com.common.value.Member;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String linkMan;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String telephone;

    /** nullable persistent field */
    private Member saleman;
    private Long salemanId;

    /** full constructor */
    public Customer(String name, String linkMan, String address, String telephone, Member saleman) {
        this.name = name;
        this.linkMan = linkMan;
        this.address = address;
        this.telephone = telephone;
        this.saleman = saleman;
    }

    /** default constructor */
    public Customer() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkMan() {
        return this.linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Member getSaleman() {
        return this.saleman;
    }

    public void setSaleman(Member saleman) {
        this.saleman = saleman;
    }

    public Long getSalemanId() {
        if (this.saleman != null && this.saleman.getId() != null)
            return saleman.getId();
        return this.salemanId;
    }

    public void setSalemanId(Long id) {
        this.salemanId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("linkMan", getLinkMan())
            .append("address", getAddress())
            .append("telephone", getTelephone())
            .append("saleman", getSaleman())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
