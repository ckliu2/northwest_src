package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

public class CustomerAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Customer customer;
    private String[] selectedCustomerIds;
	private List<CustomerDetail> customerDetails;
	private CustomerDetail customerDetail;
    private java.io.File filePhoto1;
    private String filePhoto1ContentType, filePhoto1FileName, removePhoto1;
    private java.io.File filePhoto2;
    private String filePhoto2ContentType, filePhoto2FileName, removePhoto2;
    private java.io.File filePhoto3;
    private String filePhoto3ContentType, filePhoto3FileName, removePhoto3;
    private java.io.File filePhoto4;
    private String filePhoto4ContentType, filePhoto4FileName, removePhoto4;
    private java.io.File filePhoto5;
    private String filePhoto5ContentType, filePhoto5FileName, removePhoto5;    
    private java.io.File filePlanmap;
    private String filePlanmapContentType, filePlanmapFileName, removePlanmap;
	String keyword="";
	
    public CustomerAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.CustomerAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CUSTOMER");
    }
    
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}    

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer val)
    {
        customer = val;
    }

    public void setGenericManager(BillManager m)
    {
        super.setGenericManager(m);
    }

    public BillManager getGenericManager()
    {
        return (BillManager) super.getGenericManager();
    }


    public String edit()
    {
        if (customer == null) {
            customer = new Customer();
        } else if (customer.getId() != null) {
            customer = getGenericManager().getCustomerById(customer.getId());
            
           if (customerDetail == null) {
            	customerDetail=new CustomerDetail();
            }else{
                customerDetail=getGenericManager().getCustomerDetailById(customerDetail.getId());
            }
            System.out.println("edit() customerDetail="+customerDetail);
            
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String delete()
    {    	
    	customer=getGenericManager().getCustomerDetailById(customerDetail.getId()).getCustomer();
    	appendXworkParam("customer.id="+customer.getId());    	
    	System.out.println("delete() customerDetail.getId()="+customerDetail.getId()+"---customer.getId()="+customer.getId());   	
    	getGenericManager().removeCustomerDetail(customerDetail.getId());    	    	        
        return DELETE;
    }

    public String execute()
    {
    	if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            return SUCCESS;
        }
        
    }

    public boolean inputValidation(Customer val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCustomerDetail(customerDetail);
        //CustomerDetail c=getGenericManager().getCustomerDetailLastByCustomerNo(customer);
         if(customerDetail.getId()==null){
        	 customerDetail=getGenericManager().getCustomerDetailLastByCustomerNo(customer);
         }
        
          saveFileToLocal(filePhoto1FileName, filePhoto1, getTextWithArgs("customerDetail.uploadPhoto1.dir"), customerDetail.getId());
          saveFileToLocal(filePhoto2FileName, filePhoto2, getTextWithArgs("customerDetail.uploadPhoto2.dir"), customerDetail.getId());
          saveFileToLocal(filePhoto3FileName, filePhoto3, getTextWithArgs("customerDetail.uploadPhoto3.dir"), customerDetail.getId());
          saveFileToLocal(filePhoto4FileName, filePhoto4, getTextWithArgs("customerDetail.uploadPhoto4.dir"), customerDetail.getId());
          saveFileToLocal(filePhoto5FileName, filePhoto5, getTextWithArgs("customerDetail.uploadPhoto5.dir"), customerDetail.getId());
          saveFileToLocal(filePlanmapFileName, filePlanmap, getTextWithArgs("customerDetail.uploadPlanmap.dir"), customerDetail.getId());
          
          
          /***套用所有的客服人員*/
           try{
        	  List<CustomerDetail> ls=getGenericManager().getCustomerDetailListByCustomerNo(customerDetail.getCustomer());
        	   for(int i=0;i<ls.size();i++){
        		   CustomerDetail c=(CustomerDetail)ls.get(i);
        		   c.setCustomerService(customerDetail.getCustomerService());
        		   getGenericManager().saveCustomerDetail(c);
        	   }
           }catch(Exception e){
        	   System.out.println(e.toString());
           }
          
          /***套用所有的客服人員*/
          
          appendXworkParam("customer.id="+customerDetail.getCustomerId());   
          
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
    	if (getRemovePhoto1() != null && getRemovePhoto1().length() > 0) {
            customerDetail.setPhoto1(computeUploadedFile(filePhoto1FileName, filePhoto1)); 
            removeUploadedFile(getTextWithArgs("customerDetail.uploadPhoto1.dir"), customerDetail.getPhoto1Id(), customerDetail.getPhoto1FileName());
        } else {
            if (customerDetail.getPhoto1Id() != null)
                customerDetail.setPhoto1(getGenericManager().getUploadedFileById(customerDetail.getPhoto1Id())); 
            else
                customerDetail.setPhoto1(computeUploadedFile(filePhoto1FileName, filePhoto1)); 
        }
        if (getRemovePhoto2() != null && getRemovePhoto2().length() > 0) {
            customerDetail.setPhoto2(computeUploadedFile(filePhoto2FileName, filePhoto2)); 
            removeUploadedFile(getTextWithArgs("customerDetail.uploadPhoto2.dir"), customerDetail.getPhoto2Id(), customerDetail.getPhoto2FileName());
        } else {
            if (customerDetail.getPhoto2Id() != null)
                customerDetail.setPhoto2(getGenericManager().getUploadedFileById(customerDetail.getPhoto2Id())); 
            else
                customerDetail.setPhoto2(computeUploadedFile(filePhoto2FileName, filePhoto2)); 
        }
        if (getRemovePhoto3() != null && getRemovePhoto3().length() > 0) {
            customerDetail.setPhoto3(computeUploadedFile(filePhoto3FileName, filePhoto3)); 
            removeUploadedFile(getTextWithArgs("customerDetail.uploadPhoto3.dir"), customerDetail.getPhoto3Id(), customerDetail.getPhoto3FileName());
        } else {
            if (customerDetail.getPhoto3Id() != null)
                customerDetail.setPhoto3(getGenericManager().getUploadedFileById(customerDetail.getPhoto3Id())); 
            else
                customerDetail.setPhoto3(computeUploadedFile(filePhoto3FileName, filePhoto3)); 
        }
        if (getRemovePhoto4() != null && getRemovePhoto4().length() > 0) {
            customerDetail.setPhoto4(computeUploadedFile(filePhoto4FileName, filePhoto4)); 
            removeUploadedFile(getTextWithArgs("customerDetail.uploadPhoto4.dir"), customerDetail.getPhoto4Id(), customerDetail.getPhoto4FileName());
        } else {
            if (customerDetail.getPhoto4Id() != null)
                customerDetail.setPhoto4(getGenericManager().getUploadedFileById(customerDetail.getPhoto4Id())); 
            else
                customerDetail.setPhoto4(computeUploadedFile(filePhoto4FileName, filePhoto4)); 
        }
        if (getRemovePhoto5() != null && getRemovePhoto5().length() > 0) {
            customerDetail.setPhoto5(computeUploadedFile(filePhoto5FileName, filePhoto5)); 
            removeUploadedFile(getTextWithArgs("customerDetail.uploadPhoto5.dir"), customerDetail.getPhoto5Id(), customerDetail.getPhoto5FileName());
        } else {
            if (customerDetail.getPhoto5Id() != null)
                customerDetail.setPhoto5(getGenericManager().getUploadedFileById(customerDetail.getPhoto5Id())); 
            else
                customerDetail.setPhoto5(computeUploadedFile(filePhoto5FileName, filePhoto5)); 
        }
        
        if (getRemovePlanmap() != null && getRemovePlanmap().length() > 0) {
            customerDetail.setPlanmap(computeUploadedFile(filePlanmapFileName, filePlanmap)); 
            removeUploadedFile(getTextWithArgs("customerDetail.uploadPlanmap.dir"), customerDetail.getPlanmapId(), customerDetail.getPlanmapFileName());
        } else {
            if (customerDetail.getPlanmapId() != null)
                customerDetail.setPlanmap(getGenericManager().getUploadedFileById(customerDetail.getPlanmapId())); 
            else
                customerDetail.setPlanmap(computeUploadedFile(filePlanmapFileName, filePlanmap)); 
        }     
    	customerDetail.setCustomer(customer);
    	customerDetail.setCustomerService(getGenericManager().getMemberById(customerDetail.getCustomerServiceId())); 
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

    public void setFilePhoto2(java.io.File val)
    {
        filePhoto2 = val;
    }

    public java.io.File getFilePhoto2()
    {
        return filePhoto2;
    }

    public void setFilePhoto2ContentType(String val)
    {
        filePhoto2ContentType = val;
    }

    public String getFilePhoto2ContentType()
    {
        return filePhoto2ContentType;
    }

    public void setFilePhoto2FileName(String val)
    {
        filePhoto2FileName = val;
    }

    public String getFilePhoto2FileName()
    {
        return filePhoto2FileName;
    }

    public void setRemovePhoto2(String val)
    {
        removePhoto2 = val;
    }

    public String getRemovePhoto2()
    {
        return removePhoto2;
    }

    public void setFilePhoto3(java.io.File val)
    {
        filePhoto3 = val;
    }

    public java.io.File getFilePhoto3()
    {
        return filePhoto3;
    }

    public void setFilePhoto3ContentType(String val)
    {
        filePhoto3ContentType = val;
    }

    public String getFilePhoto3ContentType()
    {
        return filePhoto3ContentType;
    }

    public void setFilePhoto3FileName(String val)
    {
        filePhoto3FileName = val;
    }

    public String getFilePhoto3FileName()
    {
        return filePhoto3FileName;
    }

    public void setRemovePhoto3(String val)
    {
        removePhoto3 = val;
    }

    public String getRemovePhoto3()
    {
        return removePhoto3;
    }

    public void setFilePhoto4(java.io.File val)
    {
        filePhoto4 = val;
    }

    public java.io.File getFilePhoto4()
    {
        return filePhoto4;
    }

    public void setFilePhoto4ContentType(String val)
    {
        filePhoto4ContentType = val;
    }

    public String getFilePhoto4ContentType()
    {
        return filePhoto4ContentType;
    }

    public void setFilePhoto4FileName(String val)
    {
        filePhoto4FileName = val;
    }

    public String getFilePhoto4FileName()
    {
        return filePhoto4FileName;
    }

    public void setRemovePhoto4(String val)
    {
        removePhoto4 = val;
    }

    public String getRemovePhoto4()
    {
        return removePhoto4;
    }

    public void setFilePhoto5(java.io.File val)
    {
        filePhoto5 = val;
    }

    public java.io.File getFilePhoto5()
    {
        return filePhoto5;
    }

    public void setFilePhoto5ContentType(String val)
    {
        filePhoto5ContentType = val;
    }

    public String getFilePhoto5ContentType()
    {
        return filePhoto5ContentType;
    }

    public void setFilePhoto5FileName(String val)
    {
        filePhoto5FileName = val;
    }

    public String getFilePhoto5FileName()
    {
        return filePhoto5FileName;
    }

    public void setRemovePhoto5(String val)
    {
        removePhoto5 = val;
    }

    public String getRemovePhoto5()
    {
        return removePhoto5;
    }

 
    public void setFilePlanmap(java.io.File val)
    {
        filePlanmap = val;
    }

    public java.io.File getFilePlanmap()
    {
        return filePlanmap;
    }

    public void setFilePlanmapContentType(String val)
    {
        filePlanmapContentType = val;
    }

    public String getFilePlanmapContentType()
    {
        return filePlanmapContentType;
    }

    public void setFilePlanmapFileName(String val)
    {
        filePlanmapFileName = val;
    }

    public String getFilePlanmapFileName()
    {
        return filePlanmapFileName;
    }

    public void setRemovePlanmap(String val)
    {
        removePlanmap = val;
    }

    public String getRemovePlanmap()
    {
        return removePlanmap;
    }

    public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
 
    
    public List<Customer> getCustomerList()
    {
    	if(!keyword.equals("")){
     	   System.out.println("keyword="+keyword);	
     	   return getGenericManager().getCustomerByKeyWord(keyword);
     	}else{
     		return getGenericManager().getCustomerList();
     	}
    }
    
    public List<Customer> queryCustomerList()
    {    
       return getGenericManager().getCustomerByKeyWord(keyword);
    }

    public void setSelectedCustomerIds(String[] val)
    {
        selectedCustomerIds = val;
    }

    public String[] getSelectedCustomerIds()
    {
        return selectedCustomerIds;
    }    
    
    public List<Member> getMemberList(){    
    	return getGenericManager().getMemberList();	
    }
    
	public List<CustomerDetail> getCustomerDetails() {
		
		if(!keyword.equals("")){
			return getGenericManager().getCustomerDetailListByCustomerByQuery(customer,keyword);
		}else{
			return getGenericManager().getCustomerDetailListByCustomerNo(customer);
		}
		//return getGenericManager().getCustomerDetailListByCustomerNo(customer);
	}

	public void setCustomerDetails(List<CustomerDetail> customerDetails) {
		this.customerDetails = customerDetails;
	}
    
}
