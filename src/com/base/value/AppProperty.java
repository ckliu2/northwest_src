package com.base.value;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/** @author Hibernate CodeGenerator */
public class AppProperty extends BaseObject implements Serializable {

    private static final long serialVersionUID = 100L;
    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String kind;

    private String subKind;

//    /** nullable persistent field */
//    private String valueCh;
//
//    /** nullable persistent field */
//    private String valueEn;

    /** nullable persistent field */
    private int seqNo = 1; 

    /** persistent field */
    private String valueTw;

    /** persistent field */
    private String valueUs;

    /** Labor constructor */
    public AppProperty() {
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getKind() {
        return this.kind;
    }

    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    public int getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String toString() {
        return getValue();
        /*
        return new ToStringBuilder(this)
            .append("id\n", getId())
            .append("kind\n", getKind())
            .append("value\n", getValue())
            .append("seqNo\n", getSeqNo())
            .toString();
            */
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AppProperty) ) return false;
        AppProperty castOther = (AppProperty) other;
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
        if (isTw())
            return getValueTw();
        
        if (isUs())
            return getValueUs();

        return null;
    }

//    public String getValueCh()
//    {
//        return valueCh;
//    }
//
//    public void setValueCh(String valueCh)
//    {
//        this.valueCh = valueCh;
//    }
//
//    public String getValueEn()
//    {
//        return valueEn;
//    }
//
//    public void setValueEn(String valueEn)
//    {
//        this.valueEn = valueEn;
//    }
    
    public String getCaption_()
    {
        return getValue();
    }

    public String getSubKind()
    {
        return subKind;
    }

    public void setSubKind(String subKind)
    {
        this.subKind = subKind;
    }

    public String getValueTw()
    {
        return valueTw;
    }

    public void setValueTw(String valueTw)
    {
        this.valueTw = valueTw;
    }

    public String getValueUs()
    {
        return valueUs;
    }

    public void setValueUs(String valueUs)
    {
        this.valueUs = valueUs;
    }
}
