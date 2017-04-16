package northwest.common.dao;

import northwest.common.value.RecipientDB;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface RecipientDBDAO extends CommonDAO 
{
    public abstract void saveRecipientDB(RecipientDB val);

    public abstract void removeRecipientDB(RecipientDB val);

    public abstract void removeRecipientDB(Long id);

    public abstract RecipientDB findRecipientDBById(Long id);

    public abstract List<RecipientDB> findAllRecipientDB();
}

