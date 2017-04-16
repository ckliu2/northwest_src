package com.common.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.base.value.BaseObject;
import com.base.value.SessionUser;
import com.common.service.CommonManager;
import com.common.value.Member;
import com.opensymphony.webwork.config.Configuration;
import com.opensymphony.xwork.util.LocalizedTextUtil;

import java.util.*;
import com.base.value.Group;


public class LoginAction extends CommonActionSupport
{
    private static final long serialVersionUID = 100L;
    private final Log log;
 
    private String loginId;
    private String password;


    private String msg;  

    public LoginAction()
    {
        log = LogFactory.getLog(com.common.web.action.LoginAction.class);
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }
    
    public String logout()
    {
        log.info("entering 'logout' method");
        super.getSession().removeAttribute("user"); //.remove(AuthenticationInterceptor.USER);
        super.getSession().invalidate();
        log.info("exit 'logout' method");
        return SUCCESS;
    }
    public String save()
    {
        log.info("entering 'execute' method");

        return SUCCESS;
    }

    public String execute()    {        
    	
    	/*if(checkCaptcha()){  //�Ϥ�����    		
    		appendXworkParam("msg=1");
    		return INPUT;
    	}*/
    	//�h��y�t
    	/*BaseObject b=new BaseObject();
    	b.setLocale("en_US");*/
    	//LocalizedTextUtil.s
    	//LocalizedTextUtil.addLaborResourceBundle("en_US");
    	
    	
    	if(loginId==null||password==null){
            appendXworkParam("msg=2");
            return INPUT;
    	}
    	
        Member user =getGenericManager().getMemberByLoginIdAndPassword(loginId, password);  
        
        
        /**test*/
        String ip=getClientIP();
        System.out.println("IP="+ip+" loginId:"+ loginId +"___"+ password +"  user="+user);
       /**test*/       
   
        
        if (user == null) {
            //�p�G�䤣��o��user�n�J����
            System.out.println("�p�G�䤣��o��user�n�J����");
            appendXworkParam("msg=2");
            return INPUT;
        } else {    
        	System.out.println(user.getName()+" �n�J���\!!    getLocal()="+getLocal());
        	getSession().setAttribute("user", copyToSessionUser(user));    //���\�n�J            	
            
        	return SUCCESS;  
        } 
           
    }
    

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getLoginId()
    {
        return loginId;
    }

    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}