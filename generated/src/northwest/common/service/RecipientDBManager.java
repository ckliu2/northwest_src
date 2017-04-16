package northwest.common.service;

import northwest.common.value.RecipientDB;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface RecipientDBManager extends CommonManager 
{
    public abstract void saveRecipientDB(RecipientDB val);

    public abstract void removeRecipientDB(RecipientDB val);

    public abstract void removeRecipientDB(Long id);

    public abstract RecipientDB getRecipientDBById(Long id);

    public abstract List<RecipientDB> getRecipientDBList();
}

