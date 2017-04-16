package com.cip.dao.hibernate;

import com.cip.value.OrderBill;
import com.cip.dao.OrderBillDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class OrderBillDAOHibernate extends CommonDAOHibernate implements OrderBillDAO
{

    public OrderBillDAOHibernate()
    {
    }

    public void saveOrderBill(OrderBill val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeOrderBill(OrderBill val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeOrderBill(Long id)
    {
        OrderBill obj = findOrderBillById(id);
        getHibernateTemplate().delete(obj);
    }

    public OrderBill findOrderBillById(Long id)
    {
        if (id == null)
            return null;
        OrderBill obj = (OrderBill)getHibernateTemplate().get(com.cip.value.OrderBill.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.cip.value.OrderBill.class, id);
        else
            return obj;
    }

    public List<OrderBill> findAllOrderBill()
    {
        return getHibernateTemplate().find("from OrderBill");
    }
    public List<Project> findProjectList()
    {
        return new ArrayList<Project>(); // TODO
    }

    public List<Customer> findCustomerList()
    {
        return new ArrayList<Customer>(); // TODO
    }

    public List<Member> findSalesManList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findMakerList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

