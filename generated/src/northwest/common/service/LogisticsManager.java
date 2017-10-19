package northwest.common.service;

import northwest.common.value.Logistics;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public interface LogisticsManager extends CommonManager 
{
    public abstract void saveLogistics(Logistics val);

    public abstract void removeLogistics(Logistics val);

    public abstract void removeLogistics(Long id);

    public abstract Logistics getLogisticsById(Long id);

    public abstract List<Logistics> getLogisticsList();
    public abstract List<Bill> getBillList();
    public abstract List<Member> getMemberList();
    public abstract List<Member> getCreatedUserList();
}

