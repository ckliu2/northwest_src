package com.common.web.action;

import com.base.value.FunctionCategory;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Feb 25 06:47:03 CST 2007
*/

public class FunctionCategoryAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private FunctionCategory functionCategory;

    public FunctionCategoryAction()
    {
        log = LogFactory.getLog(com.common.web.action.FunctionCategoryAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("FUNCTIONCATEGORY");
    }

    public FunctionCategory getFunctionCategory()
    {
        return functionCategory;
    }

    public void setFunctionCategory(FunctionCategory val)
    {
        functionCategory = val;
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
        getGenericManager().removeFunctionCategory(functionCategory.getId());
        return DELETE;
    }

    public String edit()
    {
        if (functionCategory == null || functionCategory.getId() == null) {
            functionCategory = new FunctionCategory();
        } else {
            functionCategory = getGenericManager().getFunctionCategoryById(functionCategory.getId());
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
            if (inputValidation(functionCategory) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(FunctionCategory val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveFunctionCategory(functionCategory);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        log.info("exit formToBean()");
    }
    public List getFunctionCategoryList()
    {
        return getGenericManager().getFunctionCategoryList();
    }
}
