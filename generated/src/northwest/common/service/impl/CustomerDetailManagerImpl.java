package northwest.common.service.impl;

import northwest.common.service.CustomerDetailManager;
import northwest.common.dao.CustomerDetailDAO;
import northwest.common.value.CustomerDetail;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class CustomerDetailManagerImpl extends CommonManagerImpl implements CustomerDetailManager
{

    public CustomerDetailManagerImpl()
    {
    }

    public CustomerDetailDAO getGenericDAO()
    {
        return (CustomerDetailDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CustomerDetailDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCustomerDetail(CustomerDetail val)
    {
        getGenericDAO().saveCustomerDetail(val);
    }

    public void removeCustomerDetail(CustomerDetail val)
    {
        getGenericDAO().removeCustomerDetail(val);
    }

    public void removeCustomerDetail(Long id)
    {
        getGenericDAO().removeCustomerDetail(id);
    }

    public CustomerDetail getCustomerDetailById(Long id)
    {
         return getGenericDAO().findCustomerDetailById(id);
    }

    public List<CustomerDetail> getCustomerDetailList()
    {
        return getGenericDAO().findAllCustomerDetail();
    }
    public List<UploadedFile> getPlanmapList()
    {
        return getGenericDAO().findPlanmapList();
    }

    public List<UploadedFile> getPhoto1List()
    {
        return getGenericDAO().findPhoto1List();
    }

    public List<UploadedFile> getPhoto2List()
    {
        return getGenericDAO().findPhoto2List();
    }

    public List<UploadedFile> getPhoto3List()
    {
        return getGenericDAO().findPhoto3List();
    }

    public List<UploadedFile> getPhoto4List()
    {
        return getGenericDAO().findPhoto4List();
    }

    public List<UploadedFile> getPhoto5List()
    {
        return getGenericDAO().findPhoto5List();
    }

    public List<Member> getCustomerServiceList()
    {
        return getGenericDAO().findCustomerServiceList();
    }

    public List<Customer> getCustomerList()
    {
        return getGenericDAO().findCustomerList();
    }

}

