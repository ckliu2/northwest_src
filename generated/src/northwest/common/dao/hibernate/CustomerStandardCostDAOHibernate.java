package northwest.common.dao.hibernate;

import northwest.common.value.CustomerStandardCost;
import northwest.common.dao.CustomerStandardCostDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class CustomerStandardCostDAOHibernate extends CommonDAOHibernate implements CustomerStandardCostDAO
{

    public CustomerStandardCostDAOHibernate()
    {
    }

    public void saveCustomerStandardCost(CustomerStandardCost val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCustomerStandardCost(CustomerStandardCost val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCustomerStandardCost(Long id)
    {
        CustomerStandardCost obj = findCustomerStandardCostById(id);
        getHibernateTemplate().delete(obj);
    }

    public CustomerStandardCost findCustomerStandardCostById(Long id)
    {
        if (id == null)
            return null;
        CustomerStandardCost obj = (CustomerStandardCost)getHibernateTemplate().get(northwest.common.value.CustomerStandardCost.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.CustomerStandardCost.class, id);
        else
            return obj;
    }

    public List<CustomerStandardCost> findAllCustomerStandardCost()
    {
        return getHibernateTemplate().find("from CustomerStandardCost");
    }
    public List<Customer> findCustomerList()
    {
        return new ArrayList<Customer>(); // TODO
    }

    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

}

