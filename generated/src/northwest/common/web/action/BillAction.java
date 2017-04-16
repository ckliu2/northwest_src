package northwest.common.web.action;

import northwest.common.value.Bill;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:18 CST 2017
*/

public class BillAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Bill bill;
    private Long[] selectedBillIds;

    public BillAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILL");
    }

    public Bill getBill()
    {
        return bill;
    }

    public void setBill(Bill val)
    {
        bill = val;
    }

    public void setGenericManager(BillManager m)
    {
        super.setGenericManager(m);
    }

    public BillManager getGenericManager()
    {
        return (BillManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBill(bill.getId());
        return DELETE;
    }

    public String edit()
    {
        if (bill == null) {
            bill = new Bill();
        } else if (bill.getId() != null) {
            bill = getGenericManager().getBillById(bill.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillIds != null && selectedBillIds.length > 0) {
            Bill obj = getGenericManager().getBillById(selectedBillIds[0]);
            obj.setId(null);
            bill = obj;
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
            if (inputValidation(bill) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Bill val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBill(bill);
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
        bill.setCustomer(getGenericManager().getCustomerById(bill.getCustomerId())); 
        log.info("exit formToBean()");
    }
    public List<Customer> getCustomerList()
    {
        return getGenericManager().getCustomerList(); // TODO
    }

    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList();
    }

    public void setSelectedBillIds(Long[] val)
    {
        selectedBillIds = val;
    }

    public Long[] getSelectedBillIds()
    {
        return selectedBillIds;
    }
}
