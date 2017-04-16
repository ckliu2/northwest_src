package com.common.web.action;

import com.common.value.Member;
import com.common.value.Unit;
import com.base.value.Group;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Nov 17 13:30:45 GMT 2007
*/

public class UnitAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Unit unit;
    private Long[] groupIds;
    private Long[] selectedMemberIds;

    public UnitAction()
    {
        log = LogFactory.getLog(com.common.web.action.UnitAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("UNIT");
    }

    public Unit getUnit()
    {
        return unit;
    }

    public void setUnit(Unit val)
    {
        unit = val;
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
        getGenericManager().removeUnit(unit.getId());
        return DELETE;
    }

    public String edit()
    {
        if (unit == null) {
        	unit = new Unit();
            System.out.println("這是一個NEW Unit");
        } else if (unit.getId() != null) {
        	unit = getGenericManager().getUnitById(unit.getId());
            System.out.println("unitName:"+unit.getName());
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
            if (inputValidation(unit) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Unit val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (unit.getId() == null) {
        	unit.setCreatedDate(ts);
        	unit.setCreatedUser(getSessionUser().getLoginId());
        }
        unit.setLastModifiedDate(ts);
        unit.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveUnit(unit);
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

    public List<Unit> getUnitList()
    {
        return getGenericManager().getUnitList();
    }

}
