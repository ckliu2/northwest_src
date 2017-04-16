package northwest.common.web.action;

import northwest.common.value.StandardCost;
import northwest.common.service.StandardCostManager;
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

public class StandardCostAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private StandardCost standardCost;
    private Long[] selectedStandardCostIds;

    public StandardCostAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.StandardCostAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("STANDARDCOST");
    }

    public StandardCost getStandardCost()
    {
        return standardCost;
    }

    public void setStandardCost(StandardCost val)
    {
        standardCost = val;
    }

    public void setGenericManager(StandardCostManager m)
    {
        super.setGenericManager(m);
    }

    public StandardCostManager getGenericManager()
    {
        return (StandardCostManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeStandardCost(standardCost.getId());
        return DELETE;
    }

    public String edit()
    {
        if (standardCost == null) {
            standardCost = new StandardCost();
        } else if (standardCost.getId() != null) {
            standardCost = getGenericManager().getStandardCostById(standardCost.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedStandardCostIds != null && selectedStandardCostIds.length > 0) {
            StandardCost obj = getGenericManager().getStandardCostById(selectedStandardCostIds[0]);
            obj.setId(null);
            standardCost = obj;
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
            if (inputValidation(standardCost) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(StandardCost val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveStandardCost(standardCost);
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
        standardCost.setProduct(getGenericManager().getProductById(standardCost.getProductId())); 
        log.info("exit formToBean()");
    }
    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<StandardCost> getStandardCostList()
    {
        return getGenericManager().getStandardCostList();
    }

    public void setSelectedStandardCostIds(Long[] val)
    {
        selectedStandardCostIds = val;
    }

    public Long[] getSelectedStandardCostIds()
    {
        return selectedStandardCostIds;
    }
}
