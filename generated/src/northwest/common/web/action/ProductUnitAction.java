package northwest.common.web.action;

import northwest.common.value.ProductUnit;
import northwest.common.service.ProductUnitManager;
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

public class ProductUnitAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProductUnit productUnit;
    private Long[] selectedProductUnitIds;

    public ProductUnitAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProductUnitAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRODUCTUNIT");
    }

    public ProductUnit getProductUnit()
    {
        return productUnit;
    }

    public void setProductUnit(ProductUnit val)
    {
        productUnit = val;
    }

    public void setGenericManager(ProductUnitManager m)
    {
        super.setGenericManager(m);
    }

    public ProductUnitManager getGenericManager()
    {
        return (ProductUnitManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProductUnit(productUnit.getId());
        return DELETE;
    }

    public String edit()
    {
        if (productUnit == null) {
            productUnit = new ProductUnit();
        } else if (productUnit.getId() != null) {
            productUnit = getGenericManager().getProductUnitById(productUnit.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProductUnitIds != null && selectedProductUnitIds.length > 0) {
            ProductUnit obj = getGenericManager().getProductUnitById(selectedProductUnitIds[0]);
            obj.setId(null);
            productUnit = obj;
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
            if (inputValidation(productUnit) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProductUnit val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProductUnit(productUnit);
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
    public List<ProductUnit> getProductUnitList()
    {
        return getGenericManager().getProductUnitList();
    }

    public void setSelectedProductUnitIds(Long[] val)
    {
        selectedProductUnitIds = val;
    }

    public Long[] getSelectedProductUnitIds()
    {
        return selectedProductUnitIds;
    }
}
