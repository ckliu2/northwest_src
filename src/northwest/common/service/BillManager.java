package northwest.common.service;

import northwest.common.value.*;
import java.math.BigDecimal;
import java.util.*;
import com.base.value.*;
import com.common.value.*;
import com.common.service.CommonManager;

public interface BillManager extends CommonManager {
	// Bill
	public abstract List<Bill> getBillByNo(String keyword);

	public abstract Bill getBillById(String id);

	public abstract List<Bill> getBillList();

	public abstract List<Bill> getBills(int pageSize, int pageIndex);

	public abstract List<Group> getBillGroupAuthority();

	public abstract List<Bill> getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate, int pageSize, int pageIndex);

	public abstract int getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate);

	public abstract List<Bill> getProcessStateByCondition(int condition, Customer customer, String billNo, int pageSize, int pageIndex, Group group, boolean isCheck);

	// BillFiles
	public abstract BillFiles getBillFilesByBill(Bill bill);

	public abstract void saveBillFilesByBill(BillFiles val);

	public abstract void saveBillFiles(BillFiles val);

	public abstract BillFiles getBillFilesById(Long id);

	// BillDetail
	public abstract BillDetail getBillDetailById(String id);

	public abstract List<BillDetail> getBillDetailList();

	public abstract List<BillDetail> getBillDetailListByBillNo(String BillNo);

	public abstract List<BillDetail> getBillDetailListByBillNo(String BillNo, int fromRow1, int fromRow2);

	public abstract List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex);

	public abstract List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex, Member worker);

	public abstract int getBillDetailListByBillNoWorker(Bill bill, Member worker);

	public abstract List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex);

	public abstract List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result);

	public abstract List<Meter> getMeterListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex);

	public abstract List<Meter> getMeterListByCondition(Long step, Product product, boolean result);

	// BillSchedule
	public abstract void saveBillSchedule(BillSchedule val);

	public abstract void removeBillSchedule(BillSchedule val);

	public abstract void removeBillSchedule(String id);

	public abstract BillSchedule getBillScheduleById(String id);

	public abstract BillSchedule getBillScheduleByCode(String code);

	public abstract List<BillSchedule> getBillScheduleList();

	public abstract List<UploadedFile> getCheck4photo1List();

	public abstract List<UploadedFile> getCheck4photo2List();

	public abstract List<UploadedFile> getCompletionphoto1List();

	public abstract List<UploadedFile> getCompletionphoto2List();

	public abstract List<UploadedFile> getCompletionphoto3List();

	public abstract List<UploadedFile> getCompletionphoto4List();

	public abstract List<UploadedFile> getCompletionphoto5List();

	public abstract BillSchedule getBillScheduleByBillDetail(BillDetail obj);

	public abstract void initialBillSchedule(String id);

	public abstract Group previousStep(BillSchedule billSchedule, Group group);

	public abstract void saveBarcode(BillSchedule billSchedule, Member member, Group group);

	public abstract List<BillSchedule> getSameProductList(BillSchedule billSchedule);

	public abstract List<BillSchedule> getSameProductItemMarkList(BillSchedule billSchedule);

	public abstract void saveBarcodeCuticle(BillSchedule billSchedule, Member member, boolean result);

	// Customer
	public abstract Customer getCustomerById(String id);

	public abstract List<Customer> getCustomerByKeyWord(String KeyWord);

	public abstract List<Customer> getCustomerList();

	// CustomerDetail
	public abstract void saveCustomerDetail(CustomerDetail val);

	public abstract void removeCustomerDetail(CustomerDetail val);

	public abstract void removeCustomerDetail(Long id);

	public abstract CustomerDetail getCustomerDetailById(Long id);

	public abstract List<CustomerDetail> getCustomerDetailList();

	public abstract List<CustomerDetail> getCustomerDetailListByCustomerNo(Customer customer);

	public abstract List<CustomerDetail> getCustomerDetailListByCustomerByQuery(Customer customer, String key);

	public abstract CustomerDetail getCustomerDetailLastByCustomerNo(Customer customer);

	public abstract List<UploadedFile> getPhoto1List();

	public abstract List<UploadedFile> getPhoto2List();

	public abstract List<UploadedFile> getPhoto3List();

	public abstract List<UploadedFile> getPhoto4List();

	public abstract List<UploadedFile> getPhoto5List();

	// Product
	public abstract Product getProductById(String id);

	public abstract List<Product> getProductList();

	public abstract List<Product> getProductListByCondition(String name, String id);

	// Freight
	public abstract void saveFreight(Freight val);

	public abstract void removeFreight(Freight val);

	public abstract void removeFreight(Long id);

	public abstract Freight getFreightById(Long id);

	public abstract List<Freight> getFreightList();

	// BillAuthority
	public abstract void saveBillAuthority(BillAuthority val);

	public abstract void removeBillAuthority(BillAuthority val);

	public abstract void removeBillAuthority(Long id);

	public abstract BillAuthority getBillAuthorityById(Long id);

	public abstract List<BillAuthority> getBillAuthorityList();

	public abstract List<BillAuthority> getBillAuthorityListByBill(Bill bill);

	public abstract List<BillAuthority> getBillAuthorityListByBill(String bill);

	public abstract List<BillAuthority> getBillAuthorityListByByIds(Long[] ids);

	public abstract List<Group> getDeleteStepList(BillSchedule billSchedule);

	public abstract int getAllCompleteStatusByBill(Bill bill, Group group, boolean status);

	public abstract boolean isStepEnabled(Bill bill, Group group);

	public abstract boolean isSettingPermissions(Member member, Group group);

	public abstract boolean isEnabledEdit1(BillSchedule billSchedule, Group group);

	public abstract boolean isEnabledEdit(BillSchedule billSchedule, Group group);

	public abstract Vector isAlreadyEdits(BillSchedule billSchedule, Group group);

	public abstract void deleteBarcode(BillSchedule billSchedule, Group group);

	public abstract Boolean Checker(BillSchedule billSchedule, Member member, Group group);

	public abstract Vector completeDetail(BillSchedule billSchedule);

	// CustomerScreen
	public abstract void saveCustomerScreen(CustomerScreen val);

	public abstract void removeCustomerScreen(CustomerScreen val);

	public abstract void removeCustomerScreen(Long id);

	public abstract CustomerScreen getCustomerScreenById(Long id);

	public abstract List<CustomerScreen> getCustomerScreenList();

	public abstract List<CustomerScreen> getCustomerScreenListByCustomerDetail(CustomerDetail c);

	public abstract List<CustomerScreen> getCustomerScreenListByBill(Bill bill);

	// ProductClass
	public abstract void saveProductClass(ProductClass val);

	public abstract void removeProductClass(ProductClass val);

	public abstract void removeProductClass(String id);

	public abstract ProductClass getProductClassById(String id);

	public abstract List<ProductClass> getProductClassList();

	// OutputEquipment
	public abstract void saveOutputEquipment(OutputEquipment val);

	public abstract void removeOutputEquipment(OutputEquipment val);

	public abstract void removeOutputEquipment(Long id);

	public abstract OutputEquipment getOutputEquipmentById(Long id);

	public abstract List<OutputEquipment> getOutputEquipmentList();

	// BillFinish
	public abstract void saveBillFinish(BillFinish val);

	public abstract void removeBillFinish(BillFinish val);

	public abstract void removeBillFinish(Long id);

	public abstract BillFinish getBillFinishById(Long id);

	public abstract BillFinish getBillFinishByBill(Bill b);

	public abstract List<BillFinish> getBillFinishList();

	// ProcessState
	public abstract List<ProcessState> getProcessStateList(String billNo, Group group, boolean status, int xor, String worker);

	public abstract List<ProcessState> getProcessStateList();

	// Profit
	public abstract ProfitSum getProfitListSum(List<Profit> ls);

	public abstract ProfitSum getProfitListSum(String projectNo, String start, String end, Customer customer, Member salesmen);

	public abstract List<Profit> getProfitList(String projectNo, String start, String end, Customer customer, Member salesmen, int pageSize, int pageIndex);

	public abstract int getProfitListByConditionCount(String projectNo, String start, String end, Customer customer, Member salesmen);

	public abstract Profit getProfitById(String id);

	public abstract Profit getProfitBySalesNo(String salesNo);

	public abstract List<Profit> getProfitList(String projectNo, String start, String end, Customer customer, Member salesmen);

	public abstract List<Profit> getProfitRateList(String start, String end, int tag, BigDecimal profitPerc);

	// ProfitDetail
	public abstract List<ProfitDetail> getProfitDetailList(Profit profit);

	public abstract List<ProfitDetail> getProfitDetailListBySalesNo(String salesNo);

	public abstract List getProfitDetailListByProduct(String startDate, String endDate, Product product);

	// ProfitProduct
	public abstract ProfitProduct getProfitProductList(String startDate, String endDate, Product product);

	// WorkEfficiency
	public abstract List<WorkEfficiency> getWorkEfficiencyByMember(String startDate, String endDate, Member member);

	// profitFee
	public abstract List<ProfitFee> getProfitFeeByBill(Bill bill);

	// StandardCost
	public abstract void saveStandardCost(StandardCost val);

	public abstract void removeStandardCost(StandardCost val);

	public abstract void removeStandardCost(Long id);

	public abstract StandardCost getStandardCostById(Long id);

	public abstract List<StandardCost> getStandardCostList(String salesNo);

	// CustomerStandardCost
	public abstract void saveCustomerStandardCost(CustomerStandardCost val);

	public abstract void removeCustomerStandardCost(CustomerStandardCost val);

	public abstract void removeCustomerStandardCost(Long id);

	public abstract CustomerStandardCost getCustomerStandardCostById(Long id);

	public abstract List<CustomerStandardCost> getCustomerStandardCostList(Customer customer);

	// BillQA
	public abstract void saveBillQA(BillQA val);

	public abstract void removeBillQA(BillQA val);

	public abstract void removeBillQA(Long id);

	public abstract BillQA getBillQAById(Long id);

	public abstract List<BillQA> getBillQAList(Bill bill);

	public abstract List<BillQA> getBillQAList(String startDate, String endDate, String billno, Customer customer);

	// Logistics
	public abstract void saveLogistics(Logistics val);

	public abstract void removeLogistics(Long id);

	public abstract Logistics getLogisticsById(Long id);

	public abstract List<Logistics> getLogisticsList(String keyword, Date startDate, Date endDate);

	// SenderDB
	public abstract List<SenderDB> getSenderDBList(String keyword);

	// LogisticsCode
	public abstract void saveLogisticsCode(LogisticsCode val);

	public abstract void removeLogisticsCode(Logistics val);

	public abstract LogisticsCode getLastOneLogisticsCode();

	// RecipientDB
	public abstract List<RecipientDB> getRecipientDBList(String keyword);

}
