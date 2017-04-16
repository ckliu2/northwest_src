package northwest.common.dao;

import northwest.common.value.ProductUnit;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface ProductUnitDAO extends CommonDAO 
{
    public abstract void saveProductUnit(ProductUnit val);

    public abstract void removeProductUnit(ProductUnit val);

    public abstract void removeProductUnit(Long id);

    public abstract ProductUnit findProductUnitById(Long id);

    public abstract List<ProductUnit> findAllProductUnit();
}

