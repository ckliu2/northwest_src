package northwest.common.service;

import northwest.common.value.CustomerDetail;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface CustomerDetailManager extends CommonManager 
{
    public abstract void saveCustomerDetail(CustomerDetail val);

    public abstract void removeCustomerDetail(CustomerDetail val);

    public abstract void removeCustomerDetail(Long id);

    public abstract CustomerDetail getCustomerDetailById(Long id);

    public abstract List<CustomerDetail> getCustomerDetailList();
    public abstract List<UploadedFile> getPlanmapList();
    public abstract List<UploadedFile> getPhoto1List();
    public abstract List<UploadedFile> getPhoto2List();
    public abstract List<UploadedFile> getPhoto3List();
    public abstract List<UploadedFile> getPhoto4List();
    public abstract List<UploadedFile> getPhoto5List();
    public abstract List<Member> getCustomerServiceList();
    public abstract List<Customer> getCustomerList();
}

