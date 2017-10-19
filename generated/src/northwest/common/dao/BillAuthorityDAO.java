package northwest.common.dao;

import northwest.common.value.BillAuthority;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface BillAuthorityDAO extends CommonDAO 
{
    public abstract void saveBillAuthority(BillAuthority val);

    public abstract void removeBillAuthority(BillAuthority val);

    public abstract void removeBillAuthority(Long id);

    public abstract BillAuthority findBillAuthorityById(Long id);

    public abstract List<BillAuthority> findAllBillAuthority();
    public abstract List<Bill> findBillList();
    public abstract List<Group> findGroupList();
}

