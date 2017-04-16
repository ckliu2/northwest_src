package northwest.common.service.impl;

import northwest.common.service.SenderDBManager;
import northwest.common.dao.SenderDBDAO;
import northwest.common.value.SenderDB;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:17 CST 2017
*/

public class SenderDBManagerImpl extends CommonManagerImpl implements SenderDBManager
{

    public SenderDBManagerImpl()
    {
    }

    public SenderDBDAO getGenericDAO()
    {
        return (SenderDBDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SenderDBDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSenderDB(SenderDB val)
    {
        getGenericDAO().saveSenderDB(val);
    }

    public void removeSenderDB(SenderDB val)
    {
        getGenericDAO().removeSenderDB(val);
    }

    public void removeSenderDB(Long id)
    {
        getGenericDAO().removeSenderDB(id);
    }

    public SenderDB getSenderDBById(Long id)
    {
         return getGenericDAO().findSenderDBById(id);
    }

    public List<SenderDB> getSenderDBList()
    {
        return getGenericDAO().findAllSenderDB();
    }
}

