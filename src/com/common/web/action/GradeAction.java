package com.common.web.action;

import com.common.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Jun 11 14:53:30 CST 2009
*/

public class GradeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Grade grade;
    private String[] membersIds;
    private Long[] selectedGradeIds;
    private Set<Member> newMembers = new HashSet();

    public GradeAction()
    {
        log = LogFactory.getLog(com.common.web.action.GradeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("GRADE");
    }

    public Grade getGrade()
    {
        return grade;
    }

    public void setGrade(Grade val)
    {
        grade = val;
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
        getGenericManager().removeGrade(grade.getId());
        return DELETE;
    }

    public String edit()
    {
    	if (grade == null ) {
    		grade = new Grade();
            System.out.println("這是一個NEW Grade");
        } else  if(grade.getId() == null) {        	
            grade = new Grade();
        } else if (grade.getId() != null) {
            grade = getGenericManager().getGradeById(grade.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedGradeIds != null && selectedGradeIds.length > 0) {
            Grade obj = getGenericManager().getGradeById(selectedGradeIds[0]);
            obj.setId(null);
            grade = obj;
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
            if (inputValidation(grade) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Grade val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveGrade(grade);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(grade.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        grade.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
        grade.setCreatedDate(Tools.getCurrentTimestamp());
        log.info("exit formToBean()");
    }
    
    public List<Member> getMemberList()
    {
        List<Member> al = getGenericManager().getMemberList();
        if (al != null) {   
    	 Set members=grade.getMembers();
   		 if(members!=null){
   	        Iterator i = grade.getMembers().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Member m= (Member) i.next();
   	                al.remove(m);
   	         } 
   		   }        	
        }
        return  al;
    }

    public void setMembersIds(String[] val)
    {
        membersIds = val;
    }

    public String[] getMembersIds()
    {
        return membersIds;
    }

    public List<Grade> getGradeList()
    {
        return getGenericManager().getGradeList();
    }
    
    public Set<Member> getGrade_memberList()
    {
    	Set members=grade.getMembers();
		 if(members!=null){
			 return grade.getMembers();
		 }else{
			 return   newMembers;
		 }
    }    
    

    public void setSelectedGradeIds(Long[] val)
    {
        selectedGradeIds = val;
    }

    public Long[] getSelectedGradeIds()
    {
        return selectedGradeIds;
    }
}
