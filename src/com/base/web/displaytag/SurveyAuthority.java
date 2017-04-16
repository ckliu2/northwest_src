package com.base.web.displaytag;

import java.util.List;

import javax.servlet.jsp.PageContext;
import org.displaytag.properties.MediaTypeEnum;

import com.base.value.MiscCode;

public class SurveyAuthority extends CommonColumnDecorator
{

    public SurveyAuthority()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
 
        if (columnValue instanceof List) {        	
            List al = (List) columnValue;    
            
            System.out.println("SurveyAuthority al.size()="+al.size());
            
            if (al.size() == 0){
            	return getText("survey.noauthority");
            }                
        }         
        return columnValue;
    }
}
