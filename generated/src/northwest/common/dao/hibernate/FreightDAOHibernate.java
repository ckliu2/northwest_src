package northwest.common.dao.hibernate;

import northwest.common.value.Freight;
import northwest.common.dao.FreightDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public class FreightDAOHibernate extends CommonDAOHibernate implements FreightDAO
{

    public FreightDAOHibernate()
    {
    }

    public void saveFreight(Freight val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFreight(Freight val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFreight(Long id)
    {
        Freight obj = findFreightById(id);
        getHibernateTemplate().delete(obj);
    }

    public Freight findFreightById(Long id)
    {
        if (id == null)
            return null;
        Freight obj = (Freight)getHibernateTemplate().get(northwest.common.value.Freight.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Freight.class, id);
        else
            return obj;
    }

    public List<Freight> findAllFreight()
    {
        return getHibernateTemplate().find("from Freight");
    }
}

