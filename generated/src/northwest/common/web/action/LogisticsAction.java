package northwest.common.web.action;

import northwest.common.value.Logistics;
import northwest.common.service.LogisticsManager;
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

public class LogisticsAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Logistics logistics;
    private String serviceDate;
    private Long[] selectedLogisticsIds;

    public LogisticsAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.LogisticsAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("LOGISTICS");
    }

    public Logistics getLogistics()
    {
        return logistics;
    }

    public void setLogistics(Logistics val)
    {
        logistics = val;
    }

    public void setGenericManager(LogisticsManager m)
    {
        super.setGenericManager(m);
    }

    public LogisticsManager getGenericManager()
    {
        return (LogisticsManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeLogistics(logistics.getId());
        return DELETE;
    }

    public String edit()
    {
        if (logistics == null) {
            logistics = new Logistics();
        } else if (logistics.getId() != null) {
            logistics = getGenericManager().getLogisticsById(logistics.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedLogisticsIds != null && selectedLogisticsIds.length > 0) {
            Logistics obj = getGenericManager().getLogisticsById(selectedLogisticsIds[0]);
            obj.setId(null);
            logistics = obj;
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
            if (inputValidation(logistics) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Logistics val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (logistics.getId() == null) {
            logistics.setCreatedDate(ts);
            logistics.setCreatedUser(getSessionUser().getLoginId());
        }
        logistics.setLastModifiedDate(ts);
        logistics.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveLogistics(logistics);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        serviceDate = Tools.dateToString(logistics.getServiceDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        logistics.setServiceDate(Tools.convertToDate(serviceDate)); 
        logistics.setBill(getGenericManager().getBillById(logistics.getBillId())); 
        logistics.setMember(getGenericManager().getMemberById(logistics.getMemberId())); 
        logistics.setTime(getAppPropertyById(logistics.getTimeId())); 
        log.info("exit formToBean()");
    }
    public void setServiceDate(String val)
    {
        serviceDate = val;
    }

    public String getServiceDate()
    {
        return serviceDate;
    }

    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<AppProperty> getTimeList()
    {
        return super.getAppPropertyList("logistics.time");
    }

    public List<Logistics> getLogisticsList()
    {
        return getGenericManager().getLogisticsList();
    }

    public void setSelectedLogisticsIds(Long[] val)
    {
        selectedLogisticsIds = val;
    }

    public Long[] getSelectedLogisticsIds()
    {
        return selectedLogisticsIds;
    }
}
