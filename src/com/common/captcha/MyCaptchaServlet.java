package com.common.captcha;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Security;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.smx.captcha.IBackgroundProducer;
import org.smx.captcha.Producer;
import org.smx.captcha.impl.FactorySimpleMathImpl;
import org.smx.captcha.impl.GridBackgroundProducer;

import campus.tool.util.Text;
import campus.tool.util.security.Util;

public class MyCaptchaServlet extends HttpServlet
{
	private static HashMap<String, Integer> captchaMap;
	
	public void init()throws ServletException 
	{
		if (captchaMap == null)
			captchaMap = new HashMap<String, Integer>();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		try {
			resp.setContentType("image/jpg");
			
			OutputStream os = resp.getOutputStream();
			Properties props = new Properties(); 
			props.put("format", "jpg");
			props.put("font", "Helvetica");
			props.put("fontsize", "40");
			props.put("min-width", "100");
			props.put("padding-x", "5");
			props.put("padding-y", "5");

			//Disable Bezier curve drawing
			props.put("curve", "false");

			FactorySimpleMathImpl solver=(FactorySimpleMathImpl)Producer.forName("org.smx.captcha.impl.FactorySimpleMathImpl");

			Properties instProps;
			instProps=new Properties();
			instProps.put("min","2");
			instProps.put("max","9");
			instProps.put("symbols","1");

			solver.setProperties(instProps);


			IBackgroundProducer backGrid =  new GridBackgroundProducer();
			Properties backProp=new Properties();
			backProp.put("background","cccccc");
			backProp.put("frequency","10");
			backGrid.setProperties(backProp);

			solver.setBackGroundImageProducer( backGrid );

			Producer.render(os, solver, props);

			//System.out.println("getLastWord="+solver.getLastWord());
			//System.out.println("solver solved ="+solver.getHashCode(solver.getLastWord()));

			//HttpSession session = req.getSession(true);
			//session.setAttribute("icaptcha" , );
			String uuid = req.getParameter("dd");
			int a = 0;
			try {
				a = Integer.parseInt(solver.getHashCode(solver.getLastWord()));
			} catch (Exception ex) {
				
			}
			//System.out.println(uuid + "=" + a);
			captchaMap.put(uuid, new Integer(a));

			os.flush();
			os.close();// *important* to ensure no more jsp output
			return; 	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String randomUUID()
	{
		String uuid = UUID.randomUUID().toString();
		System.out.println("MyCaptchaServlet randomUUID()==>uuid="+uuid);
		return Text.substitute(UUID.randomUUID().toString(), "-", "");
	}
	
	public static String getAndRemove(String uu)
	{
		Integer uuid = captchaMap.get(uu);
		captchaMap.remove(uu);
		//System.out.println("getAndRemove(" + uu + ")=>" + uuid);
		return Util.encrypt(""+uuid);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doGet(req, res);
	}
}
