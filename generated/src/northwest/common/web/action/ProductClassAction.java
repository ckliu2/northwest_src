package northwest.common.web.action;

import northwest.common.value.ProductClass;
import northwest.common.service.ProductClassManager;
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

public class ProductClassAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProductClass productClass;
    private Long[] expectionFlowsIds;
    private Long[] selectedProductClassIds;

    public ProductClassAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProductClassAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRODUCTCLASS");
    }

    public ProductClass getProductClass()
    {
        return productClass;
    }

    public void setProductClass(ProductClass val)
    {
        productClass = val;
    }

    public void setGenericManager(ProductClassManager m)
    {
        super.setGenericManager(m);
    }

    public ProductClassManager getGenericManager()
    {
        return (ProductClassManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProductClass(productClass.getId());
        return DELETE;
    }

    public String edit()
    {
        if (productClass == null) {
            productClass = new ProductClass();
        } else if (productClass.getId() != null) {
            productClass = getGenericManager().getProductClassById(productClass.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProductClassIds != null && selectedProductClassIds.length > 0) {
            ProductClass obj = getGenericManager().getProductClassById(selectedProductClassIds[0]);
            obj.setId(null);
            productClass = obj;
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
            if (inputValidation(productClass) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProductClass val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProductClass(productClass);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        expectionFlowsIds = getGenericManager().getIdsFromGroupList(productClass.getExpectionFlows());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        productClass.setExpectionFlows(getGenericManager().getGroupListByIds(expectionFlowsIds)); 
        log.info("exit formToBean()");
    }
    public List<List> getExpectionFlowsList()
    {
        return getGenericManager().getExpectionFlowsList(); // TODO
    }

    public void setExpectionFlowsIds(Long[] val)
    {
        expectionFlowsIds = val;
    }

    public Long[] getExpectionFlowsIds()
    {
        return expectionFlowsIds;
    }

    public List<ProductClass> getProductClassList()
    {
        return getGenericManager().getProductClassList();
    }

    public void setSelectedProductClassIds(Long[] val)
    {
        selectedProductClassIds = val;
    }

    public Long[] getSelectedProductClassIds()
    {
        return selectedProductClassIds;
    }
}
