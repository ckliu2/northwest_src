package northwest.common.dao.hibernate;

import northwest.common.value.BillFinish;
import northwest.common.dao.BillFinishDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class BillFinishDAOHibernate extends CommonDAOHibernate implements BillFinishDAO
{

    public BillFinishDAOHibernate()
    {
    }

    public void saveBillFinish(BillFinish val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillFinish(BillFinish val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillFinish(Long id)
    {
        BillFinish obj = findBillFinishById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillFinish findBillFinishById(Long id)
    {
        if (id == null)
            return null;
        BillFinish obj = (BillFinish)getHibernateTemplate().get(northwest.common.value.BillFinish.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillFinish.class, id);
        else
            return obj;
    }

    public List<BillFinish> findAllBillFinish()
    {
        return getHibernateTemplate().find("from BillFinish");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

}

