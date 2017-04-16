package northwest.common.web.action;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import northwest.common.service.BillManager;
import northwest.common.value.*;

import com.base.util.Tools;
import com.common.value.Member;
import com.common.web.action.*;

public class WorkEfficiencyAction extends CommonActionSupport{
	String startDate="",endDate="",q;  
    Member member;
	String memberId;
	WorkEfficiency workEfficiency;
	
    public void setGenericManager(BillManager m)
    {
        super.setGenericManager(m);
    }

    public BillManager getGenericManager()
    {
        return (BillManager) super.getGenericManager();
    }
	
	public String list()
    {
		if(startDate==null){
		   startDate=(String)getSession().getAttribute("startDate");
	    }
	    if(endDate==null){
	       endDate=(String)getSession().getAttribute("endDate");
	    }
	    
	    if(startDate!=null){
	     if(startDate.length()>8){
	    	startDate=startDate.substring(0, 8);
	     }
	    }
	    
	    if(endDate!=null){
		     if(endDate.length()>8){
		    	 endDate=endDate.substring(0, 8);
		     }
		 }
	    
        return SUCCESS;
    }
	
	
	public List<Member> getMemberList(){
		return getGenericManager().getStaffList();
	}
	
	/*
	public List<WorkEfficiency> getWorkEfficiency(){
		member=getGenericManager().getMemberById(memberId);
		List<WorkEfficiency> al=getGenericManager().getWorkEfficiencyByMember(startDate, endDate, member);				    
		 
		//test
		for(int k=0;k<al.size();k++){
			WorkEfficiency s=al.get(k);
			List<ProductX> d=s.getProducts();
			System.out.println(s.getGroup().getGroupName());
			for(int x=0;x<d.size();x++){
				ProductX px=d.get(x);
				Product p=px.getProduct();
				System.out.println("action="+p.getId()+"--sumQuantity="+p.getSumQuantity()+"---SumBasicQuantity="+p.getSumBasicQuantity());
        	}
		}
		
		return al;
	}
	*/
	
	public List<WorkEfficiency> getWorkEfficiency(){
		List<WorkEfficiency> al = new ArrayList<WorkEfficiency>(); 
		
		String session_memberId=(String)getSession().getAttribute("memberId");  
		String session_startDate=(String)getSession().getAttribute("startDate");  
		String session_endDate=(String)getSession().getAttribute("endDate");
		int i=0;
		if(session_memberId!=null){
		 if(session_memberId.equals(memberId)){
			i++;
		 }
		}		
		if(session_startDate!=null){
		  if(session_startDate.equals(startDate)){
			 i++;
		  }
		}		
		if(session_endDate!=null){
		  if(session_endDate.equals(endDate)){				
			 i++;
		  }
		}
		
		//System.out.println("session_memberId="+session_memberId+"--session_startDate="+session_startDate+"--session_endDate="+session_endDate);
		//System.out.println("memberId="+memberId+"--startDate="+startDate+"--endDate="+endDate);
		
		if(memberId!=null && startDate!=null && endDate!=null){		
			member=getGenericManager().getMemberById(memberId);
			if(i!=3){	 
			 al=getGenericManager().getWorkEfficiencyByMember(startDate, endDate, member);				    
			 getSession().setAttribute("al", al);  
			 System.out.println("更新Session");
			}else{					
				List ls=(List)getSession().getAttribute("al");
				for(int j=0;j<ls.size();j++){
					WorkEfficiency w=(WorkEfficiency)ls.get(j);			
					al.add(w);
				}				
				System.out.println("不用更新抓Session**");
			}
			 getSession().setAttribute("memberId", memberId);  
			 getSession().setAttribute("startDate", startDate);  
			 getSession().setAttribute("endDate", endDate);
		  }	
		
		return al;
	}
	
	
	public JSONArray findMemberByJSON(){
		System.out.println("findMemberByJSON q="+q);
		JSONArray jsonArray = new JSONArray();
    	try{
    	   List ls=getGenericManager().getMemberByCardId(q);
    	   for(int i=0;i<ls.size();i++){    		   
    		   Member s=(Member)ls.get(i);
    		   JSONObject jo = new JSONObject();
        	   jo.accumulate("id",s.getId());
        	   jo.accumulate("name",s.getName());       
        	   jo.accumulate("email",s.getEmail());  
        	   jsonArray.put(jo);     
        	   //System.out.println("findMemberByJSON="+s.getName());
    	   }    	 
    	   //System.out.println("findCustomerByJSON JSONArray="+jsonArray.toString());
    	}catch(Exception e){
    		System.out.println("findMemberByJSON error..");
    	}
    	return jsonArray;
    }
	
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}
