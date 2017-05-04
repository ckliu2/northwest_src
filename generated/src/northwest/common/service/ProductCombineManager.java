package northwest.common.service;

import northwest.common.value.ProductCombine;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface ProductCombineManager extends CommonManager 
{
    public abstract void saveProductCombine(ProductCombine val);

    public abstract void removeProductCombine(ProductCombine val);

    public abstract void removeProductCombine(Long id);

    public abstract ProductCombine getProductCombineById(Long id);

    public abstract List<ProductCombine> getProductCombineList();
    public abstract List<Product> getProductList();
}

