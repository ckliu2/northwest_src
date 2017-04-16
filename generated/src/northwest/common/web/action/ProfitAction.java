package northwest.common.web.action;

import northwest.common.value.Profit;
import northwest.common.service.ProfitManager;
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

public class ProfitAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Profit profit;
    private Long[] selectedProfitIds;

    public ProfitAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProfitAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PROFIT");
    }

    public Profit getProfit()
    {
        return profit;
    }

    public void setProfit(Profit val)
    {
        profit = val;
    }

    public void setGenericManager(ProfitManager m)
    {
        super.setGenericManager(m);
    }

    public ProfitManager getGenericManager()
    {
        return (ProfitManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProfit(profit.getId());
        return DELETE;
    }

    public String edit()
    {
        if (profit == null) {
            profit = new Profit();
        } else if (profit.getId() != null) {
            profit = getGenericManager().getProfitById(profit.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProfitIds != null && selectedProfitIds.length > 0) {
            Profit obj = getGenericManager().getProfitById(selectedProfitIds[0]);
            obj.setId(null);
            profit = obj;
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
            if (inputValidation(profit) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Profit val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProfit(profit);
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
        profit.setCustomer(getGenericManager().getCustomerById(profit.getCustomerId())); 
        profit.setSalesmen(getGenericManager().getMemberById(profit.getSalesmenId())); 
        log.info("exit formToBean()");
    }
    public List<Customer> getCustomerList()
    {
        return getGenericManager().getCustomerList(); // TODO
    }

    public List<Member> getSalesmenList()
    {
        return getGenericManager().getSalesmenList(); // TODO
    }

    public List<Profit> getProfitList()
    {
        return getGenericManager().getProfitList();
    }

    public void setSelectedProfitIds(Long[] val)
    {
        selectedProfitIds = val;
    }

    public Long[] getSelectedProfitIds()
    {
        return selectedProfitIds;
    }
}
