package northwest.common.value;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Meter implements Serializable {

    private static final long serialVersionUID = 1L;

	String id;
    
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
    private Boolean group1;

    /** nullable persistent field */
    private Boolean group2;

    /** nullable persistent field */
    private Boolean group3;

    /** nullable persistent field */
    private Boolean group4;

    /** nullable persistent field */
    private Boolean group5;

    /** nullable persistent field */
    private Boolean group6;

    /** nullable persistent field */
    private Boolean group7;

    /** nullable persistent field */
    private Boolean group8;

    /** nullable persistent field */
    private Boolean group9;

    /** nullable persistent field */
    private Boolean group10;

    /** nullable persistent field */
    private Boolean group11;

    /** nullable persistent field */
    private Boolean group12;
    
    

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
    private northwest.common.value.BillSchedule schedule;


    /** nullable persistent field */
    private northwest.common.value.BillDetail billdetail;


    /** nullable persistent field */
    private northwest.common.value.Bill bill;

	private Product product;


    /** full constructor */
    public Meter(Boolean step1, Boolean step2, Boolean step3, Boolean step4, Boolean step5, Boolean step6, Boolean step7, Boolean step8, Boolean step9, Boolean step10, Boolean step11, Boolean step12, Boolean group1, Boolean group2, Boolean group3, Boolean group4, Boolean group5, Boolean group6, Boolean group7, Boolean group8, Boolean group9, Boolean group10, Boolean group11, Boolean group12, northwest.common.value.BillSchedule schedule, northwest.common.value.BillDetail billdetail, northwest.common.value.Bill bill) {
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
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;
        this.group4 = group4;
        this.group5 = group5;
        this.group6 = group6;
        this.group7 = group7;
        this.group8 = group8;
        this.group9 = group9;
        this.group10 = group10;
        this.group11 = group11;
        this.group12 = group12;
        this.schedule = schedule;
        this.billdetail = billdetail;
        this.bill = bill;
    }

    /** Labor constructor */
    public Meter() {
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

    public Boolean getGroup1() {
        return this.group1;
    }

    public void setGroup1(Boolean group1) {
        this.group1 = group1;
    }

    public Boolean getGroup2() {
        return this.group2;
    }

    public void setGroup2(Boolean group2) {
        this.group2 = group2;
    }

    public Boolean getGroup3() {
        return this.group3;
    }

    public void setGroup3(Boolean group3) {
        this.group3 = group3;
    }

    public Boolean getGroup4() {
        return this.group4;
    }

    public void setGroup4(Boolean group4) {
        this.group4 = group4;
    }

    public Boolean getGroup5() {
        return this.group5;
    }

    public void setGroup5(Boolean group5) {
        this.group5 = group5;
    }

    public Boolean getGroup6() {
        return this.group6;
    }

    public void setGroup6(Boolean group6) {
        this.group6 = group6;
    }

    public Boolean getGroup7() {
        return this.group7;
    }

    public void setGroup7(Boolean group7) {
        this.group7 = group7;
    }

    public Boolean getGroup8() {
        return this.group8;
    }

    public void setGroup8(Boolean group8) {
        this.group8 = group8;
    }

    public Boolean getGroup9() {
        return this.group9;
    }

    public void setGroup9(Boolean group9) {
        this.group9 = group9;
    }

    public Boolean getGroup10() {
        return this.group10;
    }

    public void setGroup10(Boolean group10) {
        this.group10 = group10;
    }

    public Boolean getGroup11() {
        return this.group11;
    }

    public void setGroup11(Boolean group11) {
        this.group11 = group11;
    }

    public Boolean getGroup12() {
        return this.group12;
    }

    public void setGroup12(Boolean group12) {
        this.group12 = group12;
    }

    public northwest.common.value.BillSchedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(northwest.common.value.BillSchedule schedule) {
        this.schedule = schedule;
    }


    public northwest.common.value.BillDetail getBilldetail() {
        return this.billdetail;
    }

    public void setBilldetail(northwest.common.value.BillDetail billdetail) {
        this.billdetail = billdetail;
    }


    public northwest.common.value.Bill getBill() {
        return this.bill;
    }

    public void setBill(northwest.common.value.Bill bill) {
        this.bill = bill;
    }
    
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Date getCheck1() {
		return check1;
	}

	public void setCheck1(Date check1) {
		this.check1 = check1;
	}

	public Date getCheck2() {
		return check2;
	}

	public void setCheck2(Date check2) {
		this.check2 = check2;
	}

	public Date getCheck3() {
		return check3;
	}

	public void setCheck3(Date check3) {
		this.check3 = check3;
	}

	public Date getCheck4() {
		return check4;
	}

	public void setCheck4(Date check4) {
		this.check4 = check4;
	}

	public Date getCheck5() {
		return check5;
	}

	public void setCheck5(Date check5) {
		this.check5 = check5;
	}

	public Date getCheck6() {
		return check6;
	}

	public void setCheck6(Date check6) {
		this.check6 = check6;
	}

	public Date getCheck7() {
		return check7;
	}

	public void setCheck7(Date check7) {
		this.check7 = check7;
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
            .append("group1", getGroup1())
            .append("group2", getGroup2())
            .append("group3", getGroup3())
            .append("group4", getGroup4())
            .append("group5", getGroup5())
            .append("group6", getGroup6())
            .append("group7", getGroup7())
            .append("group8", getGroup8())
            .append("group9", getGroup9())
            .append("group10", getGroup10())
            .append("group11", getGroup11())
            .append("group12", getGroup12())
            .append("schedule", getSchedule())
            .append("billdetail", getBilldetail())
            .append("bill", getBill())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
