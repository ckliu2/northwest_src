<%@ include file="/common/taglibs.jsp"%>

<ww:form name="profitDetailForm" action="saveProfitDetail" method="POST">
  <ww:hidden name="profitDetail.id" value="${profitDetail.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="profitDetail.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="profitDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="profitDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="profitDetail.salesNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.salesNo" value="%{profitDetail.salesNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.item"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.item" value="%{profitDetail.item}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.item')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.rowNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.rowNo" value="%{profitDetail.rowNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.rowNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.salesDetail"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.salesDetail" value="%{profitDetail.salesDetail}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.salesItemMark"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.salesItemMark" value="%{profitDetail.salesItemMark}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.salesPrice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.salesPrice" value="%{profitDetail.salesPrice}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.salesPrice')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.salesCost"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.salesCost" value="%{profitDetail.salesCost}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.salesCost')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.buyNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.buyNo" value="%{profitDetail.buyNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.company"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.company" value="%{profitDetail.company}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.purchasePrice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.purchasePrice" value="%{profitDetail.purchasePrice}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.purchasePrice')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.purchaseDetail"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.purchaseDetail" value="%{profitDetail.purchaseDetail}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.purchaseItemMark"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.purchaseItemMark" value="%{profitDetail.purchaseItemMark}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.purchaseRowNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.purchaseRowNo" value="%{profitDetail.purchaseRowNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.purchaseRowNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.discount"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.discount" value="%{profitDetail.discount}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.discount')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.profit"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.profit" value="%{profitDetail.profit}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.profit')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.profitPerc"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.profitPerc" value="%{profitDetail.profitPerc}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.profitPerc')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.billDate"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.billDate" value="%{profitDetail.billDate}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.descript"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.descript" value="%{profitDetail.descript}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.standcost"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="profitDetail.standcost" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.unit1"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.unit1" value="%{profitDetail.unit1}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.unit1')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.unit2"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.unit2" value="%{profitDetail.unit2}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.unit2')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.unit3"/></td>
        <td class="cInputColumn">
            <ww:textfield name="profitDetail.unit3" value="%{profitDetail.unit3}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('profitDetail.unit3')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.productClass"/></td>
        <td class="cInputColumn">
            <ww:select name="profitDetail.productClassId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="productClassList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.project"/></td>
        <td class="cInputColumn">
            <ww:select name="profitDetail.projectId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="projectList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.product"/></td>
        <td class="cInputColumn">
            <ww:select name="profitDetail.productId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="productList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="profitDetail.profitNo"/></td>
        <td class="cInputColumn">
            <ww:select name="profitDetail.profitNoId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="profitNoList"
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
            <ww:if test="profitDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="profitDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
