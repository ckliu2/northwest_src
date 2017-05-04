package northwest.common.dao.hibernate;

import northwest.common.value.Customer;
import northwest.common.dao.CustomerDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class CustomerDAOHibernate extends CommonDAOHibernate implements CustomerDAO
{

    public CustomerDAOHibernate()
    {
    }

    public void saveCustomer(Customer val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCustomer(Customer val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCustomer(Long id)
    {
        Customer obj = findCustomerById(id);
        getHibernateTemplate().delete(obj);
    }

    public Customer findCustomerById(Long id)
    {
        if (id == null)
            return null;
        Customer obj = (Customer)getHibernateTemplate().get(northwest.common.value.Customer.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Customer.class, id);
        else
            return obj;
    }

    public List<Customer> findAllCustomer()
    {
        return getHibernateTemplate().find("from Customer");
    }
    public List<Member> findSalemanList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

