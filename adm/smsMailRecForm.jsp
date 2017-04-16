<%@ include file="/common/taglibs.jsp"%>

<ww:form name="smsMailRecForm" action="saveSmsMailRec" method="POST">
  <ww:hidden name="smsMailRec.id" value="${smsMailRec.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="smsMailRec.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.cellphone"/></td>
        <td class="cInputColumn">
            <ww:property value="smsMailRec.cellphone"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.cellphone1"/></td>
        <td class="cInputColumn">
            <ww:property value="smsMailRec.cellphone1"/>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.email"/></td>
        <td class="cInputColumn">
            <ww:property value="smsMailRec.email"/>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.email1"/></td>
        <td class="cInputColumn">
            <ww:property value="smsMailRec.email1"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.msg"/></td>
        <td class="cInputColumn">
           <ww:property value="smsMailRec.msg"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.sendDate"/></td>
        <td class="cInputColumn">
            <ww:property value="smsMailRec.sendDate"/>     
         </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.target"/></td>
        <td class="cInputColumn">
               <ww:property value="smsMailRec.target"/>  
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.member"/></td>
        <td class="cInputColumn">
                  <ww:property value="smsMailRec.member"/>
        </td>
    </tr>


  </table>
</ww:form>
