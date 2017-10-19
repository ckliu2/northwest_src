package northwest.common.dao.hibernate;

import northwest.common.value.SenderDB;
import northwest.common.dao.SenderDBDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:56 CST 2017
*/

public class SenderDBDAOHibernate extends CommonDAOHibernate implements SenderDBDAO
{

    public SenderDBDAOHibernate()
    {
    }

    public void saveSenderDB(SenderDB val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSenderDB(SenderDB val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSenderDB(Long id)
    {
        SenderDB obj = findSenderDBById(id);
        getHibernateTemplate().delete(obj);
    }

    public SenderDB findSenderDBById(Long id)
    {
        if (id == null)
            return null;
        SenderDB obj = (SenderDB)getHibernateTemplate().get(northwest.common.value.SenderDB.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.SenderDB.class, id);
        else
            return obj;
    }

    public List<SenderDB> findAllSenderDB()
    {
        return getHibernateTemplate().find("from SenderDB");
    }
}

