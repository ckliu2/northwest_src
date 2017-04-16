package com.base.value;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MiscCode extends BaseObject
{

    private static final long serialVersionUID = 100L;

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String codeName;

    /** nullable persistent field */
    private String keyName;

    /** nullable persistent field */
    private String valueCh; 
    private String valueEn; 

       
    /** full constructor */
    public MiscCode(java.lang.String codeName, java.lang.String keyName, String value) {
        this.codeName = codeName;
        this.keyName = keyName;
        this.valueCh = value;
    }

    /** Labor constructor */
    public MiscCode() {
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(java.lang.String codeName) {
        this.codeName = codeName;
    }

    public java.lang.String getKeyName() {
        return this.keyName;
    }

    public void setKeyName(java.lang.String keyName) {
        this.keyName = keyName;
    }


    public boolean equals(Object other) {
        if ( !(other instanceof MiscCode) ) return false;
        MiscCode castOther = (MiscCode) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

    public String getValue()
    {
        if (isCh())
            return getValueCh();
        
        if (isEn())
            return getValueEn();
        
        return null;
    }

    public String getValueCh()
    {
        return valueCh;
    }

    public void setValueCh(String valueCh)
    {
        this.valueCh = valueCh;
    }

    public String getValueEn()
    {
        return valueEn;
    }

    public void setValueEn(String valueEn)
    {
        this.valueEn = valueEn;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("codeName", getCodeName())
            .append("keyName", getKeyName())
            .append("valueCh", getValueCh())
            .append("valueEn", getValueEn())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
