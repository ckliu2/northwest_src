package northwest.common.dao.hibernate;

import northwest.common.value.Profit;
import northwest.common.dao.ProfitDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitDAOHibernate extends CommonDAOHibernate implements ProfitDAO
{

    public ProfitDAOHibernate()
    {
    }

    public void saveProfit(Profit val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProfit(Profit val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProfit(Long id)
    {
        Profit obj = findProfitById(id);
        getHibernateTemplate().delete(obj);
    }

    public Profit findProfitById(Long id)
    {
        if (id == null)
            return null;
        Profit obj = (Profit)getHibernateTemplate().get(northwest.common.value.Profit.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Profit.class, id);
        else
            return obj;
    }

    public List<Profit> findAllProfit()
    {
        return getHibernateTemplate().find("from Profit");
    }
    public List<Customer> findCustomerList()
    {
        return new ArrayList<Customer>(); // TODO
    }

    public List<Member> findSalesmenList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

