package com.common.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.base.dao.hibernate.BaseDAOHibernate;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.base.value.SessionUser;
import com.common.dao.CommonDAO;
import com.common.value.*;
import com.base.value.*;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;





 
public class CommonDAOHibernate extends BaseDAOHibernate implements CommonDAO 
{
    public Long[] getIdsFromFunctionCategoryList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                FunctionCategory t = (FunctionCategory) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);

        return lng;
    }

    public List getFunctionCategoryListByIds(Long[] ids)
    {
        ArrayList<FunctionCategory> al = new ArrayList<FunctionCategory>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                FunctionCategory t = (FunctionCategory) findFunctionCategoryById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }

    public Set getGroupListByIds(Long[] ids)
    {
    	Set groups = new HashSet();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Group t = (Group) findGroupById(ids[i]);
                if (t != null)
                	groups.add(t);
            }
        }
        return groups;
    }
    
	 public List getSurveyGroupListByIds(Long[] ids)
	    {
	        ArrayList<Group> al = new ArrayList<Group>();
	        if (ids != null) {
	            for (int i = 0; i < ids.length; i++) {
	                Group t = (Group) findGroupById(ids[i]);
	                if (t != null)
	                    al.add(t);
	            }
	        }
	        return al;
	    } 
    
    
    public Set getUnitListByIds(Long[] ids)
    {
    	Set units = new HashSet();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Unit t = (Unit) findUnitById(ids[i]);
                if (t != null)
                	units.add(t);
            }
        }
        return units;
    	/*ArrayList<Unit> al = new ArrayList<Unit>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
            	Unit t = (Unit) findUnitById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;*/
    }
    
    public List findAllAppProperty()
    {
        return getHibernateTemplate()
                .find(
                        "select distinct app.kind from AppProperty as app order by app.kind");
    }

    public void saveAppProperty(AppProperty obj)
    {
        getHibernateTemplate().saveOrUpdate(obj);
        if (logger.isDebugEnabled())
            logger.debug((new StringBuffer()).append("id set to: ").append(
                    obj.getId()).toString());
    }

    public void removeAppProperty(Long id)
    {
        getHibernateTemplate().delete(findAppPropertyById(id));
    }

    public void removeAppProperty(AppProperty obj)
    {
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.AppProperty.class, obj);
        getHibernateTemplate().delete(obj);
    }

    public List getMaxSeqNoOfAppPropertyByKind(String kind)
    {
        java.util.List result = new java.util.ArrayList();

        try {
            String hsql = "select max(app.seqNo) from AppProperty as app where app.kind=:kind";

            Query query = getHibernateSession().createQuery(hsql);
            query.setParameter("kind", kind);

            result = query.list();

            logger.debug(query.getQueryString());
        } catch (HibernateException ex) {
            if (logger.isErrorEnabled()) {
                logger.error(ex.getMessage(), ex);
            }

            throw new RuntimeException(ex);
        }

        return result;
    }

    public List<AppProperty> findAllAppPropertyByIds(Long[] ids)
	{
		 ArrayList<AppProperty> al = new ArrayList<AppProperty>();
	     if (ids != null) {        	
	         for (int j=0; j < ids.length; j++) { 
	        	 AppProperty a = findAppPropertyById(ids[j]);
	         	 al.add(a);
	         }
	     }    	
		return al;
	}

	public void saveChecking(Checking obj)
    {
        getHibernateTemplate().saveOrUpdate(obj);
        if (logger.isDebugEnabled())
            logger.debug((new StringBuffer()).append("id set to: ").append(
                    obj.getId()).toString());
    }

    public Group findGroupById(Long id)
    {
        if (id == null)
            return null;
        Group obj = (Group) getHibernateTemplate().get(
                com.base.value.Group.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.Group.class, id);
        else
            return obj;
    }
    
    public Group findGroupByGroupKey(String GroupKey){
    	Group group = null;
        try {
            Criteria c = getHibernateSession().createCriteria(Group.class);
            c.add(Expression.eq("groupKey", GroupKey));        
            List result = c.list();
            if (result.size() > 0)
            	group = (Group) result.get(0);           
        }
        catch (HibernateException ex) {
          System.out.println(ex.toString());
        }        
        return group;   
    }
    
    

    public void saveGroup(Group val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeGroup(Group val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeGroup(Long id)
    {
        Group obj = findGroupById(id);
        getHibernateTemplate().delete(obj);
    }

    public List findAllGroup()
    {
        return getHibernateTemplate().find("from Group order by id asc");
    }

    public void saveFunction(Function val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunction(Function val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunction(Long id)
    {
        Function obj = findFunctionById(id);
        getHibernateTemplate().delete(obj);
    }

    public Function findFunctionById(Long id)
    {
        if (id == null)
            return null;
        Function obj = (Function) getHibernateTemplate().get(
                com.base.value.Function.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.Function.class, id);
        else
            return obj;
    }

    public List findAllFunction()
    {
        return getHibernateTemplate().find("from Function order by category");
    }

    public List findOnlineFunction()
    {
        return getHibernateTemplate().find("from Function order by category");
    }

    public List findCategoryList()
    {
        return new ArrayList(); // TODO
    }

    public void saveFunctionCategory(FunctionCategory val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunctionCategory(FunctionCategory val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunctionCategory(Long id)
    {
        FunctionCategory obj = findFunctionCategoryById(id);
        getHibernateTemplate().delete(obj);
    }

    public FunctionCategory findFunctionCategoryById(Long id)
    {
        if (id == null)
            return null;
        FunctionCategory obj = (FunctionCategory) getHibernateTemplate().get(
                com.base.value.FunctionCategory.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.FunctionCategory.class, id);
        else
            return obj;
    }

    public List findAllFunctionCategory()
    {
        return getHibernateTemplate().find(
                "from FunctionCategory order by seqNo");
    }

    public List findFrontFunctionCategoryList()
    {
        return getHibernateTemplate().find(
                "from FunctionCategory where isFront=true order by seqNo ");
    }

    public void saveFunctionAuthority(FunctionAuthority val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunctionAuthority(FunctionAuthority val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunctionAuthority(Long id)
    {
        FunctionAuthority obj = findFunctionAuthorityById(id);
        getHibernateTemplate().delete(obj);
    }

    public FunctionAuthority findFunctionAuthorityById(Long id)
    {
        if (id == null)
            return null;
        FunctionAuthority obj = (FunctionAuthority) getHibernateTemplate().get(
                com.base.value.FunctionAuthority.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.FunctionAuthority.class, id);
        else
            return obj;
    }

    public List findAllFunctionAuthority()
    {
        return getHibernateTemplate().find("from FunctionAuthority");
    }

    public List findGroupList()
    {
        return findAllGroup();
    }

    public Long[] getIdsFromGroupList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {        	
            
        	 Iterator i = tlist.iterator(); 
	    		 while (i.hasNext()) {
	    			Group g= (Group) i.next(); 
	    			 al.add(g.getId());
	    		 }
        	
        	/*
        	for (int j=0; j < tlist.size(); j++) { 
            	Group g = (Group) tlist.iterator().next();
            	 al.add(g.getId());
            }
        	*/
        	
        	
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;
    }
    
   
    public Long[] getIdsFromSurveyGroupList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
            	Group t = (Group) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);

        return lng;
    }
    
    
    public Long[] getIdsFromUnitList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {        	
            for (int j=0; j < tlist.size(); j++) { 
            	Unit u = (Unit) tlist.iterator().next();
            	 al.add(u.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;   	
    }
    

    public void saveWebSite(WebSite val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeWebSite(WebSite val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeWebSite(Long id)
    {
        WebSite obj = findWebSiteById(id);
        getHibernateTemplate().delete(obj);
    }

    public WebSite findWebSiteById(Long id)
    {
        if (id == null)
            return null;
        WebSite obj = (WebSite) getHibernateTemplate().get(
                com.common.value.WebSite.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.common.value.WebSite.class, id);
        else
            return obj;
    }

    public WebSite findWebSiteByCode(String code)
    {
        //System.out.println("WebSiteByCode:" + code);
        if (code == null)
            return null;
        Criteria c = getHibernateSession().createCriteria(
                com.common.value.WebSite.class);
        c.add(Expression.eq("code", code));
        List ll = c.list();
        if (ll.size() > 0)
            return (WebSite) ll.get(0);
        else
            return null;
    }

    public List findAllWebSite()
    {
        return getHibernateTemplate().find("from WebSite");
    }

    public void saveMember(Member val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMember(Member val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMember(String id)
    {
        Member obj = findMemberById(id);
        getHibernateTemplate().delete(obj);
    }

    public Member findMemberById(String id)
    {
        
 	   Member user = null;

       try {
           Criteria c = getHibernateSession().createCriteria(
                   com.common.value.Member.class);
           c.add(Expression.eq("id", id));

           List result = c.list();
           if (result.size() > 0)
               user = (Member) result.get(0);           
       }
       catch (HibernateException ex) {
           if ( logger.isErrorEnabled() ) {
               logger.error(ex.getMessage(), ex);
           }

           throw new RuntimeException(ex);
       }
       
       return user;
        
        
    }
    
    public Member findMemberByEmail(String email)
    {
        System.out.println("findMemberByEmail..email="+email);
    	if (email == null)
            return null;
        Criteria c = getHibernateSession().createCriteria(
                com.common.value.Member.class);
        c.add(Expression.eq("email", email));
        List ll = c.list();
        if (ll.size() > 0)
            return (Member) ll.get(0);
        else
            return null;
    }

    public List<Member> findAllMember()
    {   
    	return getHibernateTemplate().find("from Member order by flag,id asc");    	
    }
    
    public List<Member> getStaffList()
    {   
    	return getHibernateTemplate().find("from Member where flag='1' order by name asc");    	
    }
    
    public List<Member> findMemberByCardId(String cardId)
    {   
    	ArrayList<Member> al = new ArrayList<Member>();
        try {
    	  Criteria c = getHibernateSession().createCriteria(com.common.value.Member.class);

          c.add(Restrictions.or(
        		  Restrictions.like("id","%"+cardId+"%"),
        		  Restrictions.like("name","%"+cardId+"%")
              ));
    	  
             List result = c.list();        
             for (int i = 0; i < result.size(); i++) {
             	   Member m=(Member) result.get(i);
                    al.add(m);    
                    
             }
             return al;
        }catch (HibernateException ex) {
            System.out.println("findMemberByCardId error!");
            return al;
        }
    	  	
    }
    
    
    public List<Member> findQueryMember(String name)
    {

        if(name!=null){
          name.trim();
        }        

        String hsql = "select m from Member as m where m.name like :name or firstName like :firstName or lastName like :lastName or city like :city or state like :state or zip like :zip or bapPlace like :bapPlace";
        Query qry = getHibernateSession().createQuery(hsql);
        qry.setParameter("name", "%"+name+"%");
        qry.setParameter("firstName", "%"+name+"%");
        qry.setParameter("lastName", "%"+name+"%");
        qry.setParameter("city", "%"+name+"%");
        qry.setParameter("state", "%"+name+"%");
        qry.setParameter("zip", "%"+name+"%");
        qry.setParameter("bapPlace", "%"+name+"%");
        
        List query = qry.list();  
        ArrayList<Member> al = new ArrayList<Member>();
            for (int i = 0; i < query.size(); i++) {
            	   Member m=(Member) query.get(i);
                   al.add(m);
                  // System.out.println("查詢結果："+m.getName());
            }
        return al;
    }
    
    public Member findMemberByLoginIdAndPassword(String loginId, String pwd)
    {
        Member user = null;

        try {
            Criteria c = getHibernateSession().createCriteria(
                    com.common.value.Member.class);
            c.add(Expression.eq("id", loginId));
            c.add(Expression.eq("idNo", pwd));  
            List result = c.list();
            if (result.size() > 0)
                user = (Member) result.get(0);           
        }
        catch (HibernateException ex) {
          System.out.println(ex.toString());
        }
        
        return user;
    }
    
    public List<UploadedFile> findPhotoList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public void saveMiscCode(MiscCode val)
    {
        getHibernateTemplate().save(val);
    }

    public void updateMiscCode(MiscCode val)
    {
        getHibernateTemplate().update(val);
    }
    
    public void removeMiscCode(MiscCode val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMiscCode(Long id)
    {
        MiscCode obj = findMiscCodeById(id);
        getHibernateTemplate().delete(obj);
    }

    public List<MiscCode> findAllMiscCode()
    {
        return getHibernateTemplate().find("from MiscCode");
    }
    
   
    /**產生 Unit Hibernate impl*/
    
    public void saveUnit(Unit val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeUnit(Unit val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeUnit(Long id)
    {
    	Unit obj = findUnitById(id);
        getHibernateTemplate().delete(obj);
    }

    public Unit findUnitById(Long id)
    {
        if (id == null)
            return null;
        Unit obj = (Unit)getHibernateTemplate().get(com.common.value.Unit.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Unit.class, id);
        else
            return obj;
    }
    
    public List findAllUnit()
    {
        return getHibernateTemplate().find("from Unit");
    }    
    
    public Set getMemberListByIds(String[] ids)
    {
        Set<Member> al = new HashSet();
        if (ids != null) {
           for(int i=0;i<ids.length;i++){
        	Member m = (Member) findMemberById(ids[i]);
        	System.out.println("getMemberListByIds 加入Member name="+m.getName());
        	al.add(m);
           }
        }
        return al;
    }
    
   public String[] getIdsFromMemberList(Set tlist)
    {
        ArrayList<String> al = new ArrayList<String>();
        if (tlist != null) {
        	Iterator i = tlist.iterator();    	
    		while (i.hasNext()) {
    			Member m= (Member) i.next();               
                al.add(m.getId());
            }    
        }
        String lng[] = new String[al.size()];
        al.toArray(lng);
        return lng;
    }
   
   
   public List<Member> getMemberListById(String[] ids)
   {	  
	   ArrayList<Member> al = new ArrayList<Member>();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
       	    Member m = (Member) findMemberById(ids[i]);
       	    System.out.println("getMemberListByIds 加入Member name="+m.getName());
       	    al.add(m);
          }
       }
       return al;
   }
   
  public String[] getIdFromMemberList(List tlist)
   {
       ArrayList<String> al = new ArrayList<String>();
       if (tlist != null) {
       	Iterator i = tlist.iterator();    	
   		while (i.hasNext()) {
   			Member m= (Member) i.next();               
               al.add(m.getId());
           }    
       }
       String lng[] = new String[al.size()];
       al.toArray(lng);
       return lng;
   }
  
   
   /**職稱管理*/
    
   public void saveGrade(Grade val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }

   public void removeGrade(Grade val)
   {
       getHibernateTemplate().delete(val);
   }

   public void removeGrade(Long id)
   {
       Grade obj = findGradeById(id);
       getHibernateTemplate().delete(obj);
   }

   public Grade findGradeById(Long id)
   {
       if (id == null)
           return null;
       Grade obj = (Grade)getHibernateTemplate().get(com.common.value.Grade.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(com.common.value.Grade.class, id);
       else
           return obj;
   }

   public List<Grade> findAllGrade()
   {
       return getHibernateTemplate().find("from Grade");
   }
   
   public Set getGradeListByIds(Long[] ids)
   {
       Set<Grade> al = new HashSet();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
        	  Grade g = (Grade) findGradeById(ids[i]);
              al.add(g);
          }
       }
       return al;
   }
   
   public  Member findMemberByIdWithMD5(String id){
	   Member user = null;

       try {
           Criteria c = getHibernateSession().createCriteria(
                   com.common.value.Member.class);
           c.add(Expression.eq("md5", id));

           List result = c.list();
           if (result.size() > 0)
               user = (Member) result.get(0);           
       }
       catch (HibernateException ex) {
           if ( logger.isErrorEnabled() ) {
               logger.error(ex.getMessage(), ex);
           }

           throw new RuntimeException(ex);
       }
       
       return user;
	   
   }
   
   
 
}
