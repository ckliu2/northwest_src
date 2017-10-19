package northwest.common.web.action;

import northwest.common.value.CustomerScreen;
import northwest.common.service.CustomerScreenManager;
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

public class CustomerScreenAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CustomerScreen customerScreen;
    private Long[] customerScreenFilesIds;
    private Long[] selectedCustomerScreenIds;

    public CustomerScreenAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.CustomerScreenAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CUSTOMERSCREEN");
    }

    public CustomerScreen getCustomerScreen()
    {
        return customerScreen;
    }

    public void setCustomerScreen(CustomerScreen val)
    {
        customerScreen = val;
    }

    public void setGenericManager(CustomerScreenManager m)
    {
        super.setGenericManager(m);
    }

    public CustomerScreenManager getGenericManager()
    {
        return (CustomerScreenManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCustomerScreen(customerScreen.getId());
        return DELETE;
    }

    public String edit()
    {
        if (customerScreen == null) {
            customerScreen = new CustomerScreen();
        } else if (customerScreen.getId() != null) {
            customerScreen = getGenericManager().getCustomerScreenById(customerScreen.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCustomerScreenIds != null && selectedCustomerScreenIds.length > 0) {
            CustomerScreen obj = getGenericManager().getCustomerScreenById(selectedCustomerScreenIds[0]);
            obj.setId(null);
            customerScreen = obj;
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
            if (inputValidation(customerScreen) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(CustomerScreen val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCustomerScreen(customerScreen);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        customerScreenFilesIds = getGenericManager().getIdsFromUploadedFileList(customerScreen.getCustomerScreenFiles());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        customerScreen.setCustomerDetail(getGenericManager().getCustomerDetailById(customerScreen.getCustomerDetailId())); 
        customerScreen.setCustomerScreenFiles(getGenericManager().getUploadedFileListByIds(customerScreenFilesIds)); 
        log.info("exit formToBean()");
    }
    public List<CustomerDetail> getCustomerDetailList()
    {
        return getGenericManager().getCustomerDetailList(); // TODO
    }

    public List<List> getCustomerScreenFilesList()
    {
        return getGenericManager().getCustomerScreenFilesList(); // TODO
    }

    public void setCustomerScreenFilesIds(Long[] val)
    {
        customerScreenFilesIds = val;
    }

    public Long[] getCustomerScreenFilesIds()
    {
        return customerScreenFilesIds;
    }

    public List<CustomerScreen> getCustomerScreenList()
    {
        return getGenericManager().getCustomerScreenList();
    }

    public void setSelectedCustomerScreenIds(Long[] val)
    {
        selectedCustomerScreenIds = val;
    }

    public Long[] getSelectedCustomerScreenIds()
    {
        return selectedCustomerScreenIds;
    }
}
