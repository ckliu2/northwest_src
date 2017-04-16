package com.base.value;
import java.util.*;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.util.Tools;


/** @author Hibernate CodeGenerator */
public class UploadedFile implements Serializable 
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id; 
    
    /** nullable persistent field */
    private String fileName;

    /** nullable persistent field */
    private Long size;

	private Date lastModifiedDate;

    /** full constructor */
    public UploadedFile(String fileName, Long size) {
        this.fileName = fileName;
        this.size = size;
        this.lastModifiedDate=Tools.getCurrentTimestamp();
    }
    
    

    /** Labor constructor */
    public UploadedFile() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    
    public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


    public String toString() {
        return new ToStringBuilder(this)
        .append(getId())
        .append(getFileName())
        .append(getSize())
        .toString();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
