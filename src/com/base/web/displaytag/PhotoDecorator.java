package com.base.web.displaytag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.PageContext;
import org.displaytag.properties.MediaTypeEnum;
import com.base.value.*;




public class PhotoDecorator extends CommonColumnDecorator
{
    public PhotoDecorator()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {       	
    	if (columnValue == null) 
            return "";
    	       
    	List al = new ArrayList();
    	al.add(columnValue);    	
      
        if (al.size()>0) {
            System.out.println("PhotoDecorator() al.size()>0");            
            //Product product = (Product) al.get(0);
            //System.out.println( "al.get(0)="+al.get(0));           
            return getText("product.photo");
        } else {
            return "";
        }
        
      
    }
}
