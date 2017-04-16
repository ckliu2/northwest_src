package northwest.common.dao;

import northwest.common.value.ProfitDetail;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public interface ProfitDetailDAO extends CommonDAO 
{
    public abstract void saveProfitDetail(ProfitDetail val);

    public abstract void removeProfitDetail(ProfitDetail val);

    public abstract void removeProfitDetail(Long id);

    public abstract ProfitDetail findProfitDetailById(Long id);

    public abstract List<ProfitDetail> findAllProfitDetail();
    public abstract List<ProductClass> findProductClassList();
    public abstract List<Profit> findProjectList();
    public abstract List<Product> findProductList();
    public abstract List<Profit> findProfitNoList();
}

