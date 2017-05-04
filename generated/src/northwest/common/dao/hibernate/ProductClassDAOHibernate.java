package northwest.common.dao.hibernate;

import northwest.common.value.ProductClass;
import northwest.common.dao.ProductClassDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class ProductClassDAOHibernate extends CommonDAOHibernate implements ProductClassDAO
{

    public ProductClassDAOHibernate()
    {
    }

    public void saveProductClass(ProductClass val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProductClass(ProductClass val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProductClass(Long id)
    {
        ProductClass obj = findProductClassById(id);
        getHibernateTemplate().delete(obj);
    }

    public ProductClass findProductClassById(Long id)
    {
        if (id == null)
            return null;
        ProductClass obj = (ProductClass)getHibernateTemplate().get(northwest.common.value.ProductClass.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.ProductClass.class, id);
        else
            return obj;
    }

    public List<ProductClass> findAllProductClass()
    {
        return getHibernateTemplate().find("from ProductClass");
    }
    public Long[] getIdsFromGroupList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Group t = (Group) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getGroupListByIds(Long[] ids)
    {
        ArrayList<Group> al = new ArrayList<Group>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Group t = (Group) findGroupById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

