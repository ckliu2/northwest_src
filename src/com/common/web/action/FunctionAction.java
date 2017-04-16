package com.common.web.action;

import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.Group;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
//import com.base.value.NameValue;
//import com.opensymphony.webwork.config.Configuration;
/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Feb 25 06:47:03 CST 2007
*/

public class FunctionAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Function function;
    private String editBegin;
    private String editEnd;
    private Long[] groupIds; //i.e., group Id

    public FunctionAction()
    {
        log = LogFactory.getLog(com.common.web.action.FunctionAction.class);
    }

    public Function getFunction()
    {
        return function;
    }

    public void setFunction(Function val)
    {
        function = val;
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
        getGenericManager().removeFunction(function.getId());
        return DELETE;
    }

    public String edit()
    {
        if (function == null || function.getId() == null) {
            function = new Function();
        } else {
            function = getGenericManager().getFunctionById(function.getId());
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
            if (inputValidation(function) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Function val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveFunction(function);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        editBegin = Tools.dateToString(function.getEditBegin());
        editEnd = Tools.dateToString(function.getEditEnd());
        groupIds = getGroupIdsFromFunctionAuthorityList(function.getAuthority());
        log.info("exit beanToForm()");
    }

    private Long[] getGroupIdsFromFunctionAuthorityList(List<FunctionAuthority> fal)
    {
        if (fal == null)
            return null;
        
        Long[] al = new Long[fal.size()];
        for (int i=0; i < al.length; i++) {
            al[i] = ((FunctionAuthority) fal.get(i)).getGroupId();
        }
        return al;
    }
    
    protected void formToBean()
    {
        log.info("enter formToBean()");
        function.setEditBegin(Tools.convertToDate(editBegin)); 
        function.setEditEnd(Tools.convertToDate(editEnd)); 
        function.setCategory(getGenericManager().getFunctionCategoryById(function.getCategoryId())); 
        function.setAuthority(getFunctionAuthorityListByGroupIds(getGroupIds())); 

        log.info("exit formToBean()");
    }
    
    private List getFunctionAuthorityListByGroupIds(Long[] ids)    
    {
    	List<Group> result = new ArrayList<Group>();
    	 for(int i=0;i<ids.length;i++){
    		 result.add( getGenericManager().getGroupById(ids[i]));
    	 }    	
        List al = getFunctionAuthorityListByGroupList(result);
        return al;
    }
    
    private List getFunctionAuthorityListByGroupList(List glist)
    {
        List result = new ArrayList();
        for (int i=0; glist != null && i < glist.size(); i++) {
            result.add(new FunctionAuthority((Group)glist.get(i)));
        }
        return result;
    }
    
    public void setEditBegin(String val)
    {
        editBegin = val;
    }

    public String getEditBegin()
    {
        return editBegin;
    }

    public void setEditEnd(String val)
    {
        editEnd = val;
    }

    public String getEditEnd()
    {
        return editEnd;
    }

    public List getCategoryList()
    {
        return getGenericManager().getFunctionCategoryList(); 
    }

    public List getAuthorityList()
    {
        List result = getFunctionAuthorityListByGroupList(getGenericManager().getGroupList());
        if (result != null) {
            result.removeAll(function.getAuthority());
            return result;
        }
        return new java.util.ArrayList();
    }

    public List getGroupList(List<FunctionAuthority> al)
    {
        List gl = new ArrayList();
        if (al == null)
            return gl;
        
        for (FunctionAuthority f : al)
            gl.add(f.getGroup());
        
        return gl;
    }

    public List getGroupList()
    {
        List gl = getGenericManager().getGroupList();
        List al = getGroupList(function.getAuthority());

        
        return removeFromList(gl, al);
    }

    public List getObject_groupList()
    {
        return (function.getAuthority() == null) ? new java.util.ArrayList() : getGroupList(function.getAuthority());
    }

    public void setGroupIds(Long[] val)
    {
        groupIds = val;
    }

    public Long[] getGroupIds()
    {
        return groupIds;
    }

    public List getFunctionList()
    {
        return getGenericManager().getFunctionList();
    }

    public List getOnlineFunctionList()
    {
        return getGenericManager().getOnlineFunctionList();
    }
}
