package northwest.common.web.action;

import northwest.common.value.LogisticsCode;
import northwest.common.service.LogisticsCodeManager;
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

public class LogisticsCodeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private LogisticsCode logisticsCode;
    private Long[] selectedLogisticsCodeIds;

    public LogisticsCodeAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.LogisticsCodeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("LOGISTICSCODE");
    }

    public LogisticsCode getLogisticsCode()
    {
        return logisticsCode;
    }

    public void setLogisticsCode(LogisticsCode val)
    {
        logisticsCode = val;
    }

    public void setGenericManager(LogisticsCodeManager m)
    {
        super.setGenericManager(m);
    }

    public LogisticsCodeManager getGenericManager()
    {
        return (LogisticsCodeManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeLogisticsCode(logisticsCode.getId());
        return DELETE;
    }

    public String edit()
    {
        if (logisticsCode == null) {
            logisticsCode = new LogisticsCode();
        } else if (logisticsCode.getId() != null) {
            logisticsCode = getGenericManager().getLogisticsCodeById(logisticsCode.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedLogisticsCodeIds != null && selectedLogisticsCodeIds.length > 0) {
            LogisticsCode obj = getGenericManager().getLogisticsCodeById(selectedLogisticsCodeIds[0]);
            obj.setId(null);
            logisticsCode = obj;
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
            if (inputValidation(logisticsCode) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(LogisticsCode val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveLogisticsCode(logisticsCode);
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
        logisticsCode.setLogistics(getGenericManager().getLogisticsById(logisticsCode.getLogisticsId())); 
        log.info("exit formToBean()");
    }
    public List<Logistics> getLogisticsList()
    {
        return getGenericManager().getLogisticsList(); // TODO
    }

    public List<LogisticsCode> getLogisticsCodeList()
    {
        return getGenericManager().getLogisticsCodeList();
    }

    public void setSelectedLogisticsCodeIds(Long[] val)
    {
        selectedLogisticsCodeIds = val;
    }

    public Long[] getSelectedLogisticsCodeIds()
    {
        return selectedLogisticsCodeIds;
    }
}
