package northwest.common.service.impl;

import northwest.common.service.LogisticsManager;
import northwest.common.dao.LogisticsDAO;
import northwest.common.value.Logistics;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class LogisticsManagerImpl extends CommonManagerImpl implements LogisticsManager
{

    public LogisticsManagerImpl()
    {
    }

    public LogisticsDAO getGenericDAO()
    {
        return (LogisticsDAO)super.getGenericDAO();
    }

    public void setGenericDAO(LogisticsDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveLogistics(Logistics val)
    {
        getGenericDAO().saveLogistics(val);
    }

    public void removeLogistics(Logistics val)
    {
        getGenericDAO().removeLogistics(val);
    }

    public void removeLogistics(Long id)
    {
        getGenericDAO().removeLogistics(id);
    }

    public Logistics getLogisticsById(Long id)
    {
         return getGenericDAO().findLogisticsById(id);
    }

    public List<Logistics> getLogisticsList()
    {
        return getGenericDAO().findAllLogistics();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

