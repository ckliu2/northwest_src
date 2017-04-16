<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="profitDetail.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editProfitDetail.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="profitDetailList.size()"/>, 'selectedProfitDetailId', 'copyProfitDetail.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editProfitDetail.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="profitDetailList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedProfitDetailId_<c:out value="${count}"/>" name="selectedProfitDetailId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="salesNo" sortable="true" titleKey="profitDetail.salesNo" style="text-align:left" />
    <display:column property="item" sortable="true" titleKey="profitDetail.item" />
    <display:column property="rowNo" sortable="true" titleKey="profitDetail.rowNo" />
    <display:column property="salesDetail" sortable="true" titleKey="profitDetail.salesDetail" style="text-align:left" />
    <display:column property="salesItemMark" sortable="true" titleKey="profitDetail.salesItemMark" style="text-align:left" />
    <display:column property="salesPrice" sortable="true" titleKey="profitDetail.salesPrice" />
    <display:column property="salesCost" sortable="true" titleKey="profitDetail.salesCost" />
    <display:column property="buyNo" sortable="true" titleKey="profitDetail.buyNo" style="text-align:left" />
    <display:column property="company" sortable="true" titleKey="profitDetail.company" style="text-align:left" />
    <display:column property="purchasePrice" sortable="true" titleKey="profitDetail.purchasePrice" />
    <display:column property="purchaseDetail" sortable="true" titleKey="profitDetail.purchaseDetail" style="text-align:left" />
    <display:column property="purchaseItemMark" sortable="true" titleKey="profitDetail.purchaseItemMark" style="text-align:left" />
    <display:column property="purchaseRowNo" sortable="true" titleKey="profitDetail.purchaseRowNo" />
    <display:column property="discount" sortable="true" titleKey="profitDetail.discount" />
    <display:column property="profit" sortable="true" titleKey="profitDetail.profit" />
    <display:column property="profitPerc" sortable="true" titleKey="profitDetail.profitPerc" />
    <display:column property="billDate" sortable="true" titleKey="profitDetail.billDate" style="text-align:left" />
    <display:column property="descript" sortable="true" titleKey="profitDetail.descript" style="text-align:left" />
    <display:column property="standcost" sortable="true" titleKey="profitDetail.standcost" style="text-align:left" />
    <display:column property="unit1" sortable="true" titleKey="profitDetail.unit1" />
    <display:column property="unit2" sortable="true" titleKey="profitDetail.unit2" />
    <display:column property="unit3" sortable="true" titleKey="profitDetail.unit3" />
    <display:column property="productClass.caption_" sortable="true" titleKey="profitDetail.productClass" style="text-align:left"/>
    <display:column property="project.caption_" sortable="true" titleKey="profitDetail.project" style="text-align:left"/>
    <display:column property="product.caption_" sortable="true" titleKey="profitDetail.product" style="text-align:left"/>
    <display:column property="profitNo.caption_" sortable="true" titleKey="profitDetail.profitNo" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editProfitDetail.html?profitDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'profitDetail.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editProfitDetail.html?profitDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editProfitDetail.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="profitDetailList.size()"/>, 'selectedProfitDetailId', 'copyProfitDetail.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editProfitDetail.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveProfitDetail.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="profitDetail.id" value="">
    <select name="selectedProfitDetailIds" multiple="true" style="display:none"></select>
</form>
