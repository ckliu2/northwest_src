package com.base.value;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Function extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** persistent field */
    private Integer seqNo; 

    /** persistent field */
    private String funKey;

    /** persistent field */
    private String funNameCh;

    /** persistent field */
    private String funNameEn;
    
    private String descCh;
    private String descEn;

    /** persistent field */
    private String funUrl;

    /** nullable persistent field */
    private Date editBegin;

    /** nullable persistent field */
    private Date editEnd;

    /** nullable persistent field */
    private com.base.value.FunctionCategory category;
    private Long categoryId;

    /** nullable persistent field */
    private List<FunctionAuthority> authority = new java.util.ArrayList<FunctionAuthority>();
    
    private Boolean disabled = new Boolean(false);

    /** full constructor */
    public Function(Long id, Integer seqNo, String funKey, String funName, String funUrl, Date editBegin, Date editEnd, com.base.value.FunctionCategory category, List authority) {
        this.id = id;
        this.funKey = funKey;
        this.funNameCh = funName;
        this.funUrl = funUrl;
        this.editBegin = editBegin;
        this.editEnd = editEnd;
        this.category = category;
        this.authority = authority;
        this.seqNo = seqNo;
    }

    /** Labor constructor */
    public Function() {
    }

    /** minimal constructor */
    public Function(Long id, Integer seqNo, String funKey, String funName, String funUrl) {
        this.id = id;
        this.funKey = funKey;
        this.funNameCh = funName;
        this.funUrl = funUrl;
        this.seqNo = seqNo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunKey() {
        return this.funKey;
    }

    public void setFunKey(String funKey) {
        this.funKey = funKey;
    }

    public String getFunName() {
        if (isCh())
            return getFunNameCh();

        if (isEn())
            return getFunNameEn();

        return null;
    }

    public String getDesc() {
        if (isCh())
            return getDescCh();

        if (isEn())
            return getDescEn();

        return null;
    }

    public String getFunUrl() {
        return this.funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    public Date getEditBegin() {
        return this.editBegin;
    }

    public void setEditBegin(Date editBegin) {
        this.editBegin = editBegin;
    }

    public Date getEditEnd() {
        return this.editEnd;
    }

    public void setEditEnd(Date editEnd) {
        this.editEnd = editEnd;
    }

    public com.base.value.FunctionCategory getCategory() {
        return this.category;
    }

    public void setCategory(com.base.value.FunctionCategory category) {
        this.category = category;
    }

    public Long getCategoryId() {
        if (this.category != null && this.category.getId() != null)
            return category.getId();
        return this.categoryId;
    }

    public void setCategoryId(Long id) {
        this.categoryId = id;
    }

    public List getAuthority() {
        return this.authority;
    }

    public void setAuthority(List authority) {
        this.authority = authority;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("funKey", getFunKey())
            .append("funName", getFunName())
            .append("funUrl", getFunUrl())
            .append("editBegin", getEditBegin())
            .append("editEnd", getEditEnd())
            .append("category", getCategory())
            .append("authority", getAuthority())
            .toString();
    }

    public Integer getSeqNo()
    {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo)
    {
        this.seqNo = seqNo;
    }

    public boolean equals(Object arg0)
    {
        if (arg0 == null || !(arg0 instanceof Function))
            return false;
        
        Function fun = (Function) arg0;
        if (fun.getId().longValue() == this.getId().longValue())
            return true;
        
        return false;
    }

    public int hashCode()
    {
        return this.getId().intValue();
    }
    
    public boolean containGroup(Group gp)
    {
        if (getAuthority() == null || gp == null)
            return false;
        
        FunctionAuthority gg = null;
        for (int i=0; i < getAuthority().size(); i++) {
            gg = (FunctionAuthority) getAuthority().get(i);
            if (gg.getGroup() != null && gg.getGroup().getId().longValue() == gp.getId().longValue()) {
                return true;
            }
        }
        return false;
    }
    

    
    

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getFunNameCh()
    {
        return funNameCh;
    }

    public void setFunNameCh(String funNameCh)
    {
        this.funNameCh = funNameCh;
    }

    public String getFunNameEn()
    {
        return funNameEn;
    }

    public void setFunNameEn(String funNameEn)
    {
        this.funNameEn = funNameEn;
    }
    
    public String getCaption_()
    {
        return getFunName();
    }
//    public List getFunctionAuthorityByGroup(List gl)
//    {
//        
//    }

    public String getDescCh()
    {
        return descCh;
    }

    public void setDescCh(String descCh)
    {
        this.descCh = descCh;
    }

    public String getDescEn()
    {
        return descEn;
    }

    public void setDescEn(String descEn)
    {
        this.descEn = descEn;
    }

}
