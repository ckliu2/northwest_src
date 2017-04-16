package com.common.value;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;    


	private Long id;
    
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private Set members;

    /** full constructor */
    public Grade(String name, Date createdDate, Set members) {
        this.name = name;
        this.createdDate = createdDate;
        this.members = members;
    }

    /** Labor constructor */
    public Grade() {
    }

    /** minimal constructor */
    public Grade(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set getMembers() {
        return this.members;
    }

    public void setMembers(Set members) {
        this.members = members;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String toString() {
        return getName();
    }

    public String getCaption_() {
        return toString();
    }

}
