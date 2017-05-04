package northwest.common.service;

import northwest.common.value.Freight;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface FreightManager extends CommonManager 
{
    public abstract void saveFreight(Freight val);

    public abstract void removeFreight(Freight val);

    public abstract void removeFreight(Long id);

    public abstract Freight getFreightById(Long id);

    public abstract List<Freight> getFreightList();
}

