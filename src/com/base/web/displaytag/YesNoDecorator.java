package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;
import org.displaytag.properties.MediaTypeEnum;

public class YesNoDecorator extends CommonColumnDecorator
{

    public YesNoDecorator()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
        if (columnValue instanceof Boolean) {
            Boolean b = (Boolean) columnValue;
            if (b.booleanValue() == true) {
                return getText("common.yes");
            } else {
                return getText("common.no");
            }
        } else if (columnValue instanceof Integer) {
            Integer b = (Integer) columnValue;
            if (b.intValue() == 1) {
                return getText("common.yes");
            } else {
                return getText("common.no");
            }
        } else {
            return "";
        }
    }
}
