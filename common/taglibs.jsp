<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8" import="net.fckeditor.*" %>	
<%@ page language="java" errorPage="/error.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/webwork" prefix="ww" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Cache-control", "no-cache");
    response.setDateHeader("Expires", 0);

    response.setContentType("text/html;charset=UTF-8");

	com.common.util.Util.IMAGE_CONTEXT_ROOT_PATH = "/church";

	
//	java.io.File f = new java.io.File(request.getSession().getServletContext().getRealPath("/"));
//	String ff = f.getAbsolutePath();

   //System.out.println("........" + request.getSession().getServletContext().getServletContextName());     
   
      
    if (request.getSession().getAttribute("user") == null) 
    {
       // response.sendRedirect(com.common.util.Util.IMAGE_CONTEXT_ROOT_PATH );
    }
%>
<%
if (false) {
%>
<script language="JavaScript">
<!--
   // alert before session end
   var remainingseconds=<%= request.getSession().getMaxInactiveInterval()%>;
   var url = "${ctx}/common/timeout.jsp";
   var tid;
   var hWnd;
   var warn=0;

   function timeoutcheck () {
      remainingseconds=remainingseconds-1;
      if (remainingseconds>0) {
         tid=setTimeout("timeoutcheck()", 1*1000);
         if (remainingseconds<65) {
            if (remainingseconds>6) {
               window.defaultStatus="Session 時間 : 倒數 "+ (remainingseconds-5) +" 秒";
            } else if (remainingseconds>=5) {
               window.defaultStatus="Session 時間 : 倒數 "+ (remainingseconds-5) +" 秒";
            }
            if (!warn) {
               warn=1;
               
               hWnd = window.open(url,"_timeoutwarning","width=400,height=140,resizable=no,scrollbars=no");
               hWnd.focus();
            }
         }
      } else {
         window.defaultStatus="Session 時間結束";
         clearTimeout(tid);
      }
   }

   function sessioncheck () {
      if (remainingseconds>0) {
         return true;
      } else {
         alert("很抱歉, 您的作業階段已經逾時, 請重新登入");
         return false;
      }
   }

   timeoutcheck();
//-->
</script>
<% 
}
%>
