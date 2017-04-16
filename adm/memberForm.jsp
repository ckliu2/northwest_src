<%@ include file="/common/taglibs.jsp"%>

<ww:form name="memberForm" action="saveMember" method="POST" enctype="multipart/form-data" onsubmit="onSubmit()">
  <ww:hidden name="member.id" value="${member.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="member.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
        <tr><td class="cInputCaption"><fmt:message key="member.photo"/></td>
        <td class="cInputColumn">
        <ww:if test="member.photo != null">
            <input type="checkbox" name="removePhoto" onclick="if (this.checked == true) document.memberForm.filePhoto.style.display='inline'; else document.memberForm.filePhoto.style.display='none';" value="<ww:property value="member.photo.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="member.uploadPhoto.relativeUrl"/>/<ww:property value="member.id"/>/<ww:property value="member.photo.fileName"/>"><ww:property value="member.photo.fileName" /> (<ww:property value="member.photo.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="member.photoId" value="${member.photo.id}"/>
            <ww:hidden name="member.photoFileName" value="${member.photo.fileName}"/>             
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>
    
    <ww:if test="member.photo != null">
    <tr><td class="cInputCaption"><fmt:message key="member.photo"/></td>
        <td class="cInputColumn">
        <img border="0" src="<fmt:message key="member.uploadPhoto.relativeUrl"/>/${member.id}/${member.photo.fileName}" width="150" />
      </td>
    </tr>
    </ww:if>


    <tr><td class="cInputCaption"><fmt:message key="member.memberId"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.memberId" value="%{member.memberId}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.password"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.password" value="%{member.password}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="member.name" value="%{member.name}" maxlength="40" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.name')"/></span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.ename"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.ename" value="%{member.ename}" maxlength="40" cssClass="cInputTextField" />
        </td>
    </tr>
    
       <tr><td class="cInputCaption"><fmt:message key="member.sex"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:radio name="member.sex"
               list="sexList"
               listKey="id"
               listValue="value"              
            />
           <span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.sex')"/></span>
        </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="member.birthday"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="member.birthday" id="birthday" value="%{member.birthday}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.msn"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.msn" value="%{member.msn}" maxlength="40" cssClass="cInputTextFieldLong" /><span class="cInputValidationError">
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.email"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.email" value="%{member.email}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.email1"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.email1" value="%{member.email1}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.cellphone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.cellphone" value="%{member.cellphone}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.cellphone1"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.cellphone1" value="%{member.cellphone1}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="member.homePhone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.homePhone" value="%{member.homePhone}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.homePhone1"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.homePhone1" value="%{member.homePhone1}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.officePhone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.officePhone" value="%{member.officePhone}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.fax"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.fax" value="%{member.fax}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
     <tr><td class="cInputCaption"><fmt:message key="member.fax1"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.fax1" value="%{member.fax1}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="member.degree"/></td>
        <td class="cInputColumn">
            <ww:select name="member.degreeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="degreeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />  
            member.degreeId=<ww:property value="member.degree"/>  
        </td>
    </tr>
    
     <tr><td class="cInputCaption"><fmt:message key="member.introducer"/></td>
        <td class="cInputColumn">
            <ww:select name="member.introducerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="introducerList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            />          
             member.introducerId=<ww:property value="member.introducer"/> 
        </td>
    </tr>



    <tr><td class="cInputCaption"><fmt:message key="member.enabled"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="member.enabled" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.deleted"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="member.deleted" cssClass="cCheckboxField" />
        </td>
    </tr>



    <tr><td class="cInputCaption"><fmt:message key="member.address"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.address" value="%{member.address}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="member.address1"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.address1" value="%{member.address1}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="member.lastModifiedDate" /></span>
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="member.createdDate" /></span>
        </td>
    </tr>




    <tr><td class="cInputCaption"><fmt:message key="member.group"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="member.group"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="member.group"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allGroup"
                list="groupList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                /></td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allGroup, selectedGroup);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allGroup, selectedGroup);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedGroup, allGroup);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedGroup, allGroup);"><br>
            </td>
            
            <td align="center">
                <ww:select name="groupIds" id="selectedGroup"
                list="object_groupList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />                 
            </td>
            </tr>
            
            
            </table>
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="member.unit"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="member.unit"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="member.unit"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allUnit"
                list="unitList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allUnit, selectedUnit);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allUnit, selectedUnit);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedUnit, allUnit);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedUnit, allUnit);"><br>
            </td>
            
            <td align="center">
                <ww:select name="unitIds" id="selectedUnit"
                list="object_unitList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />              
            </td>
            </tr>
            
            
            </table>
        </td>
    </tr>
    
    
     <tr><td class="cInputCaption"><fmt:message key="team.name"/></td>
        <td class="cInputColumn">
        
         <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="team.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="team.name"/></style></th>
            </tr><tr>
            <td >
            
               <ww:select id="allTeam"
                list="teamAllList"
                listKey="id"
                listValue="name"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />   
                
             
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allTeam, selectedTeam);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allTeam, selectedTeam);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedTeam, allTeam);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedTeam, allTeam);"><br>
            </td>            
            <td align="center">
                <ww:select name="teamIds" id="selectedTeam"
                list="team_memberList"
                listKey="id"
                listValue="name"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />  
            </td>
            </tr>
        </table>
            
            
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="grade.name"/></td>
        <td class="cInputColumn">
        
     <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="grade.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="grade.name"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allGrade"
                list="gradeAllList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />                
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allGrade, selectedGrade);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allGrade, selectedGrade);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedGrade, allGrade);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedGrade, allGrade);"><br>
            </td>
            
            <td align="center">
                <ww:select name="gradeIds" id="selectedGrade"
                list="grade_memberList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />   
            </td>
            </tr>
       </table>
            
        </td>
    </tr>    
    
    
    
    
        <tr><td class="cInputCaption"><fmt:message key="common.remark"/></td>
        <td class="cInputColumn">
            <ww:textarea name="member.memo" value="%{member.memo}" cssClass="cInputTextArea" cols="45" rows="12" />
        </td>
    </tr>
   

    
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
<script>
function onSubmit() {
    mySelectAll(document.memberForm.groupIds);
    mySelectAll(document.memberForm.unitIds);
	mySelectAll(document.memberForm.teamIds);
	mySelectAll(document.memberForm.gradeIds);
    return true;
}
mySelectAll(document.memberForm.groupIds);
mySelectAll(document.memberForm.unitIds);
mySelectAll(document.memberForm.teamIds);
mySelectAll(document.memberForm.gradeIds);
</script>


