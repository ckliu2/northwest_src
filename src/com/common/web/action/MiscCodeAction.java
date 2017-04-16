package com.common.web.action;

import com.base.value.MiscCode;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Nov 17 13:30:45 GMT 2007
*/

public class MiscCodeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private MiscCode miscCode;
    private Long[] selectedMiscCodeIds;
    private String action;

    public MiscCodeAction()
    {
        log = LogFactory.getLog(com.common.web.action.MiscCodeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MISCCODE");
    }

    public MiscCode getMiscCode()
    {
        return miscCode;
    }

    public void setMiscCode(MiscCode val)
    {
        miscCode = val;
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
        getGenericManager().removeMiscCode(miscCode.getId());
        return DELETE;
    }

    public String edit()
    {
        if (miscCode == null) {
            miscCode = new MiscCode();
        } else if (miscCode.getId() != null) {
            miscCode = getGenericManager().getMiscCodeById(miscCode.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMiscCodeIds != null && selectedMiscCodeIds.length > 0) {
            MiscCode obj = getGenericManager().getMiscCodeById(selectedMiscCodeIds[0]);
            obj.setId(null);
            miscCode = obj;
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
            if (inputValidation(miscCode) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(MiscCode val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        if ("update".equals(getAction())) {
            getGenericManager().updateMiscCode(miscCode);
        } else {
            getGenericManager().saveMiscCode(miscCode);
        }
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
    public List<MiscCode> getMiscCodeList()
    {
        return getGenericManager().getMiscCodeList();
    }

    public void setSelectedMiscCodeIds(Long[] val)
    {
        selectedMiscCodeIds = val;
    }

    public Long[] getSelectedMiscCodeIds()
    {
        return selectedMiscCodeIds;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }
}
