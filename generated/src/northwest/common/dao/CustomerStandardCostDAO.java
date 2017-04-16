package northwest.common.dao;

import northwest.common.value.CustomerStandardCost;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public interface CustomerStandardCostDAO extends CommonDAO 
{
    public abstract void saveCustomerStandardCost(CustomerStandardCost val);

    public abstract void removeCustomerStandardCost(CustomerStandardCost val);

    public abstract void removeCustomerStandardCost(Long id);

    public abstract CustomerStandardCost findCustomerStandardCostById(Long id);

    public abstract List<CustomerStandardCost> findAllCustomerStandardCost();
    public abstract List<Customer> findCustomerList();
    public abstract List<Product> findProductList();
}

