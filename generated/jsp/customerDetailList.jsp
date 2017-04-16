<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="customerDetail.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editCustomerDetail.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="customerDetailList.size()"/>, 'selectedCustomerDetailId', 'copyCustomerDetail.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editCustomerDetail.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="customerDetailList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedCustomerDetailId_<c:out value="${count}"/>" name="selectedCustomerDetailId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="id" sortable="true" titleKey="common.id"/>
    <display:column property="counterNo" sortable="true" titleKey="customerDetail.counterNo" style="text-align:left" />
    <display:column property="counter" sortable="true" titleKey="customerDetail.counter" style="text-align:left" />
    <display:column property="contacts" sortable="true" titleKey="customerDetail.contacts" style="text-align:left" />
    <display:column property="screenPosition" sortable="true" titleKey="customerDetail.screenPosition" style="text-align:left" />
    <display:column property="location" sortable="true" titleKey="customerDetail.location" style="text-align:left" />
    <display:column property="counterPhone" sortable="true" titleKey="customerDetail.counterPhone" style="text-align:left" />
    <display:column property="planmap.caption_" sortable="true" titleKey="customerDetail.planmap" style="text-align:left"/>
    <display:column property="photo1.caption_" sortable="true" titleKey="customerDetail.photo1" style="text-align:left"/>
    <display:column property="photo2.caption_" sortable="true" titleKey="customerDetail.photo2" style="text-align:left"/>
    <display:column property="photo3.caption_" sortable="true" titleKey="customerDetail.photo3" style="text-align:left"/>
    <display:column property="photo4.caption_" sortable="true" titleKey="customerDetail.photo4" style="text-align:left"/>
    <display:column property="photo5.caption_" sortable="true" titleKey="customerDetail.photo5" style="text-align:left"/>
    <display:column property="customerService.caption_" sortable="true" titleKey="customerDetail.customerService" style="text-align:left"/>
    <display:column property="customer.caption_" sortable="true" titleKey="customerDetail.customer" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editCustomerDetail.html?customerDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'customerDetail.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editCustomerDetail.html?customerDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editCustomerDetail.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="customerDetailList.size()"/>, 'selectedCustomerDetailId', 'copyCustomerDetail.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editCustomerDetail.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveCustomerDetail.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="customerDetail.id" value="">
    <select name="selectedCustomerDetailIds" multiple="true" style="display:none"></select>
</form>
