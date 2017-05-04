package northwest.common.service.impl;

import northwest.common.service.BillScheduleManager;
import northwest.common.dao.BillScheduleDAO;
import northwest.common.value.BillSchedule;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Apr 29 13:10:14 CST 2017
*/

public class BillScheduleManagerImpl extends CommonManagerImpl implements BillScheduleManager
{

    public BillScheduleManagerImpl()
    {
    }

    public BillScheduleDAO getGenericDAO()
    {
        return (BillScheduleDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillScheduleDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillSchedule(BillSchedule val)
    {
        getGenericDAO().saveBillSchedule(val);
    }

    public void removeBillSchedule(BillSchedule val)
    {
        getGenericDAO().removeBillSchedule(val);
    }

    public void removeBillSchedule(Long id)
    {
        getGenericDAO().removeBillSchedule(id);
    }

    public BillSchedule getBillScheduleById(Long id)
    {
         return getGenericDAO().findBillScheduleById(id);
    }

    public List<BillSchedule> getBillScheduleList()
    {
        return getGenericDAO().findAllBillSchedule();
    }
    public List<UploadedFile> getImageDiagramList()
    {
        return getGenericDAO().findImageDiagramList();
    }

    public List<UploadedFile> getCheckDiagramList()
    {
        return getGenericDAO().findCheckDiagramList();
    }

    public List<OutputEquipment> getOutputEquipmentList()
    {
        return getGenericDAO().findOutputEquipmentList();
    }

    public List<CustomerDetail> getCustomerAddressList()
    {
        return getGenericDAO().findCustomerAddressList();
    }

    public List<Freight> getFreightList()
    {
        return getGenericDAO().findFreightList();
    }

    public List<Member> getWorkerList()
    {
        return getGenericDAO().findWorkerList();
    }

    public List<BillDetail> getBillDetailList()
    {
        return getGenericDAO().findBillDetailList();
    }

    public List<CustomerScreen> getCustomerScreenList()
    {
        return getGenericDAO().findCustomerScreenList();
    }

    public List<Member> getCuticleerList()
    {
        return getGenericDAO().findCuticleerList();
    }

    public List<Member> getChecker1List()
    {
        return getGenericDAO().findChecker1List();
    }

    public List<Member> getChecker2List()
    {
        return getGenericDAO().findChecker2List();
    }

    public List<Member> getChecker3List()
    {
        return getGenericDAO().findChecker3List();
    }

    public List<Member> getChecker4List()
    {
        return getGenericDAO().findChecker4List();
    }

    public List<Member> getChecker5List()
    {
        return getGenericDAO().findChecker5List();
    }

    public List<Member> getChecker6List()
    {
        return getGenericDAO().findChecker6List();
    }

    public List<Member> getChecker7List()
    {
        return getGenericDAO().findChecker7List();
    }

    public List<Member> getChecker8List()
    {
        return getGenericDAO().findChecker8List();
    }

    public List<Member> getChecker9List()
    {
        return getGenericDAO().findChecker9List();
    }

    public List<Member> getChecker10List()
    {
        return getGenericDAO().findChecker10List();
    }

    public List<Member> getChecker11List()
    {
        return getGenericDAO().findChecker11List();
    }

    public List<Member> getChecker12List()
    {
        return getGenericDAO().findChecker12List();
    }

    public Long[] getIdsFromUploadedFileList(List<UploadedFile> lst)
    {
        return getGenericDAO().getIdsFromUploadedFileList(lst);
    }

    public List<UploadedFile> getUploadedFileListByIds(Long[] ids)
    {
        return getGenericDAO().getUploadedFileListByIds(ids);
    }

}

