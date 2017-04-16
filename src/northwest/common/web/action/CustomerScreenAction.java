package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;


/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Sep 28 23:21:55 CST 2011
*/

public class CustomerScreenAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CustomerScreen customerScreen;
	private CustomerDetail customerdetail;
    private Long[] customerScreenFilesIds;
    private Long[] selectedCustomerScreenIds;
    private java.io.File filePhoto1;
    private String filePhoto1ContentType, filePhoto1FileName, removePhoto1;

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

    public void setGenericManager(BillManager m)
    {
        super.setGenericManager(m);
    }

    public BillManager getGenericManager()
    {
        return (BillManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCustomerScreen(customerScreen.getId());
        appendXworkParam("customerdetail.id="+customerdetail.getId());
        System.out.println("customerdetail.id="+customerdetail.getId());
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
        //saveFileToLocal(filePhoto1FileName, filePhoto1, getTextWithArgs("customerScreen.customerScreen.dir"), customerScreen.getId());
        
        return SUCCESS;
    }

    public String list()
    {
        System.out.println("screenAction list()");
    	return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        //customerScreenFilesIds = getGenericManager().getIdsFromUploadedFileList(customerScreen.getCustomerScreenFiles());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        customerScreen.setCustomerDetail(getGenericManager().getCustomerDetailById(customerScreen.getCustomerDetailId())); 
        ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
        if(customerScreen.getId()!=null){
           if(customerScreenFilesIds!=null){	
            for(int i=0;i<customerScreenFilesIds.length;i++){
            	System.out.println("customerScreenFilesIds="+customerScreenFilesIds[i]);
            	UploadedFile obj=getGenericManager().getUploadedFileById(customerScreenFilesIds[i]);
            	al.add(obj);
            }
           } 
            if(filePhoto1!=null){
            saveFileToLocal(filePhoto1FileName, filePhoto1, getTextWithArgs("customerScreen.customerScreen.dir"), customerScreen.getId());
        	UploadedFile u=computeUploadedFile(filePhoto1FileName, filePhoto1);
        	getGenericManager().saveUploadedFile(u);
        	al.add(u);
            }
            customerScreen.setCustomerScreenFiles(al);
        }
    }
    public List<CustomerDetail> getCustomerDetailList()
    {
        return getGenericManager().getCustomerDetailList(); // TODO
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
    	CustomerDetail c=getGenericManager().getCustomerDetailById(customerdetail.getId());
        return getGenericManager().getCustomerScreenListByCustomerDetail(c);
    }

    public void setSelectedCustomerScreenIds(Long[] val)
    {
        selectedCustomerScreenIds = val;
    }

    public Long[] getSelectedCustomerScreenIds()
    {
        return selectedCustomerScreenIds;
    }
    
    public CustomerDetail getCustomerdetail() {
		return customerdetail;
	}

	public void setCustomerdetail(CustomerDetail customerdetail) {
		this.customerdetail = customerdetail;
	}
	
    public void setFilePhoto1(java.io.File val)
    {
        filePhoto1 = val;
    }

    public java.io.File getFilePhoto1()
    {
        return filePhoto1;
    }

    public void setFilePhoto1ContentType(String val)
    {
        filePhoto1ContentType = val;
    }

    public String getFilePhoto1ContentType()
    {
        return filePhoto1ContentType;
    }

    public void setFilePhoto1FileName(String val)
    {
        filePhoto1FileName = val;
    }

    public String getFilePhoto1FileName()
    {
        return filePhoto1FileName;
    }

    public void setRemovePhoto1(String val)
    {
        removePhoto1 = val;
    }

    public String getRemovePhoto1()
    {
        return removePhoto1;
    }
   
    public List getCustomerScreenFilesList()
    {
    	return customerScreen.getCustomerScreenFiles();
    	/*
    	List<CustomerScreen> al = new ArrayList<CustomerScreen>();
    	List a=customerScreen.getCustomerScreenFiles();
    	
    	if(a.size()==0){
    		System.out.println("a.size()==0");
    		return al;
    	}else{
    		return customerScreen.getCustomerScreenFiles();
    	}
       */
    }
    


}
