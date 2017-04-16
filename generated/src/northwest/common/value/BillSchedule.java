package northwest.common.value;

import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String fileName;

    /** nullable persistent field */
    private String outputDevice;

    /** nullable persistent field */
    private Date outputTime;

    /** nullable persistent field */
    private Date deliveryTime;

    /** nullable persistent field */
    private Date isSendTime;

    /** nullable persistent field */
    private Date arrival;

    /** nullable persistent field */
    private String freightNo;

    /** nullable persistent field */
    private Integer costs;

    /** nullable persistent field */
    private Date uploadDrawingsTime;

    /** nullable persistent field */
    private String drawingsMemo;

    /** nullable persistent field */
    private Boolean step1;

    /** nullable persistent field */
    private Boolean step2;

    /** nullable persistent field */
    private Boolean step3;

    /** nullable persistent field */
    private Boolean step4;

    /** nullable persistent field */
    private Boolean step5;

    /** nullable persistent field */
    private Boolean step6;

    /** nullable persistent field */
    private Boolean step7;

    /** nullable persistent field */
    private Boolean step8;

    /** nullable persistent field */
    private Boolean step9;

    /** nullable persistent field */
    private Boolean step10;

    /** nullable persistent field */
    private Boolean step11;

    /** nullable persistent field */
    private Boolean step12;

    /** nullable persistent field */
    private Boolean cuticlestep;

    /** nullable persistent field */
    private Date cuticle;

    /** nullable persistent field */
    private Date check1;

    /** nullable persistent field */
    private Date check2;

    /** nullable persistent field */
    private Date check3;

    /** nullable persistent field */
    private Date check4;

    /** nullable persistent field */
    private Date check5;

    /** nullable persistent field */
    private Date check6;

    /** nullable persistent field */
    private Date check7;

    /** nullable persistent field */
    private Date check8;

    /** nullable persistent field */
    private Date check9;

    /** nullable persistent field */
    private Date check10;

    /** nullable persistent field */
    private Date check11;

    /** nullable persistent field */
    private Date check12;

    /** nullable persistent field */
    private String code;

    /** nullable persistent field */
    private UploadedFile imageDiagram;
    private String imageDiagramFileName;
    private Long imageDiagramId;

    /** nullable persistent field */
    private UploadedFile checkDiagram;
    private String checkDiagramFileName;
    private Long checkDiagramId;

    /** nullable persistent field */
    private northwest.common.value.OutputEquipment outputEquipment;
    private Long outputEquipmentId;

    /** nullable persistent field */
    private AppProperty isSend;
    private Long isSendId;

    /** nullable persistent field */
    private northwest.common.value.CustomerDetail customerAddress;
    private Long customerAddressId;

    /** nullable persistent field */
    private northwest.common.value.Freight freight;
    private Long freightId;

    /** nullable persistent field */
    private Member worker;
    private Long workerId;

    /** nullable persistent field */
    private northwest.common.value.BillDetail billDetail;
    private Long billDetailId;

    /** nullable persistent field */
    private northwest.common.value.CustomerScreen customerScreen;
    private Long customerScreenId;

    /** nullable persistent field */
    private Member cuticleer;
    private Long cuticleerId;

    /** nullable persistent field */
    private Member checker1;
    private Long checker1Id;

    /** nullable persistent field */
    private Member checker2;
    private Long checker2Id;

    /** nullable persistent field */
    private Member checker3;
    private Long checker3Id;

    /** nullable persistent field */
    private Member checker4;
    private Long checker4Id;

    /** nullable persistent field */
    private Member checker5;
    private Long checker5Id;

    /** nullable persistent field */
    private Member checker6;
    private Long checker6Id;

    /** nullable persistent field */
    private Member checker7;
    private Long checker7Id;

    /** nullable persistent field */
    private Member checker8;
    private Long checker8Id;

    /** nullable persistent field */
    private Member checker9;
    private Long checker9Id;

    /** nullable persistent field */
    private Member checker10;
    private Long checker10Id;

    /** nullable persistent field */
    private Member checker11;
    private Long checker11Id;

    /** nullable persistent field */
    private Member checker12;
    private Long checker12Id;

    /** nullable persistent field */
    private List drawingsFiles;

    /** full constructor */
    public BillSchedule(String fileName, String outputDevice, Date outputTime, Date deliveryTime, Date isSendTime, Date arrival, String freightNo, Integer costs, Date uploadDrawingsTime, String drawingsMemo, Boolean step1, Boolean step2, Boolean step3, Boolean step4, Boolean step5, Boolean step6, Boolean step7, Boolean step8, Boolean step9, Boolean step10, Boolean step11, Boolean step12, Boolean cuticlestep, Date cuticle, Date check1, Date check2, Date check3, Date check4, Date check5, Date check6, Date check7, Date check8, Date check9, Date check10, Date check11, Date check12, String code, UploadedFile imageDiagram, UploadedFile checkDiagram, northwest.common.value.OutputEquipment outputEquipment, AppProperty isSend, northwest.common.value.CustomerDetail customerAddress, northwest.common.value.Freight freight, Member worker, northwest.common.value.BillDetail billDetail, northwest.common.value.CustomerScreen customerScreen, Member cuticleer, Member checker1, Member checker2, Member checker3, Member checker4, Member checker5, Member checker6, Member checker7, Member checker8, Member checker9, Member checker10, Member checker11, Member checker12, List drawingsFiles) {
        this.fileName = fileName;
        this.outputDevice = outputDevice;
        this.outputTime = outputTime;
        this.deliveryTime = deliveryTime;
        this.isSendTime = isSendTime;
        this.arrival = arrival;
        this.freightNo = freightNo;
        this.costs = costs;
        this.uploadDrawingsTime = uploadDrawingsTime;
        this.drawingsMemo = drawingsMemo;
        this.step1 = step1;
        this.step2 = step2;
        this.step3 = step3;
        this.step4 = step4;
        this.step5 = step5;
        this.step6 = step6;
        this.step7 = step7;
        this.step8 = step8;
        this.step9 = step9;
        this.step10 = step10;
        this.step11 = step11;
        this.step12 = step12;
        this.cuticlestep = cuticlestep;
        this.cuticle = cuticle;
        this.check1 = check1;
        this.check2 = check2;
        this.check3 = check3;
        this.check4 = check4;
        this.check5 = check5;
        this.check6 = check6;
        this.check7 = check7;
        this.check8 = check8;
        this.check9 = check9;
        this.check10 = check10;
        this.check11 = check11;
        this.check12 = check12;
        this.code = code;
        this.imageDiagram = imageDiagram;
        this.checkDiagram = checkDiagram;
        this.outputEquipment = outputEquipment;
        this.isSend = isSend;
        this.customerAddress = customerAddress;
        this.freight = freight;
        this.worker = worker;
        this.billDetail = billDetail;
        this.customerScreen = customerScreen;
        this.cuticleer = cuticleer;
        this.checker1 = checker1;
        this.checker2 = checker2;
        this.checker3 = checker3;
        this.checker4 = checker4;
        this.checker5 = checker5;
        this.checker6 = checker6;
        this.checker7 = checker7;
        this.checker8 = checker8;
        this.checker9 = checker9;
        this.checker10 = checker10;
        this.checker11 = checker11;
        this.checker12 = checker12;
        this.drawingsFiles = drawingsFiles;
    }

    /** default constructor */
    public BillSchedule() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOutputDevice() {
        return this.outputDevice;
    }

    public void setOutputDevice(String outputDevice) {
        this.outputDevice = outputDevice;
    }

    public Date getOutputTime() {
        return this.outputTime;
    }

    public void setOutputTime(Date outputTime) {
        this.outputTime = outputTime;
    }

    public Date getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getIsSendTime() {
        return this.isSendTime;
    }

    public void setIsSendTime(Date isSendTime) {
        this.isSendTime = isSendTime;
    }

    public Date getArrival() {
        return this.arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getFreightNo() {
        return this.freightNo;
    }

    public void setFreightNo(String freightNo) {
        this.freightNo = freightNo;
    }

    public Integer getCosts() {
        return this.costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }

    public Date getUploadDrawingsTime() {
        return this.uploadDrawingsTime;
    }

    public void setUploadDrawingsTime(Date uploadDrawingsTime) {
        this.uploadDrawingsTime = uploadDrawingsTime;
    }

    public String getDrawingsMemo() {
        return this.drawingsMemo;
    }

    public void setDrawingsMemo(String drawingsMemo) {
        this.drawingsMemo = drawingsMemo;
    }

    public Boolean getStep1() {
        return this.step1;
    }

    public void setStep1(Boolean step1) {
        this.step1 = step1;
    }

    public Boolean getStep2() {
        return this.step2;
    }

    public void setStep2(Boolean step2) {
        this.step2 = step2;
    }

    public Boolean getStep3() {
        return this.step3;
    }

    public void setStep3(Boolean step3) {
        this.step3 = step3;
    }

    public Boolean getStep4() {
        return this.step4;
    }

    public void setStep4(Boolean step4) {
        this.step4 = step4;
    }

    public Boolean getStep5() {
        return this.step5;
    }

    public void setStep5(Boolean step5) {
        this.step5 = step5;
    }

    public Boolean getStep6() {
        return this.step6;
    }

    public void setStep6(Boolean step6) {
        this.step6 = step6;
    }

    public Boolean getStep7() {
        return this.step7;
    }

    public void setStep7(Boolean step7) {
        this.step7 = step7;
    }

    public Boolean getStep8() {
        return this.step8;
    }

    public void setStep8(Boolean step8) {
        this.step8 = step8;
    }

    public Boolean getStep9() {
        return this.step9;
    }

    public void setStep9(Boolean step9) {
        this.step9 = step9;
    }

    public Boolean getStep10() {
        return this.step10;
    }

    public void setStep10(Boolean step10) {
        this.step10 = step10;
    }

    public Boolean getStep11() {
        return this.step11;
    }

    public void setStep11(Boolean step11) {
        this.step11 = step11;
    }

    public Boolean getStep12() {
        return this.step12;
    }

    public void setStep12(Boolean step12) {
        this.step12 = step12;
    }

    public Boolean getCuticlestep() {
        return this.cuticlestep;
    }

    public void setCuticlestep(Boolean cuticlestep) {
        this.cuticlestep = cuticlestep;
    }

    public Date getCuticle() {
        return this.cuticle;
    }

    public void setCuticle(Date cuticle) {
        this.cuticle = cuticle;
    }

    public Date getCheck1() {
        return this.check1;
    }

    public void setCheck1(Date check1) {
        this.check1 = check1;
    }

    public Date getCheck2() {
        return this.check2;
    }

    public void setCheck2(Date check2) {
        this.check2 = check2;
    }

    public Date getCheck3() {
        return this.check3;
    }

    public void setCheck3(Date check3) {
        this.check3 = check3;
    }

    public Date getCheck4() {
        return this.check4;
    }

    public void setCheck4(Date check4) {
        this.check4 = check4;
    }

    public Date getCheck5() {
        return this.check5;
    }

    public void setCheck5(Date check5) {
        this.check5 = check5;
    }

    public Date getCheck6() {
        return this.check6;
    }

    public void setCheck6(Date check6) {
        this.check6 = check6;
    }

    public Date getCheck7() {
        return this.check7;
    }

    public void setCheck7(Date check7) {
        this.check7 = check7;
    }

    public Date getCheck8() {
        return this.check8;
    }

    public void setCheck8(Date check8) {
        this.check8 = check8;
    }

    public Date getCheck9() {
        return this.check9;
    }

    public void setCheck9(Date check9) {
        this.check9 = check9;
    }

    public Date getCheck10() {
        return this.check10;
    }

    public void setCheck10(Date check10) {
        this.check10 = check10;
    }

    public Date getCheck11() {
        return this.check11;
    }

    public void setCheck11(Date check11) {
        this.check11 = check11;
    }

    public Date getCheck12() {
        return this.check12;
    }

    public void setCheck12(Date check12) {
        this.check12 = check12;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UploadedFile getImageDiagram() {
        return this.imageDiagram;
    }

    public void setImageDiagram(UploadedFile imageDiagram) {
        this.imageDiagram = imageDiagram;
    }

    public String getImageDiagramFileName() {
        return this.imageDiagramFileName;
    }

    public void setImageDiagramFileName(String val) {
        this.imageDiagramFileName = val;
    }

    public Long getImageDiagramId() {
        if (this.imageDiagram != null && this.imageDiagram.getId() != null)
            return imageDiagram.getId();
        return this.imageDiagramId;
    }

    public void setImageDiagramId(Long id) {
        this.imageDiagramId = id;
    }

    public UploadedFile getCheckDiagram() {
        return this.checkDiagram;
    }

    public void setCheckDiagram(UploadedFile checkDiagram) {
        this.checkDiagram = checkDiagram;
    }

    public String getCheckDiagramFileName() {
        return this.checkDiagramFileName;
    }

    public void setCheckDiagramFileName(String val) {
        this.checkDiagramFileName = val;
    }

    public Long getCheckDiagramId() {
        if (this.checkDiagram != null && this.checkDiagram.getId() != null)
            return checkDiagram.getId();
        return this.checkDiagramId;
    }

    public void setCheckDiagramId(Long id) {
        this.checkDiagramId = id;
    }

    public northwest.common.value.OutputEquipment getOutputEquipment() {
        return this.outputEquipment;
    }

    public void setOutputEquipment(northwest.common.value.OutputEquipment outputEquipment) {
        this.outputEquipment = outputEquipment;
    }

    public Long getOutputEquipmentId() {
        if (this.outputEquipment != null && this.outputEquipment.getId() != null)
            return outputEquipment.getId();
        return this.outputEquipmentId;
    }

    public void setOutputEquipmentId(Long id) {
        this.outputEquipmentId = id;
    }

    public AppProperty getIsSend() {
        return this.isSend;
    }

    public void setIsSend(AppProperty isSend) {
        this.isSend = isSend;
    }

    public Long getIsSendId() {
        if (this.isSend != null && this.isSend.getId() != null)
            return isSend.getId();
        return this.isSendId;
    }

    public void setIsSendId(Long id) {
        this.isSendId = id;
    }

    public northwest.common.value.CustomerDetail getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(northwest.common.value.CustomerDetail customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getCustomerAddressId() {
        if (this.customerAddress != null && this.customerAddress.getId() != null)
            return customerAddress.getId();
        return this.customerAddressId;
    }

    public void setCustomerAddressId(Long id) {
        this.customerAddressId = id;
    }

    public northwest.common.value.Freight getFreight() {
        return this.freight;
    }

    public void setFreight(northwest.common.value.Freight freight) {
        this.freight = freight;
    }

    public Long getFreightId() {
        if (this.freight != null && this.freight.getId() != null)
            return freight.getId();
        return this.freightId;
    }

    public void setFreightId(Long id) {
        this.freightId = id;
    }

    public Member getWorker() {
        return this.worker;
    }

    public void setWorker(Member worker) {
        this.worker = worker;
    }

    public Long getWorkerId() {
        if (this.worker != null && this.worker.getId() != null)
            return worker.getId();
        return this.workerId;
    }

    public void setWorkerId(Long id) {
        this.workerId = id;
    }

    public northwest.common.value.BillDetail getBillDetail() {
        return this.billDetail;
    }

    public void setBillDetail(northwest.common.value.BillDetail billDetail) {
        this.billDetail = billDetail;
    }

    public Long getBillDetailId() {
        if (this.billDetail != null && this.billDetail.getId() != null)
            return billDetail.getId();
        return this.billDetailId;
    }

    public void setBillDetailId(Long id) {
        this.billDetailId = id;
    }

    public northwest.common.value.CustomerScreen getCustomerScreen() {
        return this.customerScreen;
    }

    public void setCustomerScreen(northwest.common.value.CustomerScreen customerScreen) {
        this.customerScreen = customerScreen;
    }

    public Long getCustomerScreenId() {
        if (this.customerScreen != null && this.customerScreen.getId() != null)
            return customerScreen.getId();
        return this.customerScreenId;
    }

    public void setCustomerScreenId(Long id) {
        this.customerScreenId = id;
    }

    public Member getCuticleer() {
        return this.cuticleer;
    }

    public void setCuticleer(Member cuticleer) {
        this.cuticleer = cuticleer;
    }

    public Long getCuticleerId() {
        if (this.cuticleer != null && this.cuticleer.getId() != null)
            return cuticleer.getId();
        return this.cuticleerId;
    }

    public void setCuticleerId(Long id) {
        this.cuticleerId = id;
    }

    public Member getChecker1() {
        return this.checker1;
    }

    public void setChecker1(Member checker1) {
        this.checker1 = checker1;
    }

    public Long getChecker1Id() {
        if (this.checker1 != null && this.checker1.getId() != null)
            return checker1.getId();
        return this.checker1Id;
    }

    public void setChecker1Id(Long id) {
        this.checker1Id = id;
    }

    public Member getChecker2() {
        return this.checker2;
    }

    public void setChecker2(Member checker2) {
        this.checker2 = checker2;
    }

    public Long getChecker2Id() {
        if (this.checker2 != null && this.checker2.getId() != null)
            return checker2.getId();
        return this.checker2Id;
    }

    public void setChecker2Id(Long id) {
        this.checker2Id = id;
    }

    public Member getChecker3() {
        return this.checker3;
    }

    public void setChecker3(Member checker3) {
        this.checker3 = checker3;
    }

    public Long getChecker3Id() {
        if (this.checker3 != null && this.checker3.getId() != null)
            return checker3.getId();
        return this.checker3Id;
    }

    public void setChecker3Id(Long id) {
        this.checker3Id = id;
    }

    public Member getChecker4() {
        return this.checker4;
    }

    public void setChecker4(Member checker4) {
        this.checker4 = checker4;
    }

    public Long getChecker4Id() {
        if (this.checker4 != null && this.checker4.getId() != null)
            return checker4.getId();
        return this.checker4Id;
    }

    public void setChecker4Id(Long id) {
        this.checker4Id = id;
    }

    public Member getChecker5() {
        return this.checker5;
    }

    public void setChecker5(Member checker5) {
        this.checker5 = checker5;
    }

    public Long getChecker5Id() {
        if (this.checker5 != null && this.checker5.getId() != null)
            return checker5.getId();
        return this.checker5Id;
    }

    public void setChecker5Id(Long id) {
        this.checker5Id = id;
    }

    public Member getChecker6() {
        return this.checker6;
    }

    public void setChecker6(Member checker6) {
        this.checker6 = checker6;
    }

    public Long getChecker6Id() {
        if (this.checker6 != null && this.checker6.getId() != null)
            return checker6.getId();
        return this.checker6Id;
    }

    public void setChecker6Id(Long id) {
        this.checker6Id = id;
    }

    public Member getChecker7() {
        return this.checker7;
    }

    public void setChecker7(Member checker7) {
        this.checker7 = checker7;
    }

    public Long getChecker7Id() {
        if (this.checker7 != null && this.checker7.getId() != null)
            return checker7.getId();
        return this.checker7Id;
    }

    public void setChecker7Id(Long id) {
        this.checker7Id = id;
    }

    public Member getChecker8() {
        return this.checker8;
    }

    public void setChecker8(Member checker8) {
        this.checker8 = checker8;
    }

    public Long getChecker8Id() {
        if (this.checker8 != null && this.checker8.getId() != null)
            return checker8.getId();
        return this.checker8Id;
    }

    public void setChecker8Id(Long id) {
        this.checker8Id = id;
    }

    public Member getChecker9() {
        return this.checker9;
    }

    public void setChecker9(Member checker9) {
        this.checker9 = checker9;
    }

    public Long getChecker9Id() {
        if (this.checker9 != null && this.checker9.getId() != null)
            return checker9.getId();
        return this.checker9Id;
    }

    public void setChecker9Id(Long id) {
        this.checker9Id = id;
    }

    public Member getChecker10() {
        return this.checker10;
    }

    public void setChecker10(Member checker10) {
        this.checker10 = checker10;
    }

    public Long getChecker10Id() {
        if (this.checker10 != null && this.checker10.getId() != null)
            return checker10.getId();
        return this.checker10Id;
    }

    public void setChecker10Id(Long id) {
        this.checker10Id = id;
    }

    public Member getChecker11() {
        return this.checker11;
    }

    public void setChecker11(Member checker11) {
        this.checker11 = checker11;
    }

    public Long getChecker11Id() {
        if (this.checker11 != null && this.checker11.getId() != null)
            return checker11.getId();
        return this.checker11Id;
    }

    public void setChecker11Id(Long id) {
        this.checker11Id = id;
    }

    public Member getChecker12() {
        return this.checker12;
    }

    public void setChecker12(Member checker12) {
        this.checker12 = checker12;
    }

    public Long getChecker12Id() {
        if (this.checker12 != null && this.checker12.getId() != null)
            return checker12.getId();
        return this.checker12Id;
    }

    public void setChecker12Id(Long id) {
        this.checker12Id = id;
    }

    public List getDrawingsFiles() {
        return this.drawingsFiles;
    }

    public void setDrawingsFiles(List drawingsFiles) {
        this.drawingsFiles = drawingsFiles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("fileName", getFileName())
            .append("outputDevice", getOutputDevice())
            .append("outputTime", getOutputTime())
            .append("deliveryTime", getDeliveryTime())
            .append("isSendTime", getIsSendTime())
            .append("arrival", getArrival())
            .append("freightNo", getFreightNo())
            .append("costs", getCosts())
            .append("uploadDrawingsTime", getUploadDrawingsTime())
            .append("drawingsMemo", getDrawingsMemo())
            .append("step1", getStep1())
            .append("step2", getStep2())
            .append("step3", getStep3())
            .append("step4", getStep4())
            .append("step5", getStep5())
            .append("step6", getStep6())
            .append("step7", getStep7())
            .append("step8", getStep8())
            .append("step9", getStep9())
            .append("step10", getStep10())
            .append("step11", getStep11())
            .append("step12", getStep12())
            .append("cuticlestep", getCuticlestep())
            .append("cuticle", getCuticle())
            .append("check1", getCheck1())
            .append("check2", getCheck2())
            .append("check3", getCheck3())
            .append("check4", getCheck4())
            .append("check5", getCheck5())
            .append("check6", getCheck6())
            .append("check7", getCheck7())
            .append("check8", getCheck8())
            .append("check9", getCheck9())
            .append("check10", getCheck10())
            .append("check11", getCheck11())
            .append("check12", getCheck12())
            .append("code", getCode())
            .append("imageDiagram", getImageDiagram())
            .append("checkDiagram", getCheckDiagram())
            .append("outputEquipment", getOutputEquipment())
            .append("isSend", getIsSend())
            .append("customerAddress", getCustomerAddress())
            .append("freight", getFreight())
            .append("worker", getWorker())
            .append("billDetail", getBillDetail())
            .append("customerScreen", getCustomerScreen())
            .append("cuticleer", getCuticleer())
            .append("checker1", getChecker1())
            .append("checker2", getChecker2())
            .append("checker3", getChecker3())
            .append("checker4", getChecker4())
            .append("checker5", getChecker5())
            .append("checker6", getChecker6())
            .append("checker7", getChecker7())
            .append("checker8", getChecker8())
            .append("checker9", getChecker9())
            .append("checker10", getChecker10())
            .append("checker11", getChecker11())
            .append("checker12", getChecker12())
            .append("drawingsFiles", getDrawingsFiles())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
