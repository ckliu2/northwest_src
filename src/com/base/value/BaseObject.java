package com.base.value;

import java.io.Serializable;

public class BaseObject implements Serializable 
{
    private static final long serialVersionUID = 100L;
    private static String locale = null;
    //private static String locale = "en_US";
    public BaseObject() 
    {}
    public static String getLocale()
    {    	
    	return locale;
    }
    public static void setLocale(String l)
    {
        locale = l;
    }     
    
    public boolean isCh()
    {
        if (locale == null || "zh_TW".equals(locale)){
        	
        	//System.out.println("BaseObject isCh() getLocale()"+getLocale());
            return true;
        }
        //System.out.println("BaseObject is not Ch()");
        return false;
    }

    public boolean isEn()
    {
        if ("en_AU".equals(locale) || "en_US".equals(locale) || "en_UK".equals(locale)){
        	//System.out.println("BaseObject isEn()");
        	return true;
        }
        //System.out.println("BaseObject is not En()");
        return false;
    }

    public boolean isTw()
    {
        if (locale == null || "zh_TW".equals(locale)) {
        	//System.out.println("BaseObject isTw()");
            return true;
        }
        //System.out.println("BaseObject is not Tw()");
        return false;
    }

    public boolean isAu()
    {
        if ("en_AU".equals(locale)) {
        	System.out.println("BaseObject isAu()");
            return true;
        }
        System.out.println("BaseObject is not Au()");
        return false;
    }

    public boolean isUs()
    {
        if ("en_US".equals(locale)) {
        	System.out.println("BaseObject is isUs()");
            return true;
        }
        System.out.println("BaseObject is not isUs()");
        return false;
    }

    public boolean isUk()
    {
        if ("en_UK".equals(locale)) {
        	System.out.println("BaseObject is isUk()");
            return true;
        }
        System.out.println("BaseObject is not isUk()");
        return false;
    }

    public boolean isJp()
    {
        if ("ja_JP".equals(locale)) {
            return true;
        }
        
        return false;
    }

    public boolean isGe()
    {
        if ("de_DE".equals(locale)) {
            return true;
        }        
        return false;
    }
    

    public String getCaption_()
    {
        return toString();
    }
    

    
    public String getClassName()
    {
        return "BaseObject";
    }

}
