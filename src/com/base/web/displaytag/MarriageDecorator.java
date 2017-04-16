package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

public class MarriageDecorator extends CommonColumnDecorator
{

    public MarriageDecorator()
    {
        super();
    }

    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
        String s = "";
        if (columnValue instanceof Integer) {
            Integer b = (Integer) columnValue;
            switch (b.intValue()) {
                case 1:
                    s = getText("common.marriage.has");
                    break;
                case 2:
                    s = getText("common.marriage.never");
                    break;
                case 3:
                    s = getText("common.marriage.divorce");
                    break;
                case 4:
                    s = getText("common.marriage.separate");
                    break; 
                default:
                    return "";
            }
        } else {
            return "";
        }
        
        return s;
    }
}
