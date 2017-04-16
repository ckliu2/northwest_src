package northwest.common.service.impl;

import northwest.common.service.ProductClassManager;
import northwest.common.dao.ProductClassDAO;
import northwest.common.value.ProductClass;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class ProductClassManagerImpl extends CommonManagerImpl implements ProductClassManager
{

    public ProductClassManagerImpl()
    {
    }

    public ProductClassDAO getGenericDAO()
    {
        return (ProductClassDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProductClassDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProductClass(ProductClass val)
    {
        getGenericDAO().saveProductClass(val);
    }

    public void removeProductClass(ProductClass val)
    {
        getGenericDAO().removeProductClass(val);
    }

    public void removeProductClass(Long id)
    {
        getGenericDAO().removeProductClass(id);
    }

    public ProductClass getProductClassById(Long id)
    {
         return getGenericDAO().findProductClassById(id);
    }

    public List<ProductClass> getProductClassList()
    {
        return getGenericDAO().findAllProductClass();
    }
    public Long[] getIdsFromGroupList(List<Group> lst)
    {
        return getGenericDAO().getIdsFromGroupList(lst);
    }

    public List<Group> getGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getGroupListByIds(ids);
    }

}

