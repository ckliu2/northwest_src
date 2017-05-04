package northwest.common.dao.hibernate;

import northwest.common.value.OutputEquipment;
import northwest.common.dao.OutputEquipmentDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class OutputEquipmentDAOHibernate extends CommonDAOHibernate implements OutputEquipmentDAO
{

    public OutputEquipmentDAOHibernate()
    {
    }

    public void saveOutputEquipment(OutputEquipment val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeOutputEquipment(OutputEquipment val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeOutputEquipment(Long id)
    {
        OutputEquipment obj = findOutputEquipmentById(id);
        getHibernateTemplate().delete(obj);
    }

    public OutputEquipment findOutputEquipmentById(Long id)
    {
        if (id == null)
            return null;
        OutputEquipment obj = (OutputEquipment)getHibernateTemplate().get(northwest.common.value.OutputEquipment.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.OutputEquipment.class, id);
        else
            return obj;
    }

    public List<OutputEquipment> findAllOutputEquipment()
    {
        return getHibernateTemplate().find("from OutputEquipment");
    }
}

