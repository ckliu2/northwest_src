package northwest.common.service;

import northwest.common.value.BillDetail;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface BillDetailManager extends CommonManager 
{
    public abstract void saveBillDetail(BillDetail val);

    public abstract void removeBillDetail(BillDetail val);

    public abstract void removeBillDetail(Long id);

    public abstract BillDetail getBillDetailById(Long id);

    public abstract List<BillDetail> getBillDetailList();
    public abstract List<Product> getProductList();
    public abstract List<Bill> getBillList();
}

