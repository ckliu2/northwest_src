package northwest.common.dao.hibernate;

import northwest.common.value.Meter;
import northwest.common.dao.MeterDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public class MeterDAOHibernate extends CommonDAOHibernate implements MeterDAO
{

    public MeterDAOHibernate()
    {
    }

    public void saveMeter(Meter val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMeter(Meter val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMeter(Long id)
    {
        Meter obj = findMeterById(id);
        getHibernateTemplate().delete(obj);
    }

    public Meter findMeterById(Long id)
    {
        if (id == null)
            return null;
        Meter obj = (Meter)getHibernateTemplate().get(northwest.common.value.Meter.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.Meter.class, id);
        else
            return obj;
    }

    public List<Meter> findAllMeter()
    {
        return getHibernateTemplate().find("from Meter");
    }
    public List<BillSchedule> findScheduleList()
    {
        return new ArrayList<BillSchedule>(); // TODO
    }

    public List<BillDetail> findBilldetailList()
    {
        return new ArrayList<BillDetail>(); // TODO
    }

    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

    public List<Product> findProductList()
    {
        return new ArrayList<Product>(); // TODO
    }

}

