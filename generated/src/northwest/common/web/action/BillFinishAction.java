package northwest.common.web.action;

import northwest.common.value.BillFinish;
import northwest.common.service.BillFinishManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class BillFinishAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillFinish billFinish;
    private Long[] selectedBillFinishIds;

    public BillFinishAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillFinishAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLFINISH");
    }

    public BillFinish getBillFinish()
    {
        return billFinish;
    }

    public void setBillFinish(BillFinish val)
    {
        billFinish = val;
    }

    public void setGenericManager(BillFinishManager m)
    {
        super.setGenericManager(m);
    }

    public BillFinishManager getGenericManager()
    {
        return (BillFinishManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillFinish(billFinish.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billFinish == null) {
            billFinish = new BillFinish();
        } else if (billFinish.getId() != null) {
            billFinish = getGenericManager().getBillFinishById(billFinish.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillFinishIds != null && selectedBillFinishIds.length > 0) {
            BillFinish obj = getGenericManager().getBillFinishById(selectedBillFinishIds[0]);
            obj.setId(null);
            billFinish = obj;
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
            if (inputValidation(billFinish) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillFinish val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillFinish(billFinish);
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
        billFinish.setBill(getGenericManager().getBillById(billFinish.getBillId())); 
        log.info("exit formToBean()");
    }
    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<BillFinish> getBillFinishList()
    {
        return getGenericManager().getBillFinishList();
    }

    public void setSelectedBillFinishIds(Long[] val)
    {
        selectedBillFinishIds = val;
    }

    public Long[] getSelectedBillFinishIds()
    {
        return selectedBillFinishIds;
    }
}
