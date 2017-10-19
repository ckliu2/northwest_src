package northwest.common.dao;

import northwest.common.value.Product;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface ProductDAO extends CommonDAO 
{
    public abstract void saveProduct(Product val);

    public abstract void removeProduct(Product val);

    public abstract void removeProduct(Long id);

    public abstract Product findProductById(Long id);

    public abstract List<Product> findAllProduct();
    public abstract List<ProductClass> findProductClassList();
    public abstract List<ProductUnit> findProductUnitList();
}

