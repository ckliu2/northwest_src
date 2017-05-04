package northwest.common.service.impl;

import northwest.common.service.CustomerManager;
import northwest.common.dao.CustomerDAO;
import northwest.common.value.Customer;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class CustomerManagerImpl extends CommonManagerImpl implements CustomerManager
{

    public CustomerManagerImpl()
    {
    }

    public CustomerDAO getGenericDAO()
    {
        return (CustomerDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CustomerDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCustomer(Customer val)
    {
        getGenericDAO().saveCustomer(val);
    }

    public void removeCustomer(Customer val)
    {
        getGenericDAO().removeCustomer(val);
    }

    public void removeCustomer(Long id)
    {
        getGenericDAO().removeCustomer(id);
    }

    public Customer getCustomerById(Long id)
    {
         return getGenericDAO().findCustomerById(id);
    }

    public List<Customer> getCustomerList()
    {
        return getGenericDAO().findAllCustomer();
    }
    public List<Member> getSalemanList()
    {
        return getGenericDAO().findSalemanList();
    }

}

