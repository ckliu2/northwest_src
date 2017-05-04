package northwest.common.service.impl;

import northwest.common.service.ProcessStateManager;
import northwest.common.dao.ProcessStateDAO;
import northwest.common.value.ProcessState;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class ProcessStateManagerImpl extends CommonManagerImpl implements ProcessStateManager
{

    public ProcessStateManagerImpl()
    {
    }

    public ProcessStateDAO getGenericDAO()
    {
        return (ProcessStateDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ProcessStateDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveProcessState(ProcessState val)
    {
        getGenericDAO().saveProcessState(val);
    }

    public void removeProcessState(ProcessState val)
    {
        getGenericDAO().removeProcessState(val);
    }

    public void removeProcessState(Long id)
    {
        getGenericDAO().removeProcessState(id);
    }

    public ProcessState getProcessStateById(Long id)
    {
         return getGenericDAO().findProcessStateById(id);
    }

    public List<ProcessState> getProcessStateList()
    {
        return getGenericDAO().findAllProcessState();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

}

