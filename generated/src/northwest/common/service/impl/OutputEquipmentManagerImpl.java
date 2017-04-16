package northwest.common.service.impl;

import northwest.common.service.OutputEquipmentManager;
import northwest.common.dao.OutputEquipmentDAO;
import northwest.common.value.OutputEquipment;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class OutputEquipmentManagerImpl extends CommonManagerImpl implements OutputEquipmentManager
{

    public OutputEquipmentManagerImpl()
    {
    }

    public OutputEquipmentDAO getGenericDAO()
    {
        return (OutputEquipmentDAO)super.getGenericDAO();
    }

    public void setGenericDAO(OutputEquipmentDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveOutputEquipment(OutputEquipment val)
    {
        getGenericDAO().saveOutputEquipment(val);
    }

    public void removeOutputEquipment(OutputEquipment val)
    {
        getGenericDAO().removeOutputEquipment(val);
    }

    public void removeOutputEquipment(Long id)
    {
        getGenericDAO().removeOutputEquipment(id);
    }

    public OutputEquipment getOutputEquipmentById(Long id)
    {
         return getGenericDAO().findOutputEquipmentById(id);
    }

    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericDAO().findAllOutputEquipment();
    }
}

