package northwest.common.service.impl;

import northwest.common.service.ProductUnitManager;
import northwest.common.dao.ProductUnitDAO;
import northwest.common.value.ProductUnit;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class ProductUnitManagerImpl extends CommonManagerImpl implements ProductUnitManager
{

    public ProductUnitManagerImpl()
    {
    }

    public ProductUnitDAO getGenericDAO()
    {
        return (ProductUnitDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProductUnitDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProductUnit(ProductUnit val)
    {
        getGenericDAO().saveProductUnit(val);
    }

    public void removeProductUnit(ProductUnit val)
    {
        getGenericDAO().removeProductUnit(val);
    }

    public void removeProductUnit(Long id)
    {
        getGenericDAO().removeProductUnit(id);
    }

    public ProductUnit getProductUnitById(Long id)
    {
         return getGenericDAO().findProductUnitById(id);
    }

    public List<ProductUnit> getProductUnitList()
    {
        return getGenericDAO().findAllProductUnit();
    }
}

