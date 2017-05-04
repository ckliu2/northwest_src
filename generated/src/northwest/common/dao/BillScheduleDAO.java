package northwest.common.dao;

import northwest.common.value.BillSchedule;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:13 CST 2017
*/

public interface BillScheduleDAO extends CommonDAO 
{
    public abstract void saveBillSchedule(BillSchedule val);

    public abstract void removeBillSchedule(BillSchedule val);

    public abstract void removeBillSchedule(Long id);

    public abstract BillSchedule findBillScheduleById(Long id);

    public abstract List<BillSchedule> findAllBillSchedule();
    public abstract List<UploadedFile> findImageDiagramList();
    public abstract List<UploadedFile> findCheckDiagramList();
    public abstract List<OutputEquipment> findOutputEquipmentList();
    public abstract List<CustomerDetail> findCustomerAddressList();
    public abstract List<Freight> findFreightList();
    public abstract List<Member> findWorkerList();
    public abstract List<BillDetail> findBillDetailList();
    public abstract List<CustomerScreen> findCustomerScreenList();
    public abstract List<Member> findCuticleerList();
    public abstract List<Member> findChecker1List();
    public abstract List<Member> findChecker2List();
    public abstract List<Member> findChecker3List();
    public abstract List<Member> findChecker4List();
    public abstract List<Member> findChecker5List();
    public abstract List<Member> findChecker6List();
    public abstract List<Member> findChecker7List();
    public abstract List<Member> findChecker8List();
    public abstract List<Member> findChecker9List();
    public abstract List<Member> findChecker10List();
    public abstract List<Member> findChecker11List();
    public abstract List<Member> findChecker12List();
    public abstract Long[] getIdsFromUploadedFileList(List<UploadedFile> lst);

    public abstract List<UploadedFile> getUploadedFileListByIds(Long[] ids);

}

