<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="profit.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editProfit.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="profitList.size()"/>, 'selectedProfitId', 'copyProfit.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editProfit.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="profitList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedProfitId_<c:out value="${count}"/>" name="selectedProfitId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="projectNo" sortable="true" titleKey="profit.projectNo" style="text-align:left" />
    <display:column property="projectName" sortable="true" titleKey="profit.projectName" style="text-align:left" />
    <display:column property="billNo" sortable="true" titleKey="profit.billNo" style="text-align:left" />
    <display:column property="salesNo" sortable="true" titleKey="profit.salesNo" style="text-align:left" />
    <display:column property="salesPrice" sortable="true" titleKey="profit.salesPrice" />
    <display:column property="salesCost" sortable="true" titleKey="profit.salesCost" />
    <display:column property="purchase" sortable="true" titleKey="profit.purchase" />
    <display:column property="profit" sortable="true" titleKey="profit.profit" />
    <display:column property="discount" sortable="true" titleKey="profit.discount" />
    <display:column property="recdiscount" sortable="true" titleKey="profit.recdiscount" />
    <display:column property="profitPerc.caption_" sortable="true" titleKey="profit.profitPerc" style="text-align:left"/>
    <display:column property="billDate" sortable="true" titleKey="profit.billDate" style="text-align:left" />
    <display:column property="remark" sortable="true" titleKey="profit.remark" style="text-align:left" />
    <display:column property="standcost" sortable="true" titleKey="profit.standcost" style="text-align:left" />
    <display:column property="customer.caption_" sortable="true" titleKey="profit.customer" style="text-align:left"/>
    <display:column property="salesmen.caption_" sortable="true" titleKey="profit.salesmen" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editProfit.html?profit.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'profit.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editProfit.html?profit.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editProfit.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="profitList.size()"/>, 'selectedProfitId', 'copyProfit.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editProfit.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveProfit.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="profit.id" value="">
    <select name="selectedProfitIds" multiple="true" style="display:none"></select>
</form>
