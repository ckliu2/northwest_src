package northwest.common.service;

import northwest.common.value.SenderDB;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface SenderDBManager extends CommonManager 
{
    public abstract void saveSenderDB(SenderDB val);

    public abstract void removeSenderDB(SenderDB val);

    public abstract void removeSenderDB(Long id);

    public abstract SenderDB getSenderDBById(Long id);

    public abstract List<SenderDB> getSenderDBList();
}

