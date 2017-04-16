<%@ include file="/common/taglibs.jsp"%>

<ww:form name="ordBillSubForm" action="saveOrdBillSub" method="POST">
  <ww:hidden name="ordBillSub.id" value="${ordBillSub.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="ordBillSub.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="ordBillSub.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="ordBillSub.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.flag"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.flag" value="%{ordBillSub.flag}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.flag')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.rowNO"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.rowNO" value="%{ordBillSub.rowNO}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.rowNO')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.width"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.width" value="%{ordBillSub.width}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.width')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.heigh"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.heigh" value="%{ordBillSub.heigh}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.heigh')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.vwidth"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.vwidth" value="%{ordBillSub.vwidth}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.vwidth')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.vheigh"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.vheigh" value="%{ordBillSub.vheigh}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.vheigh')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.calcDisp"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.calcDisp" value="%{ordBillSub.calcDisp}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.calcArea"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.calcArea" value="%{ordBillSub.calcArea}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.calcArea')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.paperPrice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.paperPrice" value="%{ordBillSub.paperPrice}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.paperPrice')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.paperCount"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.paperCount" value="%{ordBillSub.paperCount}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.paperCount')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.sprice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.sprice" value="%{ordBillSub.sprice}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.sprice')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.amount"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.amount" value="%{ordBillSub.amount}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.amount')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.squantity"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.squantity" value="%{ordBillSub.squantity}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.squantity')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.quantity"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.quantity" value="%{ordBillSub.quantity}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.quantity')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.equantity"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.equantity" value="%{ordBillSub.equantity}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.equantity')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.preInDate"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.preInDate" value="%{ordBillSub.preInDate}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.isGift"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="ordBillSub.isGift" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.qtyRemain"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.qtyRemain" value="%{ordBillSub.qtyRemain}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('ordBillSub.qtyRemain')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.detail"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.detail" value="%{ordBillSub.detail}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.itemRemark"/></td>
        <td class="cInputColumn">
            <ww:textfield name="ordBillSub.itemRemark" value="%{ordBillSub.itemRemark}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.orderBill"/></td>
        <td class="cInputColumn">
            <ww:select name="ordBillSub.orderBillId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="orderBillList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.product"/></td>
        <td class="cInputColumn">
            <ww:select name="ordBillSub.productId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="productList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="ordBillSub.crement"/></td>
        <td class="cInputColumn">
            <ww:select name="ordBillSub.crementId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="crementList"
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
            <ww:if test="ordBillSub.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="ordBillSub.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
