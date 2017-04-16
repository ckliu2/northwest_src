<%@ include file="/common/taglibs.jsp"%>

<ww:form name="orderBillForm" action="saveOrderBill" method="POST">
  <ww:hidden name="orderBill.id" value="${orderBill.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="orderBill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="orderBill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="orderBill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="orderBill.flag"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.flag" value="%{orderBill.flag}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('orderBill.flag')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.billNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.billNo" value="%{orderBill.billNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.billDate"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.billDate" value="%{orderBill.billDate}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.addressID"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.addressID" value="%{orderBill.addressID}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.zipCode"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.zipCode" value="%{orderBill.zipCode}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.custAddress"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.custAddress" value="%{orderBill.custAddress}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.linkMan"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.linkMan" value="%{orderBill.linkMan}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.linkManProf"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.linkManProf" value="%{orderBill.linkManProf}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.linkTelephone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.linkTelephone" value="%{orderBill.linkTelephone}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.detail"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.detail" value="%{orderBill.detail}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.projectName"/></td>
        <td class="cInputColumn">
            <ww:textfield name="orderBill.projectName" value="%{orderBill.projectName}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.project"/></td>
        <td class="cInputColumn">
            <ww:select name="orderBill.projectId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="projectList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.customer"/></td>
        <td class="cInputColumn">
            <ww:select name="orderBill.customerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="customerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.salesMan"/></td>
        <td class="cInputColumn">
            <ww:select name="orderBill.salesManId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="salesManList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="orderBill.maker"/></td>
        <td class="cInputColumn">
            <ww:select name="orderBill.makerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="makerList"
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
            <ww:if test="orderBill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="orderBill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
