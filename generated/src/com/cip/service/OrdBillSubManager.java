package com.cip.service;

import com.cip.value.OrdBillSub;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 10 10:37:05 CST 2015
*/

public interface OrdBillSubManager extends CommonManager 
{
    public abstract void saveOrdBillSub(OrdBillSub val);

    public abstract void removeOrdBillSub(OrdBillSub val);

    public abstract void removeOrdBillSub(Long id);

    public abstract OrdBillSub getOrdBillSubById(Long id);

    public abstract List<OrdBillSub> getOrdBillSubList();
    public abstract List<OrderBill> getOrderBillList();
    public abstract List<Product> getProductList();
}

