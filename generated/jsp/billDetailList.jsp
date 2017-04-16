<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="billDetail.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBillDetail.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="billDetailList.size()"/>, 'selectedBillDetailId', 'copyBillDetail.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBillDetail.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="billDetailList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBillDetailId_<c:out value="${count}"/>" name="selectedBillDetailId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="fromRow" sortable="true" titleKey="billDetail.fromRow" />
    <display:column property="price" sortable="true" titleKey="billDetail.price" />
    <display:column property="width" sortable="true" titleKey="billDetail.width" />
    <display:column property="heigh" sortable="true" titleKey="billDetail.heigh" />
    <display:column property="visibleWidth" sortable="true" titleKey="billDetail.visibleWidth" />
    <display:column property="visibleHeigh" sortable="true" titleKey="billDetail.visibleHeigh" />
    <display:column property="calcArea" sortable="true" titleKey="billDetail.calcArea" />
    <display:column property="area" sortable="true" titleKey="billDetail.area" />
    <display:column property="quantity" sortable="true" titleKey="billDetail.quantity" />
    <display:column property="basicQuantity" sortable="true" titleKey="billDetail.basicQuantity" />
    <display:column property="detail" sortable="true" titleKey="billDetail.detail" style="text-align:left" />
    <display:column property="itemRemark" sortable="true" titleKey="billDetail.itemRemark" style="text-align:left" />
    <display:column property="paperPrice" sortable="true" titleKey="billDetail.paperPrice" />
    <display:column property="amount" sortable="true" titleKey="billDetail.amount" />
    <display:column property="complete" sortable="true" titleKey="billDetail.complete" style="text-align:left" />
    <display:column property="uncomplete" sortable="true" titleKey="billDetail.uncomplete" style="text-align:left" />
    <display:column property="product.caption_" sortable="true" titleKey="billDetail.product" style="text-align:left"/>
    <display:column property="bill.caption_" sortable="true" titleKey="billDetail.bill" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBillDetail.html?billDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'billDetail.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBillDetail.html?billDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBillDetail.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="billDetailList.size()"/>, 'selectedBillDetailId', 'copyBillDetail.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBillDetail.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBillDetail.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="billDetail.id" value="">
    <select name="selectedBillDetailIds" multiple="true" style="display:none"></select>
</form>
