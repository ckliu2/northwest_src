package northwest.common.service;

import northwest.common.value.StandardCost;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public interface StandardCostManager extends CommonManager 
{
    public abstract void saveStandardCost(StandardCost val);

    public abstract void removeStandardCost(StandardCost val);

    public abstract void removeStandardCost(Long id);

    public abstract StandardCost getStandardCostById(Long id);

    public abstract List<StandardCost> getStandardCostList();
    public abstract List<Product> getProductList();
}

