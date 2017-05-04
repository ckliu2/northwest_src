package northwest.common.web.action;

import northwest.common.value.BillAuthority;
import northwest.common.service.BillAuthorityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:15 CST 2017
*/

public class BillAuthorityAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillAuthority billAuthority;
    private Long[] selectedBillAuthorityIds;

    public BillAuthorityAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillAuthorityAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLAUTHORITY");
    }

    public BillAuthority getBillAuthority()
    {
        return billAuthority;
    }

    public void setBillAuthority(BillAuthority val)
    {
        billAuthority = val;
    }

    public void setGenericManager(BillAuthorityManager m)
    {
        super.setGenericManager(m);
    }

    public BillAuthorityManager getGenericManager()
    {
        return (BillAuthorityManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillAuthority(billAuthority.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billAuthority == null) {
            billAuthority = new BillAuthority();
        } else if (billAuthority.getId() != null) {
            billAuthority = getGenericManager().getBillAuthorityById(billAuthority.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillAuthorityIds != null && selectedBillAuthorityIds.length > 0) {
            BillAuthority obj = getGenericManager().getBillAuthorityById(selectedBillAuthorityIds[0]);
            obj.setId(null);
            billAuthority = obj;
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
            if (inputValidation(billAuthority) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillAuthority val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillAuthority(billAuthority);
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
        billAuthority.setBill(getGenericManager().getBillById(billAuthority.getBillId())); 
        billAuthority.setGroup(getGenericManager().getGroupById(billAuthority.getGroupId())); 
        log.info("exit formToBean()");
    }
    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<Group> getGroupList()
    {
        return getGenericManager().getGroupList(); // TODO
    }

    public List<BillAuthority> getBillAuthorityList()
    {
        return getGenericManager().getBillAuthorityList();
    }

    public void setSelectedBillAuthorityIds(Long[] val)
    {
        selectedBillAuthorityIds = val;
    }

    public Long[] getSelectedBillAuthorityIds()
    {
        return selectedBillAuthorityIds;
    }
}
