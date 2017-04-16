package com.cip.service.impl;

import com.cip.service.OrdBillSubManager;
import com.cip.dao.OrdBillSubDAO;
import com.cip.value.OrdBillSub;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class OrdBillSubManagerImpl extends CommonManagerImpl implements OrdBillSubManager
{

    public OrdBillSubManagerImpl()
    {
    }

    public OrdBillSubDAO getGenericDAO()
    {
        return (OrdBillSubDAO)super.getGenericDAO();
    }

    public void setGenericDAO(OrdBillSubDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveOrdBillSub(OrdBillSub val)
    {
        getGenericDAO().saveOrdBillSub(val);
    }

    public void removeOrdBillSub(OrdBillSub val)
    {
        getGenericDAO().removeOrdBillSub(val);
    }

    public void removeOrdBillSub(Long id)
    {
        getGenericDAO().removeOrdBillSub(id);
    }

    public OrdBillSub getOrdBillSubById(Long id)
    {
         return getGenericDAO().findOrdBillSubById(id);
    }

    public List<OrdBillSub> getOrdBillSubList()
    {
        return getGenericDAO().findAllOrdBillSub();
    }
    public List<OrderBill> getOrderBillList()
    {
        return getGenericDAO().findOrderBillList();
    }

    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

}

