package northwest.common.service;

import northwest.common.value.ProfitDetail;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public interface ProfitDetailManager extends CommonManager 
{
    public abstract void saveProfitDetail(ProfitDetail val);

    public abstract void removeProfitDetail(ProfitDetail val);

    public abstract void removeProfitDetail(Long id);

    public abstract ProfitDetail getProfitDetailById(Long id);

    public abstract List<ProfitDetail> getProfitDetailList();
    public abstract List<ProductClass> getProductClassList();
    public abstract List<Profit> getProjectList();
    public abstract List<Product> getProductList();
    public abstract List<Profit> getProfitNoList();
}

