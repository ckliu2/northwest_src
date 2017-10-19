package northwest.common.service.impl;

import northwest.common.service.WeightsManager;
import northwest.common.dao.WeightsDAO;
import northwest.common.value.Weights;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class WeightsManagerImpl extends CommonManagerImpl implements WeightsManager
{

    public WeightsManagerImpl()
    {
    }

    public WeightsDAO getGenericDAO()
    {
        return (WeightsDAO)super.getGenericDAO();
    }

    public void setGenericDAO(WeightsDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveWeights(Weights val)
    {
        getGenericDAO().saveWeights(val);
    }

    public void removeWeights(Weights val)
    {
        getGenericDAO().removeWeights(val);
    }

    public void removeWeights(Long id)
    {
        getGenericDAO().removeWeights(id);
    }

    public Weights getWeightsById(Long id)
    {
         return getGenericDAO().findWeightsById(id);
    }

    public List<Weights> getWeightsList()
    {
        return getGenericDAO().findAllWeights();
    }
    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericDAO().findOutputEquipmentList();
    }

    public Long[] getIdsFromProductClassList(List<ProductClass> lst)
    {
        return getGenericDAO().getIdsFromProductClassList(lst);
    }

    public List<ProductClass> getProductClassListByIds(Long[] ids)
    {
        return getGenericDAO().getProductClassListByIds(ids);
    }

}

