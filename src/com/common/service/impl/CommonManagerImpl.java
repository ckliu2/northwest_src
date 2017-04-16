package com.common.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import com.base.service.impl.BaseManagerImpl;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.common.dao.CommonDAO;
import com.common.service.CommonManager;
import com.common.value.*;
import com.base.value.*;


public class CommonManagerImpl extends BaseManagerImpl implements CommonManager
{
    public CommonManagerImpl()
    {
        super();
    }
    
    public void saveChecking(Checking obj)
    {
        getGenericDAO().saveChecking(obj);
    }

    public CommonDAO getGenericDAO()
    {
        return (CommonDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CommonDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveAppProperty(AppProperty val)
    {
        getGenericDAO().saveAppProperty(val);
    }

    public void updateMiscCode(MiscCode val)
    {
        getGenericDAO().updateMiscCode(val);
    }

    public void removeAppProperty(AppProperty val)
    {
        getGenericDAO().removeAppProperty(val);
    }

    public void removeAppProperty(Long id)
    {
        getGenericDAO().removeAppProperty(id);
    }

    public AppProperty getAppPropertyById(Long id)
    {
         return getGenericDAO().findAppPropertyById(id);
    }

    public List getAppPropertyList()
    {
        java.util.List ls = getGenericDAO().findAllAppProperty();
        //System.out.println("===========>" + ls);
        return ls;
    }
    
    
    public List<AppProperty> getAppPropertyListByIds(Long[] ids)
    {
    	return getGenericDAO().findAllAppPropertyByIds(ids);
    }
    
    public List getMaxSeqNoOfAppPropertyByKind(String kind)
    {
        return getGenericDAO().getMaxSeqNoOfAppPropertyByKind(kind);
    }

    public Group getGroupById(Long id)
    {
        return getGenericDAO().findGroupById(id);
    }
    
    public  Group getGroupByGroupKey(String GroupKey){
    	 return getGenericDAO().findGroupByGroupKey(GroupKey);
    }
    
    
    public void saveGroup(Group val)
    {
        getGenericDAO().saveGroup(val);
    }

    public void removeGroup(Group val)
    {
        getGenericDAO().removeGroup(val);
    }

    public void removeGroup(Long id)
    {
        getGenericDAO().removeGroup(id);
    }

    public void saveFunction(Function val)
    {
        getGenericDAO().saveFunction(val);
    }

    public void removeFunction(Function val)
    {
        getGenericDAO().removeFunction(val);
    }

    public void removeFunction(Long id)
    {
        getGenericDAO().removeFunction(id);
    }

    public Function getFunctionById(Long id)
    {
         return getGenericDAO().findFunctionById(id);
    }

    public List getFunctionList()
    {
        return getGenericDAO().findAllFunction();
    }

    public List getOnlineFunctionList()
    {
        return getGenericDAO().findOnlineFunction();
    }

    public List getCategoryList()
    {
        return getGenericDAO().findCategoryList();
    }

    public void saveFunctionCategory(FunctionCategory val)
    {
        getGenericDAO().saveFunctionCategory(val);
    }

    public void removeFunctionCategory(FunctionCategory val)
    {
        getGenericDAO().removeFunctionCategory(val);
    }

    public void removeFunctionCategory(Long id)
    {
        getGenericDAO().removeFunctionCategory(id);
    }

    public FunctionCategory getFunctionCategoryById(Long id)
    {
         return getGenericDAO().findFunctionCategoryById(id);
    }

    public List getFunctionCategoryList()
    {
        return getGenericDAO().findAllFunctionCategory();
    }

    public List getFrontFunctionCategoryList()
    {
        return getGenericDAO().findFrontFunctionCategoryList();
    }

    public void saveFunctionAuthority(FunctionAuthority val)
    {
        getGenericDAO().saveFunctionAuthority(val);
    }

    public void removeFunctionAuthority(FunctionAuthority val)
    {
        getGenericDAO().removeFunctionAuthority(val);
    }

    public void removeFunctionAuthority(Long id)
    {
        getGenericDAO().removeFunctionAuthority(id);
    }

    public FunctionAuthority getFunctionAuthorityById(Long id)
    {
         return getGenericDAO().findFunctionAuthorityById(id);
    }

    public List getFunctionAuthorityList()
    {
        return getGenericDAO().findAllFunctionAuthority();
    }
    public List getGroupList()
    {
        return getGenericDAO().findGroupList();
    }

    public Set getGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getGroupListByIds(ids);
    }
    
    public List getSurveyGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getSurveyGroupListByIds(ids);
    }  
    
    
    public Set getUnitListByIds(Long[] ids)
    {
        return getGenericDAO().getUnitListByIds(ids);
    }

    public Long[] getIdsFromGroupList(Set ids)
    {
        return getGenericDAO().getIdsFromGroupList(ids);
    }
    
    public Long[] getIdsFromSurveyGroupList(List ids)
    {
        return getGenericDAO().getIdsFromSurveyGroupList(ids);
    }
    
    public Long[] getIdsFromUnitList(Set ids)
    {
        return getGenericDAO().getIdsFromUnitList(ids);
    }
    
    
    public void saveWebSite(WebSite val)
    {
        getGenericDAO().saveWebSite(val);
    }

    public void removeWebSite(WebSite val)
    {
        getGenericDAO().removeWebSite(val);
    }

    public void removeWebSite(Long id)
    {
        getGenericDAO().removeWebSite(id);
    }

    public WebSite getWebSiteById(Long id)
    {
         return getGenericDAO().findWebSiteById(id);
    }

    public WebSite getWebSiteByCode(String code)
    {
         return getGenericDAO().findWebSiteByCode(code);
    }

    public List getWebSiteList()
    {
        return getGenericDAO().findAllWebSite();
    }
    public Long[] getIdsFromFunctionCategoryList(List al)
    {
        return getGenericDAO().getIdsFromFunctionCategoryList(al);        
    }
    //getIdsFromFunctionCategoryList

    public List getFunctionCategoryListByIds(Long[] ids)
    {
         return getGenericDAO().getFunctionCategoryListByIds(ids);
    }


    public List getOnlineUserFunctionListByFunctionCategoryList(List al)
    {
        return getGenericDAO().getOnlineUserFunctionListByFunctionCategoryList(al);
    }
    
    public List getAllOnlineUserFunctionList()
    {
        return getGenericDAO().getAllOnlineUserFunctionList();
    }

    public void saveMember(Member val)
    {
        getGenericDAO().saveMember(val);
    }

    public void removeMember(Member val)
    {
        getGenericDAO().removeMember(val);
    }

    public void removeMember(String id)
    {
        getGenericDAO().removeMember(id);
    }

    public Member getMemberById(String id)
    {
         return getGenericDAO().findMemberById(id);
    }
    
    public Member getMemberByEmail(String email)
    {
         return getGenericDAO().findMemberByEmail(email);
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findAllMember();
    }
    
    public List<Member> getStaffList()
    {
    	return getGenericDAO().getStaffList();
    }
    
    public List<Member> getMemberByCardId(String cardId)
    {
         return getGenericDAO().findMemberByCardId(cardId);
    }
    
    public Member getMemberByIdWithMD5(String id)
    {
         return getGenericDAO().findMemberByIdWithMD5(id);
    }

    
    public List<Member> getQueryMemberList(String name)
    {
        return getGenericDAO().findQueryMember(name);
    }

    public Member getMemberByLoginIdAndPassword(String loginId, String password)
    {
        return getGenericDAO().findMemberByLoginIdAndPassword(loginId, password);
    }
    
    public Set getMemberListByIds(String[] ids)
    {
        return getGenericDAO().getMemberListByIds(ids);
    }
    
   public String[] getIdsFromMemberList(Set ids)
    {
        return getGenericDAO().getIdsFromMemberList(ids);
    }
        
        
    public List<Member> getMemberListById(String[] ids)
        {
            return getGenericDAO().getMemberListById(ids);
        }
        
   public String[] getIdFromMemberList(List ids)
        {
            return getGenericDAO().getIdFromMemberList(ids);
        }    
   
        
    
    public List<UploadedFile> getPhotoList()
    {
        return getGenericDAO().findPhotoList();
    }
    
    
    public void saveMiscCode(MiscCode val)
    {
        getGenericDAO().saveMiscCode(val);
    }

    public void removeMiscCode(MiscCode val)
    {
        getGenericDAO().removeMiscCode(val);
    }

    public void removeMiscCode(Long id)
    {
        getGenericDAO().removeMiscCode(id);
    }

    public MiscCode getMiscCodeById(Long id)
    {
         return getGenericDAO().findMiscCodeById(id);
    }

    public List<MiscCode> getMiscCodeList()
    {
        return getGenericDAO().findAllMiscCode();
    }
    

    
    /**產生Unit 實作*/
    
    public void saveUnit(Unit val)
    {
        getGenericDAO().saveUnit(val);
    }

    public void removeUnit(Unit val)
    {
        getGenericDAO().removeUnit(val);
    }

    public void removeUnit(Long id)
    {
        getGenericDAO().removeUnit(id);
    }

    public Unit getUnitById(Long id)
    {
         return getGenericDAO().findUnitById(id);
    }
    
    public List<Unit> getUnitList()
    {
        return getGenericDAO().findAllUnit();
    }
    
    /**產生Unit 實作*/    
    

    
    /**職稱*/
    public void saveGrade(Grade val)
    {
        getGenericDAO().saveGrade(val);
    }

    public void removeGrade(Grade val)
    {
        getGenericDAO().removeGrade(val);
    }

    public void removeGrade(Long id)
    {
        getGenericDAO().removeGrade(id);
    }

    public Grade getGradeById(Long id)
    {
         return getGenericDAO().findGradeById(id);
    }

    public List<Grade> getGradeList()
    {
        return getGenericDAO().findAllGrade();
    }
    
    public Set getGradeListByIds(Long[] ids)
    {
        return getGenericDAO().getGradeListByIds(ids);
    }
    
 
 
}
