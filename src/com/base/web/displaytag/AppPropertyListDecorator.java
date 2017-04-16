package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;
import java.util.*;

import com.base.value.AppProperty;

import org.displaytag.properties.MediaTypeEnum;

public class AppPropertyListDecorator extends CommonColumnDecorator
{

    public AppPropertyListDecorator()
    {
        super();
    }

    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null) 
            return "";
        
        StringBuffer sb = new StringBuffer();
        if (columnValue instanceof List) {
            List al = (List) columnValue;
            for(int i=0; al != null && i < al.size(); i++) {
                AppProperty ap = (AppProperty) al.get(i);
                sb.append(ap.getValue() + ",");
            }
            if (sb.toString().length() > 0)
                return sb.toString().substring(0,sb.toString().length() - 1);
        } else {
            return "";
        }
        
        return "";
    }
}
