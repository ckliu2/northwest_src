package northwest.common.service.impl;

import northwest.common.service.ProductManager;
import northwest.common.dao.ProductDAO;
import northwest.common.value.Product;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class ProductManagerImpl extends CommonManagerImpl implements ProductManager
{

    public ProductManagerImpl()
    {
    }

    public ProductDAO getGenericDAO()
    {
        return (ProductDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProductDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProduct(Product val)
    {
        getGenericDAO().saveProduct(val);
    }

    public void removeProduct(Product val)
    {
        getGenericDAO().removeProduct(val);
    }

    public void removeProduct(Long id)
    {
        getGenericDAO().removeProduct(id);
    }

    public Product getProductById(Long id)
    {
         return getGenericDAO().findProductById(id);
    }

    public List<Product> getProductList()
    {
        return getGenericDAO().findAllProduct();
    }
    public List<ProductClass> getProductClassList()
    {
        return getGenericDAO().findProductClassList();
    }

    public List<ProductUnit> getProductUnitList()
    {
        return getGenericDAO().findProductUnitList();
    }

}

