package northwest.common.web.action;

import northwest.common.value.ProfitFee;
import northwest.common.service.ProfitFeeManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitFeeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProfitFee profitFee;
    private Long[] selectedProfitFeeIds;

    public ProfitFeeAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProfitFeeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PROFITFEE");
    }

    public ProfitFee getProfitFee()
    {
        return profitFee;
    }

    public void setProfitFee(ProfitFee val)
    {
        profitFee = val;
    }

    public void setGenericManager(ProfitFeeManager m)
    {
        super.setGenericManager(m);
    }

    public ProfitFeeManager getGenericManager()
    {
        return (ProfitFeeManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProfitFee(profitFee.getId());
        return DELETE;
    }

    public String edit()
    {
        if (profitFee == null) {
            profitFee = new ProfitFee();
        } else if (profitFee.getId() != null) {
            profitFee = getGenericManager().getProfitFeeById(profitFee.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProfitFeeIds != null && selectedProfitFeeIds.length > 0) {
            ProfitFee obj = getGenericManager().getProfitFeeById(selectedProfitFeeIds[0]);
            obj.setId(null);
            profitFee = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(profitFee) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProfitFee val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProfitFee(profitFee);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        profitFee.setBill(getGenericManager().getBillById(profitFee.getBillId())); 
        log.info("exit formToBean()");
    }
    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<ProfitFee> getProfitFeeList()
    {
        return getGenericManager().getProfitFeeList();
    }

    public void setSelectedProfitFeeIds(Long[] val)
    {
        selectedProfitFeeIds = val;
    }

    public Long[] getSelectedProfitFeeIds()
    {
        return selectedProfitFeeIds;
    }
}
