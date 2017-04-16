package com.base.web.displaytag;

import java.text.DecimalFormat;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

public class ThousandsDecorator1 extends CommonColumnDecorator
{
    public ThousandsDecorator1()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
    	DecimalFormat df = new DecimalFormat("###,###"); 
    	
    	try {
    		String s=(String)(columnValue);
            int b1 = Integer.parseInt(s);           
            return df.format(b1);
		} catch (Exception e) {
			return "";
		}
        
        
        
       
    }
}
