<%@ include file="/common/unsecureTaglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="ordBillSub.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editOrdBillSub.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="ordBillSubList.size()"/>, 'selectedOrdBillSubId', 'copyOrdBillSub.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editOrdBillSub.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="ordBillSubList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedOrdBillSubId_<c:out value="${count}"/>" name="selectedOrdBillSubId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="flag" sortable="true" titleKey="ordBillSub.flag" />
    <display:column property="rowNO" sortable="true" titleKey="ordBillSub.rowNO" />
    <display:column property="width" sortable="true" titleKey="ordBillSub.width" />
    <display:column property="heigh" sortable="true" titleKey="ordBillSub.heigh" />
    <display:column property="vwidth" sortable="true" titleKey="ordBillSub.vwidth" />
    <display:column property="vheigh" sortable="true" titleKey="ordBillSub.vheigh" />
    <display:column property="calcDisp" sortable="true" titleKey="ordBillSub.calcDisp" style="text-align:left" />
    <display:column property="calcArea" sortable="true" titleKey="ordBillSub.calcArea" />
    <display:column property="paperPrice" sortable="true" titleKey="ordBillSub.paperPrice" />
    <display:column property="paperCount" sortable="true" titleKey="ordBillSub.paperCount" />
    <display:column property="sprice" sortable="true" titleKey="ordBillSub.sprice" />
    <display:column property="amount" sortable="true" titleKey="ordBillSub.amount" />
    <display:column property="squantity" sortable="true" titleKey="ordBillSub.squantity" />
    <display:column property="quantity" sortable="true" titleKey="ordBillSub.quantity" />
    <display:column property="equantity" sortable="true" titleKey="ordBillSub.equantity" />
    <display:column property="preInDate" sortable="true" titleKey="ordBillSub.preInDate" style="text-align:left" />
    <display:column property="isGift" sortable="true" titleKey="ordBillSub.isGift" style="text-align:left" />
    <display:column property="qtyRemain" sortable="true" titleKey="ordBillSub.qtyRemain" />
    <display:column property="detail" sortable="true" titleKey="ordBillSub.detail" style="text-align:left" />
    <display:column property="itemRemark" sortable="true" titleKey="ordBillSub.itemRemark" style="text-align:left" />
    <display:column property="orderBill.caption_" sortable="true" titleKey="ordBillSub.orderBill" style="text-align:left"/>
    <display:column property="product.caption_" sortable="true" titleKey="ordBillSub.product" style="text-align:left"/>
    <display:column property="crement.caption_" sortable="true" titleKey="ordBillSub.crement" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editOrdBillSub.html?ordBillSub.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'ordBillSub.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editOrdBillSub.html?ordBillSub.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editOrdBillSub.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="ordBillSubList.size()"/>, 'selectedOrdBillSubId', 'copyOrdBillSub.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editOrdBillSub.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveOrdBillSub.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="ordBillSub.id" value="">
    <select name="selectedOrdBillSubIds" multiple="true" style="display:none"></select>
</form>
