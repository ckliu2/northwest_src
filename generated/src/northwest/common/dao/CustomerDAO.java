package northwest.common.dao;

import northwest.common.value.Customer;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface CustomerDAO extends CommonDAO 
{
    public abstract void saveCustomer(Customer val);

    public abstract void removeCustomer(Customer val);

    public abstract void removeCustomer(Long id);

    public abstract Customer findCustomerById(Long id);

    public abstract List<Customer> findAllCustomer();
    public abstract List<Member> findSalemanList();
}

