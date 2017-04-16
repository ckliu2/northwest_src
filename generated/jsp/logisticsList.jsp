<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="logistics.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editLogistics.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="logisticsList.size()"/>, 'selectedLogisticsId', 'copyLogistics.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editLogistics.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="logisticsList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedLogisticsId_<c:out value="${count}"/>" name="selectedLogisticsId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="code" sortable="true" titleKey="logistics.code" style="text-align:left" />
    <display:column property="otherBills" sortable="true" titleKey="logistics.otherBills" style="text-align:left" />
    <display:column property="sender" sortable="true" titleKey="logistics.sender" style="text-align:left" />
    <display:column property="senderPhone" sortable="true" titleKey="logistics.senderPhone" style="text-align:left" />
    <display:column property="senderAddress" sortable="true" titleKey="logistics.senderAddress" style="text-align:left" />
    <display:column property="senderMemo" sortable="true" titleKey="logistics.senderMemo" style="text-align:left" />
    <display:column property="recipient" sortable="true" titleKey="logistics.recipient" style="text-align:left" />
    <display:column property="recipientPhone" sortable="true" titleKey="logistics.recipientPhone" style="text-align:left" />
    <display:column property="recipientAddress" sortable="true" titleKey="logistics.recipientAddress" style="text-align:left" />
    <display:column property="serviceDate" sortable="true" titleKey="logistics.serviceDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="bill.caption_" sortable="true" titleKey="logistics.bill" style="text-align:left"/>
    <display:column property="member.caption_" sortable="true" titleKey="logistics.member" style="text-align:left"/>
    <display:column property="time.caption_" sortable="true" titleKey="logistics.time" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editLogistics.html?logistics.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'logistics.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editLogistics.html?logistics.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editLogistics.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="logisticsList.size()"/>, 'selectedLogisticsId', 'copyLogistics.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editLogistics.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveLogistics.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="logistics.id" value="">
    <select name="selectedLogisticsIds" multiple="true" style="display:none"></select>
</form>
