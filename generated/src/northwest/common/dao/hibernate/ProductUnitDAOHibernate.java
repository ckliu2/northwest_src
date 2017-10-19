package northwest.common.dao.hibernate;

import northwest.common.value.ProductUnit;
import northwest.common.dao.ProductUnitDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:56 CST 2017
*/

public class ProductUnitDAOHibernate extends CommonDAOHibernate implements ProductUnitDAO
{

    public ProductUnitDAOHibernate()
    {
    }

    public void saveProductUnit(ProductUnit val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProductUnit(ProductUnit val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProductUnit(Long id)
    {
        ProductUnit obj = findProductUnitById(id);
        getHibernateTemplate().delete(obj);
    }

    public ProductUnit findProductUnitById(Long id)
    {
        if (id == null)
            return null;
        ProductUnit obj = (ProductUnit)getHibernateTemplate().get(northwest.common.value.ProductUnit.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.ProductUnit.class, id);
        else
            return obj;
    }

    public List<ProductUnit> findAllProductUnit()
    {
        return getHibernateTemplate().find("from ProductUnit");
    }
}

