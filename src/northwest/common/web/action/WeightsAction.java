package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import org.json.*;


public class WeightsAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Weights weights;
    private String[] productClassesIds;
	OutputEquipment outputEquipment;
	int reload;

	public WeightsAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.WeightsAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("WEIGHTS");
    }

    public Weights getWeights()
    {
        return weights;
    }

    public void setWeights(Weights val)
    {
        weights = val;
    }
    
    public int getReload() {
		return reload;
	}

	public void setReload(int reload) {
		this.reload = reload;
	}
	
    public OutputEquipment getOutputEquipment() {
 		return outputEquipment;
 	}

 	public void setOutputEquipment(OutputEquipment outputEquipment) {
 		this.outputEquipment = outputEquipment;
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
        getGenericManager().removeWeights(weights.getId());
        return DELETE;
    }

    public String edit()
    {
        if (weights == null) {
            weights = new Weights();
        } else if (weights.getId() != null) {
            weights = getGenericManager().getWeightsById(weights.getId());
        } else { // TODO
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
            if (inputValidation(weights) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Weights val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveWeights(weights);
        appendXworkParam("weights.id="+weights.getId());
        appendXworkParam("outputEquipment.id="+weights.getOutputEquipmentId());
        appendXworkParam("reload=1");
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        productClassesIds = getGenericManager().getIdsFromProductClassList(weights.getProductClasses());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        weights.setOutputEquipment(getGenericManager().getOutputEquipmentById(weights.getOutputEquipmentId())); 
        weights.setProductClasses(getGenericManager().getProductClassListByIds(productClassesIds)); 
        log.info("exit formToBean()");
    }
    
    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericManager().getOutputEquipmentList(); // TODO
    }

    public List getProductClassesList()
    {
        return getGenericManager().getProductClassList();
    }

    public void setProductClassesIds(String[] val)
    {
        productClassesIds = val;
    }

    public String[] getProductClassesIds()
    {
        return productClassesIds;
    }

    public List<Weights> getWeightsList()
    {
    	outputEquipment = getGenericManager().getOutputEquipmentById(outputEquipment.getId());
        return getGenericManager().getWeightsList(outputEquipment);
    }
    
    
    public String removeWeightsByIDJSON()
    {
    	try{    		
    		getGenericManager().removeWeights(weights.getId());    		
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}
        return SUCCESS;
    }
    
    
    public JSONArray weightsByOutputEquipmentJSON(){
    	JSONArray ar = new JSONArray();
    	try{    	
    		outputEquipment = getGenericManager().getOutputEquipmentById(outputEquipment.getId());
    		List<Weights> ls= getGenericManager().getWeightsList(outputEquipment);
    		for (Weights w : ls) {
    			JSONObject jo = new JSONObject();    	
    			jo.put("weightsId", w.getId());
    			jo.put("title", w.getProductClasses());    
    			jo.put("inkWeight", w.getInkWeight());   
    			jo.put("productClassWeight", w.getProductClassWeight());   
    			ar.put(jo);
    		}
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}
      return ar;
    }

}
