package northwest.common.dao.hibernate;

import northwest.common.value.ProfitDetail;
import northwest.common.dao.ProfitDetailDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitDetailDAOHibernate extends CommonDAOHibernate implements ProfitDetailDAO
{

    public ProfitDetailDAOHibernate()
    {
    }

    public void saveProfitDetail(ProfitDetail val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeProfitDetail(ProfitDetail val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProfitDetail(Long id)
    {
        ProfitDetail obj = findProfitDetailById(id);
        getHibernateTemplate().delete(obj);
    }

    public ProfitDetail findProfitDetailById(Long id)
    {
        if (id == null)
            return null;
        ProfitDetail obj = (ProfitDetail)getHibernateTemplate().get(northwest.common.value.ProfitDetail.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.ProfitDetail.class, id);
        else
            return obj;
    }

    public List<ProfitDetail> findAllProfitDetail()
    {
        return getHibernateTemplate().find("from ProfitDetail");
    }
    public List<ProductClass> findProductClassList()
    {
        return new ArrayList<ProductClass>(); // TODO
    }

    public List<Profit> findProjectList()
    {
        return new ArrayList<Profit>(); // TODO
    }

    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

    public List<Profit> findProfitNoList()
    {
        return new ArrayList<Profit>(); // TODO
    }

}

