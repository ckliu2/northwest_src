package northwest.common.service.impl;

import northwest.common.service.ProfitDetailManager;
import northwest.common.dao.ProfitDetailDAO;
import northwest.common.value.ProfitDetail;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitDetailManagerImpl extends CommonManagerImpl implements ProfitDetailManager
{

    public ProfitDetailManagerImpl()
    {
    }

    public ProfitDetailDAO getGenericDAO()
    {
        return (ProfitDetailDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProfitDetailDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProfitDetail(ProfitDetail val)
    {
        getGenericDAO().saveProfitDetail(val);
    }

    public void removeProfitDetail(ProfitDetail val)
    {
        getGenericDAO().removeProfitDetail(val);
    }

    public void removeProfitDetail(Long id)
    {
        getGenericDAO().removeProfitDetail(id);
    }

    public ProfitDetail getProfitDetailById(Long id)
    {
         return getGenericDAO().findProfitDetailById(id);
    }

    public List<ProfitDetail> getProfitDetailList()
    {
        return getGenericDAO().findAllProfitDetail();
    }
    public List<ProductClass> getProductClassList()
    {
        return getGenericDAO().findProductClassList();
    }

    public List<Profit> getProjectList()
    {
        return getGenericDAO().findProjectList();
    }

    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

    public List<Profit> getProfitNoList()
    {
        return getGenericDAO().findProfitNoList();
    }

}

