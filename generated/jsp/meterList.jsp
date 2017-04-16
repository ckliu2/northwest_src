<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="meter.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editMeter.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="meterList.size()"/>, 'selectedMeterId', 'copyMeter.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editMeter.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="meterList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedMeterId_<c:out value="${count}"/>" name="selectedMeterId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="step1" sortable="true" titleKey="meter.step1" style="text-align:left" />
    <display:column property="step2" sortable="true" titleKey="meter.step2" style="text-align:left" />
    <display:column property="step3" sortable="true" titleKey="meter.step3" style="text-align:left" />
    <display:column property="step4" sortable="true" titleKey="meter.step4" style="text-align:left" />
    <display:column property="step5" sortable="true" titleKey="meter.step5" style="text-align:left" />
    <display:column property="step6" sortable="true" titleKey="meter.step6" style="text-align:left" />
    <display:column property="step7" sortable="true" titleKey="meter.step7" style="text-align:left" />
    <display:column property="step8" sortable="true" titleKey="meter.step8" style="text-align:left" />
    <display:column property="step9" sortable="true" titleKey="meter.step9" style="text-align:left" />
    <display:column property="step10" sortable="true" titleKey="meter.step10" style="text-align:left" />
    <display:column property="step11" sortable="true" titleKey="meter.step11" style="text-align:left" />
    <display:column property="step12" sortable="true" titleKey="meter.step12" style="text-align:left" />
    <display:column property="group1" sortable="true" titleKey="meter.group1" style="text-align:left" />
    <display:column property="group2" sortable="true" titleKey="meter.group2" style="text-align:left" />
    <display:column property="group3" sortable="true" titleKey="meter.group3" style="text-align:left" />
    <display:column property="group4" sortable="true" titleKey="meter.group4" style="text-align:left" />
    <display:column property="group5" sortable="true" titleKey="meter.group5" style="text-align:left" />
    <display:column property="group6" sortable="true" titleKey="meter.group6" style="text-align:left" />
    <display:column property="group7" sortable="true" titleKey="meter.group7" style="text-align:left" />
    <display:column property="group8" sortable="true" titleKey="meter.group8" style="text-align:left" />
    <display:column property="group9" sortable="true" titleKey="meter.group9" style="text-align:left" />
    <display:column property="group10" sortable="true" titleKey="meter.group10" style="text-align:left" />
    <display:column property="group11" sortable="true" titleKey="meter.group11" style="text-align:left" />
    <display:column property="group12" sortable="true" titleKey="meter.group12" style="text-align:left" />
    <display:column property="check1" sortable="true" titleKey="meter.check1" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check2" sortable="true" titleKey="meter.check2" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check3" sortable="true" titleKey="meter.check3" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check4" sortable="true" titleKey="meter.check4" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check5" sortable="true" titleKey="meter.check5" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check6" sortable="true" titleKey="meter.check6" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check7" sortable="true" titleKey="meter.check7" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check8" sortable="true" titleKey="meter.check8" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check9" sortable="true" titleKey="meter.check9" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check10" sortable="true" titleKey="meter.check10" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check11" sortable="true" titleKey="meter.check11" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check12" sortable="true" titleKey="meter.check12" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="schedule.caption_" sortable="true" titleKey="meter.schedule" style="text-align:left"/>
    <display:column property="billdetail.caption_" sortable="true" titleKey="meter.billdetail" style="text-align:left"/>
    <display:column property="bill.caption_" sortable="true" titleKey="meter.bill" style="text-align:left"/>
    <display:column property="product.caption_" sortable="true" titleKey="meter.product" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editMeter.html?meter.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'meter.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editMeter.html?meter.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editMeter.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="meterList.size()"/>, 'selectedMeterId', 'copyMeter.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editMeter.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveMeter.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="meter.id" value="">
    <select name="selectedMeterIds" multiple="true" style="display:none"></select>
</form>
