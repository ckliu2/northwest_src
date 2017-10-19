package northwest.common.dao.hibernate;

import northwest.common.value.Bill;
import northwest.common.dao.BillDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public class BillDAOHibernate extends CommonDAOHibernate implements BillDAO
{

    public BillDAOHibernate()
    {
    }

    public void saveBill(Bill val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBill(Bill val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBill(Long id)
    {
        Bill obj = findBillById(id);
        getHibernateTemplate().delete(obj);
    }

    public Bill findBillById(Long id)
    {
        if (id == null)
            return null;
        Bill obj = (Bill)getHibernateTemplate().get(northwest.common.value.Bill.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Bill.class, id);
        else
            return obj;
    }

    public List<Bill> findAllBill()
    {
        return getHibernateTemplate().find("from Bill");
    }
    public List<Customer> findCustomerList()
    {
        return new ArrayList<Customer>(); // TODO
    }

}

