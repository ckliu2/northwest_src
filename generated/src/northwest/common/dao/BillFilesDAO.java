package northwest.common.dao;

import northwest.common.value.BillFiles;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface BillFilesDAO extends CommonDAO 
{
    public abstract void saveBillFiles(BillFiles val);

    public abstract void removeBillFiles(BillFiles val);

    public abstract void removeBillFiles(Long id);

    public abstract BillFiles findBillFilesById(Long id);

    public abstract List<BillFiles> findAllBillFiles();
    public abstract List<Bill> findBillList();
    public abstract List<UploadedFile> findDoc1List();
    public abstract List<UploadedFile> findDoc2List();
    public abstract List<UploadedFile> findDoc3List();
    public abstract List<UploadedFile> findDoc4List();
    public abstract List<UploadedFile> findDoc5List();
    public abstract List<UploadedFile> findDoc6List();
}

