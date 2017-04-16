package northwest.common.dao;

import northwest.common.value.SenderDB;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 08 13:06:16 CST 2017
*/

public interface SenderDBDAO extends CommonDAO 
{
    public abstract void saveSenderDB(SenderDB val);

    public abstract void removeSenderDB(SenderDB val);

    public abstract void removeSenderDB(Long id);

    public abstract SenderDB findSenderDBById(Long id);

    public abstract List<SenderDB> findAllSenderDB();
}

