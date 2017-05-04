package northwest.common.web.action;

import northwest.common.value.RecipientDB;
import northwest.common.service.RecipientDBManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class RecipientDBAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private RecipientDB recipientDB;
    private Long[] selectedRecipientDBIds;

    public RecipientDBAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.RecipientDBAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("RECIPIENTDB");
    }

    public RecipientDB getRecipientDB()
    {
        return recipientDB;
    }

    public void setRecipientDB(RecipientDB val)
    {
        recipientDB = val;
    }

    public void setGenericManager(RecipientDBManager m)
    {
        super.setGenericManager(m);
    }

    public RecipientDBManager getGenericManager()
    {
        return (RecipientDBManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeRecipientDB(recipientDB.getId());
        return DELETE;
    }

    public String edit()
    {
        if (recipientDB == null) {
            recipientDB = new RecipientDB();
        } else if (recipientDB.getId() != null) {
            recipientDB = getGenericManager().getRecipientDBById(recipientDB.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedRecipientDBIds != null && selectedRecipientDBIds.length > 0) {
            RecipientDB obj = getGenericManager().getRecipientDBById(selectedRecipientDBIds[0]);
            obj.setId(null);
            recipientDB = obj;
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
            if (inputValidation(recipientDB) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(RecipientDB val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveRecipientDB(recipientDB);
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
    public List<RecipientDB> getRecipientDBList()
    {
        return getGenericManager().getRecipientDBList();
    }

    public void setSelectedRecipientDBIds(Long[] val)
    {
        selectedRecipientDBIds = val;
    }

    public Long[] getSelectedRecipientDBIds()
    {
        return selectedRecipientDBIds;
    }
}
