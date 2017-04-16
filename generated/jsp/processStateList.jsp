<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="processState.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editProcessState.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="processStateList.size()"/>, 'selectedProcessStateId', 'copyProcessState.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editProcessState.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="processStateList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedProcessStateId_<c:out value="${count}"/>" name="selectedProcessStateId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="step1" sortable="true" titleKey="processState.step1" style="text-align:left" />
    <display:column property="step2" sortable="true" titleKey="processState.step2" style="text-align:left" />
    <display:column property="step3" sortable="true" titleKey="processState.step3" style="text-align:left" />
    <display:column property="step4" sortable="true" titleKey="processState.step4" style="text-align:left" />
    <display:column property="step5" sortable="true" titleKey="processState.step5" style="text-align:left" />
    <display:column property="step6" sortable="true" titleKey="processState.step6" style="text-align:left" />
    <display:column property="step7" sortable="true" titleKey="processState.step7" style="text-align:left" />
    <display:column property="step8" sortable="true" titleKey="processState.step8" style="text-align:left" />
    <display:column property="step9" sortable="true" titleKey="processState.step9" style="text-align:left" />
    <display:column property="step10" sortable="true" titleKey="processState.step10" style="text-align:left" />
    <display:column property="step11" sortable="true" titleKey="processState.step11" style="text-align:left" />
    <display:column property="step12" sortable="true" titleKey="processState.step12" style="text-align:left" />
    <display:column property="worker" sortable="true" titleKey="processState.worker" style="text-align:left" />
    <display:column property="bill.caption_" sortable="true" titleKey="processState.bill" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editProcessState.html?processState.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'processState.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editProcessState.html?processState.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editProcessState.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="processStateList.size()"/>, 'selectedProcessStateId', 'copyProcessState.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editProcessState.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveProcessState.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="processState.id" value="">
    <select name="selectedProcessStateIds" multiple="true" style="display:none"></select>
</form>
