package northwest.common.dao;

import northwest.common.value.PostProductions;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface PostProductionsDAO extends CommonDAO 
{
    public abstract void savePostProductions(PostProductions val);

    public abstract void removePostProductions(PostProductions val);

    public abstract void removePostProductions(Long id);

    public abstract PostProductions findPostProductionsById(Long id);

    public abstract List<PostProductions> findAllPostProductions();
    public abstract List<Member> findMemberList();
    public abstract List<BillSchedule> findBillscheduleList();
}

