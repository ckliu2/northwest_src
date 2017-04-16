package northwest.common.service.impl;

import northwest.common.service.ProfitFeeManager;
import northwest.common.dao.ProfitFeeDAO;
import northwest.common.value.ProfitFee;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitFeeManagerImpl extends CommonManagerImpl implements ProfitFeeManager
{

    public ProfitFeeManagerImpl()
    {
    }

    public ProfitFeeDAO getGenericDAO()
    {
        return (ProfitFeeDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProfitFeeDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProfitFee(ProfitFee val)
    {
        getGenericDAO().saveProfitFee(val);
    }

    public void removeProfitFee(ProfitFee val)
    {
        getGenericDAO().removeProfitFee(val);
    }

    public void removeProfitFee(Long id)
    {
        getGenericDAO().removeProfitFee(id);
    }

    public ProfitFee getProfitFeeById(Long id)
    {
         return getGenericDAO().findProfitFeeById(id);
    }

    public List<ProfitFee> getProfitFeeList()
    {
        return getGenericDAO().findAllProfitFee();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

}

