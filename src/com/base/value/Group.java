package com.base.value;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import com.common.value.*;

/** @author Hibernate CodeGenerator */
public class Group extends BaseObject 
{

    private static final long serialVersionUID = 100L;
    public static final String GROUP_ADMIN        = "GROUP_ADMIN";      
    public static final String GROUP_GUEST        = "GROUP_GUEST";      
    public static final String GROUP_VENDOR       = "GROUP_VENDOR";     
    public static final String GROUP_SUPPLIER     = "GROUP_SUPPLIER";   
    public static final String GROUP_WEB_MEMBER   = "GROUP_WEB_MEMBER"; 
	private Set members;

    
    public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group group;



    
    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String groupKey;

    /** nullable persistent field */
    private String groupNameCh;
    private String groupNameEn;
    
    

       
    /** full constructor */
    public Group(java.lang.String groupKey, java.lang.String groupName) {
        this.groupKey = groupKey;
        this.groupNameCh = groupName; 
    }

    /** Labor constructor */
    public Group() {
    }

    public Group(Long id, String groupKey, String groupNameCh, String groupNameEn) {
        this.id = id;
        this.groupKey = groupKey;
        this.groupNameCh = groupNameCh;
        this.groupNameEn = groupNameEn;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String toString() {
        return getGroupName();
    }

    public boolean equals(Object other) {
        if ( other == null || !(other instanceof Group) ) return false;
        Group castOther = (Group) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

    public String getGroupKey()
    {
        return groupKey;
    }

    public void setGroupKey(String groupKey)
    {
        this.groupKey = groupKey;
    }

    public String getGroupName()
    {
        if (isCh())
            return getGroupNameCh();

        if (isEn())
            return getGroupNameEn();

        return null;
    }

    public String getGroupNameCh()
    {
        return groupNameCh;
    }

    public void setGroupNameCh(String groupNameCh)
    {
        this.groupNameCh = groupNameCh;
    }

    public String getGroupNameEn()
    {
        return groupNameEn;
    }

    public void setGroupNameEn(String groupNameEn)
    {
        this.groupNameEn = groupNameEn;
    }

    public String getCaption_()
    {
        return getGroupName();
    }  

	
    public Set getMembers() {
		return members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

}
