package com.cip.dao;

import com.cip.value.*;

import java.util.*;

import northwest.common.dao.BillDAO;

import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Jan 26 14:53:23 CST 2015
*/

public interface OrderBillDAO extends BillDAO 
{
    
    //OrderBill
    public abstract void saveOrderBill(OrderBill val);
    public abstract void removeOrderBill(OrderBill val);
    public abstract void removeOrderBill(Long id);
    public abstract OrderBill findOrderBillById(Long id);
    public abstract List<OrderBill> findAllOrderBill();
    
    //Project
    public abstract void saveProject(Project val);
    public abstract void removeProject(Project val);
    public abstract void removeProject(String id);
    public abstract Project findProjectById(String id);
    public abstract List<Project> findAllProject();
    
    //OrdBillSub
    public abstract OrdBillSub findOrdBillSubById(Long id);
    public abstract List<OrdBillSub> findAllOrdBillSub(OrderBill orderBill);
    public abstract void saveOrdBillSub(OrdBillSub val);
    public abstract OrdBillSub getOrdBillSub(int flag,OrderBill orderBill,int rowNo);
    public abstract void removeOrdBillSub(Long id);
    public abstract String orderBillCurrentProjectNo();
    public abstract int ordBillSubRowNo(OrderBill orderBill);
}

