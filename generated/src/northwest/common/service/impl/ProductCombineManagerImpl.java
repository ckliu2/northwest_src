package northwest.common.service.impl;

import northwest.common.service.ProductCombineManager;
import northwest.common.dao.ProductCombineDAO;
import northwest.common.value.ProductCombine;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class ProductCombineManagerImpl extends CommonManagerImpl implements ProductCombineManager
{

    public ProductCombineManagerImpl()
    {
    }

    public ProductCombineDAO getGenericDAO()
    {
        return (ProductCombineDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProductCombineDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProductCombine(ProductCombine val)
    {
        getGenericDAO().saveProductCombine(val);
    }

    public void removeProductCombine(ProductCombine val)
    {
        getGenericDAO().removeProductCombine(val);
    }

    public void removeProductCombine(Long id)
    {
        getGenericDAO().removeProductCombine(id);
    }

    public ProductCombine getProductCombineById(Long id)
    {
         return getGenericDAO().findProductCombineById(id);
    }

    public List<ProductCombine> getProductCombineList()
    {
        return getGenericDAO().findAllProductCombine();
    }
    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

}

