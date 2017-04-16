package com.base.service.impl;

import java.util.List;

import com.base.dao.BaseDAO;
import com.base.service.BaseManager;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.MiscCode;
import com.base.value.SessionUser;
import com.base.value.UploadedFile;

public class BaseManagerImpl implements BaseManager
{
    private BaseDAO dao; 

    public BaseManagerImpl()
    {
        super();
    }

    public BaseDAO getGenericDAO()
    {
        return dao;
    }

    public void setGenericDAO(BaseDAO dao)
    {
        this.dao = dao;
    }
    
    public List getCountryList()
    {
        return dao.findCountryList();
    }
    
    public List getCountyList()
    {
        return dao.findCountyList();
    }

    public List getCityList(String county)
    {
        return dao.findCityList(county);
    }
    
    public List getAppPropertyList(String kind)
    {
        return dao.findAppPropertyList(kind);
    }
    public List getMiscCodeListByCodeName(String codeName)
    {
        return dao.findMiscCodeListByCodeName(codeName);
    }
    public MiscCode getMiscCodeById(Long miscCodeId)
    {
        return dao.findMiscCodeById(miscCodeId);
    }

    public AppProperty getAppPropertyById(Long appPropertyId)
    {
        return dao.findAppPropertyById(appPropertyId);
    }

    public MiscCode getMiscCodeByCodeKeyName(String codeName, String keyName)
    {
        return dao.findMiscCodeByCodeKeyName(codeName, keyName);
    }
    public UploadedFile getUploadedFileById(Long id)
    {
        return dao.findUploadedFileById(id);
    }
    
    public void removeUploadedFile(UploadedFile val)
    {
        dao.removeUploadedFile(val);
    }
    
    public void saveUploadedFile(UploadedFile val){
    	dao.saveUploadedFile(val);
    }
    
    public void removeUploadedFile(Long id)
    {
        dao.removeUploadedFile(id);
    }
    
    public Function getFunctionById(Long id)
    {
        return dao.findFunctionById(id);
    }

    public Function getFunctionByKey(String funKey)
    {
        return dao.findFunctionByKey(funKey);
    }

    public List getGroupList()
    {
        return dao.findAllGroup();
    }
    public SessionUser getSessionUserByLoginIdAndPassword(String uid, String pwd)
    {
        return getGenericDAO().findSessionUserByLoginIdAndPassword(uid, pwd);
    }

    public List findFunctionListBySessionUser(SessionUser su)
    {
        return getGenericDAO().findFunctionListBySessionUser(su);
    }

    public void exportExcel(String sql,String outFile)
    {
    	getGenericDAO().exportExcel(sql,outFile);
    }
    
    public void executeSQL(String sql)
    {
    	getGenericDAO().executeSQL(sql);
    }
    
    public void sendEmail(String email,String subject,String content){
    	getGenericDAO().sendEmail(email,subject,content);
    }
    
}
