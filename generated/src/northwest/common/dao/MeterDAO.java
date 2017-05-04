package northwest.common.dao;

import northwest.common.value.Meter;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public interface MeterDAO extends CommonDAO 
{
    public abstract void saveMeter(Meter val);

    public abstract void removeMeter(Meter val);

    public abstract void removeMeter(Long id);

    public abstract Meter findMeterById(Long id);

    public abstract List<Meter> findAllMeter();
    public abstract List<BillSchedule> findScheduleList();
    public abstract List<BillDetail> findBilldetailList();
    public abstract List<Bill> findBillList();
    public abstract List<Product> findProductList();
}

