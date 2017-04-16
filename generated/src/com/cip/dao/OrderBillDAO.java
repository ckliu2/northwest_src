package com.cip.dao;

import com.cip.value.OrderBill;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public interface OrderBillDAO extends CommonDAO 
{
    public abstract void saveOrderBill(OrderBill val);

    public abstract void removeOrderBill(OrderBill val);

    public abstract void removeOrderBill(Long id);

    public abstract OrderBill findOrderBillById(Long id);

    public abstract List<OrderBill> findAllOrderBill();
    public abstract List<Project> findProjectList();
    public abstract List<Customer> findCustomerList();
    public abstract List<Member> findSalesManList();
    public abstract List<Member> findMakerList();
}

