package northwest.common.dao;

import northwest.common.value.Freight;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface FreightDAO extends CommonDAO 
{
    public abstract void saveFreight(Freight val);

    public abstract void removeFreight(Freight val);

    public abstract void removeFreight(Long id);

    public abstract Freight findFreightById(Long id);

    public abstract List<Freight> findAllFreight();
}

