package northwest.common.web.action;

import northwest.common.value.ProfitDetail;
import northwest.common.service.ProfitDetailManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 20:59:03 CST 2017
*/

public class ProfitDetailAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProfitDetail profitDetail;
    private Long[] selectedProfitDetailIds;

    public ProfitDetailAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.ProfitDetailAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PROFITDETAIL");
    }

    public ProfitDetail getProfitDetail()
    {
        return profitDetail;
    }

    public void setProfitDetail(ProfitDetail val)
    {
        profitDetail = val;
    }

    public void setGenericManager(ProfitDetailManager m)
    {
        super.setGenericManager(m);
    }

    public ProfitDetailManager getGenericManager()
    {
        return (ProfitDetailManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProfitDetail(profitDetail.getId());
        return DELETE;
    }

    public String edit()
    {
        if (profitDetail == null) {
            profitDetail = new ProfitDetail();
        } else if (profitDetail.getId() != null) {
            profitDetail = getGenericManager().getProfitDetailById(profitDetail.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProfitDetailIds != null && selectedProfitDetailIds.length > 0) {
            ProfitDetail obj = getGenericManager().getProfitDetailById(selectedProfitDetailIds[0]);
            obj.setId(null);
            profitDetail = obj;
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
            if (inputValidation(profitDetail) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProfitDetail val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProfitDetail(profitDetail);
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
        profitDetail.setProductClass(getGenericManager().getProductClassById(profitDetail.getProductClassId())); 
        profitDetail.setProject(getGenericManager().getProfitById(profitDetail.getProjectId())); 
        profitDetail.setProduct(getGenericManager().getProductById(profitDetail.getProductId())); 
        profitDetail.setProfitNo(getGenericManager().getProfitById(profitDetail.getProfitNoId())); 
        log.info("exit formToBean()");
    }
    public List<ProductClass> getProductClassList()
    {
        return getGenericManager().getProductClassList(); // TODO
    }

    public List<Profit> getProjectList()
    {
        return getGenericManager().getProjectList(); // TODO
    }

    public List<Product> getProductList()
    {
        return getGenericManager().getProductList(); // TODO
    }

    public List<Profit> getProfitNoList()
    {
        return getGenericManager().getProfitNoList(); // TODO
    }

    public List<ProfitDetail> getProfitDetailList()
    {
        return getGenericManager().getProfitDetailList();
    }

    public void setSelectedProfitDetailIds(Long[] val)
    {
        selectedProfitDetailIds = val;
    }

    public Long[] getSelectedProfitDetailIds()
    {
        return selectedProfitDetailIds;
    }
}
