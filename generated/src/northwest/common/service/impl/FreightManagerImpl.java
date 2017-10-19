package northwest.common.service.impl;

import northwest.common.service.FreightManager;
import northwest.common.dao.FreightDAO;
import northwest.common.value.Freight;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class FreightManagerImpl extends CommonManagerImpl implements FreightManager
{

    public FreightManagerImpl()
    {
    }

    public FreightDAO getGenericDAO()
    {
        return (FreightDAO)super.getGenericDAO();
    }

    public void setGenericDAO(FreightDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveFreight(Freight val)
    {
        getGenericDAO().saveFreight(val);
    }

    public void removeFreight(Freight val)
    {
        getGenericDAO().removeFreight(val);
    }

    public void removeFreight(Long id)
    {
        getGenericDAO().removeFreight(id);
    }

    public Freight getFreightById(Long id)
    {
         return getGenericDAO().findFreightById(id);
    }

    public List<Freight> getFreightList()
    {
        return getGenericDAO().findAllFreight();
    }
}

