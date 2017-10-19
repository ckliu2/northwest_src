package northwest.common.service.impl;

import northwest.common.service.BillFinishManager;
import northwest.common.dao.BillFinishDAO;
import northwest.common.value.BillFinish;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class BillFinishManagerImpl extends CommonManagerImpl implements BillFinishManager
{

    public BillFinishManagerImpl()
    {
    }

    public BillFinishDAO getGenericDAO()
    {
        return (BillFinishDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillFinishDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillFinish(BillFinish val)
    {
        getGenericDAO().saveBillFinish(val);
    }

    public void removeBillFinish(BillFinish val)
    {
        getGenericDAO().removeBillFinish(val);
    }

    public void removeBillFinish(Long id)
    {
        getGenericDAO().removeBillFinish(id);
    }

    public BillFinish getBillFinishById(Long id)
    {
         return getGenericDAO().findBillFinishById(id);
    }

    public List<BillFinish> getBillFinishList()
    {
        return getGenericDAO().findAllBillFinish();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

}

