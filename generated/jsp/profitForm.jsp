<%@ include file="/common/taglibs.jsp"%>

<ww:form name="profitForm" action="saveProfit" method="POST">
  <ww:hidden name="profit.id" value="${profit.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="profit.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="profit.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="profit.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="profit.projectNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.projectNo" value="%{profit.projectNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.projectName"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.projectName" value="%{profit.projectName}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.billNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.billNo" value="%{profit.billNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.salesNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.salesNo" value="%{profit.salesNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.salesPrice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.salesPrice" value="%{profit.salesPrice}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profit.salesPrice')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.salesCost"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.salesCost" value="%{profit.salesCost}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profit.salesCost')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.purchase"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.purchase" value="%{profit.purchase}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profit.purchase')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.profit"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.profit" value="%{profit.profit}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profit.profit')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.discount"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.discount" value="%{profit.discount}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profit.discount')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.recdiscount"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.recdiscount" value="%{profit.recdiscount}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profit.recdiscount')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.profitPerc"/></td>
        <td class="cInputColumn">
null
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.billDate"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.billDate" value="%{profit.billDate}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.remark"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profit.remark" value="%{profit.remark}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.standcost"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="profit.standcost" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.customer"/></td>
        <td class="cInputColumn">
            <ww:select name="profit.customerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="customerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profit.salesmen"/></td>
        <td class="cInputColumn">
            <ww:select name="profit.salesmenId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="salesmenList"
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
            <ww:if test="profit.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="profit.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
