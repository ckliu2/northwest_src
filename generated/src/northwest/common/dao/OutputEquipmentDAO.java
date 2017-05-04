package northwest.common.dao;

import northwest.common.value.OutputEquipment;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public interface OutputEquipmentDAO extends CommonDAO 
{
    public abstract void saveOutputEquipment(OutputEquipment val);

    public abstract void removeOutputEquipment(OutputEquipment val);

    public abstract void removeOutputEquipment(Long id);

    public abstract OutputEquipment findOutputEquipmentById(Long id);

    public abstract List<OutputEquipment> findAllOutputEquipment();
}

