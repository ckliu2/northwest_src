package northwest.common.dao.hibernate;

import northwest.common.value.BillFiles;
import northwest.common.dao.BillFilesDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:56 CST 2017
*/

public class BillFilesDAOHibernate extends CommonDAOHibernate implements BillFilesDAO
{

    public BillFilesDAOHibernate()
    {
    }

    public void saveBillFiles(BillFiles val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillFiles(BillFiles val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillFiles(Long id)
    {
        BillFiles obj = findBillFilesById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillFiles findBillFilesById(Long id)
    {
        if (id == null)
            return null;
        BillFiles obj = (BillFiles)getHibernateTemplate().get(northwest.common.value.BillFiles.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillFiles.class, id);
        else
            return obj;
    }

    public List<BillFiles> findAllBillFiles()
    {
        return getHibernateTemplate().find("from BillFiles");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

    public List<UploadedFile> findDoc1List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findDoc2List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findDoc3List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findDoc4List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findDoc5List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findDoc6List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

}

