package northwest.common.service.impl;

import northwest.common.service.BillDetailManager;
import northwest.common.dao.BillDetailDAO;
import northwest.common.value.BillDetail;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class BillDetailManagerImpl extends CommonManagerImpl implements BillDetailManager
{

    public BillDetailManagerImpl()
    {
    }

    public BillDetailDAO getGenericDAO()
    {
        return (BillDetailDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillDetailDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillDetail(BillDetail val)
    {
        getGenericDAO().saveBillDetail(val);
    }

    public void removeBillDetail(BillDetail val)
    {
        getGenericDAO().removeBillDetail(val);
    }

    public void removeBillDetail(Long id)
    {
        getGenericDAO().removeBillDetail(id);
    }

    public BillDetail getBillDetailById(Long id)
    {
         return getGenericDAO().findBillDetailById(id);
    }

    public List<BillDetail> getBillDetailList()
    {
        return getGenericDAO().findAllBillDetail();
    }
    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

}

