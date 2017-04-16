package com.cip.web.action;

import com.cip.value.OrdBillSub;
import com.cip.service.OrdBillSubManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class OrdBillSubAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private OrdBillSub ordBillSub;
    private Long[] selectedOrdBillSubIds;

    public OrdBillSubAction()
    {
        log = LogFactory.getLog(com.cip.web.action.OrdBillSubAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("ORDBILLSUB");
    }

    public OrdBillSub getOrdBillSub()
    {
        return ordBillSub;
    }

    public void setOrdBillSub(OrdBillSub val)
    {
        ordBillSub = val;
    }

    public void setGenericManager(OrdBillSubManager m)
    {
        super.setGenericManager(m);
    }

    public OrdBillSubManager getGenericManager()
    {
        return (OrdBillSubManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeOrdBillSub(ordBillSub.getId());
        return DELETE;
    }

    public String edit()
    {
        if (ordBillSub == null) {
            ordBillSub = new OrdBillSub();
        } else if (ordBillSub.getId() != null) {
            ordBillSub = getGenericManager().getOrdBillSubById(ordBillSub.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedOrdBillSubIds != null && selectedOrdBillSubIds.length > 0) {
            OrdBillSub obj = getGenericManager().getOrdBillSubById(selectedOrdBillSubIds[0]);
            obj.setId(null);
            ordBillSub = obj;
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
            if (inputValidation(ordBillSub) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(OrdBillSub val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveOrdBillSub(ordBillSub);
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
        ordBillSub.setOrderBill(getGenericManager().getOrderBillById(ordBillSub.getOrderBillId())); 
        ordBillSub.setProduct(getGenericManager().getProductById(ordBillSub.getProductId())); 
        ordBillSub.setCrement(getAppPropertyById(ordBillSub.getCrementId())); 
        log.info("exit formToBean()");
    }
    public List<OrderBill> getOrderBillList()
    {
        return getGenericManager().getOrderBillList(); // TODO
    }

    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<AppProperty> getCrementList()
    {
        return super.getAppPropertyList("ordBillSub.crement");
    }

    public List<OrdBillSub> getOrdBillSubList()
    {
        return getGenericManager().getOrdBillSubList();
    }

    public void setSelectedOrdBillSubIds(Long[] val)
    {
        selectedOrdBillSubIds = val;
    }

    public Long[] getSelectedOrdBillSubIds()
    {
        return selectedOrdBillSubIds;
    }
}
