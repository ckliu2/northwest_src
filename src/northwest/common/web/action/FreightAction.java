package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Sep 12 14:54:27 CST 2011
*/

public class FreightAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Freight freight;
    private Long[] selectedFreightIds;
	String no;

    public FreightAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.FreightAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("FREIGHT");
    }
    
    public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

    public Freight getFreight()
    {
        return freight;
    }

    public void setFreight(Freight val)
    {
        freight = val;
    }

    public void setGenericManager(BillManager m)
    {
        super.setGenericManager(m);
    }

    public BillManager getGenericManager()
    {
        return (BillManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeFreight(freight.getId());
        return DELETE;
    }

    public String edit()
    {
        if (freight == null) {
            freight = new Freight();
        } else if (freight.getId() != null) {
            freight = getGenericManager().getFreightById(freight.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedFreightIds != null && selectedFreightIds.length > 0) {
            Freight obj = getGenericManager().getFreightById(selectedFreightIds[0]);
            obj.setId(null);
            freight = obj;
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
            if (inputValidation(freight) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Freight val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (freight.getId() == null) {
            freight.setCreatedDate(ts);
        }
        freight.setLastModifiedDate(ts);
        getGenericManager().saveFreight(freight);
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
        log.info("exit formToBean()");
    }
    public List<Freight> getFreightList()
    {
        return getGenericManager().getFreightList();
    }

    public void setSelectedFreightIds(Long[] val)
    {
        selectedFreightIds = val;
    }

    public Long[] getSelectedFreightIds()
    {
        return selectedFreightIds;
    }
    
    
    public void saveFreightNoJSON(){         
        try{    	    	 
        	System.out.println("saveFreightNoJSON no="+no);     
        	getSession().setAttribute("freightNo", no); 	
        }catch(Exception ex){
        	System.out.println("saveFreightNoJSON err="+ex.toString());
        }
      
    }
    
    public JSONObject freightIdByJSON() throws Exception{           
        JSONObject jo = new JSONObject();
        try{    	    	 
        	System.out.println("freight.id="+freight.getId());    
        	freight=getGenericManager().getFreightById(freight.getId());
        	System.out.println("freight.name="+freight.getName());    
        	jo.put("id", freight.getId());
        	jo.put("name", freight.getName());
        	getSession().setAttribute("freight", freight); 	
        }catch(Exception ex){
        	System.out.println("freightIdByJSON err="+ex.toString());
        }
        return jo;
    }
    
}
