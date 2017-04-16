package com.common.value;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Long id;
    
    
    /** persistent field */
    private String name;

    /** persistent field */
    private String ename;   


	/** nullable persistent field */
    private Set members;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private String lastModifiedUser;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private String createdUser;

    /** full constructor */
    public Unit(String name, String ename, Date lastModifiedDate, String lastModifiedUser, Date createdDate, String createdUser) {
        this.name = name;
        this.ename = ename;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public Unit() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String toString() {    	
      return getName();
      /*return new ToStringBuilder(this)
            .append("name", getName())
            .append("ename", getEname())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdDate", getCreatedDate())
            .append("createdUser", getCreatedUser())
            .toString();*/
    }

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id 的設定的 id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
    public String getCaption_()
    {
        return getName();
    }
    
    public Set getMembers() {
		return members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

}
