package northwest.common.value;

import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import com.common.value.Member;
import java.io.Serializable;
import java.util.*;
import java.text.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillSchedule implements Serializable {

    private static final long serialVersionUID = 1L;  
    
	private String id;
	
    /** nullable persistent field */
    private String fileName;

    /** nullable persistent field */  
	private Date check1;
    private Date check2;
    private Date check3;
    private Date check4;
    private Date check5;
    private Date check6;
    private Date check7;
    private Date check8;
    private Date check9;
    private Date check10;
    private Date check11;
    private Date check12;
    
    /** nullable persistent field */
    private UploadedFile imageDiagram;
    private String imageDiagramFileName;
    private Long imageDiagramId;

    /** nullable persistent field */
    private UploadedFile checkDiagram;
    private String checkDiagramFileName;
    private Long checkDiagramId;


    /** nullable persistent field */
    private String outputDevice;

    /** nullable persistent field */
    private Date outputTime;    

    /** nullable persistent field */
    private Date deliveryTime;

    /** nullable persistent field */
    private String freightNo;

    /** nullable persistent field */
    private Integer costs;

    /** nullable persistent field */
    private Date isSendTime;
	private AppProperty isSend;
    private Long isSendId;
    
    
    private CustomerDetail customerAddress;
    private Long customerAddressId;

    /** nullable persistent field */
    private northwest.common.value.Freight freight;
    private Long freightId;
    
    /** nullable persistent field */
    private northwest.common.value.OutputEquipment outputEquipment;
    private Long outputEquipmentId;

    /** nullable persistent field */
    private Member worker;
    private String workerId;
  
    /** nullable persistent field */
    private northwest.common.value.BillDetail billDetail;
    private String billDetailId;
    
    /** nullable persistent field */
    private CustomerScreen customerScreen;
    private Long customerScreenId;
    
	/** nullable persistent field */
    private Date arrival;

	private Date uploadDrawingsTime;
    
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

	private Boolean step11;
	
	private Boolean step12;
    
	private Member checker1;
    private Member checker2;
    private Member checker3;
    private Member checker4;
    private Member checker5;
    private Member checker6;
    private Member checker7;
    private Member checker8;
    private Member checker9;
    private Member checker10;
    private Member checker11;
	private Member checker12;
	
    /** nullable persistent field */
    private List drawingsFiles;
	private String drawingsMemo;

	String code;	

	private Member cuticleer;
	private Boolean cuticlestep;
	private Date cuticle;

    /** Labor constructor */
    public BillSchedule() {
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
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


    public Date getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    public String getWorkerId() {
        if (this.worker != null && this.worker.getId() != null)
            return worker.getId();
        return this.workerId;
    }

    public void setWorkerId(String id) {
        this.workerId = id;
    }


    public northwest.common.value.BillDetail getBillDetail() {
        return this.billDetail;
    }

    public void setBillDetail(northwest.common.value.BillDetail billDetail) {
        this.billDetail = billDetail;
    }

    public String getBillDetailId() {
        if (this.billDetail != null && this.billDetail.getId() != null)
            return billDetail.getId();
        return this.billDetailId;
    }

    public void setBillDetailId(String id) {
        this.billDetailId = id;
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
		return step11;
	}

	public void setStep11(Boolean step11) {
		this.step11 = step11;
	}
	
    public Boolean getStep12() {
		return step12;
	}

	public void setStep12(Boolean step12) {
		this.step12 = step12;
	}
    
    public Date getIsSendTime() {
		return isSendTime;
	}

	public void setIsSendTime(Date isSendTime) {
		this.isSendTime = isSendTime;
	}
	
    public List getDrawingsFiles() {
		return drawingsFiles;
	}

	public void setDrawingsFiles(List drawingsFiles) {
		this.drawingsFiles = drawingsFiles;
	}
	
    public String getDrawingsMemo() {
		return drawingsMemo;
	}

	public void setDrawingsMemo(String drawingsMemo) {
		this.drawingsMemo = drawingsMemo;
	}


    public String toString() {
        return new ToStringBuilder(this)
            .append("fileName", getFileName())
            .append("check1", getCheck1())
            .append("check2", getCheck2())
            .append("check3", getCheck3())
            .append("check4", getCheck4())
            .append("check5", getCheck5())
            .append("outputDevice", getOutputDevice())
            .append("outputTime", getOutputTime())
            .append("check6", getCheck6())
            .append("check7", getCheck7())
            .append("deliveryTime", getDeliveryTime())
            .append("freightNo", getFreightNo())
            .append("costs", getCosts())
            .append("isSend", getIsSend())
            .append("freight", getFreight())
            .append("worker", getWorker())
            .append("billDetail", getBillDetail())
            .toString();
    }
    
    public Member getChecker1() {
		return checker1;
	}

	public void setChecker1(Member checker1) {
		this.checker1 = checker1;
	}

	public Member getChecker2() {
		return checker2;
	}

	public void setChecker2(Member checker2) {
		this.checker2 = checker2;
	}

	public Member getChecker3() {
		return checker3;
	}

	public void setChecker3(Member checker3) {
		this.checker3 = checker3;
	}

	public Member getChecker4() {
		return checker4;
	}

	public void setChecker4(Member checker4) {
		this.checker4 = checker4;
	}

	public Member getChecker5() {
		return checker5;
	}

	public void setChecker5(Member checker5) {
		this.checker5 = checker5;
	}

	public Member getChecker6() {
		return checker6;
	}

	public void setChecker6(Member checker6) {
		this.checker6 = checker6;
	}

	public Member getChecker7() {
		return checker7;
	}

	public void setChecker7(Member checker7) {
		this.checker7 = checker7;
	}

	public Member getChecker8() {
		return checker8;
	}

	public void setChecker8(Member checker8) {
		this.checker8 = checker8;
	}
	
    public Date getCheck8() {
		return check8;
	}

	public void setCheck8(Date check8) {
		this.check8 = check8;
	}

	public Date getCheck9() {
		return check9;
	}

	public void setCheck9(Date check9) {
		this.check9 = check9;
	}

	public Date getCheck10() {
		return check10;
	}

	public void setCheck10(Date check10) {
		this.check10 = check10;
	}

	public Date getCheck11() {
		return check11;
	}

	public void setCheck11(Date check11) {
		this.check11 = check11;
	}

	public Date getCheck12() {
		return check12;
	}

	public void setCheck12(Date check12) {
		this.check12 = check12;
	}


	public Member getChecker9() {
		return checker9;
	}

	public void setChecker9(Member checker9) {
		this.checker9 = checker9;
	}

	public Member getChecker10() {
		return checker10;
	}

	public void setChecker10(Member checker10) {
		this.checker10 = checker10;
	}
	
	public Member getChecker11() {
		return checker11;
	}

	public void setChecker11(Member checker11) {
		this.checker11 = checker11;
	}
	
    public Member getChecker12() {
		return checker12;
	}

	public void setChecker12(Member checker12) {
		this.checker12 = checker12;
	}
	
    public CustomerDetail getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(CustomerDetail customerAddress) {
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

    public CustomerScreen getCustomerScreen() {
        return this.customerScreen;
    }

    public void setCustomerScreen(CustomerScreen customerScreen) {
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
    
    public Date getUploadDrawingsTime() {
		return uploadDrawingsTime;
	}

	public void setUploadDrawingsTime(Date uploadDrawingsTime) {
		this.uploadDrawingsTime = uploadDrawingsTime;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public String getCaption_() {
        return toString();
    }
    
    public Member getCuticleer() {
		return cuticleer;
	}

	public void setCuticleer(Member cuticleer) {
		this.cuticleer = cuticleer;
	}

	public Boolean getCuticlestep() {
		return cuticlestep;
	}

	public void setCuticlestep(Boolean cuticlestep) {
		this.cuticlestep = cuticlestep;
	}

	public Date getCuticle() {
		return cuticle;
	}

	public void setCuticle(Date cuticle) {
		this.cuticle = cuticle;
	}

}
