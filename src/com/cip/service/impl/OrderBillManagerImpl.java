package com.cip.service.impl;

import com.cip.service.*;
import com.cip.dao.OrderBillDAO;
import com.cip.value.*;

import java.util.*;

import northwest.common.service.impl.BillManagerImpl;

import com.common.service.impl.CommonManagerImpl;


public class OrderBillManagerImpl extends BillManagerImpl implements OrderBillManager
{

    public OrderBillManagerImpl()
    {
    }

    //OrderBillDAO
    
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


    //Project
    public void saveProject(Project val)
    {
        getGenericDAO().saveProject(val);
    }

    public void removeProject(Project val)
    {
        getGenericDAO().removeProject(val);
    }

    public void removeProject(String id)
    {
        getGenericDAO().removeProject(id);
    }

    public Project getProjectById(String id)
    {
         return getGenericDAO().findProjectById(id);
    }

    public List<Project> getProjectList()
    {
        return getGenericDAO().findAllProject();
    }
    
    //OrdBillSub
    
    public OrdBillSub getOrdBillSubById(Long id)
    {
	return getGenericDAO().findOrdBillSubById(id);
    }
    
    
    public List<OrdBillSub> getOrdBillSubList(OrderBill orderBill)
    {
        return getGenericDAO().findAllOrdBillSub(orderBill);
    }
    
    public void saveOrdBillSub(OrdBillSub val)
    {
	getGenericDAO().saveOrdBillSub(val);
    }
    
    public OrdBillSub getOrdBillSub(int flag,OrderBill orderBill,int rowNo)
    {
	return getGenericDAO().getOrdBillSub(flag,orderBill,rowNo);
    }
    
    public void removeOrdBillSub(Long id)
    {
	getGenericDAO().removeOrdBillSub(id);
    }
    
    public String orderBillCurrentProjectNo()
    {
	return getGenericDAO().orderBillCurrentProjectNo();
    }
    
    public int ordBillSubRowNo(OrderBill orderBill)
    {
	return getGenericDAO().ordBillSubRowNo(orderBill);
    }

}

