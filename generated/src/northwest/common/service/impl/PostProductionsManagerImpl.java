package northwest.common.service.impl;

import northwest.common.service.PostProductionsManager;
import northwest.common.dao.PostProductionsDAO;
import northwest.common.value.PostProductions;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class PostProductionsManagerImpl extends CommonManagerImpl implements PostProductionsManager
{

    public PostProductionsManagerImpl()
    {
    }

    public PostProductionsDAO getGenericDAO()
    {
        return (PostProductionsDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PostProductionsDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePostProductions(PostProductions val)
    {
        getGenericDAO().savePostProductions(val);
    }

    public void removePostProductions(PostProductions val)
    {
        getGenericDAO().removePostProductions(val);
    }

    public void removePostProductions(Long id)
    {
        getGenericDAO().removePostProductions(id);
    }

    public PostProductions getPostProductionsById(Long id)
    {
         return getGenericDAO().findPostProductionsById(id);
    }

    public List<PostProductions> getPostProductionsList()
    {
        return getGenericDAO().findAllPostProductions();
    }
    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

    public List<BillSchedule> getBillscheduleList()
    {
        return getGenericDAO().findBillscheduleList();
    }

}

