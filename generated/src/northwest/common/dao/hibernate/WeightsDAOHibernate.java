package northwest.common.dao.hibernate;

import northwest.common.value.Weights;
import northwest.common.dao.WeightsDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public class WeightsDAOHibernate extends CommonDAOHibernate implements WeightsDAO
{

    public WeightsDAOHibernate()
    {
    }

    public void saveWeights(Weights val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeWeights(Weights val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeWeights(Long id)
    {
        Weights obj = findWeightsById(id);
        getHibernateTemplate().delete(obj);
    }

    public Weights findWeightsById(Long id)
    {
        if (id == null)
            return null;
        Weights obj = (Weights)getHibernateTemplate().get(northwest.common.value.Weights.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Weights.class, id);
        else
            return obj;
    }

    public List<Weights> findAllWeights()
    {
        return getHibernateTemplate().find("from Weights");
    }
    public List<OutputEquipment> findOutputEquipmentList()
    {
        return new ArrayList<OutputEquipment>(); // TODO
    }

    public Long[] getIdsFromProductClassList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                ProductClass t = (ProductClass) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getProductClassListByIds(Long[] ids)
    {
        ArrayList<ProductClass> al = new ArrayList<ProductClass>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                ProductClass t = (ProductClass) findProductClassById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

