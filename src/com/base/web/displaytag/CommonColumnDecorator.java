package com.base.web.displaytag;

import java.util.Locale;

import org.displaytag.decorator.DisplaytagColumnDecorator ;
import javax.servlet.jsp.PageContext;
import org.displaytag.properties.MediaTypeEnum;

import com.opensymphony.xwork.util.LocalizedTextUtil;


public class CommonColumnDecorator implements DisplaytagColumnDecorator
{

    public CommonColumnDecorator()
    {
        super();
    }

    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {    
        return null;  
    }   

    
    public String getText(String keyStr)
    {
        return LocalizedTextUtil.findText(CommonColumnDecorator.class, keyStr, Locale.TRADITIONAL_CHINESE);
    }
}