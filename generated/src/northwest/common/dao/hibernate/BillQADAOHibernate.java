package northwest.common.dao.hibernate;

import northwest.common.value.BillQA;
import northwest.common.dao.BillQADAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public class BillQADAOHibernate extends CommonDAOHibernate implements BillQADAO
{

    public BillQADAOHibernate()
    {
    }

    public void saveBillQA(BillQA val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillQA(BillQA val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillQA(Long id)
    {
        BillQA obj = findBillQAById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillQA findBillQAById(Long id)
    {
        if (id == null)
            return null;
        BillQA obj = (BillQA)getHibernateTemplate().get(northwest.common.value.BillQA.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillQA.class, id);
        else
            return obj;
    }

    public List<BillQA> findAllBillQA()
    {
        return getHibernateTemplate().find("from BillQA");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public Long[] getIdsFromMemberList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Member t = (Member) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getMemberListByIds(Long[] ids)
    {
        ArrayList<Member> al = new ArrayList<Member>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Member t = (Member) findMemberById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

