package com.cip.dao;

import com.cip.value.OrdBillSub;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public interface OrdBillSubDAO extends CommonDAO 
{
    public abstract void saveOrdBillSub(OrdBillSub val);

    public abstract void removeOrdBillSub(OrdBillSub val);

    public abstract void removeOrdBillSub(Long id);

    public abstract OrdBillSub findOrdBillSubById(Long id);

    public abstract List<OrdBillSub> findAllOrdBillSub();
    public abstract List<OrderBill> findOrderBillList();
    public abstract List<Product> findProductList();
}

