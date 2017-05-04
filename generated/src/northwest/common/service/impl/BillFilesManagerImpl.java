package northwest.common.service.impl;

import northwest.common.service.BillFilesManager;
import northwest.common.dao.BillFilesDAO;
import northwest.common.value.BillFiles;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class BillFilesManagerImpl extends CommonManagerImpl implements BillFilesManager
{

    public BillFilesManagerImpl()
    {
    }

    public BillFilesDAO getGenericDAO()
    {
        return (BillFilesDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillFilesDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillFiles(BillFiles val)
    {
        getGenericDAO().saveBillFiles(val);
    }

    public void removeBillFiles(BillFiles val)
    {
        getGenericDAO().removeBillFiles(val);
    }

    public void removeBillFiles(Long id)
    {
        getGenericDAO().removeBillFiles(id);
    }

    public BillFiles getBillFilesById(Long id)
    {
         return getGenericDAO().findBillFilesById(id);
    }

    public List<BillFiles> getBillFilesList()
    {
        return getGenericDAO().findAllBillFiles();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

    public List<UploadedFile> getDoc1List()
    {
        return getGenericDAO().findDoc1List();
    }

    public List<UploadedFile> getDoc2List()
    {
        return getGenericDAO().findDoc2List();
    }

    public List<UploadedFile> getDoc3List()
    {
        return getGenericDAO().findDoc3List();
    }

    public List<UploadedFile> getDoc4List()
    {
        return getGenericDAO().findDoc4List();
    }

    public List<UploadedFile> getDoc5List()
    {
        return getGenericDAO().findDoc5List();
    }

    public List<UploadedFile> getDoc6List()
    {
        return getGenericDAO().findDoc6List();
    }

}

