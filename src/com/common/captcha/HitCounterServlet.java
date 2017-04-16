package com.common.captcha;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

public class HitCounterServlet extends HttpServlet {
    
	private static int todate = getDate();
    private static int todayCount = 0;
    private static int totalCount = 0;
    private static int downloadCount = 0;
    private String filePath ="/inc/hitcount.properties";
   
    public void init()throws ServletException {
        
        filePath = getServletContext().getRealPath(filePath); 
        BufferedReader bR = null;
        try {
            bR = new BufferedReader(new FileReader(filePath));
            String todayCountStr = bR.readLine();
            if (todayCountStr != null)
            	todayCount = Integer.parseInt(todayCountStr);
            
            String totalCountStr = bR.readLine();
            if (totalCountStr != null)
            	totalCount = Integer.parseInt(totalCountStr);

            String downloadCountStr = bR.readLine();
            if (downloadCountStr != null)
            	downloadCount = Integer.parseInt(downloadCountStr);

            return;
        }
        catch (FileNotFoundException fNfE) {
            String error = "Couldn't find file " + filePath + ":\n" + fNfE.getMessage();
            System.err.println(error);
            log(error);
        }
        catch (IOException iOe) {
            String error = "Couldn't read file " + filePath + ":\n" + iOe.getMessage();
            System.err.println(error);
            log(error);
        }
        catch (NumberFormatException nFe) {
            String error = "Couldn't read file " + filePath + ":\n" + nFe.getMessage();
            System.err.println(error);
            log(error);
        }
        finally {
            try {
                if(bR !=null)
                    bR.close();
            }
            catch(IOException iOe) {
                String error = "Problem closing the bufferedReader stream to " + filePath + ":\n" + iOe.getMessage();
                System.err.println(error); 
                log(error);
            }
        }
    }
   
    //Increases the hitcount and saves to disk every 10th request
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {
        if (req.getParameter("f") != null) {
       		downloadCount++;
        	String filePath = getServletContext().getInitParameter("downloadFilePath");
        	RequestDispatcher rd = getServletContext().getRequestDispatcher(filePath);
        	res.setContentType("application/pdf");
        	rd.forward(req, res);
        } else {
        	//request.getSession(true) will return the current session if one exists, if one doesn't exits a new one will be created. 
        	//if you use request.getSession(false), it will return the current session if one exists and if one DOES NOT exist a new one will NOT be cretaed. 
        	//HttpSession session = req.getSession(false); 
        	//if (session == null) {
	        //	session = req.getSession(true);
	        //	session.setAttribute("guest", "user");
            int localCount;
	        if (req.getParameter("inc") != null && req.getParameter("inc").equals("1") == true) {
	            synchronized(this) {
	            	todayCount++;
	                localCount = ++totalCount;
	                if(localCount % 10 == 0) {
	                    saveCount();
	                }
                    int d = getDate();
                    if (todate != d) {
                    	todayCount = 1;
                    	todate = d;
                    }
	            }
	        }
        	//}
            PrintWriter out = res.getWriter();
            res.setContentType("text/plain");
        	out.println(todayCount + "|" + totalCount + "|" + downloadCount);
        }
    }
    
    private static int getDate()
    {
    	Calendar d = Calendar.getInstance();
    	return d.get(Calendar.DATE);
    }
    public void destroy() {
        
        saveCount();
    }
    
    //Creates a file and writes the new hit count as a string
    public void saveCount() {
        
        PrintWriter pW = null;
        try {
            pW = new PrintWriter(new FileWriter(filePath));
            pW.println(todayCount);
            pW.println(totalCount);
            pW.println(downloadCount);
            return;
        }
        catch(IOException iOe) { 
            String error = "Couln't write to " + filePath + ":\n" + iOe.getMessage();
            System.err.println(error);
            log(error);
        }
       
        finally {
            try {    
                if(pW != null) {
                    pW.close();
                }
            }
            catch(Exception e) {
                String error = "Problem closing the PrintWriter stream to " + filePath + ":\n" + e.getMessage();
                System.err.println(error);
                log(error);
            }
        }
    }
}