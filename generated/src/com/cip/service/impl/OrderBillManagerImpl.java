package com.cip.service.impl;

import com.cip.service.OrderBillManager;
import com.cip.dao.OrderBillDAO;
import com.cip.value.OrderBill;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class OrderBillManagerImpl extends CommonManagerImpl implements OrderBillManager
{

    public OrderBillManagerImpl()
    {
    }

    public OrderBillDAO getGenericDAO()
    {
        return (OrderBillDAO)super.getGenericDAO();
    }

    public void setGenericDAO(OrderBillDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveOrderBill(OrderBill val)
    {
        getGenericDAO().saveOrderBill(val);
    }

    public void removeOrderBill(OrderBill val)
    {
        getGenericDAO().removeOrderBill(val);
    }

    public void removeOrderBill(Long id)
    {
        getGenericDAO().removeOrderBill(id);
    }

    public OrderBill getOrderBillById(Long id)
    {
         return getGenericDAO().findOrderBillById(id);
    }

    public List<OrderBill> getOrderBillList()
    {
        return getGenericDAO().findAllOrderBill();
    }
    public List<Project> getProjectList()
    {
        return getGenericDAO().findProjectList();
    }

    public List<Customer> getCustomerList()
    {
        return getGenericDAO().findCustomerList();
    }

    public List<Member> getSalesManList()
    {
        return getGenericDAO().findSalesManList();
    }

    public List<Member> getMakerList()
    {
        return getGenericDAO().findMakerList();
    }

}

