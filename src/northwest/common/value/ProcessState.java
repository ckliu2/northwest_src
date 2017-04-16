package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProcessState implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;   
	
    /** nullable persistent field */
    private Boolean step1;

	private Boolean step2;
    private Boolean step3;
    private Boolean step4;
    private Boolean step5;
    private Boolean step6;
    private Boolean step7;
    private Boolean step8;
    private Boolean step9;
    private Boolean step10;
    private Boolean step11;
    private Boolean step12;
    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private String billId;   
	private String worker;

    /** full constructor */
    public ProcessState(Boolean step1, northwest.common.value.Bill bill) {
        this.step1 = step1;
        this.bill = bill;
    }

    /** Labor constructor */
    public ProcessState() {
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}
	
    public Boolean getStep1() {
        return this.step1;
    }

    public void setStep1(Boolean step1) {
        this.step1 = step1;
    }
    
    public Boolean getStep2() {
		return step2;
	}

	public void setStep2(Boolean step2) {
		this.step2 = step2;
	}

	public Boolean getStep3() {
		return step3;
	}

	public void setStep3(Boolean step3) {
		this.step3 = step3;
	}

	public Boolean getStep4() {
		return step4;
	}

	public void setStep4(Boolean step4) {
		this.step4 = step4;
	}

	public Boolean getStep5() {
		return step5;
	}

	public void setStep5(Boolean step5) {
		this.step5 = step5;
	}

	public Boolean getStep6() {
		return step6;
	}

	public void setStep6(Boolean step6) {
		this.step6 = step6;
	}

	public Boolean getStep7() {
		return step7;
	}

	public void setStep7(Boolean step7) {
		this.step7 = step7;
	}

	public Boolean getStep8() {
		return step8;
	}

	public void setStep8(Boolean step8) {
		this.step8 = step8;
	}

	public Boolean getStep9() {
		return step9;
	}

	public void setStep9(Boolean step9) {
		this.step9 = step9;
	}

	public Boolean getStep10() {
		return step10;
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


    public northwest.common.value.Bill getBill() {
        return this.bill;
    }

    public void setBill(northwest.common.value.Bill bill) {
        this.bill = bill;
    }

    public String getBillId() {
        if (this.bill != null && this.bill.getId() != null)
            return bill.getId();
        return this.billId;
    }

    public void setBillId(String id) {
        this.billId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("step1", getStep1())
            .append("bill", getBill())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
