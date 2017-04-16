package com.common.web.action;

import com.common.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Nov 18 14:22:24 CST 2009
*/

public class MemberAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Member member;
    private Long[] groupIds;
	private String cardId="";
	private String md5="";
	private Long missCardIds;
	private Long id;
    
    private String[] selectedMemberIds;
    private Set<Group> newGroups = new HashSet();

    public MemberAction()
    {
        log = LogFactory.getLog(com.common.web.action.MemberAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MEMBER");
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member val)
    {
        member = val;
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMember(member.getId());
        return DELETE;
    }

    public String edit()
    {
        if (member == null) {
            member = new Member();
        } else if (member.getId() != null) {
            member = getGenericManager().getMemberById(member.getId());              
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMemberIds != null && selectedMemberIds.length > 0) {
            Member obj = getGenericManager().getMemberById(selectedMemberIds[0]);
            obj.setId(null);
            member = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        
       if(member.getId()!=null){
          member = getGenericManager().getMemberById(member.getId());
       }
       
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(member) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Member val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMember(member);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        groupIds = getGenericManager().getIdsFromGroupList(member.getGroups());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        member.setGroups(getGenericManager().getGroupListByIds(groupIds)); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getCardTypeList()
    {
        return super.getAppPropertyList("card.type");
    }

    public List<Group> getGroupList()
    {
        List<Group> al = getGenericManager().getGroupList();
        if (al != null) {
    		Set groups=member.getGroups();
   		    if(groups!=null){
   	        Iterator i = member.getGroups().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Group g= (Group) i.next();   	               
   	                al.remove(g);
   	            } 
   		     }    		
           }
        return al;
    }
    
    public Set<Group> getObject_groupList()
    {
    	Set groups=member.getGroups();
		 if(groups!=null){
			 return member.getGroups();
		 }else{
			 return   newGroups;
		 }   	
    }

    public void setGroupIds(Long[] val)
    {
    	groupIds = val;
    }

    public Long[] getGroupIds()
    {
        return groupIds;
    }
    
    

    public List<Member> getMemberList()
    {
    	if(!cardId.equals("")){
    	   System.out.println("cardId="+cardId);	
    	   return getGenericManager().getMemberByCardId(cardId);
    	}else{
    	   return getGenericManager().getMemberList();
    	}
    }

    public void setSelectedMemberIds(String[] val)
    {
        selectedMemberIds = val;
    }

    public String[] getSelectedMemberIds()
    {
        return selectedMemberIds;
    }
    
    public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
	
	public Long getMissCardIds() {
		return missCardIds;
	}

	public void setMissCardIds(Long missCardIds) {
		this.missCardIds = missCardIds;
	}
	
	public String miss(){
		member=getGenericManager().getMemberByIdWithMD5(getMd5());
        System.out.println("getId()="+getMd5()+"  member="+member.getName());
		return SUCCESS;
	}
	
	public String missSave(){
		
		member=getGenericManager().getMemberById(member.getId());
		 if(getMissCardIds()==11L){
		     member.setEnabled(true);
		 }else if (getMissCardIds()==10L){
			 member.setEnabled(false);
		 }
		save();
		
		return SUCCESS;
	}
	
    public List getMissCardList()
    {
        return getAppPropertyList("common.misscard");
    }
}
