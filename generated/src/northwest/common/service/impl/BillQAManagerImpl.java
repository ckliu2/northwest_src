package northwest.common.service.impl;

import northwest.common.service.BillQAManager;
import northwest.common.dao.BillQADAO;
import northwest.common.value.BillQA;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class BillQAManagerImpl extends CommonManagerImpl implements BillQAManager
{

    public BillQAManagerImpl()
    {
    }

    public BillQADAO getGenericDAO()
    {
        return (BillQADAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillQADAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillQA(BillQA val)
    {
        getGenericDAO().saveBillQA(val);
    }

    public void removeBillQA(BillQA val)
    {
        getGenericDAO().removeBillQA(val);
    }

    public void removeBillQA(Long id)
    {
        getGenericDAO().removeBillQA(id);
    }

    public BillQA getBillQAById(Long id)
    {
         return getGenericDAO().findBillQAById(id);
    }

    public List<BillQA> getBillQAList()
    {
        return getGenericDAO().findAllBillQA();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

    public Long[] getIdsFromMemberList(List<Member> lst)
    {
        return getGenericDAO().getIdsFromMemberList(lst);
    }

    public List<Member> getMemberListByIds(Long[] ids)
    {
        return getGenericDAO().getMemberListByIds(ids);
    }

}

