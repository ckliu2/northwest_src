package com.common.mail;

import oliva.mail.MailBean;
import oliva.mail.NewMessage;

import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.HtmlEmail;
import com.common.mail.MailProperties;
public class MailHelper 
{
	static MailProperties m=new MailProperties();
	

    public static String sendSimpleMail(String to, String toName,  String subject, String msg) throws Exception
    {    
  
    	SimpleEmail mail = new SimpleEmail();  
        mail.setCharset("utf-8");
        mail.setFrom(m.LaborSender);
        mail.addTo(to, toName);
        mail.setSubject(subject);
        /*if (cc != null)
        	mail.addCc(cc);*/
        mail.setMsg(msg);
        mail.setSmtpPort(m.port);
        mail.setHostName(m.host);
        mail.setAuthentication(m.username, m.password);
        return mail.send();
    	
    }

    public static String sendHtmlMail( String to, String toName,  String subject, String msg) throws Exception
    {
       try{
    	HtmlEmail mail = new HtmlEmail();
        mail.setCharset("utf-8");       
        //mail.setFrom(m.LaborSender);
        mail.setFrom(m.LaborSender, toName);
        mail.addTo(to, toName);
        mail.setSubject(subject);
       /*if (cc != null)
        	mail.addCc(cc);*/        
        int index=0;
        while((index=msg.indexOf("\n"))!=-1){
        	msg=msg.substring(0,index)+"<BR>"+msg.substring(index+1);    
        }
        
        mail.setHtmlMsg("<html><body>" + msg + "</body></html>");
        //mail.setSSL(true);        
        mail.setSmtpPort(m.port);
        mail.setHostName(m.host);
        mail.setDebug(true);    
        mail.setAuthentication(m.username, m.password);
        
        /*
        mail.setHtmlMsg("<html><body>" + msg + "</body></html>");
        mail.setSmtpPort(m.port);
        mail.setHostName(m.host);
        mail.setAuthentication(m.username, m.password);  */
        
       
        
        return mail.send();
       }catch(Exception e){
    	   return "";
       }
    	
    }
    


}
