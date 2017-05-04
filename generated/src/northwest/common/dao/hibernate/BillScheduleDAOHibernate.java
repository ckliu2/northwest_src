package northwest.common.dao.hibernate;

import northwest.common.value.BillSchedule;
import northwest.common.dao.BillScheduleDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class BillScheduleDAOHibernate extends CommonDAOHibernate implements BillScheduleDAO
{

    public BillScheduleDAOHibernate()
    {
    }

    public void saveBillSchedule(BillSchedule val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillSchedule(BillSchedule val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillSchedule(Long id)
    {
        BillSchedule obj = findBillScheduleById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillSchedule findBillScheduleById(Long id)
    {
        if (id == null)
            return null;
        BillSchedule obj = (BillSchedule)getHibernateTemplate().get(northwest.common.value.BillSchedule.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillSchedule.class, id);
        else
            return obj;
    }

    public List<BillSchedule> findAllBillSchedule()
    {
        return getHibernateTemplate().find("from BillSchedule");
    }
    public List<UploadedFile> findImageDiagramList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findCheckDiagramList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<OutputEquipment> findOutputEquipmentList()
    {
        return new ArrayList<OutputEquipment>(); // TODO
    }

    public List<CustomerDetail> findCustomerAddressList()
    {
        return new ArrayList<CustomerDetail>(); // TODO
    }

    public List<Freight> findFreightList()
    {
        return new ArrayList<Freight>(); // TODO
    }

    public List<Member> findWorkerList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<BillDetail> findBillDetailList()
    {
        return new ArrayList<BillDetail>(); // TODO
    }

    public List<CustomerScreen> findCustomerScreenList()
    {
        return new ArrayList<CustomerScreen>(); // TODO
    }

    public List<Member> findCuticleerList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker1List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker2List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker3List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker4List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker5List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker6List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker7List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker8List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker9List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker10List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker11List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findChecker12List()
    {
        return new ArrayList<Member>(); // TODO
    }

    public Long[] getIdsFromUploadedFileList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                UploadedFile t = (UploadedFile) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getUploadedFileListByIds(Long[] ids)
    {
        ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                UploadedFile t = (UploadedFile) findUploadedFileById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

