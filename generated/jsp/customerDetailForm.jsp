<%@ include file="/common/taglibs.jsp"%>

<ww:form name="customerDetailForm" action="saveCustomerDetail" method="POST" enctype="multipart/form-data">
  <ww:hidden name="customerDetail.id" value="${customerDetail.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="customerDetail.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="customerDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="customerDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.counterNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerDetail.counterNo" value="%{customerDetail.counterNo}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.counter"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerDetail.counter" value="%{customerDetail.counter}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.contacts"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerDetail.contacts" value="%{customerDetail.contacts}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.screenPosition"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerDetail.screenPosition" value="%{customerDetail.screenPosition}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.location"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerDetail.location" value="%{customerDetail.location}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.counterPhone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerDetail.counterPhone" value="%{customerDetail.counterPhone}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.planmap"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.planmap != null">
            <input type="checkbox" name="removePlanmap" onclick="if (this.checked == true) document.customerDetailForm.filePlanmap.style.display='inline'; else document.customerDetailForm.filePlanmap.style.display='none';" value="<ww:property value="customerDetail.planmap.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPlanmap.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.planmap.fileName"/>"><ww:property value="customerDetail.planmap.fileName" /> (<ww:property value="customerDetail.planmap.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePlanmap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.planmapId" value="${customerDetail.planmap.id}"/>
            <ww:hidden name="customerDetail.planmapFileName" value="${customerDetail.planmap.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePlanmap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo1"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo1 != null">
            <input type="checkbox" name="removePhoto1" onclick="if (this.checked == true) document.customerDetailForm.filePhoto1.style.display='inline'; else document.customerDetailForm.filePhoto1.style.display='none';" value="<ww:property value="customerDetail.photo1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto1.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo1.fileName"/>"><ww:property value="customerDetail.photo1.fileName" /> (<ww:property value="customerDetail.photo1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo1Id" value="${customerDetail.photo1.id}"/>
            <ww:hidden name="customerDetail.photo1FileName" value="${customerDetail.photo1.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo2"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo2 != null">
            <input type="checkbox" name="removePhoto2" onclick="if (this.checked == true) document.customerDetailForm.filePhoto2.style.display='inline'; else document.customerDetailForm.filePhoto2.style.display='none';" value="<ww:property value="customerDetail.photo2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto2.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo2.fileName"/>"><ww:property value="customerDetail.photo2.fileName" /> (<ww:property value="customerDetail.photo2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo2Id" value="${customerDetail.photo2.id}"/>
            <ww:hidden name="customerDetail.photo2FileName" value="${customerDetail.photo2.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo3"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo3 != null">
            <input type="checkbox" name="removePhoto3" onclick="if (this.checked == true) document.customerDetailForm.filePhoto3.style.display='inline'; else document.customerDetailForm.filePhoto3.style.display='none';" value="<ww:property value="customerDetail.photo3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto3.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo3.fileName"/>"><ww:property value="customerDetail.photo3.fileName" /> (<ww:property value="customerDetail.photo3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo3Id" value="${customerDetail.photo3.id}"/>
            <ww:hidden name="customerDetail.photo3FileName" value="${customerDetail.photo3.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo4"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo4 != null">
            <input type="checkbox" name="removePhoto4" onclick="if (this.checked == true) document.customerDetailForm.filePhoto4.style.display='inline'; else document.customerDetailForm.filePhoto4.style.display='none';" value="<ww:property value="customerDetail.photo4.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto4.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo4.fileName"/>"><ww:property value="customerDetail.photo4.fileName" /> (<ww:property value="customerDetail.photo4.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo4Id" value="${customerDetail.photo4.id}"/>
            <ww:hidden name="customerDetail.photo4FileName" value="${customerDetail.photo4.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo5"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo5 != null">
            <input type="checkbox" name="removePhoto5" onclick="if (this.checked == true) document.customerDetailForm.filePhoto5.style.display='inline'; else document.customerDetailForm.filePhoto5.style.display='none';" value="<ww:property value="customerDetail.photo5.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto5.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo5.fileName"/>"><ww:property value="customerDetail.photo5.fileName" /> (<ww:property value="customerDetail.photo5.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo5Id" value="${customerDetail.photo5.id}"/>
            <ww:hidden name="customerDetail.photo5FileName" value="${customerDetail.photo5.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.customerService"/></td>
        <td class="cInputColumn">
            <ww:select name="customerDetail.customerServiceId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="customerServiceList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.customer"/></td>
        <td class="cInputColumn">
            <ww:select name="customerDetail.customerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="customerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="customerDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="customerDetail.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
