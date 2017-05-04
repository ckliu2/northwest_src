package northwest.common.web.action;

import northwest.common.value.BillDetail;
import northwest.common.service.BillDetailManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:15 CST 2017
*/

public class BillDetailAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillDetail billDetail;
    private Long[] selectedBillDetailIds;

    public BillDetailAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.BillDetailAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLDETAIL");
    }

    public BillDetail getBillDetail()
    {
        return billDetail;
    }

    public void setBillDetail(BillDetail val)
    {
        billDetail = val;
    }

    public void setGenericManager(BillDetailManager m)
    {
        super.setGenericManager(m);
    }

    public BillDetailManager getGenericManager()
    {
        return (BillDetailManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillDetail(billDetail.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billDetail == null) {
            billDetail = new BillDetail();
        } else if (billDetail.getId() != null) {
            billDetail = getGenericManager().getBillDetailById(billDetail.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillDetailIds != null && selectedBillDetailIds.length > 0) {
            BillDetail obj = getGenericManager().getBillDetailById(selectedBillDetailIds[0]);
            obj.setId(null);
            billDetail = obj;
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
            if (inputValidation(billDetail) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillDetail val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillDetail(billDetail);
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
        billDetail.setProduct(getGenericManager().getProductById(billDetail.getProductId())); 
        billDetail.setBill(getGenericManager().getBillById(billDetail.getBillId())); 
        log.info("exit formToBean()");
    }
    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<Bill> getBillList()
    {
        return getGenericManager().getBillList(); // TODO
    }

    public List<BillDetail> getBillDetailList()
    {
        return getGenericManager().getBillDetailList();
    }

    public void setSelectedBillDetailIds(Long[] val)
    {
        selectedBillDetailIds = val;
    }

    public Long[] getSelectedBillDetailIds()
    {
        return selectedBillDetailIds;
    }
}
