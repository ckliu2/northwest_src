package com.base.service;

import java.util.List;

import com.base.value.AppProperty;
import com.base.value.MiscCode;
import com.base.value.SessionUser;
import com.base.value.UploadedFile;
import com.base.value.Function;

public interface BaseManager
{
    public abstract List getCountryList();
    public abstract List getCountyList();
    public abstract List getCityList(String codeName);
    public abstract List getAppPropertyList(String kind);
    public abstract MiscCode getMiscCodeById(Long id);
    public abstract AppProperty getAppPropertyById(Long id);
    public abstract List getMiscCodeListByCodeName(String codeName);
    public abstract MiscCode getMiscCodeByCodeKeyName(String codeName, String keyName);
    public abstract UploadedFile getUploadedFileById(Long id);
    public abstract void removeUploadedFile(UploadedFile val);
    public abstract void saveUploadedFile(UploadedFile val);
    public abstract void removeUploadedFile(Long id);
    public abstract Function getFunctionById(Long id);
    public abstract Function getFunctionByKey(String id);
    public abstract List getGroupList(); 
    public abstract List findFunctionListBySessionUser(SessionUser su);
    public abstract SessionUser getSessionUserByLoginIdAndPassword(String uid, String pwd);
    public abstract void exportExcel(String sql,String outFile);
    public abstract void executeSQL(String sql);
    public abstract void sendEmail(String email,String subject,String content);
}
