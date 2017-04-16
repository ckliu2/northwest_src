package com.common.mail;
import com.common.web.action.CommonActionSupport;

public class MailProperties  extends CommonActionSupport
{
	public String protocol = "smtp";
	public String host = getText("common.mail.host");
	public int port = 25;
	public String username = getText("common.mail.username");
	public String password = getText("common.mail.password");
	public String sslProtocol = "smtp";
	public int sslPort = 465;
	public String LaborSender = getText("common.mail.LaborSender");
	public String LaborSmsReceiver = "";
	public String shortMessage = "";
	public String htmlMessage =  "";
    
}
