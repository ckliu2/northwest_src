package northwest.common.service.impl;

import northwest.common.service.ProfitManager;
import northwest.common.dao.ProfitDAO;
import northwest.common.value.Profit;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitManagerImpl extends CommonManagerImpl implements ProfitManager
{

    public ProfitManagerImpl()
    {
    }

    public ProfitDAO getGenericDAO()
    {
        return (ProfitDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProfitDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProfit(Profit val)
    {
        getGenericDAO().saveProfit(val);
    }

    public void removeProfit(Profit val)
    {
        getGenericDAO().removeProfit(val);
    }

    public void removeProfit(Long id)
    {
        getGenericDAO().removeProfit(id);
    }

    public Profit getProfitById(Long id)
    {
         return getGenericDAO().findProfitById(id);
    }

    public List<Profit> getProfitList()
    {
        return getGenericDAO().findAllProfit();
    }
    public List<Customer> getCustomerList()
    {
        return getGenericDAO().findCustomerList();
    }

    public List<Member> getSalesmenList()
    {
        return getGenericDAO().findSalesmenList();
    }

}

