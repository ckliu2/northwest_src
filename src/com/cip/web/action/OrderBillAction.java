package com.cip.web.action;

import com.cip.value.*;
import com.cip.service.OrderBillManager;

import northwest.common.value.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.*;

import java.util.*;

import com.common.value.ComparatorMember;
import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.Group;

public class OrderBillAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private OrderBill orderBill;    
    Project project;
    OrdBillSub ordBillSub;
    Long[] selectedOrderBillIds;
    String billNo,productNo;

    public OrderBillAction()
    {
        log = LogFactory.getLog(com.cip.web.action.OrderBillAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("ORDERBILL");
    }

    public OrderBill getOrderBill()
    {
        return orderBill;
    }

    public void setOrderBill(OrderBill val)
    {
        orderBill = val;
    }

    public void setGenericManager(OrderBillManager m)
    {
        super.setGenericManager(m);
    }

    public OrderBillManager getGenericManager()
    {
        return (OrderBillManager) super.getGenericManager();
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public OrdBillSub getOrdBillSub() {
        return ordBillSub;
    }

    public void setOrdBillSub(OrdBillSub ordBillSub) {
        this.ordBillSub = ordBillSub;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
    
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    
    public String edit()
    {	
	//orderBill
	if (orderBill == null) {
	    orderBill = new OrderBill();
        } else if (orderBill.getId() != null) {
            orderBill=getGenericManager().getOrderBillById(orderBill.getId());
        } else { // TODO
        }
	
	//orderBillSub
	if (ordBillSub == null) {
	    ordBillSub = new OrdBillSub();
        } else if (ordBillSub.getId() != null) {
            ordBillSub=getGenericManager().getOrdBillSubById(ordBillSub.getId());
        } else { // TODO
        }
	

        return SUCCESS;
    }
    
    public String delete()
    {
        getGenericManager().removeOrdBillSub(ordBillSub.getId());
        System.out.println("delete ordBillSub.getId()="+ordBillSub.getId());
        appendXworkParam("orderBill.id="+orderBill.getId());
        return SUCCESS;
    }

     public String execute()
    {	 
	   formToBean();
             if (inputValidation(orderBill) == false) 
             return INPUT;	 
        return SUCCESS;
    }

    public boolean inputValidation(OrderBill val)
    {
        return true;
    }

    public String save()
    {
	Project pr=getGenericManager().getProjectById(project.getId());
	if(pr==null){	       
	    pr=new Project();
	    pr.setId(project.getId());  //project.getId()
	    pr.setProjectName(project.getProjectName());		    
	}	
	pr.setProjectName(project.getProjectName());
	getGenericManager().saveProject(pr);
	 
        
        orderBill.setBillNo(project.getId());
	orderBill.setCustomer(getGenericManager().getCustomerById(orderBill.getCustomerId()));
	orderBill.setProject(project);
	orderBill.setSalesMan(getGenericManager().getMemberById(orderBill.getSalesManId()));
	orderBill.setMaker(getGenericManager().getMemberById(orderBill.getMakerId()));
        getGenericManager().saveOrderBill(orderBill);
        appendXworkParam("orderBill.id="+orderBill.getId());
        return SUCCESS;
    }
    
    public String save1(){
	
	System.out.println(" save1 orderBill.getId()="+orderBill.getId()+"--ordBillSub.getProductId()="+ordBillSub.getProductId());
	
	 if (getDelete() != null) {
	    return delete();
	 }else{		     
	  orderBill=getGenericManager().getOrderBillById(orderBill.getId());
	  String calcDisp=ordBillSub.getWidth()+"x"+ordBillSub.getHeigh()+"("+ordBillSub.getVwidth()+"x"+ordBillSub.getVheigh()+")-"+ordBillSub.getQuantity();
	  int amount=ordBillSub.getPaperPrice()*ordBillSub.getPaperCount();
	  ordBillSub.setAmount(amount);
	  ordBillSub.setCalcDisp(calcDisp);
	  if(ordBillSub.getIsGift()==null){
	      ordBillSub.setIsGift(false);
	  }
	  ordBillSub.setProduct(getGenericManager().getProductById(ordBillSub.getProductId())); 
	  ordBillSub.setCrement(getAppPropertyById(ordBillSub.getCrementId())); 
	  ordBillSub.setOrderBill(orderBill);
          getGenericManager().saveOrdBillSub(ordBillSub);
	 }
	 appendXworkParam("orderBill.id="+orderBill.getId());
         return SUCCESS;
    }
    
    public JSONObject orderBillCurrentProjectNo() throws JSONException {
   	JSONObject p = new JSONObject();
   	try {   
   	   String projectNo=getGenericManager().orderBillCurrentProjectNo();
   	   p.accumulate("projectNo", projectNo);
   	} catch (Exception e) {	   
	    System.out.println("orderBillCurrentProjectNo=" + e.toString());
	}
	return p;
    }
    
    public JSONObject ordBillSubRowNo() throws JSONException {
   	JSONObject p = new JSONObject();
   	int rowNO;
   	try {   
   	   System.out.println("ordBillSubRowNo orderBill.id="+orderBill.getId());
   	   orderBill=getGenericManager().getOrderBillById(orderBill.getId());   	
   	   rowNO=getGenericManager().ordBillSubRowNo(orderBill);  
   	   p.accumulate("rowNO", rowNO);
   	} catch (Exception e) {	 
   	    p.accumulate("rowNO", 1);	   
	}
	return p;
    }
    
    
    
    public JSONArray getOrdBillSubProductJSON(String productNo)
    {
	//System.out.println("ordBillSubProductJSON productNo="+productNo);	
	JSONArray jsonArray = new JSONArray();
       try{       
	   //List<Product> ls=getGenericManager().getProductListByCondition(productNo,productNo);
	   
	   List<Product> ls=new ArrayList<Product>();
	   
	   if(!productNo.equals("")){
	       ls=getGenericManager().getProductListByCondition(productNo,productNo);
	   }
	   
	   System.out.println("product.size="+ls.size());
	   for(int i=0;i<ls.size();i++){
	       JSONObject p = new JSONObject();
	       Product product=ls.get(i);
	       p.accumulate("id",product.getId());
	       p.accumulate("text",product.getId()+product.getProductName());
	       
	       if(product.getId().equals(productNo)){
		 p.accumulate("selected",true);
	       }
	       
	       jsonArray.put(p);	
	   
	 }
       }catch(Exception e){
    	   System.out.println("ordBillSubProductJSON="+e.toString());
       }       
       return jsonArray;
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
        orderBill.setProject(getGenericManager().getProjectById(orderBill.getProjectId())); 
        orderBill.setCustomer(getGenericManager().getCustomerById(orderBill.getCustomerId())); 
        orderBill.setSalesMan(getGenericManager().getMemberById(orderBill.getSalesManId())); 
        orderBill.setMaker(getGenericManager().getMemberById(orderBill.getMakerId())); 
        log.info("exit formToBean()");
    }
    
    public List<OrdBillSub> getOrdBillSubList()
    {		
        return getGenericManager().getOrdBillSubList(orderBill);
    }
        

    public List<OrderBill> getOrderBillList()
    {
        return getGenericManager().getOrderBillList();
    }

    public List<Customer> getCustomerList()
    {
        return getGenericManager().getCustomerList();
    }
    
    public List getCrementList()
    {
        return getGenericManager().getAppPropertyList("cip.crement");
    }
    
    public List<Member> getSalesmenList()
    {
    	ArrayList<Member> al = new ArrayList<Member>();
    	
    	Group g=getGenericManager().getGroupById(21L);
    	Set s=g.getMembers();
    	if(s!=null){
    	    System.out.println("s!=null");
    	    
   	        Iterator i = s.iterator(); 
   	    		 while (i.hasNext()) {
   	    			Member u= (Member) i.next();   	               
   	                al.add(u);
   	            } 
   	            
   		     }  
    	ComparatorMember comparator=new ComparatorMember();
    	Collections.sort(al, comparator);
    	
        return al;
    }
    
    public List<Member> getMakerList()
    {
        ArrayList<Member> al = new ArrayList<Member>();    	
    	Group g=getGenericManager().getGroupById(21L);
    	Set s=g.getMembers();
    	if(s!=null){
    	    System.out.println("s!=null");
    	    
   	        Iterator i = s.iterator(); 
   	    		 while (i.hasNext()) {
   	    			Member u= (Member) i.next();   	               
   	                al.add(u);
   	            } 
   	            
   		     }  
    	ComparatorMember comparator=new ComparatorMember();
    	Collections.sort(al, comparator);
    	 return al;
    }
    
}
