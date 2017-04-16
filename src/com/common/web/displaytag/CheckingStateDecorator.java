package com.common.web.displaytag;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

import com.base.web.displaytag.CommonColumnDecorator;
import com.common.value.CheckingState;

public class CheckingStateDecorator extends CommonColumnDecorator
{

    public CheckingStateDecorator()
    {
        super();
    }

    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue instanceof String) {
            String b = (String) columnValue;
            return CheckingState.getStateLabel(b);
        }
        return columnValue;
    }

}
