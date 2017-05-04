package northwest.common.dao;

import northwest.common.value.BillFinish;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public interface BillFinishDAO extends CommonDAO 
{
    public abstract void saveBillFinish(BillFinish val);

    public abstract void removeBillFinish(BillFinish val);

    public abstract void removeBillFinish(Long id);

    public abstract BillFinish findBillFinishById(Long id);

    public abstract List<BillFinish> findAllBillFinish();
    public abstract List<Bill> findBillList();
}

