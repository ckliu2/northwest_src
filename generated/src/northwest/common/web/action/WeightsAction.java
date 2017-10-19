package northwest.common.web.action;

import northwest.common.value.Weights;
import northwest.common.service.WeightsManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:59 CST 2017
*/

public class WeightsAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Weights weights;
    private Long[] productClassesIds;
    private Long[] selectedWeightsIds;

    public WeightsAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.WeightsAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("WEIGHTS");
    }

    public Weights getWeights()
    {
        return weights;
    }

    public void setWeights(Weights val)
    {
        weights = val;
    }

    public void setGenericManager(WeightsManager m)
    {
        super.setGenericManager(m);
    }

    public WeightsManager getGenericManager()
    {
        return (WeightsManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeWeights(weights.getId());
        return DELETE;
    }

    public String edit()
    {
        if (weights == null) {
            weights = new Weights();
        } else if (weights.getId() != null) {
            weights = getGenericManager().getWeightsById(weights.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedWeightsIds != null && selectedWeightsIds.length > 0) {
            Weights obj = getGenericManager().getWeightsById(selectedWeightsIds[0]);
            obj.setId(null);
            weights = obj;
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
            if (inputValidation(weights) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Weights val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveWeights(weights);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        productClassesIds = getGenericManager().getIdsFromProductClassList(weights.getProductClasses());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        weights.setOutputEquipment(getGenericManager().getOutputEquipmentById(weights.getOutputEquipmentId())); 
        weights.setProductClasses(getGenericManager().getProductClassListByIds(productClassesIds)); 
        log.info("exit formToBean()");
    }
    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericManager().getOutputEquipmentList(); // TODO
    }

    public List<List> getProductClassesList()
    {
        return getGenericManager().getProductClassesList(); // TODO
    }

    public void setProductClassesIds(Long[] val)
    {
        productClassesIds = val;
    }

    public Long[] getProductClassesIds()
    {
        return productClassesIds;
    }

    public List<Weights> getWeightsList()
    {
        return getGenericManager().getWeightsList();
    }

    public void setSelectedWeightsIds(Long[] val)
    {
        selectedWeightsIds = val;
    }

    public Long[] getSelectedWeightsIds()
    {
        return selectedWeightsIds;
    }
}
