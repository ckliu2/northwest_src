package northwest.common.web.action;

import northwest.common.value.BillFiles;
import northwest.common.service.BillFilesManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:59 CST 2017
*/

public class BillFilesAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillFiles billFiles;
    private java.io.File fileDoc1;
    private String fileDoc1ContentType, fileDoc1FileName, removeDoc1;
    private java.io.File fileDoc2;
    private String fileDoc2ContentType, fileDoc2FileName, removeDoc2;
    private java.io.File fileDoc3;
    private String fileDoc3ContentType, fileDoc3FileName, removeDoc3;
    private java.io.File fileDoc4;
    private String fileDoc4ContentType, fileDoc4FileName, removeDoc4;
    private java.io.File fileDoc5;
    private String fileDoc5ContentType, fileDoc5FileName, removeDoc5;
    private java.io.File fileDoc6;
    private String fileDoc6ContentType, fileDoc6FileName, removeDoc6;
    private Long[] selectedBillFilesIds;

    public BillFilesAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillFilesAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLFILES");
    }

    public BillFiles getBillFiles()
    {
        return billFiles;
    }

    public void setBillFiles(BillFiles val)
    {
        billFiles = val;
    }

    public void setGenericManager(BillFilesManager m)
    {
        super.setGenericManager(m);
    }

    public BillFilesManager getGenericManager()
    {
        return (BillFilesManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillFiles(billFiles.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billFiles == null) {
            billFiles = new BillFiles();
        } else if (billFiles.getId() != null) {
            billFiles = getGenericManager().getBillFilesById(billFiles.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillFilesIds != null && selectedBillFilesIds.length > 0) {
            BillFiles obj = getGenericManager().getBillFilesById(selectedBillFilesIds[0]);
            obj.setId(null);
            billFiles = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(billFiles) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillFiles val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillFiles(billFiles);
        saveFileToLocal(fileDoc1FileName, fileDoc1, getTextWithArgs("billFiles.uploadDoc1.dir"), billFiles.getId());
        saveFileToLocal(fileDoc2FileName, fileDoc2, getTextWithArgs("billFiles.uploadDoc2.dir"), billFiles.getId());
        saveFileToLocal(fileDoc3FileName, fileDoc3, getTextWithArgs("billFiles.uploadDoc3.dir"), billFiles.getId());
        saveFileToLocal(fileDoc4FileName, fileDoc4, getTextWithArgs("billFiles.uploadDoc4.dir"), billFiles.getId());
        saveFileToLocal(fileDoc5FileName, fileDoc5, getTextWithArgs("billFiles.uploadDoc5.dir"), billFiles.getId());
        saveFileToLocal(fileDoc6FileName, fileDoc6, getTextWithArgs("billFiles.uploadDoc6.dir"), billFiles.getId());
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        billFiles.setBill(getGenericManager().getBillById(billFiles.getBillId())); 
        if (getRemoveDoc1() != null && getRemoveDoc1().length() > 0) {
            billFiles.setDoc1(computeUploadedFile(fileDoc1FileName, fileDoc1)); 
            removeUploadedFile(getTextWithArgs("billFiles.uploadDoc1.dir"), billFiles.getDoc1Id(), billFiles.getDoc1FileName());
        } else {
            if (billFiles.getDoc1Id() != null)
                billFiles.setDoc1(getGenericManager().getUploadedFileById(billFiles.getDoc1Id())); 
            else
                billFiles.setDoc1(computeUploadedFile(fileDoc1FileName, fileDoc1)); 
        }
        if (getRemoveDoc2() != null && getRemoveDoc2().length() > 0) {
            billFiles.setDoc2(computeUploadedFile(fileDoc2FileName, fileDoc2)); 
            removeUploadedFile(getTextWithArgs("billFiles.uploadDoc2.dir"), billFiles.getDoc2Id(), billFiles.getDoc2FileName());
        } else {
            if (billFiles.getDoc2Id() != null)
                billFiles.setDoc2(getGenericManager().getUploadedFileById(billFiles.getDoc2Id())); 
            else
                billFiles.setDoc2(computeUploadedFile(fileDoc2FileName, fileDoc2)); 
        }
        if (getRemoveDoc3() != null && getRemoveDoc3().length() > 0) {
            billFiles.setDoc3(computeUploadedFile(fileDoc3FileName, fileDoc3)); 
            removeUploadedFile(getTextWithArgs("billFiles.uploadDoc3.dir"), billFiles.getDoc3Id(), billFiles.getDoc3FileName());
        } else {
            if (billFiles.getDoc3Id() != null)
                billFiles.setDoc3(getGenericManager().getUploadedFileById(billFiles.getDoc3Id())); 
            else
                billFiles.setDoc3(computeUploadedFile(fileDoc3FileName, fileDoc3)); 
        }
        if (getRemoveDoc4() != null && getRemoveDoc4().length() > 0) {
            billFiles.setDoc4(computeUploadedFile(fileDoc4FileName, fileDoc4)); 
            removeUploadedFile(getTextWithArgs("billFiles.uploadDoc4.dir"), billFiles.getDoc4Id(), billFiles.getDoc4FileName());
        } else {
            if (billFiles.getDoc4Id() != null)
                billFiles.setDoc4(getGenericManager().getUploadedFileById(billFiles.getDoc4Id())); 
            else
                billFiles.setDoc4(computeUploadedFile(fileDoc4FileName, fileDoc4)); 
        }
        if (getRemoveDoc5() != null && getRemoveDoc5().length() > 0) {
            billFiles.setDoc5(computeUploadedFile(fileDoc5FileName, fileDoc5)); 
            removeUploadedFile(getTextWithArgs("billFiles.uploadDoc5.dir"), billFiles.getDoc5Id(), billFiles.getDoc5FileName());
        } else {
            if (billFiles.getDoc5Id() != null)
                billFiles.setDoc5(getGenericManager().getUploadedFileById(billFiles.getDoc5Id())); 
            else
                billFiles.setDoc5(computeUploadedFile(fileDoc5FileName, fileDoc5)); 
        }
        if (getRemoveDoc6() != null && getRemoveDoc6().length() > 0) {
            billFiles.setDoc6(computeUploadedFile(fileDoc6FileName, fileDoc6)); 
            removeUploadedFile(getTextWithArgs("billFiles.uploadDoc6.dir"), billFiles.getDoc6Id(), billFiles.getDoc6FileName());
        } else {
            if (billFiles.getDoc6Id() != null)
                billFiles.setDoc6(getGenericManager().getUploadedFileById(billFiles.getDoc6Id())); 
            else
                billFiles.setDoc6(computeUploadedFile(fileDoc6FileName, fileDoc6)); 
        }
        log.info("exit formToBean()");
    }
    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public void setFileDoc1(java.io.File val)
    {
        fileDoc1 = val;
    }

    public java.io.File getFileDoc1()
    {
        return fileDoc1;
    }

    public void setFileDoc1ContentType(String val)
    {
        fileDoc1ContentType = val;
    }

    public String getFileDoc1ContentType()
    {
        return fileDoc1ContentType;
    }

    public void setFileDoc1FileName(String val)
    {
        fileDoc1FileName = val;
    }

    public String getFileDoc1FileName()
    {
        return fileDoc1FileName;
    }

    public void setRemoveDoc1(String val)
    {
        removeDoc1 = val;
    }

    public String getRemoveDoc1()
    {
        return removeDoc1;
    }

    public void setFileDoc2(java.io.File val)
    {
        fileDoc2 = val;
    }

    public java.io.File getFileDoc2()
    {
        return fileDoc2;
    }

    public void setFileDoc2ContentType(String val)
    {
        fileDoc2ContentType = val;
    }

    public String getFileDoc2ContentType()
    {
        return fileDoc2ContentType;
    }

    public void setFileDoc2FileName(String val)
    {
        fileDoc2FileName = val;
    }

    public String getFileDoc2FileName()
    {
        return fileDoc2FileName;
    }

    public void setRemoveDoc2(String val)
    {
        removeDoc2 = val;
    }

    public String getRemoveDoc2()
    {
        return removeDoc2;
    }

    public void setFileDoc3(java.io.File val)
    {
        fileDoc3 = val;
    }

    public java.io.File getFileDoc3()
    {
        return fileDoc3;
    }

    public void setFileDoc3ContentType(String val)
    {
        fileDoc3ContentType = val;
    }

    public String getFileDoc3ContentType()
    {
        return fileDoc3ContentType;
    }

    public void setFileDoc3FileName(String val)
    {
        fileDoc3FileName = val;
    }

    public String getFileDoc3FileName()
    {
        return fileDoc3FileName;
    }

    public void setRemoveDoc3(String val)
    {
        removeDoc3 = val;
    }

    public String getRemoveDoc3()
    {
        return removeDoc3;
    }

    public void setFileDoc4(java.io.File val)
    {
        fileDoc4 = val;
    }

    public java.io.File getFileDoc4()
    {
        return fileDoc4;
    }

    public void setFileDoc4ContentType(String val)
    {
        fileDoc4ContentType = val;
    }

    public String getFileDoc4ContentType()
    {
        return fileDoc4ContentType;
    }

    public void setFileDoc4FileName(String val)
    {
        fileDoc4FileName = val;
    }

    public String getFileDoc4FileName()
    {
        return fileDoc4FileName;
    }

    public void setRemoveDoc4(String val)
    {
        removeDoc4 = val;
    }

    public String getRemoveDoc4()
    {
        return removeDoc4;
    }

    public void setFileDoc5(java.io.File val)
    {
        fileDoc5 = val;
    }

    public java.io.File getFileDoc5()
    {
        return fileDoc5;
    }

    public void setFileDoc5ContentType(String val)
    {
        fileDoc5ContentType = val;
    }

    public String getFileDoc5ContentType()
    {
        return fileDoc5ContentType;
    }

    public void setFileDoc5FileName(String val)
    {
        fileDoc5FileName = val;
    }

    public String getFileDoc5FileName()
    {
        return fileDoc5FileName;
    }

    public void setRemoveDoc5(String val)
    {
        removeDoc5 = val;
    }

    public String getRemoveDoc5()
    {
        return removeDoc5;
    }

    public void setFileDoc6(java.io.File val)
    {
        fileDoc6 = val;
    }

    public java.io.File getFileDoc6()
    {
        return fileDoc6;
    }

    public void setFileDoc6ContentType(String val)
    {
        fileDoc6ContentType = val;
    }

    public String getFileDoc6ContentType()
    {
        return fileDoc6ContentType;
    }

    public void setFileDoc6FileName(String val)
    {
        fileDoc6FileName = val;
    }

    public String getFileDoc6FileName()
    {
        return fileDoc6FileName;
    }

    public void setRemoveDoc6(String val)
    {
        removeDoc6 = val;
    }

    public String getRemoveDoc6()
    {
        return removeDoc6;
    }

    public List<BillFiles> getBillFilesList()
    {
        return getGenericManager().getBillFilesList();
    }

    public void setSelectedBillFilesIds(Long[] val)
    {
        selectedBillFilesIds = val;
    }

    public Long[] getSelectedBillFilesIds()
    {
        return selectedBillFilesIds;
    }
}
