package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

public class SexDecorator extends CommonColumnDecorator
{
    public SexDecorator()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
        if (columnValue instanceof Integer) {
            Integer b = (Integer) columnValue;
            if (b.intValue() == 1) {
                return getText("common.male");
            } else {
                return getText("common.female");
            }
        } else {
            return "";
        }
    }
}
