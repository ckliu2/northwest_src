package com.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Checking extends BaseObject implements Serializable {
 
    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** persistent field */
    private String formName;

    /** persistent field */
    private Long formId;

    /** persistent field */
    private String actorName;

    /** persistent field */
    private String state;

    /** nullable persistent field */
    private String comment;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private String createdUser;

    /** full constructor */
    public Checking(String formName, Long formId, String actorName, String state, String comment, Date createdDate, String createdUser) {
        this.formName = formName;
        this.formId = formId;
        this.actorName = actorName;
        this.state = state;
        this.comment = comment;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public Checking() {
    }

    /** minimal constructor */
    public Checking(String formName, Long formId, String actorName, String state, Date createdDate, String createdUser) {
        this.formName = formName;
        this.formId = formId;
        this.actorName = actorName;
        this.state = state;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormName() {
        return this.formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Long getFormId() {
        return this.formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getActorName() {
        return this.actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("formName", getFormName())
            .append("formId", getFormId())
            .append("actorName", getActorName())
            .append("state", getState())
            .append("comment", getComment())
            .append("createdDate", getCreatedDate())
            .append("createdUser", getCreatedUser())
            .toString();
    }

}
