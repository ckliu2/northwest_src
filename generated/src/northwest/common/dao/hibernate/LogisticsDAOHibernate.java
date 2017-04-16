package northwest.common.dao.hibernate;

import northwest.common.value.Logistics;
import northwest.common.dao.LogisticsDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public class LogisticsDAOHibernate extends CommonDAOHibernate implements LogisticsDAO
{

    public LogisticsDAOHibernate()
    {
    }

    public void saveLogistics(Logistics val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeLogistics(Logistics val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeLogistics(Long id)
    {
        Logistics obj = findLogisticsById(id);
        getHibernateTemplate().delete(obj);
    }

    public Logistics findLogisticsById(Long id)
    {
        if (id == null)
            return null;
        Logistics obj = (Logistics)getHibernateTemplate().get(northwest.common.value.Logistics.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Logistics.class, id);
        else
            return obj;
    }

    public List<Logistics> findAllLogistics()
    {
        return getHibernateTemplate().find("from Logistics");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

