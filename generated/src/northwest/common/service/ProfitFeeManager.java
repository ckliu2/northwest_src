package northwest.common.service;

import northwest.common.value.ProfitFee;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public interface ProfitFeeManager extends CommonManager 
{
    public abstract void saveProfitFee(ProfitFee val);

    public abstract void removeProfitFee(ProfitFee val);

    public abstract void removeProfitFee(Long id);

    public abstract ProfitFee getProfitFeeById(Long id);

    public abstract List<ProfitFee> getProfitFeeList();
    public abstract List<Bill> getBillList();
}

