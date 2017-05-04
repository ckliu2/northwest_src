package northwest.common.dao.hibernate;

import northwest.common.value.CustomerScreen;
import northwest.common.dao.CustomerScreenDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class CustomerScreenDAOHibernate extends CommonDAOHibernate implements CustomerScreenDAO
{

    public CustomerScreenDAOHibernate()
    {
    }

    public void saveCustomerScreen(CustomerScreen val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCustomerScreen(CustomerScreen val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCustomerScreen(Long id)
    {
        CustomerScreen obj = findCustomerScreenById(id);
        getHibernateTemplate().delete(obj);
    }

    public CustomerScreen findCustomerScreenById(Long id)
    {
        if (id == null)
            return null;
        CustomerScreen obj = (CustomerScreen)getHibernateTemplate().get(northwest.common.value.CustomerScreen.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.CustomerScreen.class, id);
        else
            return obj;
    }

    public List<CustomerScreen> findAllCustomerScreen()
    {
        return getHibernateTemplate().find("from CustomerScreen");
    }
    public List<CustomerDetail> findCustomerDetailList()
    {
        return new ArrayList<CustomerDetail>(); // TODO
    }

    public Long[] getIdsFromUploadedFileList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                UploadedFile t = (UploadedFile) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getUploadedFileListByIds(Long[] ids)
    {
        ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                UploadedFile t = (UploadedFile) findUploadedFileById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

