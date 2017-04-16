<%@ include file="/common/taglibs.jsp"%>

<ww:form name="senderDBForm" action="saveSenderDB" method="POST">
  <ww:hidden name="senderDB.id" value="${senderDB.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="senderDB.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="senderDB.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="senderDB.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="senderDB.sender"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="senderDB.sender" value="%{senderDB.sender}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('senderDB.sender')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="senderDB.senderPhone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="senderDB.senderPhone" value="%{senderDB.senderPhone}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('senderDB.senderPhone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="senderDB.senderAddress"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="senderDB.senderAddress" value="%{senderDB.senderAddress}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('senderDB.senderAddress')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="senderDB.senderMemo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="senderDB.senderMemo" value="%{senderDB.senderMemo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="senderDB.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="senderDB.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
