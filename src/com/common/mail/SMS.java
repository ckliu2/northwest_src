package com.common.mail;

import java.sql.*;
import java.math.*;
import java.util.*;
import com.base.util.Tools;
import com.base.value.*;
import com.common.value.*;
import com.common.service.CommonManager;
import com.common.web.action.CommonActionSupport;

public class SMS extends CommonActionSupport
{
    private static String dbuser="schuser2";        //登入帳號
    private static String dbpsd="mark2aixujxu";           //登入密碼
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";  //驅動程式
    private static String dburl="jdbc:sqlserver://140.129.140.215:1433;DatabaseName=sms" ;    //連線
 

    
    
 //遠傳簡訊
  public static void FetSendMsg(String phone,String msg) {  	
     try{        
	      Class.forName(driver);
	      Connection conn = DriverManager.getConnection(dburl,dbuser,dbpsd);
    	  String sql="insert into SMSRequest(serial,target,corp_id,dr_flag,submit_date,deliver_date,language,message)values(?,?,?,?,?,?,?,?)";
		  PreparedStatement smt= conn.prepareStatement(sql);
		  String msgID=  Tools.md5( String.valueOf(Tools.getUniqueId()) + String.valueOf(Math.random()) );
		  smt.setString(1, msgID);
		  smt.setString(2, phone);		  
		  smt.setString(3, "01900200024172200123");
		  smt.setString(4, "0");
		  smt.setString(5, "20080101010100");		
		  smt.setString(6, "20080101010100");
		  smt.setString(7, "C");
		  smt.setString(8, msg);
		  smt.execute();
	      conn.close(); 
	      System.out.println("簡訊傳送=>phone="+phone+"/msg="+msg);
     }catch(Exception e){    	    
            System.out.println("簡訊傳送失敗!");	 
            System.out.println(e.toString());	 
      }	      
  } 
  
  /**大於70字分封*/
  public void sendShortMessage(String cellphone,String msg){
      try{ 
                  int len=msg.length();
                  int mylen=len;
                   //如果大於70字
                   if(len>70){
                   	int p=1;  //共需分幾份
                   	do{
                   	  len = len-70;
                   	  p++;
                       }while(len > 70);
                         System.out.println("p="+p);
                         
                         //分批寄送
                           for(int s=0;s<p;s++){
                           	String msg_cut="";                           	
                           	if(p==s+1){                              		                        	   
                           	    msg_cut=msg.substring(s*70,mylen);	                       	    
                           	}else{
                           	msg_cut=msg.substring(s * 70 , (s+1) * 70);                           	  
                                }                           	
                           	//System.out.println(s+":="+msg_cut);                                
                           	FetSendMsg(cellphone,XString(msg_cut));   //寄信
                          }                         
                         //分批寄送
                  }
                   //如果大於70字
                   else{
                	   FetSendMsg(cellphone,XString(msg));   //寄信
                       //System.out.println(msg);
                   }

	  }catch(Exception e){
               System.out.println("split() 失敗！");
          }  	
  }   
  /**大於70字分封*/  
  
  /**處理特殊字串*/
  public String XString(String txt){ 
 	 String xs="";
 	 try {
 		 String c=String.valueOf('"');
 		  xs=txt.replaceAll("0","O").replaceAll(c, "'").replaceAll("&", " and ");
 		   if(txt.length()==0) {			   
 			   xs="簡訊內容空白!";  
 		   }
 	 }catch (Exception e)  {      
 	      System.out.println("XString() fail! ");
 	 }
 	 return xs;
  }
  /**處理特殊字串*/ 
  
  public static void main(String[] args) {
  	System.out.println("sms...");
  	
  }
  
  

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            