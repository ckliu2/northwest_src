package northwest.common.web.action;

import northwest.common.value.Meter;
import northwest.common.service.MeterManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class MeterAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Meter meter;
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
    private Long[] selectedMeterIds;

    public MeterAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.MeterAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("METER");
    }

    public Meter getMeter()
    {
        return meter;
    }

    public void setMeter(Meter val)
    {
        meter = val;
    }

    public void setGenericManager(MeterManager m)
    {
        super.setGenericManager(m);
    }

    public MeterManager getGenericManager()
    {
        return (MeterManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMeter(meter.getId());
        return DELETE;
    }

    public String edit()
    {
        if (meter == null) {
            meter = new Meter();
        } else if (meter.getId() != null) {
            meter = getGenericManager().getMeterById(meter.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMeterIds != null && selectedMeterIds.length > 0) {
            Meter obj = getGenericManager().getMeterById(selectedMeterIds[0]);
            obj.setId(null);
            meter = obj;
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
            if (inputValidation(meter) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Meter val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMeter(meter);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        check1 = Tools.dateToString(meter.getCheck1());
        check2 = Tools.dateToString(meter.getCheck2());
        check3 = Tools.dateToString(meter.getCheck3());
        check4 = Tools.dateToString(meter.getCheck4());
        check5 = Tools.dateToString(meter.getCheck5());
        check6 = Tools.dateToString(meter.getCheck6());
        check7 = Tools.dateToString(meter.getCheck7());
        check8 = Tools.dateToString(meter.getCheck8());
        check9 = Tools.dateToString(meter.getCheck9());
        check10 = Tools.dateToString(meter.getCheck10());
        check11 = Tools.dateToString(meter.getCheck11());
        check12 = Tools.dateToString(meter.getCheck12());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        meter.setCheck1(Tools.convertToDate(check1)); 
        meter.setCheck2(Tools.convertToDate(check2)); 
        meter.setCheck3(Tools.convertToDate(check3)); 
        meter.setCheck4(Tools.convertToDate(check4)); 
        meter.setCheck5(Tools.convertToDate(check5)); 
        meter.setCheck6(Tools.convertToDate(check6)); 
        meter.setCheck7(Tools.convertToDate(check7)); 
        meter.setCheck8(Tools.convertToDate(check8)); 
        meter.setCheck9(Tools.convertToDate(check9)); 
        meter.setCheck10(Tools.convertToDate(check10)); 
        meter.setCheck11(Tools.convertToDate(check11)); 
        meter.setCheck12(Tools.convertToDate(check12)); 
        meter.setSchedule(getGenericManager().getBillScheduleById(meter.getScheduleId())); 
        meter.setBilldetail(getGenericManager().getBillDetailById(meter.getBilldetailId())); 
        meter.setBill(getGenericManager().getBillById(meter.getBillId())); 
        meter.setProduct(getGenericManager().getProductById(meter.getProductId())); 
        log.info("exit formToBean()");
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

    public List<BillSchedule> getScheduleList()
    {
        return getGenericManager().getScheduleList(); // TODO
    }

    public List<BillDetail> getBilldetailList()
    {
        return getGenericManager().getBilldetailList(); // TODO
    }

    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<Meter> getMeterList()
    {
        return getGenericManager().getMeterList();
    }

    public void setSelectedMeterIds(Long[] val)
    {
        selectedMeterIds = val;
    }

    public Long[] getSelectedMeterIds()
    {
        return selectedMeterIds;
    }
}
