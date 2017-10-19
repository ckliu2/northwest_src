package northwest.common.service;

import northwest.common.value.PostProductions;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface PostProductionsManager extends CommonManager 
{
    public abstract void savePostProductions(PostProductions val);

    public abstract void removePostProductions(PostProductions val);

    public abstract void removePostProductions(Long id);

    public abstract PostProductions getPostProductionsById(Long id);

    public abstract List<PostProductions> getPostProductionsList();
    public abstract List<Member> getMemberList();
    public abstract List<BillSchedule> getBillscheduleList();
}

