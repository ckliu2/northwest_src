<%@ include file="/common/taglibs.jsp"%>

<ww:form name="weightsForm" action="saveWeights" method="POST">
  <ww:hidden name="weights.id" value="${weights.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="weights.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="weights.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="weights.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="weights.productClassWeight"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="weights.productClassWeight" value="%{weights.productClassWeight}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('weights.productClassWeight')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="weights.inkWeight"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="weights.inkWeight" value="%{weights.inkWeight}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('weights.inkWeight')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="weights.outputEquipment"/></td>
        <td class="cInputColumn">
            <ww:select name="weights.outputEquipmentId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="outputEquipmentList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="weights.productClasses"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="productClassesIds" 
               list="productClassesList"
               listKey="id"
               listValue="caption_"
               value = "%{productClassesIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="weights.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="weights.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
