package northwest.common.dao.hibernate;

import northwest.common.value.PostProductions;
import northwest.common.dao.PostProductionsDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:56 CST 2017
*/

public class PostProductionsDAOHibernate extends CommonDAOHibernate implements PostProductionsDAO
{

    public PostProductionsDAOHibernate()
    {
    }

    public void savePostProductions(PostProductions val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePostProductions(PostProductions val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePostProductions(Long id)
    {
        PostProductions obj = findPostProductionsById(id);
        getHibernateTemplate().delete(obj);
    }

    public PostProductions findPostProductionsById(Long id)
    {
        if (id == null)
            return null;
        PostProductions obj = (PostProductions)getHibernateTemplate().get(northwest.common.value.PostProductions.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.PostProductions.class, id);
        else
            return obj;
    }

    public List<PostProductions> findAllPostProductions()
    {
        return getHibernateTemplate().find("from PostProductions");
    }
    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<BillSchedule> findBillscheduleList()
    {
        return new ArrayList<BillSchedule>(); // TODO
    }

}

