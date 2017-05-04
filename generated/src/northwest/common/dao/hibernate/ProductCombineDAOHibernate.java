package northwest.common.dao.hibernate;

import northwest.common.value.ProductCombine;
import northwest.common.dao.ProductCombineDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class ProductCombineDAOHibernate extends CommonDAOHibernate implements ProductCombineDAO
{

    public ProductCombineDAOHibernate()
    {
    }

    public void saveProductCombine(ProductCombine val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProductCombine(ProductCombine val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProductCombine(Long id)
    {
        ProductCombine obj = findProductCombineById(id);
        getHibernateTemplate().delete(obj);
    }

    public ProductCombine findProductCombineById(Long id)
    {
        if (id == null)
            return null;
        ProductCombine obj = (ProductCombine)getHibernateTemplate().get(northwest.common.value.ProductCombine.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.ProductCombine.class, id);
        else
            return obj;
    }

    public List<ProductCombine> findAllProductCombine()
    {
        return getHibernateTemplate().find("from ProductCombine");
    }
    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

}

