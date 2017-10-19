package northwest.common.service;

import northwest.common.value.Weights;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public interface WeightsManager extends CommonManager 
{
    public abstract void saveWeights(Weights val);

    public abstract void removeWeights(Weights val);

    public abstract void removeWeights(Long id);

    public abstract Weights getWeightsById(Long id);

    public abstract List<Weights> getWeightsList();
    public abstract List<OutputEquipment> getOutputEquipmentList();
    public abstract Long[] getIdsFromProductClassList(List<ProductClass> lst);

    public abstract List<ProductClass> getProductClassListByIds(Long[] ids);

}

