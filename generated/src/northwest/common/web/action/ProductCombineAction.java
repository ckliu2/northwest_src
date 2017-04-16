package northwest.common.web.action;

import northwest.common.value.ProductCombine;
import northwest.common.service.ProductCombineManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:18 CST 2017
*/

public class ProductCombineAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProductCombine productCombine;
    private Long[] selectedProductCombineIds;

    public ProductCombineAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProductCombineAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRODUCTCOMBINE");
    }

    public ProductCombine getProductCombine()
    {
        return productCombine;
    }

    public void setProductCombine(ProductCombine val)
    {
        productCombine = val;
    }

    public void setGenericManager(ProductCombineManager m)
    {
        super.setGenericManager(m);
    }

    public ProductCombineManager getGenericManager()
    {
        return (ProductCombineManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProductCombine(productCombine.getId());
        return DELETE;
    }

    public String edit()
    {
        if (productCombine == null) {
            productCombine = new ProductCombine();
        } else if (productCombine.getId() != null) {
            productCombine = getGenericManager().getProductCombineById(productCombine.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProductCombineIds != null && selectedProductCombineIds.length > 0) {
            ProductCombine obj = getGenericManager().getProductCombineById(selectedProductCombineIds[0]);
            obj.setId(null);
            productCombine = obj;
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
            if (inputValidation(productCombine) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProductCombine val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProductCombine(productCombine);
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
        productCombine.setProduct(getGenericManager().getProductById(productCombine.getProductId())); 
        log.info("exit formToBean()");
    }
    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<ProductCombine> getProductCombineList()
    {
        return getGenericManager().getProductCombineList();
    }

    public void setSelectedProductCombineIds(Long[] val)
    {
        selectedProductCombineIds = val;
    }

    public Long[] getSelectedProductCombineIds()
    {
        return selectedProductCombineIds;
    }
}
