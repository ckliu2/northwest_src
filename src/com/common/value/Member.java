package com.common.value;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;

/** @author Hibernate CodeGenerator */
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	/** nullable persistent field */

	private String id;
	private String name;
	/** nullable persistent field */
	private String idNo;
	/** nullable persistent field */
	private String phone;
	/** nullable persistent field */
	private Boolean enabled;
	private int flag;
	private String flagName;
	String email;

	/** nullable persistent field */
	private Set groups;

	/** Labor constructor */
	public Member() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set getGroups() {
		return this.groups;
	}

	public void setGroups(Set groups) {
		this.groups = groups;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getFlagName() {
		if (flag == 1) {
			return "員工";
		} else {
			return "廠商";
		}
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return new ToStringBuilder(this)	        
	            .append("email", getEmail())
	            .append("name", getName())
	            .toString();
	}

	public String getCaption_() {
		return toString();
	}

}
