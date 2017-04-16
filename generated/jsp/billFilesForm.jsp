<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billFilesForm" action="saveBillFiles" method="POST" enctype="multipart/form-data">
  <ww:hidden name="billFiles.id" value="${billFiles.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billFiles.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billFiles.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billFiles.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.bill"/></td>
        <td class="cInputColumn">
            <ww:select name="billFiles.billId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="billList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc1"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc1 != null">
            <input type="checkbox" name="removeDoc1" onclick="if (this.checked == true) document.billFilesForm.fileDoc1.style.display='inline'; else document.billFilesForm.fileDoc1.style.display='none';" value="<ww:property value="billFiles.doc1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc1.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc1.fileName"/>"><ww:property value="billFiles.doc1.fileName" /> (<ww:property value="billFiles.doc1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc1Id" value="${billFiles.doc1.id}"/>
            <ww:hidden name="billFiles.doc1FileName" value="${billFiles.doc1.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc2"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc2 != null">
            <input type="checkbox" name="removeDoc2" onclick="if (this.checked == true) document.billFilesForm.fileDoc2.style.display='inline'; else document.billFilesForm.fileDoc2.style.display='none';" value="<ww:property value="billFiles.doc2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc2.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc2.fileName"/>"><ww:property value="billFiles.doc2.fileName" /> (<ww:property value="billFiles.doc2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc2Id" value="${billFiles.doc2.id}"/>
            <ww:hidden name="billFiles.doc2FileName" value="${billFiles.doc2.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc3"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc3 != null">
            <input type="checkbox" name="removeDoc3" onclick="if (this.checked == true) document.billFilesForm.fileDoc3.style.display='inline'; else document.billFilesForm.fileDoc3.style.display='none';" value="<ww:property value="billFiles.doc3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc3.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc3.fileName"/>"><ww:property value="billFiles.doc3.fileName" /> (<ww:property value="billFiles.doc3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc3Id" value="${billFiles.doc3.id}"/>
            <ww:hidden name="billFiles.doc3FileName" value="${billFiles.doc3.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc4"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc4 != null">
            <input type="checkbox" name="removeDoc4" onclick="if (this.checked == true) document.billFilesForm.fileDoc4.style.display='inline'; else document.billFilesForm.fileDoc4.style.display='none';" value="<ww:property value="billFiles.doc4.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc4.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc4.fileName"/>"><ww:property value="billFiles.doc4.fileName" /> (<ww:property value="billFiles.doc4.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc4Id" value="${billFiles.doc4.id}"/>
            <ww:hidden name="billFiles.doc4FileName" value="${billFiles.doc4.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc5"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc5 != null">
            <input type="checkbox" name="removeDoc5" onclick="if (this.checked == true) document.billFilesForm.fileDoc5.style.display='inline'; else document.billFilesForm.fileDoc5.style.display='none';" value="<ww:property value="billFiles.doc5.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc5.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc5.fileName"/>"><ww:property value="billFiles.doc5.fileName" /> (<ww:property value="billFiles.doc5.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc5Id" value="${billFiles.doc5.id}"/>
            <ww:hidden name="billFiles.doc5FileName" value="${billFiles.doc5.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc6"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc6 != null">
            <input type="checkbox" name="removeDoc6" onclick="if (this.checked == true) document.billFilesForm.fileDoc6.style.display='inline'; else document.billFilesForm.fileDoc6.style.display='none';" value="<ww:property value="billFiles.doc6.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc6.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc6.fileName"/>"><ww:property value="billFiles.doc6.fileName" /> (<ww:property value="billFiles.doc6.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc6" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc6Id" value="${billFiles.doc6.id}"/>
            <ww:hidden name="billFiles.doc6FileName" value="${billFiles.doc6.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc6" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billFiles.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billFiles.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
