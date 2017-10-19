package northwest.common.dao.hibernate;

import northwest.common.value.Product;
import northwest.common.dao.ProductDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:56 CST 2017
*/

public class ProductDAOHibernate extends CommonDAOHibernate implements ProductDAO
{

    public ProductDAOHibernate()
    {
    }

    public void saveProduct(Product val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProduct(Product val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProduct(Long id)
    {
        Product obj = findProductById(id);
        getHibernateTemplate().delete(obj);
    }

    public Product findProductById(Long id)
    {
        if (id == null)
            return null;
        Product obj = (Product)getHibernateTemplate().get(northwest.common.value.Product.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Product.class, id);
        else
            return obj;
    }

    public List<Product> findAllProduct()
    {
        return getHibernateTemplate().find("from Product");
    }
    public List<ProductClass> findProductClassList()
    {
        return new ArrayList<ProductClass>(); // TODO
    }

    public List<ProductUnit> findProductUnitList()
    {
        return new ArrayList<ProductUnit>(); // TODO
    }

}

