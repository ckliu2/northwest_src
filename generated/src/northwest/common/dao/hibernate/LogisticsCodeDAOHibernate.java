package northwest.common.dao.hibernate;

import northwest.common.value.LogisticsCode;
import northwest.common.dao.LogisticsCodeDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public class LogisticsCodeDAOHibernate extends CommonDAOHibernate implements LogisticsCodeDAO
{

    public LogisticsCodeDAOHibernate()
    {
    }

    public void saveLogisticsCode(LogisticsCode val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeLogisticsCode(LogisticsCode val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeLogisticsCode(Long id)
    {
        LogisticsCode obj = findLogisticsCodeById(id);
        getHibernateTemplate().delete(obj);
    }

    public LogisticsCode findLogisticsCodeById(Long id)
    {
        if (id == null)
            return null;
        LogisticsCode obj = (LogisticsCode)getHibernateTemplate().get(northwest.common.value.LogisticsCode.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.LogisticsCode.class, id);
        else
            return obj;
    }

    public List<LogisticsCode> findAllLogisticsCode()
    {
        return getHibernateTemplate().find("from LogisticsCode");
    }
    public List<Logistics> findLogisticsList()
    {
        return new ArrayList<Logistics>(); // TODO
    }

}

