package northwest.common.dao.hibernate;

import northwest.common.value.RecipientDB;
import northwest.common.dao.RecipientDBDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public class RecipientDBDAOHibernate extends CommonDAOHibernate implements RecipientDBDAO
{

    public RecipientDBDAOHibernate()
    {
    }

    public void saveRecipientDB(RecipientDB val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRecipientDB(RecipientDB val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRecipientDB(Long id)
    {
        RecipientDB obj = findRecipientDBById(id);
        getHibernateTemplate().delete(obj);
    }

    public RecipientDB findRecipientDBById(Long id)
    {
        if (id == null)
            return null;
        RecipientDB obj = (RecipientDB)getHibernateTemplate().get(northwest.common.value.RecipientDB.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.RecipientDB.class, id);
        else
            return obj;
    }

    public List<RecipientDB> findAllRecipientDB()
    {
        return getHibernateTemplate().find("from RecipientDB");
    }
}

