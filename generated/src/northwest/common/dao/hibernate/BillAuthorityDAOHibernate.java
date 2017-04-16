package northwest.common.dao.hibernate;

import northwest.common.value.BillAuthority;
import northwest.common.dao.BillAuthorityDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public class BillAuthorityDAOHibernate extends CommonDAOHibernate implements BillAuthorityDAO
{

    public BillAuthorityDAOHibernate()
    {
    }

    public void saveBillAuthority(BillAuthority val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillAuthority(BillAuthority val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillAuthority(Long id)
    {
        BillAuthority obj = findBillAuthorityById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillAuthority findBillAuthorityById(Long id)
    {
        if (id == null)
            return null;
        BillAuthority obj = (BillAuthority)getHibernateTemplate().get(northwest.common.value.BillAuthority.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillAuthority.class, id);
        else
            return obj;
    }

    public List<BillAuthority> findAllBillAuthority()
    {
        return getHibernateTemplate().find("from BillAuthority");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

    public List<Group> findGroupList()
    {
        return new ArrayList<Group>(); // TODO
    }

}

