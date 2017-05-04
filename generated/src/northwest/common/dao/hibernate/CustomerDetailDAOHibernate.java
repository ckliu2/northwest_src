package northwest.common.dao.hibernate;

import northwest.common.value.CustomerDetail;
import northwest.common.dao.CustomerDetailDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class CustomerDetailDAOHibernate extends CommonDAOHibernate implements CustomerDetailDAO
{

    public CustomerDetailDAOHibernate()
    {
    }

    public void saveCustomerDetail(CustomerDetail val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCustomerDetail(CustomerDetail val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCustomerDetail(Long id)
    {
        CustomerDetail obj = findCustomerDetailById(id);
        getHibernateTemplate().delete(obj);
    }

    public CustomerDetail findCustomerDetailById(Long id)
    {
        if (id == null)
            return null;
        CustomerDetail obj = (CustomerDetail)getHibernateTemplate().get(northwest.common.value.CustomerDetail.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.CustomerDetail.class, id);
        else
            return obj;
    }

    public List<CustomerDetail> findAllCustomerDetail()
    {
        return getHibernateTemplate().find("from CustomerDetail");
    }
    public List<UploadedFile> findPlanmapList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto1List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto2List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto3List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto4List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto5List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<Member> findCustomerServiceList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Customer> findCustomerList()
    {
        return new ArrayList<Customer>(); // TODO
    }

}

