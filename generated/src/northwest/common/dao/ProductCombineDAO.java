package northwest.common.dao;

import northwest.common.value.ProductCombine;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface ProductCombineDAO extends CommonDAO 
{
    public abstract void saveProductCombine(ProductCombine val);

    public abstract void removeProductCombine(ProductCombine val);

    public abstract void removeProductCombine(Long id);

    public abstract ProductCombine findProductCombineById(Long id);

    public abstract List<ProductCombine> findAllProductCombine();
    public abstract List<Product> findProductList();
}

