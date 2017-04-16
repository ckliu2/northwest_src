package northwest.common.service.impl;

import northwest.common.service.MeterManager;
import northwest.common.dao.MeterDAO;
import northwest.common.value.Meter;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class MeterManagerImpl extends CommonManagerImpl implements MeterManager
{

    public MeterManagerImpl()
    {
    }

    public MeterDAO getGenericDAO()
    {
        return (MeterDAO)super.getGenericDAO();
    }

    public void setGenericDAO(MeterDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveMeter(Meter val)
    {
        getGenericDAO().saveMeter(val);
    }

    public void removeMeter(Meter val)
    {
        getGenericDAO().removeMeter(val);
    }

    public void removeMeter(Long id)
    {
        getGenericDAO().removeMeter(id);
    }

    public Meter getMeterById(Long id)
    {
         return getGenericDAO().findMeterById(id);
    }

    public List<Meter> getMeterList()
    {
        return getGenericDAO().findAllMeter();
    }
    public List<BillSchedule> getScheduleList()
    {
        return getGenericDAO().findScheduleList();
    }

    public List<BillDetail> getBilldetailList()
    {
        return getGenericDAO().findBilldetailList();
    }

    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

}

