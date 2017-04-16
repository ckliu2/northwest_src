package northwest.common.dao.hibernate;

import northwest.common.value.StandardCost;
import northwest.common.dao.StandardCostDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class StandardCostDAOHibernate extends CommonDAOHibernate implements StandardCostDAO
{

    public StandardCostDAOHibernate()
    {
    }

    public void saveStandardCost(StandardCost val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeStandardCost(StandardCost val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeStandardCost(Long id)
    {
        StandardCost obj = findStandardCostById(id);
        getHibernateTemplate().delete(obj);
    }

    public StandardCost findStandardCostById(Long id)
    {
        if (id == null)
            return null;
        StandardCost obj = (StandardCost)getHibernateTemplate().get(northwest.common.value.StandardCost.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.StandardCost.class, id);
        else
            return obj;
    }

    public List<StandardCost> findAllStandardCost()
    {
        return getHibernateTemplate().find("from StandardCost");
    }
    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

}

