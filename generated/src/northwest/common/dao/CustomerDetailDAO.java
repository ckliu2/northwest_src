package northwest.common.dao;

import northwest.common.value.CustomerDetail;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface CustomerDetailDAO extends CommonDAO 
{
    public abstract void saveCustomerDetail(CustomerDetail val);

    public abstract void removeCustomerDetail(CustomerDetail val);

    public abstract void removeCustomerDetail(Long id);

    public abstract CustomerDetail findCustomerDetailById(Long id);

    public abstract List<CustomerDetail> findAllCustomerDetail();
    public abstract List<UploadedFile> findPlanmapList();
    public abstract List<UploadedFile> findPhoto1List();
    public abstract List<UploadedFile> findPhoto2List();
    public abstract List<UploadedFile> findPhoto3List();
    public abstract List<UploadedFile> findPhoto4List();
    public abstract List<UploadedFile> findPhoto5List();
    public abstract List<Member> findCustomerServiceList();
    public abstract List<Customer> findCustomerList();
}

