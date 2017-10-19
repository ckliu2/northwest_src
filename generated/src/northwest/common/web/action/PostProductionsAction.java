package northwest.common.web.action;

import northwest.common.value.PostProductions;
import northwest.common.service.PostProductionsManager;
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

public class PostProductionsAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PostProductions postProductions;
    private Long[] selectedPostProductionsIds;

    public PostProductionsAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.PostProductionsAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("POSTPRODUCTIONS");
    }

    public PostProductions getPostProductions()
    {
        return postProductions;
    }

    public void setPostProductions(PostProductions val)
    {
        postProductions = val;
    }

    public void setGenericManager(PostProductionsManager m)
    {
        super.setGenericManager(m);
    }

    public PostProductionsManager getGenericManager()
    {
        return (PostProductionsManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePostProductions(postProductions.getId());
        return DELETE;
    }

    public String edit()
    {
        if (postProductions == null) {
            postProductions = new PostProductions();
        } else if (postProductions.getId() != null) {
            postProductions = getGenericManager().getPostProductionsById(postProductions.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPostProductionsIds != null && selectedPostProductionsIds.length > 0) {
            PostProductions obj = getGenericManager().getPostProductionsById(selectedPostProductionsIds[0]);
            obj.setId(null);
            postProductions = obj;
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
            if (inputValidation(postProductions) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PostProductions val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePostProductions(postProductions);
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
        postProductions.setMember(getGenericManager().getMemberById(postProductions.getMemberId())); 
        postProductions.setBillschedule(getGenericManager().getBillScheduleById(postProductions.getBillscheduleId())); 
        log.info("exit formToBean()");
    }
    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<BillSchedule> getBillscheduleList()
    {
        return getGenericManager().getBillscheduleList(); // TODO
    }

    public List<PostProductions> getPostProductionsList()
    {
        return getGenericManager().getPostProductionsList();
    }

    public void setSelectedPostProductionsIds(Long[] val)
    {
        selectedPostProductionsIds = val;
    }

    public Long[] getSelectedPostProductionsIds()
    {
        return selectedPostProductionsIds;
    }
}
