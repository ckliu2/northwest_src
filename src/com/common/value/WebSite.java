package com.common.value;

import com.base.value.AppProperty;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class WebSite extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** identifier field */
    private Long id;

    /** persistent field */
    private String code;

    /** persistent field */
    private String name;

//    /** persistent field */
//    private String title;
//
//    /** persistent field */
//    private String keyword;
//
//    /** persistent field */
//    private String description;

    /** persistent field */
    private String homeUri;

    /** nullable persistent field */
    private String domain;

    /** persistent field */
    private AppProperty country;
    private Long countryId;

    /** nullable persistent field */
    private List functionCategory;
    
    /** nullable persistent field */
    private AppProperty seoDesc;
    private Long seoDescId;

    /** nullable persistent field */
    private AppProperty seoKeyword;
    private Long seoKeywordId;

    /** nullable persistent field */
    private AppProperty seoTitle;
    private Long seoTitleId;

    /** full constructor */
    public WebSite(String name, String title, String keyword, String description, String homeUri, String domain, AppProperty country, List functionCategory) {
        this.name = name;
//        this.title = title;
//        this.keyword = keyword;
//        this.description = description;
        this.homeUri = homeUri;
        this.domain = domain;
        this.country = country;
        this.functionCategory = functionCategory;
    }

    /** Labor constructor */
    public WebSite() {
    }

    /** minimal constructor */
    public WebSite(String name, String title, String keyword, String description, String homeUri, AppProperty country) {
        this.name = name;
//        this.title = title;
//        this.keyword = keyword;
//        this.description = description;
        this.homeUri = homeUri;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getKeyword() {
//        return this.keyword;
//    }
//
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public String getHomeUri() {
        return this.homeUri;
    }

    public void setHomeUri(String homeUri) {
        this.homeUri = homeUri;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public AppProperty getCountry() {
        return this.country;
    }

    public void setCountry(AppProperty country) {
        this.country = country;
    }

    public Long getCountryId() {
        if (this.country != null && this.country.getId() != null)
            return country.getId();
        return this.countryId;
    }

    public void setCountryId(Long id) {
        this.countryId = id;
    }

    public List getFunctionCategory() {
        return this.functionCategory;
    }

    public void setFunctionCategory(List functionCategory) {
        this.functionCategory = functionCategory;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("name", getName())
//            .append("title", getTitle())
//            .append("keyword", getKeyword())
//            .append("description", getDescription())
            .append("homeUri", getHomeUri())
            .append("domain", getDomain())
            .append("country", getCountry())
            .append("functionCategory", getFunctionCategory())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public AppProperty getSeoDesc()
    {
        return seoDesc;
    }

    public void setSeoDesc(AppProperty seoDesc)
    {
        this.seoDesc = seoDesc;
    }

    public Long getSeoDescId()
    {
        if (this.seoDesc != null && this.seoDesc.getId() != null)
            return seoDesc.getId();
        return this.seoDescId;
    }

    public void setSeoDescId(Long seoDescId)
    {
        this.seoDescId = seoDescId;
    }

    public AppProperty getSeoKeyword()
    {
        return seoKeyword;
    }

    public void setSeoKeyword(AppProperty seoKeyword)
    {
        this.seoKeyword = seoKeyword;
    }

    public Long getSeoKeywordId()
    {
        if (this.seoKeyword != null && this.seoKeyword.getId() != null)
            return seoKeyword.getId();
        return this.seoKeywordId;
    }

    public void setSeoKeywordId(Long seoKeywordId)
    {
        this.seoKeywordId = seoKeywordId;
    }

    public AppProperty getSeoTitle()
    {
        return seoTitle; 
    }

    public void setSeoTitle(AppProperty seoTitle)
    {
        this.seoTitle = seoTitle;
    }

    public Long getSeoTitleId()
    {
        if (this.seoTitle != null && this.seoTitle.getId() != null)
            return seoTitle.getId();
        return this.seoTitleId;
    }

    public void setSeoTitleId(Long seoTitleId)
    {
        this.seoTitleId = seoTitleId;
    }

//    public Long getCharacterId() {
//        if (this.character != null && this.character.getId() != null)
//            return character.getId();
//        return this.characterId;
//    }
    
}
