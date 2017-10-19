package northwest.common.web.action;

import northwest.common.value.Customer;
import northwest.common.service.CustomerManager;
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

public class CustomerAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Customer customer;
    private Long[] selectedCustomerIds;

    public CustomerAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.CustomerAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CUSTOMER");
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer val)
    {
        customer = val;
    }

    public void setGenericManager(CustomerManager m)
    {
        super.setGenericManager(m);
    }

    public CustomerManager getGenericManager()
    {
        return (CustomerManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCustomer(customer.getId());
        return DELETE;
    }

    public String edit()
    {
        if (customer == null) {
            customer = new Customer();
        } else if (customer.getId() != null) {
            customer = getGenericManager().getCustomerById(customer.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCustomerIds != null && selectedCustomerIds.length > 0) {
            Customer obj = getGenericManager().getCustomerById(selectedCustomerIds[0]);
            obj.setId(null);
            customer = obj;
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
            if (inputValidation(customer) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Customer val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCustomer(customer);
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
        customer.setSaleman(getGenericManager().getMemberById(customer.getSalemanId())); 
        log.info("exit formToBean()");
    }
    public List<Member> getSalemanList()
    {
        return getGenericManager().getSalemanList(); // TODO
    }

    public List<Customer> getCustomerList()
    {
        return getGenericManager().getCustomerList();
    }

    public void setSelectedCustomerIds(Long[] val)
    {
        selectedCustomerIds = val;
    }

    public Long[] getSelectedCustomerIds()
    {
        return selectedCustomerIds;
    }
}
