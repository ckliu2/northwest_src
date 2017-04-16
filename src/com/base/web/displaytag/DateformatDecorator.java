package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;
import java.util.*;

import org.displaytag.properties.MediaTypeEnum;

public class DateformatDecorator extends CommonColumnDecorator
{
    public DateformatDecorator()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
        if (columnValue instanceof Date) {
        	Date b = (Date) columnValue;
        	System.out.println("year="+b.getYear()+"__date="+b.getDate()+"___Day="+b.getDay());
            String week="";
        	switch(b.getDay()){
              case 1:
              	week="(一)";
              break;	
              case 2:
                	week="(二)";
                break;
              case 3:
                	week="(三)";
                break;
              case 4:
                	week="(四)";
                break;
              case 5:
                	week="(五)";
                break;
              case 6:
                	week="(六)";
                break;
              case 0:
                	week="(主日)";
                break;
            }
        	/*if (b.intValue() == 1) {
                return getText("common.male");
            } else {
                return getText("common.female");
            }*/
        	String s=b.toString()+week;
        	return s;
        } else {
            return "";
        }
    }
}
