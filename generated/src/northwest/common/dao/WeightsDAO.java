package northwest.common.dao;

import northwest.common.value.Weights;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface WeightsDAO extends CommonDAO 
{
    public abstract void saveWeights(Weights val);

    public abstract void removeWeights(Weights val);

    public abstract void removeWeights(Long id);

    public abstract Weights findWeightsById(Long id);

    public abstract List<Weights> findAllWeights();
    public abstract List<OutputEquipment> findOutputEquipmentList();
    public abstract Long[] getIdsFromProductClassList(List<ProductClass> lst);

    public abstract List<ProductClass> getProductClassListByIds(Long[] ids);

}

