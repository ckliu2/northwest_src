package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 01 18:37:38 CST 2011
*/

public class ProductClassAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProductClass productClass;
    private Long[] expectionFlowsIds;
	private String[] selectedProductClassIds;
	private String[] productIds;
	private String key="";
	private Vector vector=new Vector();
    
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
        
        Set<Group> groups = new HashSet();
        List al=productClass.getExpectionFlows();
        for(int i=0;i<al.size();i++){
        	Group g=(Group)al.get(i);
        	groups.add(g);
        	System.out.println("beanToForm="+g.getGroupName());
        }
        expectionFlowsIds = getGenericManager().getIdsFromGroupList(groups);
        
        
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        
        ArrayList<Group> al = new ArrayList<Group>();
        Set groups=getGenericManager().getGroupListByIds(expectionFlowsIds);       
	    if(groups!=null){
	    	 Iterator i = groups.iterator(); 
	    		 while (i.hasNext()) {
	    			 Group m= (Group) i.next();   	               
	    			 al.add(m);
	    		}
	    }
	    
        productClass.setExpectionFlows(al); 
        log.info("exit formToBean()");
    }
    
    public List<Group> getExpectionFlowsList()
    {
    	
        return getGenericManager().getBillGroupAuthority();
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

    public void setSelectedProductClassIds(String[] val)
    {
        selectedProductClassIds = val;
    }

    public String[] getSelectedProductClassIds()
    {
        return selectedProductClassIds;
    }
    
    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String[] getProductIds() {
		return productIds;
	}

	public void setProductIds(String[] productIds) {
		this.productIds = productIds;
	}

    
    public List<Product> getProductList()
    {
    	ArrayList<Product> al = new ArrayList<Product>();
        return  al;
    }
    
    public List<Product> getObject_ProductList()
    {    
    	ArrayList<Product> al = new ArrayList<Product>();  	
        return  al;
    }
    
    public List<Product> queryProductList(){    
    	return getGenericManager().getProductListByCondition(key,key);
    }
    
    
    public List<Vector> getProductSelect(){
    	ArrayList<Vector> obj = new ArrayList<Vector>();  
    	if(productIds!=null){
    		System.out.println("getProductSelect...productId.length="+productIds.length);
    	    for(int i=0;i<productIds.length;i++){
    	    	String[] s=productIds[i].trim().split("#");
    	    	System.out.println("productIds="+productIds[i].trim()+"--s[0]="+s[0]+"--s[1]="+s[1]+"---s[2]="+s[2]);
    	    	Product product=getGenericManager().getProductById(s[0]);
    	    	vector=new Vector();
    	    	vector.add(s[0]);
    	    	vector.add(s[1]);
    	    	vector.add(s[2]);
    	    	vector.add(product.getProductName());
    	    	obj.add(vector);    	 
    	    }
    	}
    	System.out.println("obj.size()="+obj.size());
    	return obj;
    }
    

    
    
    
    
}
