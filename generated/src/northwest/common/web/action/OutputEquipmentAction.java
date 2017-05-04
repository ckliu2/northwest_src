package northwest.common.web.action;

import northwest.common.value.OutputEquipment;
import northwest.common.service.OutputEquipmentManager;
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

public class OutputEquipmentAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private OutputEquipment outputEquipment;
    private Long[] selectedOutputEquipmentIds;

    public OutputEquipmentAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.OutputEquipmentAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("OUTPUTEQUIPMENT");
    }

    public OutputEquipment getOutputEquipment()
    {
        return outputEquipment;
    }

    public void setOutputEquipment(OutputEquipment val)
    {
        outputEquipment = val;
    }

    public void setGenericManager(OutputEquipmentManager m)
    {
        super.setGenericManager(m);
    }

    public OutputEquipmentManager getGenericManager()
    {
        return (OutputEquipmentManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeOutputEquipment(outputEquipment.getId());
        return DELETE;
    }

    public String edit()
    {
        if (outputEquipment == null) {
            outputEquipment = new OutputEquipment();
        } else if (outputEquipment.getId() != null) {
            outputEquipment = getGenericManager().getOutputEquipmentById(outputEquipment.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedOutputEquipmentIds != null && selectedOutputEquipmentIds.length > 0) {
            OutputEquipment obj = getGenericManager().getOutputEquipmentById(selectedOutputEquipmentIds[0]);
            obj.setId(null);
            outputEquipment = obj;
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
            if (inputValidation(outputEquipment) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(OutputEquipment val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveOutputEquipment(outputEquipment);
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
        log.info("exit formToBean()");
    }
    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericManager().getOutputEquipmentList();
    }

    public void setSelectedOutputEquipmentIds(Long[] val)
    {
        selectedOutputEquipmentIds = val;
    }

    public Long[] getSelectedOutputEquipmentIds()
    {
        return selectedOutputEquipmentIds;
    }
}
