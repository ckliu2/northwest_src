package com.common.web.action;

import com.common.value.WebSite;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Mar 14 15:36:29 CST 2007
*/

public class WebSiteAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private WebSite webSite;
    private Long[] functionCategoryIds;

    public WebSiteAction()
    {
        log = LogFactory.getLog(com.common.web.action.WebSiteAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("WEB_SITE_MANAGEMENT");
    }

    public WebSite getWebSite()
    {
        return webSite;
    }

    public void setWebSite(WebSite val)
    {
        webSite = val;
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeWebSite(webSite.getId());
        return DELETE;
    }

    public String edit()
    {
        if (webSite == null) {
            webSite = new WebSite();
        } else if (webSite.getId() != null) {
            webSite = getGenericManager().getWebSiteById(webSite.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(webSite) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(WebSite val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveWebSite(webSite);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        functionCategoryIds = getGenericManager().getIdsFromFunctionCategoryList(webSite.getFunctionCategory());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        webSite.setSeoDesc(getAppPropertyById(webSite.getSeoDescId())); 
        webSite.setSeoTitle(getAppPropertyById(webSite.getSeoTitleId())); 
        webSite.setSeoKeyword(getAppPropertyById(webSite.getSeoKeywordId())); 
        webSite.setCountry(getAppPropertyById(webSite.getCountryId())); 
        webSite.setFunctionCategory(getGenericManager().getFunctionCategoryListByIds(functionCategoryIds)); 
        log.info("exit formToBean()");
    }
    public List getCountryList()
    {
        return getAppPropertyList("website.country");
    }


    public List getFunctionCategoryList()
    {
        List al = getGenericManager().getFrontFunctionCategoryList();
        if (al != null) {
            al.removeAll((webSite != null && webSite.getFunctionCategory() != null) ? webSite.getFunctionCategory() : new ArrayList());
            return al;
        }
        return new java.util.ArrayList();
    }

    public List getObject_functionCategoryList()
    {
        return (webSite.getFunctionCategory() == null) ? new java.util.ArrayList() : webSite.getFunctionCategory();
    }

    public void setFunctionCategoryIds(Long[] val)
    {
        functionCategoryIds = val;
    }

    public Long[] getFunctionCategoryIds()
    {
        return functionCategoryIds;
    }

    public List getWebSiteList()
    {
        return getGenericManager().getWebSiteList();
    }
}
