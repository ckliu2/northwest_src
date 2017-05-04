package northwest.common.service.impl;

import northwest.common.service.BillManager;
import northwest.common.dao.BillDAO;
import northwest.common.value.Bill;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class BillManagerImpl extends CommonManagerImpl implements BillManager
{

    public BillManagerImpl()
    {
    }

    public BillDAO getGenericDAO()
    {
        return (BillDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBill(Bill val)
    {
        getGenericDAO().saveBill(val);
    }

    public void removeBill(Bill val)
    {
        getGenericDAO().removeBill(val);
    }

    public void removeBill(Long id)
    {
        getGenericDAO().removeBill(id);
    }

    public Bill getBillById(Long id)
    {
         return getGenericDAO().findBillById(id);
    }

    public List<Bill> getBillList()
    {
        return getGenericDAO().findAllBill();
    }
    public List<Customer> getCustomerList()
    {
        return getGenericDAO().findCustomerList();
    }

}

