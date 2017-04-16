package com.cip.web.action;

import com.cip.value.OrderBill;
import com.cip.service.OrderBillManager;
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

public class OrderBillAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private OrderBill orderBill;
    private Long[] selectedOrderBillIds;

    public OrderBillAction()
    {
        log = LogFactory.getLog(com.cip.web.action.OrderBillAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("ORDERBILL");
    }

    public OrderBill getOrderBill()
    {
        return orderBill;
    }

    public void setOrderBill(OrderBill val)
    {
        orderBill = val;
    }

    public void setGenericManager(OrderBillManager m)
    {
        super.setGenericManager(m);
    }

    public OrderBillManager getGenericManager()
    {
        return (OrderBillManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeOrderBill(orderBill.getId());
        return DELETE;
    }

    public String edit()
    {
        if (orderBill == null) {
            orderBill = new OrderBill();
        } else if (orderBill.getId() != null) {
            orderBill = getGenericManager().getOrderBillById(orderBill.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedOrderBillIds != null && selectedOrderBillIds.length > 0) {
            OrderBill obj = getGenericManager().getOrderBillById(selectedOrderBillIds[0]);
            obj.setId(null);
            orderBill = obj;
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
            if (inputValidation(orderBill) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(OrderBill val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveOrderBill(orderBill);
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
        orderBill.setProject(getGenericManager().getProjectById(orderBill.getProjectId())); 
        orderBill.setCustomer(getGenericManager().getCustomerById(orderBill.getCustomerId())); 
        orderBill.setSalesMan(getGenericManager().getMemberById(orderBill.getSalesManId())); 
        orderBill.setMaker(getGenericManager().getMemberById(orderBill.getMakerId())); 
        log.info("exit formToBean()");
    }
    public List<Project> getProjectList()
    {
        return getGenericManager().getProjectList(); // TODO
    }

    public List<Customer> getCustomerList()
    {
        return getGenericManager().getCustomerList(); // TODO
    }

    public List<Member> getSalesManList()
    {
        return getGenericManager().getSalesManList(); // TODO
    }

    public List<Member> getMakerList()
    {
        return getGenericManager().getMakerList(); // TODO
    }

    public List<OrderBill> getOrderBillList()
    {
        return getGenericManager().getOrderBillList();
    }

    public void setSelectedOrderBillIds(Long[] val)
    {
        selectedOrderBillIds = val;
    }

    public Long[] getSelectedOrderBillIds()
    {
        return selectedOrderBillIds;
    }
}
