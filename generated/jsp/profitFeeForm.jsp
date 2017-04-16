<%@ include file="/common/taglibs.jsp"%>

<ww:form name="profitFeeForm" action="saveProfitFee" method="POST">
  <ww:hidden name="profitFee.id" value="${profitFee.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="profitFee.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="profitFee.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="profitFee.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="profitFee.billDate"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitFee.billDate" value="%{profitFee.billDate}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitFee.billDate')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitFee.localtotal"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitFee.localtotal" value="%{profitFee.localtotal}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitFee.localtotal')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitFee.localtax"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitFee.localtax" value="%{profitFee.localtax}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitFee.localtax')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitFee.sumfee"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitFee.sumfee" value="%{profitFee.sumfee}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitFee.sumfee')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitFee.bill"/></td>
        <td class="cInputColumn">
            <ww:select name="profitFee.billId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="billList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="profitFee.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="profitFee.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
