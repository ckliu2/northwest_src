package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class FunctionCategory extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** persistent field */
    private Integer seqNo;

    /** persistent field */
    private String nameCh;

    /** persistent field */
    private String nameEn; 
    
    private Boolean isFront = new Boolean(false);

    /** full constructor */
    public FunctionCategory(Long id, Integer seqNo, String ename, String cname) {
        this.id = id;
        this.seqNo = seqNo;
        this.nameCh = cname;
        this.nameEn = ename;
    }

    /** Labor constructor */
    public FunctionCategory() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("seqNo", getSeqNo())
            .append("nameCh", getNameCh())
            .append("nameEn", getNameEn())
            .toString();
    }

    public String getNameCh()
    {
        return nameCh;
    }

    public void setNameCh(String nameCh)
    {
        this.nameCh = nameCh;
    }

    public String getNameEn()
    {
        return nameEn;
    }

    public void setNameEn(String nameEn)
    {
        this.nameEn = nameEn;
    }
    
    public String getName()
    {
        if (isCh())
            return getNameCh();
        
        if (isEn()) 
            return getNameEn();
        
        return null;
    }

    public String getCaption_()
    {
        if (isFront != null && isFront.booleanValue() == true)
            return getName() + "(可用於前台)";
        
        return getName();
    }

    public Boolean getIsFront()
    {
        return isFront;
    }

    public void setIsFront(Boolean isFront)
    {
        this.isFront = isFront;
    }

}
