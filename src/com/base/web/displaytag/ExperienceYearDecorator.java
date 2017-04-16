package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

public class ExperienceYearDecorator extends CommonColumnDecorator
{

    public ExperienceYearDecorator()
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
            if (b.intValue() <= 1) {
                s = getText("common.experience.none");
            } else {
                s = "" + (b.intValue()-1) + getText("common.experience.year");
            }
        } else {
            return "";
        }
        
        return s;
    }
}
