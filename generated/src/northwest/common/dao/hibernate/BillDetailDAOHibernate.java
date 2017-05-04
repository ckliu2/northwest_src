package northwest.common.dao.hibernate;

import northwest.common.value.BillDetail;
import northwest.common.dao.BillDetailDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class BillDetailDAOHibernate extends CommonDAOHibernate implements BillDetailDAO
{

    public BillDetailDAOHibernate()
    {
    }

    public void saveBillDetail(BillDetail val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillDetail(BillDetail val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillDetail(Long id)
    {
        BillDetail obj = findBillDetailById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillDetail findBillDetailById(Long id)
    {
        if (id == null)
            return null;
        BillDetail obj = (BillDetail)getHibernateTemplate().get(northwest.common.value.BillDetail.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillDetail.class, id);
        else
            return obj;
    }

    public List<BillDetail> findAllBillDetail()
    {
        return getHibernateTemplate().find("from BillDetail");
    }
    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

}

