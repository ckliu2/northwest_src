package northwest.common.service.impl;

import northwest.common.service.LogisticsCodeManager;
import northwest.common.dao.LogisticsCodeDAO;
import northwest.common.value.LogisticsCode;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class LogisticsCodeManagerImpl extends CommonManagerImpl implements LogisticsCodeManager
{

    public LogisticsCodeManagerImpl()
    {
    }

    public LogisticsCodeDAO getGenericDAO()
    {
        return (LogisticsCodeDAO)super.getGenericDAO();
    }

    public void setGenericDAO(LogisticsCodeDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveLogisticsCode(LogisticsCode val)
    {
        getGenericDAO().saveLogisticsCode(val);
    }

    public void removeLogisticsCode(LogisticsCode val)
    {
        getGenericDAO().removeLogisticsCode(val);
    }

    public void removeLogisticsCode(Long id)
    {
        getGenericDAO().removeLogisticsCode(id);
    }

    public LogisticsCode getLogisticsCodeById(Long id)
    {
         return getGenericDAO().findLogisticsCodeById(id);
    }

    public List<LogisticsCode> getLogisticsCodeList()
    {
        return getGenericDAO().findAllLogisticsCode();
    }
    public List<Logistics> getLogisticsList()
    {
        return getGenericDAO().findLogisticsList();
    }

}

