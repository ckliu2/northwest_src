package com.cip.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String id;
    
    /** nullable persistent field */
    private String projectName;

    /** full constructor */
    public Project(String projectName) {
        this.projectName = projectName;
    }

    /** default constructor */
    public Project() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("projectName", getProjectName())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
