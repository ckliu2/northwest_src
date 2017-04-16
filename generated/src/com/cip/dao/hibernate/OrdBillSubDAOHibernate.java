package com.cip.dao.hibernate;

import com.cip.value.OrdBillSub;
import com.cip.dao.OrdBillSubDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public class OrdBillSubDAOHibernate extends CommonDAOHibernate implements OrdBillSubDAO
{

    public OrdBillSubDAOHibernate()
    {
    }

    public void saveOrdBillSub(OrdBillSub val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeOrdBillSub(OrdBillSub val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeOrdBillSub(Long id)
    {
        OrdBillSub obj = findOrdBillSubById(id);
        getHibernateTemplate().delete(obj);
    }

    public OrdBillSub findOrdBillSubById(Long id)
    {
        if (id == null)
            return null;
        OrdBillSub obj = (OrdBillSub)getHibernateTemplate().get(com.cip.value.OrdBillSub.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.cip.value.OrdBillSub.class, id);
        else
            return obj;
    }

    public List<OrdBillSub> findAllOrdBillSub()
    {
        return getHibernateTemplate().find("from OrdBillSub");
    }
    public List<OrderBill> findOrderBillList()
    {
        return new ArrayList<OrderBill>(); // TODO
    }

    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

}

