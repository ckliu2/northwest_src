package com.base.web.displaytag;

import java.util.Locale;
import javax.servlet.jsp.PageContext;
import org.displaytag.properties.MediaTypeEnum;
import org.displaytag.decorator.TableDecorator ;
import com.opensymphony.xwork.util.LocalizedTextUtil;

public class CommonTableDecorator extends TableDecorator
{

    public CommonTableDecorator()
    {
        super();
    }

    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {    
        return null;  
    }
    
    public String getText(String keyStr)
    {
        return LocalizedTextUtil.findText(CommonTableDecorator.class, keyStr, Locale.TRADITIONAL_CHINESE);
    }

}
