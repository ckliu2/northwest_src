package northwest.common.web.action;

import northwest.common.value.ProcessState;
import northwest.common.service.ProcessStateManager;
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

public class ProcessStateAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProcessState processState;
    private Long[] selectedProcessStateIds;

    public ProcessStateAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProcessStateAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PROCESSSTATE");
    }

    public ProcessState getProcessState()
    {
        return processState;
    }

    public void setProcessState(ProcessState val)
    {
        processState = val;
    }

    public void setGenericManager(ProcessStateManager m)
    {
        super.setGenericManager(m);
    }

    public ProcessStateManager getGenericManager()
    {
        return (ProcessStateManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProcessState(processState.getId());
        return DELETE;
    }

    public String edit()
    {
        if (processState == null) {
            processState = new ProcessState();
        } else if (processState.getId() != null) {
            processState = getGenericManager().getProcessStateById(processState.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProcessStateIds != null && selectedProcessStateIds.length > 0) {
            ProcessState obj = getGenericManager().getProcessStateById(selectedProcessStateIds[0]);
            obj.setId(null);
            processState = obj;
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
            if (inputValidation(processState) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProcessState val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProcessState(processState);
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
        processState.setBill(getGenericManager().getBillById(processState.getBillId())); 
        log.info("exit formToBean()");
    }
    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<ProcessState> getProcessStateList()
    {
        return getGenericManager().getProcessStateList();
    }

    public void setSelectedProcessStateIds(Long[] val)
    {
        selectedProcessStateIds = val;
    }

    public Long[] getSelectedProcessStateIds()
    {
        return selectedProcessStateIds;
    }
}
