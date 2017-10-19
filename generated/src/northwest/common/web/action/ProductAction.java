package northwest.common.web.action;

import northwest.common.value.Product;
import northwest.common.service.ProductManager;
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

public class ProductAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Product product;
    private Long[] combineIds;
    private Long[] selectedProductIds;

    public ProductAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProductAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRODUCT");
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product val)
    {
        product = val;
    }

    public void setGenericManager(ProductManager m)
    {
        super.setGenericManager(m);
    }

    public ProductManager getGenericManager()
    {
        return (ProductManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProduct(product.getId());
        return DELETE;
    }

    public String edit()
    {
        if (product == null) {
            product = new Product();
        } else if (product.getId() != null) {
            product = getGenericManager().getProductById(product.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProductIds != null && selectedProductIds.length > 0) {
            Product obj = getGenericManager().getProductById(selectedProductIds[0]);
            obj.setId(null);
            product = obj;
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
            if (inputValidation(product) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Product val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProduct(product);
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
        product.setProductClass(getGenericManager().getProductClassById(product.getProductClassId())); 
        product.setProductUnit(getGenericManager().getProductUnitById(product.getProductUnitId())); 
        log.info("exit formToBean()");
    }
    public List<ProductClass> getProductClassList()
    {
        return getGenericManager().getProductClassList(); // TODO
    }

    public List<ProductUnit> getProductUnitList()
    {
        return getGenericManager().getProductUnitList(); // TODO
    }

    public void setCombineIds(Long[] val)
    {
        combineIds = val;
    }

    public Long[] getCombineIds()
    {
        return combineIds;
    }

    public List<Product> getProductList()
    {
        return getGenericManager().getProductList();
    }

    public void setSelectedProductIds(Long[] val)
    {
        selectedProductIds = val;
    }

    public Long[] getSelectedProductIds()
    {
        return selectedProductIds;
    }
}
