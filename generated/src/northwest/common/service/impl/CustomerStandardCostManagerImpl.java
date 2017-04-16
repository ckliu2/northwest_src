package northwest.common.service.impl;

import northwest.common.service.CustomerStandardCostManager;
import northwest.common.dao.CustomerStandardCostDAO;
import northwest.common.value.CustomerStandardCost;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class CustomerStandardCostManagerImpl extends CommonManagerImpl implements CustomerStandardCostManager
{

    public CustomerStandardCostManagerImpl()
    {
    }

    public CustomerStandardCostDAO getGenericDAO()
    {
        return (CustomerStandardCostDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CustomerStandardCostDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCustomerStandardCost(CustomerStandardCost val)
    {
        getGenericDAO().saveCustomerStandardCost(val);
    }

    public void removeCustomerStandardCost(CustomerStandardCost val)
    {
        getGenericDAO().removeCustomerStandardCost(val);
    }

    public void removeCustomerStandardCost(Long id)
    {
        getGenericDAO().removeCustomerStandardCost(id);
    }

    public CustomerStandardCost getCustomerStandardCostById(Long id)
    {
         return getGenericDAO().findCustomerStandardCostById(id);
    }

    public List<CustomerStandardCost> getCustomerStandardCostList()
    {
        return getGenericDAO().findAllCustomerStandardCost();
    }
    public List<Customer> getCustomerList()
    {
        return getGenericDAO().findCustomerList();
    }

    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

}

