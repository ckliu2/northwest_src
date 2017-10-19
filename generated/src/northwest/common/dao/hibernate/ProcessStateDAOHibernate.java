package northwest.common.dao.hibernate;

import northwest.common.value.ProcessState;
import northwest.common.dao.ProcessStateDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:56 CST 2017
*/

public class ProcessStateDAOHibernate extends CommonDAOHibernate implements ProcessStateDAO
{

    public ProcessStateDAOHibernate()
    {
    }

    public void saveProcessState(ProcessState val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProcessState(ProcessState val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProcessState(Long id)
    {
        ProcessState obj = findProcessStateById(id);
        getHibernateTemplate().delete(obj);
    }

    public ProcessState findProcessStateById(Long id)
    {
        if (id == null)
            return null;
        ProcessState obj = (ProcessState)getHibernateTemplate().get(northwest.common.value.ProcessState.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.ProcessState.class, id);
        else
            return obj;
    }

    public List<ProcessState> findAllProcessState()
    {
        return getHibernateTemplate().find("from ProcessState");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

}

