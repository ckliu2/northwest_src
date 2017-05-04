package northwest.common.service;

import northwest.common.value.BillSchedule;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public interface BillScheduleManager extends CommonManager 
{
    public abstract void saveBillSchedule(BillSchedule val);

    public abstract void removeBillSchedule(BillSchedule val);

    public abstract void removeBillSchedule(Long id);

    public abstract BillSchedule getBillScheduleById(Long id);

    public abstract List<BillSchedule> getBillScheduleList();
    public abstract List<UploadedFile> getImageDiagramList();
    public abstract List<UploadedFile> getCheckDiagramList();
    public abstract List<OutputEquipment> getOutputEquipmentList();
    public abstract List<CustomerDetail> getCustomerAddressList();
    public abstract List<Freight> getFreightList();
    public abstract List<Member> getWorkerList();
    public abstract List<BillDetail> getBillDetailList();
    public abstract List<CustomerScreen> getCustomerScreenList();
    public abstract List<Member> getCuticleerList();
    public abstract List<Member> getChecker1List();
    public abstract List<Member> getChecker2List();
    public abstract List<Member> getChecker3List();
    public abstract List<Member> getChecker4List();
    public abstract List<Member> getChecker5List();
    public abstract List<Member> getChecker6List();
    public abstract List<Member> getChecker7List();
    public abstract List<Member> getChecker8List();
    public abstract List<Member> getChecker9List();
    public abstract List<Member> getChecker10List();
    public abstract List<Member> getChecker11List();
    public abstract List<Member> getChecker12List();
    public abstract Long[] getIdsFromUploadedFileList(List<UploadedFile> lst);

    public abstract List<UploadedFile> getUploadedFileListByIds(Long[] ids);

}

