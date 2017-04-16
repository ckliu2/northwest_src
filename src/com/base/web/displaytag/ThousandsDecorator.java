package com.base.web.displaytag;

import java.text.DecimalFormat;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

public class ThousandsDecorator extends CommonColumnDecorator
{
    public ThousandsDecorator()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
    	DecimalFormat df = new DecimalFormat("###,###"); 
    	
        if (columnValue == null){
            return "";
        }
        
        if (columnValue instanceof Integer) {
            Integer b = (Integer) columnValue;
            return df.format(b);
        } else {
            return "";
        }
    }
}
