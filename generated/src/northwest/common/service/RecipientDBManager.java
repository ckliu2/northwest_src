package northwest.common.service;

import northwest.common.value.RecipientDB;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface RecipientDBManager extends CommonManager 
{
    public abstract void saveRecipientDB(RecipientDB val);

    public abstract void removeRecipientDB(RecipientDB val);

    public abstract void removeRecipientDB(Long id);

    public abstract RecipientDB getRecipientDBById(Long id);

    public abstract List<RecipientDB> getRecipientDBList();
}

