package northwest.common.service;

import northwest.common.value.Bill;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface BillManager extends CommonManager 
{
    public abstract void saveBill(Bill val);

    public abstract void removeBill(Bill val);

    public abstract void removeBill(Long id);

    public abstract Bill getBillById(Long id);

    public abstract List<Bill> getBillList();
    public abstract List<Customer> getCustomerList();
}

