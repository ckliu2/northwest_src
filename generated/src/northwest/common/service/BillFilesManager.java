package northwest.common.service;

import northwest.common.value.BillFiles;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sun Oct 15 16:13:57 CST 2017
*/

public interface BillFilesManager extends CommonManager 
{
    public abstract void saveBillFiles(BillFiles val);

    public abstract void removeBillFiles(BillFiles val);

    public abstract void removeBillFiles(Long id);

    public abstract BillFiles getBillFilesById(Long id);

    public abstract List<BillFiles> getBillFilesList();
    public abstract List<Bill> getBillList();
    public abstract List<UploadedFile> getDoc1List();
    public abstract List<UploadedFile> getDoc2List();
    public abstract List<UploadedFile> getDoc3List();
    public abstract List<UploadedFile> getDoc4List();
    public abstract List<UploadedFile> getDoc5List();
    public abstract List<UploadedFile> getDoc6List();
}

