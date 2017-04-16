package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class FunctionAuthority extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Boolean editable;

    /** persistent field */
    private com.base.value.Group group;
    private Long groupId;

    /** full constructor */
    public FunctionAuthority(Boolean editable, com.base.value.Group group) {
        this.editable = editable;
        this.group = group; 
    }

    /** Labor constructor */
    public FunctionAuthority() {
    }

    /** minimal constructor */
    public FunctionAuthority(com.base.value.Group group) {
        this.group = group;
    }

    public Boolean getEditable() {
        return this.editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public com.base.value.Group getGroup() {
        return this.group;
    }

    public void setGroup(com.base.value.Group group) {
        this.group = group;
    }

    public Long getGroupId() {
        if (this.group != null && this.group.getId() != null)
            return group.getId();
        return this.groupId;
    }

    public void setGroupId(Long id) {
        this.groupId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("editable", getEditable())
            .append("group", getGroup())
            .toString();
    }
    
    public String getCaption_()
    {
        return "[" + group.getCaption_() + "]";
    }

    public boolean equals(Object arg0)
    {
        if (arg0 == null || !(arg0 instanceof FunctionAuthority)) 
            return false;
        FunctionAuthority fa = (FunctionAuthority)arg0;
        if (group != null)
            return group.equals(fa.getGroup());
        
        return super.equals(arg0);
    }

    public int hashCode()
    {
        if (group != null)
            return group.hashCode();
        return super.hashCode();
    }

}
