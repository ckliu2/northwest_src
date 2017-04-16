package northwest.common.web.action;

import northwest.common.value.BillSchedule;
import northwest.common.service.BillScheduleManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class BillScheduleAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillSchedule billSchedule;
    private String outputTime;
    private String deliveryTime;
    private String isSendTime;
    private String arrival;
    private String uploadDrawingsTime;
    private String cuticle;
    private String check1;
    private String check2;
    private String check3;
    private String check4;
    private String check5;
    private String check6;
    private String check7;
    private String check8;
    private String check9;
    private String check10;
    private String check11;
    private String check12;
    private java.io.File fileImageDiagram;
    private String fileImageDiagramContentType, fileImageDiagramFileName, removeImageDiagram;
    private java.io.File fileCheckDiagram;
    private String fileCheckDiagramContentType, fileCheckDiagramFileName, removeCheckDiagram;
    private Long[] drawingsFilesIds;
    private Long[] selectedBillScheduleIds;

    public BillScheduleAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillScheduleAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLSCHEDULE");
    }

    public BillSchedule getBillSchedule()
    {
        return billSchedule;
    }

    public void setBillSchedule(BillSchedule val)
    {
        billSchedule = val;
    }

    public void setGenericManager(BillScheduleManager m)
    {
        super.setGenericManager(m);
    }

    public BillScheduleManager getGenericManager()
    {
        return (BillScheduleManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillSchedule(billSchedule.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billSchedule == null) {
            billSchedule = new BillSchedule();
        } else if (billSchedule.getId() != null) {
            billSchedule = getGenericManager().getBillScheduleById(billSchedule.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillScheduleIds != null && selectedBillScheduleIds.length > 0) {
            BillSchedule obj = getGenericManager().getBillScheduleById(selectedBillScheduleIds[0]);
            obj.setId(null);
            billSchedule = obj;
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
            if (inputValidation(billSchedule) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillSchedule val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillSchedule(billSchedule);
        saveFileToLocal(fileImageDiagramFileName, fileImageDiagram, getTextWithArgs("billSchedule.uploadImageDiagram.dir"), billSchedule.getId());
        saveFileToLocal(fileCheckDiagramFileName, fileCheckDiagram, getTextWithArgs("billSchedule.uploadCheckDiagram.dir"), billSchedule.getId());
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        outputTime = Tools.dateToString(billSchedule.getOutputTime());
        deliveryTime = Tools.dateToString(billSchedule.getDeliveryTime());
        isSendTime = Tools.dateToString(billSchedule.getIsSendTime());
        arrival = Tools.dateToString(billSchedule.getArrival());
        uploadDrawingsTime = Tools.dateToString(billSchedule.getUploadDrawingsTime());
        cuticle = Tools.dateToString(billSchedule.getCuticle());
        check1 = Tools.dateToString(billSchedule.getCheck1());
        check2 = Tools.dateToString(billSchedule.getCheck2());
        check3 = Tools.dateToString(billSchedule.getCheck3());
        check4 = Tools.dateToString(billSchedule.getCheck4());
        check5 = Tools.dateToString(billSchedule.getCheck5());
        check6 = Tools.dateToString(billSchedule.getCheck6());
        check7 = Tools.dateToString(billSchedule.getCheck7());
        check8 = Tools.dateToString(billSchedule.getCheck8());
        check9 = Tools.dateToString(billSchedule.getCheck9());
        check10 = Tools.dateToString(billSchedule.getCheck10());
        check11 = Tools.dateToString(billSchedule.getCheck11());
        check12 = Tools.dateToString(billSchedule.getCheck12());
        drawingsFilesIds = getGenericManager().getIdsFromUploadedFileList(billSchedule.getDrawingsFiles());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        billSchedule.setOutputTime(Tools.convertToDate(outputTime)); 
        billSchedule.setDeliveryTime(Tools.convertToDate(deliveryTime)); 
        billSchedule.setIsSendTime(Tools.convertToDate(isSendTime)); 
        billSchedule.setArrival(Tools.convertToDate(arrival)); 
        billSchedule.setUploadDrawingsTime(Tools.convertToDate(uploadDrawingsTime)); 
        billSchedule.setCuticle(Tools.convertToDate(cuticle)); 
        billSchedule.setCheck1(Tools.convertToDate(check1)); 
        billSchedule.setCheck2(Tools.convertToDate(check2)); 
        billSchedule.setCheck3(Tools.convertToDate(check3)); 
        billSchedule.setCheck4(Tools.convertToDate(check4)); 
        billSchedule.setCheck5(Tools.convertToDate(check5)); 
        billSchedule.setCheck6(Tools.convertToDate(check6)); 
        billSchedule.setCheck7(Tools.convertToDate(check7)); 
        billSchedule.setCheck8(Tools.convertToDate(check8)); 
        billSchedule.setCheck9(Tools.convertToDate(check9)); 
        billSchedule.setCheck10(Tools.convertToDate(check10)); 
        billSchedule.setCheck11(Tools.convertToDate(check11)); 
        billSchedule.setCheck12(Tools.convertToDate(check12)); 
        if (getRemoveImageDiagram() != null && getRemoveImageDiagram().length() > 0) {
            billSchedule.setImageDiagram(computeUploadedFile(fileImageDiagramFileName, fileImageDiagram)); 
            removeUploadedFile(getTextWithArgs("billSchedule.uploadImageDiagram.dir"), billSchedule.getImageDiagramId(), billSchedule.getImageDiagramFileName());
        } else {
            if (billSchedule.getImageDiagramId() != null)
                billSchedule.setImageDiagram(getGenericManager().getUploadedFileById(billSchedule.getImageDiagramId())); 
            else
                billSchedule.setImageDiagram(computeUploadedFile(fileImageDiagramFileName, fileImageDiagram)); 
        }
        if (getRemoveCheckDiagram() != null && getRemoveCheckDiagram().length() > 0) {
            billSchedule.setCheckDiagram(computeUploadedFile(fileCheckDiagramFileName, fileCheckDiagram)); 
            removeUploadedFile(getTextWithArgs("billSchedule.uploadCheckDiagram.dir"), billSchedule.getCheckDiagramId(), billSchedule.getCheckDiagramFileName());
        } else {
            if (billSchedule.getCheckDiagramId() != null)
                billSchedule.setCheckDiagram(getGenericManager().getUploadedFileById(billSchedule.getCheckDiagramId())); 
            else
                billSchedule.setCheckDiagram(computeUploadedFile(fileCheckDiagramFileName, fileCheckDiagram)); 
        }
        billSchedule.setOutputEquipment(getGenericManager().getOutputEquipmentById(billSchedule.getOutputEquipmentId())); 
        billSchedule.setIsSend(getAppPropertyById(billSchedule.getIsSendId())); 
        billSchedule.setCustomerAddress(getGenericManager().getCustomerDetailById(billSchedule.getCustomerAddressId())); 
        billSchedule.setFreight(getGenericManager().getFreightById(billSchedule.getFreightId())); 
        billSchedule.setWorker(getGenericManager().getMemberById(billSchedule.getWorkerId())); 
        billSchedule.setBillDetail(getGenericManager().getBillDetailById(billSchedule.getBillDetailId())); 
        billSchedule.setCustomerScreen(getGenericManager().getCustomerScreenById(billSchedule.getCustomerScreenId())); 
        billSchedule.setCuticleer(getGenericManager().getMemberById(billSchedule.getCuticleerId())); 
        billSchedule.setChecker1(getGenericManager().getMemberById(billSchedule.getChecker1Id())); 
        billSchedule.setChecker2(getGenericManager().getMemberById(billSchedule.getChecker2Id())); 
        billSchedule.setChecker3(getGenericManager().getMemberById(billSchedule.getChecker3Id())); 
        billSchedule.setChecker4(getGenericManager().getMemberById(billSchedule.getChecker4Id())); 
        billSchedule.setChecker5(getGenericManager().getMemberById(billSchedule.getChecker5Id())); 
        billSchedule.setChecker6(getGenericManager().getMemberById(billSchedule.getChecker6Id())); 
        billSchedule.setChecker7(getGenericManager().getMemberById(billSchedule.getChecker7Id())); 
        billSchedule.setChecker8(getGenericManager().getMemberById(billSchedule.getChecker8Id())); 
        billSchedule.setChecker9(getGenericManager().getMemberById(billSchedule.getChecker9Id())); 
        billSchedule.setChecker10(getGenericManager().getMemberById(billSchedule.getChecker10Id())); 
        billSchedule.setChecker11(getGenericManager().getMemberById(billSchedule.getChecker11Id())); 
        billSchedule.setChecker12(getGenericManager().getMemberById(billSchedule.getChecker12Id())); 
        billSchedule.setDrawingsFiles(getGenericManager().getUploadedFileListByIds(drawingsFilesIds)); 
        log.info("exit formToBean()");
    }
    public void setOutputTime(String val)
    {
        outputTime = val;
    }

    public String getOutputTime()
    {
        return outputTime;
    }

    public void setDeliveryTime(String val)
    {
        deliveryTime = val;
    }

    public String getDeliveryTime()
    {
        return deliveryTime;
    }

    public void setIsSendTime(String val)
    {
        isSendTime = val;
    }

    public String getIsSendTime()
    {
        return isSendTime;
    }

    public void setArrival(String val)
    {
        arrival = val;
    }

    public String getArrival()
    {
        return arrival;
    }

    public void setUploadDrawingsTime(String val)
    {
        uploadDrawingsTime = val;
    }

    public String getUploadDrawingsTime()
    {
        return uploadDrawingsTime;
    }

    public void setCuticle(String val)
    {
        cuticle = val;
    }

    public String getCuticle()
    {
        return cuticle;
    }

    public void setCheck1(String val)
    {
        check1 = val;
    }

    public String getCheck1()
    {
        return check1;
    }

    public void setCheck2(String val)
    {
        check2 = val;
    }

    public String getCheck2()
    {
        return check2;
    }

    public void setCheck3(String val)
    {
        check3 = val;
    }

    public String getCheck3()
    {
        return check3;
    }

    public void setCheck4(String val)
    {
        check4 = val;
    }

    public String getCheck4()
    {
        return check4;
    }

    public void setCheck5(String val)
    {
        check5 = val;
    }

    public String getCheck5()
    {
        return check5;
    }

    public void setCheck6(String val)
    {
        check6 = val;
    }

    public String getCheck6()
    {
        return check6;
    }

    public void setCheck7(String val)
    {
        check7 = val;
    }

    public String getCheck7()
    {
        return check7;
    }

    public void setCheck8(String val)
    {
        check8 = val;
    }

    public String getCheck8()
    {
        return check8;
    }

    public void setCheck9(String val)
    {
        check9 = val;
    }

    public String getCheck9()
    {
        return check9;
    }

    public void setCheck10(String val)
    {
        check10 = val;
    }

    public String getCheck10()
    {
        return check10;
    }

    public void setCheck11(String val)
    {
        check11 = val;
    }

    public String getCheck11()
    {
        return check11;
    }

    public void setCheck12(String val)
    {
        check12 = val;
    }

    public String getCheck12()
    {
        return check12;
    }

    public void setFileImageDiagram(java.io.File val)
    {
        fileImageDiagram = val;
    }

    public java.io.File getFileImageDiagram()
    {
        return fileImageDiagram;
    }

    public void setFileImageDiagramContentType(String val)
    {
        fileImageDiagramContentType = val;
    }

    public String getFileImageDiagramContentType()
    {
        return fileImageDiagramContentType;
    }

    public void setFileImageDiagramFileName(String val)
    {
        fileImageDiagramFileName = val;
    }

    public String getFileImageDiagramFileName()
    {
        return fileImageDiagramFileName;
    }

    public void setRemoveImageDiagram(String val)
    {
        removeImageDiagram = val;
    }

    public String getRemoveImageDiagram()
    {
        return removeImageDiagram;
    }

    public void setFileCheckDiagram(java.io.File val)
    {
        fileCheckDiagram = val;
    }

    public java.io.File getFileCheckDiagram()
    {
        return fileCheckDiagram;
    }

    public void setFileCheckDiagramContentType(String val)
    {
        fileCheckDiagramContentType = val;
    }

    public String getFileCheckDiagramContentType()
    {
        return fileCheckDiagramContentType;
    }

    public void setFileCheckDiagramFileName(String val)
    {
        fileCheckDiagramFileName = val;
    }

    public String getFileCheckDiagramFileName()
    {
        return fileCheckDiagramFileName;
    }

    public void setRemoveCheckDiagram(String val)
    {
        removeCheckDiagram = val;
    }

    public String getRemoveCheckDiagram()
    {
        return removeCheckDiagram;
    }

    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericManager().getOutputEquipmentList(); // TODO
    }

    public List<AppProperty> getIsSendList()
    {
        return super.getAppPropertyList("billSchedule.isSend");
    }

    public List<CustomerDetail> getCustomerAddressList()
    {
        return getGenericManager().getCustomerAddressList(); // TODO
    }

    public List<Freight> getFreightList()
    {
        return getGenericManager().getFreightList(); // TODO
    }

    public List<Member> getWorkerList()
    {
        return getGenericManager().getWorkerList(); // TODO
    }

    public List<BillDetail> getBillDetailList()
    {
        return getGenericManager().getBillDetailList(); // TODO
    }

    public List<CustomerScreen> getCustomerScreenList()
    {
        return getGenericManager().getCustomerScreenList(); // TODO
    }

    public List<Member> getCuticleerList()
    {
        return getGenericManager().getCuticleerList(); // TODO
    }

    public List<Member> getChecker1List()
    {
        return getGenericManager().getChecker1List(); // TODO
    }

    public List<Member> getChecker2List()
    {
        return getGenericManager().getChecker2List(); // TODO
    }

    public List<Member> getChecker3List()
    {
        return getGenericManager().getChecker3List(); // TODO
    }

    public List<Member> getChecker4List()
    {
        return getGenericManager().getChecker4List(); // TODO
    }

    public List<Member> getChecker5List()
    {
        return getGenericManager().getChecker5List(); // TODO
    }

    public List<Member> getChecker6List()
    {
        return getGenericManager().getChecker6List(); // TODO
    }

    public List<Member> getChecker7List()
    {
        return getGenericManager().getChecker7List(); // TODO
    }

    public List<Member> getChecker8List()
    {
        return getGenericManager().getChecker8List(); // TODO
    }

    public List<Member> getChecker9List()
    {
        return getGenericManager().getChecker9List(); // TODO
    }

    public List<Member> getChecker10List()
    {
        return getGenericManager().getChecker10List(); // TODO
    }

    public List<Member> getChecker11List()
    {
        return getGenericManager().getChecker11List(); // TODO
    }

    public List<Member> getChecker12List()
    {
        return getGenericManager().getChecker12List(); // TODO
    }

    public List<List> getDrawingsFilesList()
    {
        return getGenericManager().getDrawingsFilesList(); // TODO
    }

    public void setDrawingsFilesIds(Long[] val)
    {
        drawingsFilesIds = val;
    }

    public Long[] getDrawingsFilesIds()
    {
        return drawingsFilesIds;
    }

    public List<BillSchedule> getBillScheduleList()
    {
        return getGenericManager().getBillScheduleList();
    }

    public void setSelectedBillScheduleIds(Long[] val)
    {
        selectedBillScheduleIds = val;
    }

    public Long[] getSelectedBillScheduleIds()
    {
        return selectedBillScheduleIds;
    }
}
