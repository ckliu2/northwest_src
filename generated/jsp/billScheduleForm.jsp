<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billScheduleForm" action="saveBillSchedule" method="POST" enctype="multipart/form-data">
  <ww:hidden name="billSchedule.id" value="${billSchedule.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billSchedule.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.fileName"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.fileName" value="%{billSchedule.fileName}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputDevice"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.outputDevice" value="%{billSchedule.outputDevice}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="outputTime" id="outputTime" value="%{outputTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.deliveryTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="deliveryTime" id="deliveryTime" value="%{deliveryTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.isSendTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="isSendTime" id="isSendTime" value="%{isSendTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.arrival"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="arrival" id="arrival" value="%{arrival}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.freightNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.freightNo" value="%{billSchedule.freightNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.costs"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.costs" value="%{billSchedule.costs}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billSchedule.costs')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.uploadDrawingsTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="uploadDrawingsTime" id="uploadDrawingsTime" value="%{uploadDrawingsTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.drawingsMemo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.drawingsMemo" value="%{billSchedule.drawingsMemo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step1"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step1" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step2"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step2" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step3"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step3" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step4"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step4" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step5"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step5" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step6"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step6" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step7"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step7" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step8"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step8" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step9"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step9" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step10"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step10" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step11"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step11" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.step12"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.step12" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.cuticlestep"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.cuticlestep" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.cuticle"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="cuticle" id="cuticle" value="%{cuticle}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check1"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check1" id="check1" value="%{check1}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check2"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check2" id="check2" value="%{check2}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check3"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check3" id="check3" value="%{check3}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check4"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check4" id="check4" value="%{check4}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check5"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check5" id="check5" value="%{check5}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check6"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check6" id="check6" value="%{check6}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check7"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check7" id="check7" value="%{check7}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check8"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check8" id="check8" value="%{check8}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check9"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check9" id="check9" value="%{check9}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check10"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check10" id="check10" value="%{check10}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check11"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check11" id="check11" value="%{check11}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check12"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check12" id="check12" value="%{check12}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.code"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.code" value="%{billSchedule.code}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.imageDiagram"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.imageDiagram != null">
            <input type="checkbox" name="removeImageDiagram" onclick="if (this.checked == true) document.billScheduleForm.fileImageDiagram.style.display='inline'; else document.billScheduleForm.fileImageDiagram.style.display='none';" value="<ww:property value="billSchedule.imageDiagram.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadImageDiagram.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.imageDiagram.fileName"/>"><ww:property value="billSchedule.imageDiagram.fileName" /> (<ww:property value="billSchedule.imageDiagram.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileImageDiagram" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.imageDiagramId" value="${billSchedule.imageDiagram.id}"/>
            <ww:hidden name="billSchedule.imageDiagramFileName" value="${billSchedule.imageDiagram.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileImageDiagram" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checkDiagram"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.checkDiagram != null">
            <input type="checkbox" name="removeCheckDiagram" onclick="if (this.checked == true) document.billScheduleForm.fileCheckDiagram.style.display='inline'; else document.billScheduleForm.fileCheckDiagram.style.display='none';" value="<ww:property value="billSchedule.checkDiagram.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCheckDiagram.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.checkDiagram.fileName"/>"><ww:property value="billSchedule.checkDiagram.fileName" /> (<ww:property value="billSchedule.checkDiagram.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCheckDiagram" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.checkDiagramId" value="${billSchedule.checkDiagram.id}"/>
            <ww:hidden name="billSchedule.checkDiagramFileName" value="${billSchedule.checkDiagram.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCheckDiagram" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputEquipment"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.outputEquipmentId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="outputEquipmentList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.isSend"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.isSendId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="isSendList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.customerAddress"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.customerAddressId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="customerAddressList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.freight"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.freightId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="freightList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.worker"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.workerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="workerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.billDetail"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.billDetailId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="billDetailList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.customerScreen"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.customerScreenId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="customerScreenList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.cuticleer"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.cuticleerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="cuticleerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker1"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker1Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker1List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker2"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker2Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker2List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker3"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker3Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker3List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker4"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker4Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker4List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker5"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker5Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker5List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker6"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker6Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker6List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker7"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker7Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker7List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker8"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker8Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker8List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker9"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker9Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker9List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker10"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker10Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker10List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker11"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker11Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker11List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checker12"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.checker12Id" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checker12List"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.drawingsFiles"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="drawingsFilesIds" 
               list="drawingsFilesList"
               listKey="id"
               listValue="caption_"
               value = "%{drawingsFilesIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
