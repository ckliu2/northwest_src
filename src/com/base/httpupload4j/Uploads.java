package com.base.httpupload4j;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.jsp.PageContext;
import com.base.httpupload4j.SmartUpload;


public class Uploads {

	
	public static String fileUpload(SmartUpload su,PageContext pageContext) throws Exception {
	    com.base.httpupload4j.File suFile = null;
	    int fileCount = 0;
	    System.out.println("Uploads.fileUpload()..");
	    try {
	        
	    	String userId = su.getRequest().getParameter("user_id");
	    	String passId = su.getRequest().getParameter("pass_id");
	    	

	        String fileExt = "";
	        int fileSize = 0;
	        String AllowedExtensions = ",jpg,jpeg,gif,";
	        double maxFileSize = 1.5*1024;
	     
	        for (int i=0; i<su.getFiles().getCount();i++) {
	            suFile = su.getFiles().getFile(i);
	            if (suFile.isMissing())
	                continue;
	          
	            fileSize = suFile.getSize()/1024;
	            if(fileSize==0) fileSize=1;
	            if(maxFileSize<fileSize) throw new Exception(""+maxFileSize+"KB]");
	
	           
	            if (suFile.getFileExt() == null
	                    || "".equals(suFile.getFileExt())) {
	                fileExt = ",,";
	            } else {
	                fileExt = "," + suFile.getFileExt().toLowerCase() + ",";
	            }
	            if (!"".equals(AllowedExtensions)
	                    && AllowedExtensions.indexOf(fileExt) == -1) {
	                throw new Exception("" + suFile.getFileName() + "");
	            }
	            fileCount++;
	        }
	        if (fileCount==0) throw new Exception("");
	        String filePath="D:\\eclipse_project\\workspace\\PROJECT_swfupload\\swfupload\\p\\tmp\\";
	        for (int i=0; i<su.getFiles().getCount();i++) {
	            suFile = su.getFiles().getFile(i);
	            suFile.saveAs(filePath+suFile.getFileName(),SmartUpload.SAVE_PHYSICAL);
	        }
	   
	        return null;
	    } finally {
	    	System.out.print("Uploads.fileUpload.finally");
	    }
	    
	}
	
}
