package northwest.common.web.action;

import northwest.common.value.CustomerStandardCost;
import northwest.common.service.CustomerStandardCostManager;
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

public class CustomerStandardCostAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CustomerStandardCost customerStandardCost;
    private Long[] selectedCustomerStandardCostIds;

    public CustomerStandardCostAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.CustomerStandardCostAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CUSTOMERSTANDARDCOST");
    }

    public CustomerStandardCost getCustomerStandardCost()
    {
        return customerStandardCost;
    }

    public void setCustomerStandardCost(CustomerStandardCost val)
    {
        customerStandardCost = val;
    }

    public void setGenericManager(CustomerStandardCostManager m)
    {
        super.setGenericManager(m);
    }

    public CustomerStandardCostManager getGenericManager()
    {
        return (CustomerStandardCostManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCustomerStandardCost(customerStandardCost.getId());
        return DELETE;
    }

    public String edit()
    {
        if (customerStandardCost == null) {
            customerStandardCost = new CustomerStandardCost();
        } else if (customerStandardCost.getId() != null) {
            customerStandardCost = getGenericManager().getCustomerStandardCostById(customerStandardCost.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCustomerStandardCostIds != null && selectedCustomerStandardCostIds.length > 0) {
            CustomerStandardCost obj = getGenericManager().getCustomerStandardCostById(selectedCustomerStandardCostIds[0]);
            obj.setId(null);
            customerStandardCost = obj;
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
            if (inputValidation(customerStandardCost) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(CustomerStandardCost val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCustomerStandardCost(customerStandardCost);
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
        customerStandardCost.setCustomer(getGenericManager().getCustomerById(customerStandardCost.getCustomerId())); 
        customerStandardCost.setProduct(getGenericManager().getProductById(customerStandardCost.getProductId())); 
        log.info("exit formToBean()");
    }
    public List<Customer> getCustomerList()
    {
        return getGenericManager().getCustomerList(); // TODO
    }

    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<CustomerStandardCost> getCustomerStandardCostList()
    {
        return getGenericManager().getCustomerStandardCostList();
    }

    public void setSelectedCustomerStandardCostIds(Long[] val)
    {
        selectedCustomerStandardCostIds = val;
    }

    public Long[] getSelectedCustomerStandardCostIds()
    {
        return selectedCustomerStandardCostIds;
    }
}
