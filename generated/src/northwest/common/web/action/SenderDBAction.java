package northwest.common.web.action;

import northwest.common.value.SenderDB;
import northwest.common.service.SenderDBManager;
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

public class SenderDBAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SenderDB senderDB;
    private Long[] selectedSenderDBIds;

    public SenderDBAction()
    {
        log = LogFactory.getLog(northwest.common.web.action.SenderDBAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SENDERDB");
    }

    public SenderDB getSenderDB()
    {
        return senderDB;
    }

    public void setSenderDB(SenderDB val)
    {
        senderDB = val;
    }

    public void setGenericManager(SenderDBManager m)
    {
        super.setGenericManager(m);
    }

    public SenderDBManager getGenericManager()
    {
        return (SenderDBManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSenderDB(senderDB.getId());
        return DELETE;
    }

    public String edit()
    {
        if (senderDB == null) {
            senderDB = new SenderDB();
        } else if (senderDB.getId() != null) {
            senderDB = getGenericManager().getSenderDBById(senderDB.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSenderDBIds != null && selectedSenderDBIds.length > 0) {
            SenderDB obj = getGenericManager().getSenderDBById(selectedSenderDBIds[0]);
            obj.setId(null);
            senderDB = obj;
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
            if (inputValidation(senderDB) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SenderDB val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSenderDB(senderDB);
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
    public List<SenderDB> getSenderDBList()
    {
        return getGenericManager().getSenderDBList();
    }

    public void setSelectedSenderDBIds(Long[] val)
    {
        selectedSenderDBIds = val;
    }

    public Long[] getSelectedSenderDBIds()
    {
        return selectedSenderDBIds;
    }
}
