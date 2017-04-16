package northwest.common.web.action;

import northwest.common.value.BillQA;
import northwest.common.service.BillQAManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class BillQAAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillQA billQA;
    private Long[] notificationsIds;
    private Long[] selectedBillQAIds;

    public BillQAAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillQAAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLQA");
    }

    public BillQA getBillQA()
    {
        return billQA;
    }

    public void setBillQA(BillQA val)
    {
        billQA = val;
    }

    public void setGenericManager(BillQAManager m)
    {
        super.setGenericManager(m);
    }

    public BillQAManager getGenericManager()
    {
        return (BillQAManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillQA(billQA.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billQA == null) {
            billQA = new BillQA();
        } else if (billQA.getId() != null) {
            billQA = getGenericManager().getBillQAById(billQA.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillQAIds != null && selectedBillQAIds.length > 0) {
            BillQA obj = getGenericManager().getBillQAById(selectedBillQAIds[0]);
            obj.setId(null);
            billQA = obj;
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
            if (inputValidation(billQA) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillQA val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (billQA.getId() == null) {
            billQA.setCreatedDate(ts);
            billQA.setCreatedUser(getSessionUser().getLoginId());
        }
        billQA.setLastModifiedDate(ts);
        billQA.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveBillQA(billQA);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        notificationsIds = getGenericManager().getIdsFromMemberList(billQA.getNotifications());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        billQA.setBill(getGenericManager().getBillById(billQA.getBillId())); 
        billQA.setMember(getGenericManager().getMemberById(billQA.getMemberId())); 
        billQA.setNotifications(getGenericManager().getMemberListByIds(notificationsIds)); 
        log.info("exit formToBean()");
    }
    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<Member> getNotificationsList()
    {
        List<Member> al = getGenericManager().getMemberList();
        if (al != null) {
            if (billQA.getNotifications() != null)
                al.removeAll(billQA.getNotifications());
            return al;
        }
        return new ArrayList<Member>();
    }

    public List<Member> getObject_notificationsList()
    {
        return (billQA.getNotifications() == null) ? new ArrayList<Member>() : billQA.getNotifications();
    }

    public void setNotificationsIds(Long[] val)
    {
        notificationsIds = val;
    }

    public Long[] getNotificationsIds()
    {
        return notificationsIds;
    }

    public List<BillQA> getBillQAList()
    {
        return getGenericManager().getBillQAList();
    }

    public void setSelectedBillQAIds(Long[] val)
    {
        selectedBillQAIds = val;
    }

    public Long[] getSelectedBillQAIds()
    {
        return selectedBillQAIds;
    }
}
