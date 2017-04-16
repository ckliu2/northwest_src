package com.cip.service;

import com.cip.value.*;

import java.util.*;

import northwest.common.service.*;

import com.common.service.CommonManager;


public interface OrderBillManager extends BillManager 
{
    //OrderBill
    public abstract void saveOrderBill(OrderBill val);
    public abstract void removeOrderBill(OrderBill val);
    public abstract void removeOrderBill(Long id);
    public abstract OrderBill getOrderBillById(Long id);
    public abstract List<OrderBill> getOrderBillList();
    
    //Project    
    public abstract void saveProject(Project val);
    public abstract void removeProject(Project val);
    public abstract void removeProject(String id);
    public abstract Project getProjectById(String id);
    public abstract List<Project> getProjectList();
    
    //OrdBillSub
    public abstract OrdBillSub getOrdBillSubById(Long id);
    public abstract List<OrdBillSub> getOrdBillSubList(OrderBill orderBill);
    public abstract void saveOrdBillSub(OrdBillSub val);    
    public abstract OrdBillSub getOrdBillSub(int flag,OrderBill orderBill,int rowNo);
    public abstract void removeOrdBillSub(Long id);
    public abstract String orderBillCurrentProjectNo();
    public abstract int ordBillSubRowNo(OrderBill orderBill);
    
    
   
}

