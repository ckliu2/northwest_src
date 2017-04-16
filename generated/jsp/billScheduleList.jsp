<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="billSchedule.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBillSchedule.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="billScheduleList.size()"/>, 'selectedBillScheduleId', 'copyBillSchedule.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBillSchedule.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="billScheduleList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBillScheduleId_<c:out value="${count}"/>" name="selectedBillScheduleId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="fileName" sortable="true" titleKey="billSchedule.fileName" style="text-align:left" />
    <display:column property="outputDevice" sortable="true" titleKey="billSchedule.outputDevice" style="text-align:left" />
    <display:column property="outputTime" sortable="true" titleKey="billSchedule.outputTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="deliveryTime" sortable="true" titleKey="billSchedule.deliveryTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="isSendTime" sortable="true" titleKey="billSchedule.isSendTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="arrival" sortable="true" titleKey="billSchedule.arrival" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="freightNo" sortable="true" titleKey="billSchedule.freightNo" style="text-align:left" />
    <display:column property="costs" sortable="true" titleKey="billSchedule.costs" />
    <display:column property="uploadDrawingsTime" sortable="true" titleKey="billSchedule.uploadDrawingsTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="drawingsMemo" sortable="true" titleKey="billSchedule.drawingsMemo" style="text-align:left" />
    <display:column property="step1" sortable="true" titleKey="billSchedule.step1" style="text-align:left" />
    <display:column property="step2" sortable="true" titleKey="billSchedule.step2" style="text-align:left" />
    <display:column property="step3" sortable="true" titleKey="billSchedule.step3" style="text-align:left" />
    <display:column property="step4" sortable="true" titleKey="billSchedule.step4" style="text-align:left" />
    <display:column property="step5" sortable="true" titleKey="billSchedule.step5" style="text-align:left" />
    <display:column property="step6" sortable="true" titleKey="billSchedule.step6" style="text-align:left" />
    <display:column property="step7" sortable="true" titleKey="billSchedule.step7" style="text-align:left" />
    <display:column property="step8" sortable="true" titleKey="billSchedule.step8" style="text-align:left" />
    <display:column property="step9" sortable="true" titleKey="billSchedule.step9" style="text-align:left" />
    <display:column property="step10" sortable="true" titleKey="billSchedule.step10" style="text-align:left" />
    <display:column property="step11" sortable="true" titleKey="billSchedule.step11" style="text-align:left" />
    <display:column property="step12" sortable="true" titleKey="billSchedule.step12" style="text-align:left" />
    <display:column property="cuticlestep" sortable="true" titleKey="billSchedule.cuticlestep" style="text-align:left" />
    <display:column property="cuticle" sortable="true" titleKey="billSchedule.cuticle" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check1" sortable="true" titleKey="billSchedule.check1" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check2" sortable="true" titleKey="billSchedule.check2" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check3" sortable="true" titleKey="billSchedule.check3" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check4" sortable="true" titleKey="billSchedule.check4" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check5" sortable="true" titleKey="billSchedule.check5" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check6" sortable="true" titleKey="billSchedule.check6" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check7" sortable="true" titleKey="billSchedule.check7" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check8" sortable="true" titleKey="billSchedule.check8" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check9" sortable="true" titleKey="billSchedule.check9" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check10" sortable="true" titleKey="billSchedule.check10" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check11" sortable="true" titleKey="billSchedule.check11" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check12" sortable="true" titleKey="billSchedule.check12" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="code" sortable="true" titleKey="billSchedule.code" style="text-align:left" />
    <display:column property="imageDiagram.caption_" sortable="true" titleKey="billSchedule.imageDiagram" style="text-align:left"/>
    <display:column property="checkDiagram.caption_" sortable="true" titleKey="billSchedule.checkDiagram" style="text-align:left"/>
    <display:column property="outputEquipment.caption_" sortable="true" titleKey="billSchedule.outputEquipment" style="text-align:left"/>
    <display:column property="isSend.caption_" sortable="true" titleKey="billSchedule.isSend" style="text-align:left"/>
    <display:column property="customerAddress.caption_" sortable="true" titleKey="billSchedule.customerAddress" style="text-align:left"/>
    <display:column property="freight.caption_" sortable="true" titleKey="billSchedule.freight" style="text-align:left"/>
    <display:column property="worker.caption_" sortable="true" titleKey="billSchedule.worker" style="text-align:left"/>
    <display:column property="billDetail.caption_" sortable="true" titleKey="billSchedule.billDetail" style="text-align:left"/>
    <display:column property="customerScreen.caption_" sortable="true" titleKey="billSchedule.customerScreen" style="text-align:left"/>
    <display:column property="cuticleer.caption_" sortable="true" titleKey="billSchedule.cuticleer" style="text-align:left"/>
    <display:column property="checker1.caption_" sortable="true" titleKey="billSchedule.checker1" style="text-align:left"/>
    <display:column property="checker2.caption_" sortable="true" titleKey="billSchedule.checker2" style="text-align:left"/>
    <display:column property="checker3.caption_" sortable="true" titleKey="billSchedule.checker3" style="text-align:left"/>
    <display:column property="checker4.caption_" sortable="true" titleKey="billSchedule.checker4" style="text-align:left"/>
    <display:column property="checker5.caption_" sortable="true" titleKey="billSchedule.checker5" style="text-align:left"/>
    <display:column property="checker6.caption_" sortable="true" titleKey="billSchedule.checker6" style="text-align:left"/>
    <display:column property="checker7.caption_" sortable="true" titleKey="billSchedule.checker7" style="text-align:left"/>
    <display:column property="checker8.caption_" sortable="true" titleKey="billSchedule.checker8" style="text-align:left"/>
    <display:column property="checker9.caption_" sortable="true" titleKey="billSchedule.checker9" style="text-align:left"/>
    <display:column property="checker10.caption_" sortable="true" titleKey="billSchedule.checker10" style="text-align:left"/>
    <display:column property="checker11.caption_" sortable="true" titleKey="billSchedule.checker11" style="text-align:left"/>
    <display:column property="checker12.caption_" sortable="true" titleKey="billSchedule.checker12" style="text-align:left"/>
    <display:column property="drawingsFiles" sortable="true" titleKey="billSchedule.drawingsFiles" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBillSchedule.html?billSchedule.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'billSchedule.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBillSchedule.html?billSchedule.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBillSchedule.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="billScheduleList.size()"/>, 'selectedBillScheduleId', 'copyBillSchedule.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBillSchedule.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBillSchedule.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="billSchedule.id" value="">
    <select name="selectedBillScheduleIds" multiple="true" style="display:none"></select>
</form>
