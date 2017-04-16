package com.common.web.action;

import com.base.value.AppProperty;
import com.common.service.CommonManager;

import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AppPropertyAction extends CommonActionSupport
{
    private static final long serialVersionUID = 100L;
    private final Log log;

    private AppProperty appProperty;
    private String propertyKind;
    private String propertyKindName;

    public AppPropertyAction()
    {
        log = LogFactory.getLog(com.common.web.action.AppPropertyAction.class);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public String delete()
    {
        getGenericManager().removeAppProperty(appProperty.getId());
        setPropertyKind(appProperty.getKind());
        return DELETE;
    }

    public String edit()
    {
        if(appProperty != null && appProperty.getId() != null) {
            appProperty = getGenericManager().getAppPropertyById(appProperty.getId());
            setPropertyKind(appProperty.getKind());
        } else {
            appProperty = new AppProperty();
            appProperty.setSeqNo(getNextSeqNoOfAppPropertyByKind(propertyKind));
            appProperty.setKind(propertyKind);
            setPropertyKind(propertyKind);
        }

        return SUCCESS; 
    }
    
    private int getNextSeqNoOfAppPropertyByKind(String kind)
    {
        int no = 1;
        List lst = getGenericManager().getMaxSeqNoOfAppPropertyByKind(kind);
        if (lst != null && lst.size() > 0 && lst.get(0) != null) {
            no = ((Integer) lst.get(0)).intValue() + 1;
        }
        
        return no;
    }
    
    public String list()
    {
        if (propertyKind != null && propertyKind.length() > 0) {
            setPropertyKind(propertyKind);
        }
        return SUCCESS;
    }

    public String execute()
    {
        System.out.println("entering 'execute' method");
        if(getDelete() != null)
            return delete();
        else {
            if(appProperty != null) {
                if (appProperty.getId() != null) {
                    appProperty = getGenericManager().getAppPropertyById(appProperty.getId());
                }
                setPropertyKind(appProperty.getKind());
            } else {
                appProperty = new AppProperty();
                appProperty.setSeqNo(getNextSeqNoOfAppPropertyByKind(propertyKind));
                appProperty.setKind(propertyKind);
                setPropertyKind(propertyKind);
            }
            return SUCCESS;
        }
    }

    public String save()
    {
        System.out.println("entering 'save' method");

        getGenericManager().saveAppProperty(appProperty);
        setPropertyKind(appProperty.getKind());
        return SUCCESS;
    }

    public AppProperty getAppProperty()
    {
        return appProperty;
    }

    public void setAppProperty(AppProperty appProperty)
    {
        this.appProperty = appProperty;
    }

    public Map getAppPropertyList()
    {
        LinkedHashMap lhp = new LinkedHashMap();
        List al = getGenericManager().getAppPropertyList();
        for (int i=0; i < al.size(); i++) {
            String kind = (String) al.get(i);
            lhp.put(kind, getText("appProperty." + kind));
        }
        return lhp;
    }

    public List getAppPropertyValueList()
    {
        if (getPropertyKind() != null && getPropertyKind().length() > 0)
            return getGenericManager().getAppPropertyList(getPropertyKind());
        return new ArrayList();
    }

    public String getPropertyKind()
    {
        return propertyKind;
    }

    public void setPropertyKind(String propertyKind)
    {
        this.propertyKind = propertyKind;
        if (this.propertyKind != null && this.propertyKind.length() > 0)
            propertyKindName = getText("appProperty." + this.propertyKind);
    }

    public String getPropertyKindName()
    {
        return propertyKindName; 
    }
}