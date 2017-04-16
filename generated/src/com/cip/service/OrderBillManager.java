package com.cip.service;

import com.cip.value.OrderBill;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public interface OrderBillManager extends CommonManager 
{
    public abstract void saveOrderBill(OrderBill val);

    public abstract void removeOrderBill(OrderBill val);

    public abstract void removeOrderBill(Long id);

    public abstract OrderBill getOrderBillById(Long id);

    public abstract List<OrderBill> getOrderBillList();
    public abstract List<Project> getProjectList();
    public abstract List<Customer> getCustomerList();
    public abstract List<Member> getSalesManList();
    public abstract List<Member> getMakerList();
}

