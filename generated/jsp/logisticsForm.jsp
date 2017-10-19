<%@ include file="/common/taglibs.jsp"%>

<ww:form name="logisticsForm" action="saveLogistics" method="POST">
  <ww:hidden name="logistics.id" value="${logistics.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="logistics.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="logistics.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="logistics.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="logistics.freight"/></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.freight" value="%{logistics.freight}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.code"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.code" value="%{logistics.code}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.code')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.otherBills"/></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.otherBills" value="%{logistics.otherBills}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.sender"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.sender" value="%{logistics.sender}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.sender')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.senderPhone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.senderPhone" value="%{logistics.senderPhone}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.senderPhone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.senderAddress"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.senderAddress" value="%{logistics.senderAddress}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.senderAddress')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.senderMemo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.senderMemo" value="%{logistics.senderMemo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.recipient"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.recipient" value="%{logistics.recipient}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.recipient')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.recipientPhone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.recipientPhone" value="%{logistics.recipientPhone}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.recipientPhone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.recipientAddress"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.recipientAddress" value="%{logistics.recipientAddress}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.recipientAddress')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.serviceDate"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="serviceDate" id="serviceDate" value="%{serviceDate}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('serviceDate')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.memo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="logistics.memo" value="%{logistics.memo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="logistics.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="logistics.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.freightCompany"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="logistics.freightCompanyId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="freightCompanyList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.freightCompanyId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.bill"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="logistics.billId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="billList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.billId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.member"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="logistics.memberId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="memberList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.memberId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="logistics.time"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="logistics.timeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="timeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('logistics.timeId')"/></span>
        </td>
    </tr>


    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="logistics.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="logistics.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
