package northwest.common.service.impl;

import northwest.common.service.RecipientDBManager;
import northwest.common.dao.RecipientDBDAO;
import northwest.common.value.RecipientDB;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:58 CST 2017
*/

public class RecipientDBManagerImpl extends CommonManagerImpl implements RecipientDBManager
{

    public RecipientDBManagerImpl()
    {
    }

    public RecipientDBDAO getGenericDAO()
    {
        return (RecipientDBDAO)super.getGenericDAO();
    }

    public void setGenericDAO(RecipientDBDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveRecipientDB(RecipientDB val)
    {
        getGenericDAO().saveRecipientDB(val);
    }

    public void removeRecipientDB(RecipientDB val)
    {
        getGenericDAO().removeRecipientDB(val);
    }

    public void removeRecipientDB(Long id)
    {
        getGenericDAO().removeRecipientDB(id);
    }

    public RecipientDB getRecipientDBById(Long id)
    {
         return getGenericDAO().findRecipientDBById(id);
    }

    public List<RecipientDB> getRecipientDBList()
    {
        return getGenericDAO().findAllRecipientDB();
    }
}

