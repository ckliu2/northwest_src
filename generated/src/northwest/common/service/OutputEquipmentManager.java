package northwest.common.service;

import northwest.common.value.OutputEquipment;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface OutputEquipmentManager extends CommonManager 
{
    public abstract void saveOutputEquipment(OutputEquipment val);

    public abstract void removeOutputEquipment(OutputEquipment val);

    public abstract void removeOutputEquipment(Long id);

    public abstract OutputEquipment getOutputEquipmentById(Long id);

    public abstract List<OutputEquipment> getOutputEquipmentList();
}

