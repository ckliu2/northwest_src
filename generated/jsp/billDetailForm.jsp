<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billDetailForm" action="saveBillDetail" method="POST">
  <ww:hidden name="billDetail.id" value="${billDetail.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billDetail.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="billDetail.fromRow"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.fromRow" value="%{billDetail.fromRow}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.fromRow')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.price"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.price" value="%{billDetail.price}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.price')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.width"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.width" value="%{billDetail.width}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.width')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.heigh"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.heigh" value="%{billDetail.heigh}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.heigh')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.visibleWidth"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.visibleWidth" value="%{billDetail.visibleWidth}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.visibleWidth')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.visibleHeigh"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.visibleHeigh" value="%{billDetail.visibleHeigh}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.visibleHeigh')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.calcArea"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.calcArea" value="%{billDetail.calcArea}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.calcArea')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.area"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.area" value="%{billDetail.area}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.area')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.quantity"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.quantity" value="%{billDetail.quantity}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.quantity')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.basicQuantity"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.basicQuantity" value="%{billDetail.basicQuantity}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.basicQuantity')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.detail"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.detail" value="%{billDetail.detail}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.itemRemark"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.itemRemark" value="%{billDetail.itemRemark}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.paperPrice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.paperPrice" value="%{billDetail.paperPrice}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.paperPrice')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.amount"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.amount" value="%{billDetail.amount}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billDetail.amount')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.complete"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.complete" value="%{billDetail.complete}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.uncomplete"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billDetail.uncomplete" value="%{billDetail.uncomplete}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.product"/></td>
        <td class="cInputColumn">
            <ww:select name="billDetail.productId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="productList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billDetail.bill"/></td>
        <td class="cInputColumn">
            <ww:select name="billDetail.billId" 
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
            <ww:if test="billDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
