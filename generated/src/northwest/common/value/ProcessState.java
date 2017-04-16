package northwest.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProcessState implements Serializable {

    private static final long serialVersionUID = 1L;
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
    private String worker;

    /** nullable persistent field */
    private northwest.common.value.Bill bill;
    private Long billId;

    /** full constructor */
    public ProcessState(Boolean step1, Boolean step2, Boolean step3, Boolean step4, Boolean step5, Boolean step6, Boolean step7, Boolean step8, Boolean step9, Boolean step10, Boolean step11, Boolean step12, String worker, northwest.common.value.Bill bill) {
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
        this.worker = worker;
        this.bill = bill;
    }

    /** default constructor */
    public ProcessState() {
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

    public String getWorker() {
        return this.worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public northwest.common.value.Bill getBill() {
        return this.bill;
    }

    public void setBill(northwest.common.value.Bill bill) {
        this.bill = bill;
    }

    public Long getBillId() {
        if (this.bill != null && this.bill.getId() != null)
            return bill.getId();
        return this.billId;
    }

    public void setBillId(Long id) {
        this.billId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
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
            .append("worker", getWorker())
            .append("bill", getBill())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
