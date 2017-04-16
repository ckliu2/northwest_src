package northwest.common.dao.hibernate;

import northwest.common.value.ProfitFee;
import northwest.common.dao.ProfitFeeDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitFeeDAOHibernate extends CommonDAOHibernate implements ProfitFeeDAO
{

    public ProfitFeeDAOHibernate()
    {
    }

    public void saveProfitFee(ProfitFee val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProfitFee(ProfitFee val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProfitFee(Long id)
    {
        ProfitFee obj = findProfitFeeById(id);
        getHibernateTemplate().delete(obj);
    }

    public ProfitFee findProfitFeeById(Long id)
    {
        if (id == null)
            return null;
        ProfitFee obj = (ProfitFee)getHibernateTemplate().get(northwest.common.value.ProfitFee.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.ProfitFee.class, id);
        else
            return obj;
    }

    public List<ProfitFee> findAllProfitFee()
    {
        return getHibernateTemplate().find("from ProfitFee");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

}

