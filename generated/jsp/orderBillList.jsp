<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="orderBill.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editOrderBill.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="orderBillList.size()"/>, 'selectedOrderBillId', 'copyOrderBill.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editOrderBill.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="orderBillList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedOrderBillId_<c:out value="${count}"/>" name="selectedOrderBillId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="flag" sortable="true" titleKey="orderBill.flag" />
    <display:column property="billNo" sortable="true" titleKey="orderBill.billNo" style="text-align:left" />
    <display:column property="billDate" sortable="true" titleKey="orderBill.billDate" style="text-align:left" />
    <display:column property="addressID" sortable="true" titleKey="orderBill.addressID" style="text-align:left" />
    <display:column property="zipCode" sortable="true" titleKey="orderBill.zipCode" style="text-align:left" />
    <display:column property="custAddress" sortable="true" titleKey="orderBill.custAddress" style="text-align:left" />
    <display:column property="linkMan" sortable="true" titleKey="orderBill.linkMan" style="text-align:left" />
    <display:column property="linkManProf" sortable="true" titleKey="orderBill.linkManProf" style="text-align:left" />
    <display:column property="linkTelephone" sortable="true" titleKey="orderBill.linkTelephone" style="text-align:left" />
    <display:column property="detail" sortable="true" titleKey="orderBill.detail" style="text-align:left" />
    <display:column property="projectName" sortable="true" titleKey="orderBill.projectName" style="text-align:left" />
    <display:column property="project.caption_" sortable="true" titleKey="orderBill.project" style="text-align:left"/>
    <display:column property="customer.caption_" sortable="true" titleKey="orderBill.customer" style="text-align:left"/>
    <display:column property="salesMan.caption_" sortable="true" titleKey="orderBill.salesMan" style="text-align:left"/>
    <display:column property="maker.caption_" sortable="true" titleKey="orderBill.maker" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editOrderBill.html?orderBill.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'orderBill.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editOrderBill.html?orderBill.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editOrderBill.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="orderBillList.size()"/>, 'selectedOrderBillId', 'copyOrderBill.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editOrderBill.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveOrderBill.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="orderBill.id" value="">
    <select name="selectedOrderBillIds" multiple="true" style="display:none"></select>
</form>
