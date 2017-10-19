package northwest.common.dao;

import northwest.common.value.*;

import java.math.BigDecimal;
import java.util.*;

import com.base.value.*;
import com.common.dao.CommonDAO;
import com.common.value.Member;

public interface BillDAO extends CommonDAO {
	// Bill
	public abstract List<Bill> findBillByNo(String keyword);

	public abstract Bill findBillById(String id);

	public abstract List<Bill> findAllBill();

	public abstract List<Bill> getBills(int pageSize, int pageIndex);

	public abstract List<Group> getBillGroupAuthority();

	public abstract List<Bill> getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate, int pageSize, int pageIndex);

	public abstract int getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate);

	public abstract List<Bill> getProcessStateByCondition(int condition, Customer customer, String billNo, int pageSize, int pageIndex, Group group, boolean isCheck);

	// BillFiles
	public abstract BillFiles getBillFilesByBill(Bill bill);

	public abstract void saveBillFilesByBill(BillFiles val);

	public abstract void saveBillFiles(BillFiles val);

	public abstract BillFiles findBillFilesById(Long id);

	// BillDetail
	public abstract BillDetail findBillDetailById(String id);

	public abstract List<BillDetail> findAllBillDetail();

	public abstract List<BillDetail> getBillDetailListByBillNo(String BillNo);

	public abstract List<BillDetail> getBillDetailListByBillNo(String BillNo, int fromRow1, int fromRow2);

	public abstract List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex);

	public abstract List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result);

	public abstract List<Meter> getMeterListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex);

	public abstract List<Meter> getMeterListByCondition(Long step, Product product, boolean result);

	public abstract List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex);

	public abstract List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex, Member worker);

	public abstract int getBillDetailListByBillNoWorker(Bill bill, Member worker);

	// BillSchedule
	public abstract void saveBillSchedule(BillSchedule val);

	public abstract void removeBillSchedule(BillSchedule val);

	public abstract void removeBillSchedule(String id);

	public abstract BillSchedule findBillScheduleById(String id);

	public abstract BillSchedule findBillScheduleByCode(String code);

	public abstract List<BillSchedule> findAllBillSchedule();

	public abstract List<UploadedFile> findCheck4photo1List();

	public abstract List<UploadedFile> findCheck4photo2List();

	public abstract List<UploadedFile> findCompletionphoto1List();

	public abstract List<UploadedFile> findCompletionphoto2List();

	public abstract List<UploadedFile> findCompletionphoto3List();

	public abstract List<UploadedFile> findCompletionphoto4List();

	public abstract List<UploadedFile> findCompletionphoto5List();

	public abstract BillSchedule getBillScheduleByBillDetail(BillDetail obj);

	public abstract void initialBillSchedule(String id);

	public abstract Group previousStep(BillSchedule billSchedule, Group group);

	public abstract void saveBarcode(BillSchedule billSchedule, Member member, Group group);

	public abstract List<BillSchedule> getSameProductList(BillSchedule billSchedule);

	public abstract List<BillSchedule> getSameProductItemMarkList(BillSchedule billSchedule);

	public abstract void saveBarcodeCuticle(BillSchedule billSchedule, Member member, boolean result);

	// Customer
	public abstract Customer findCustomerById(String id);

	public abstract List<Customer> findAllCustomer();

	public abstract List<Customer> getCustomerByKeyWord(String KeyWord);

	// CustomerDetail
	public abstract void saveCustomerDetail(CustomerDetail val);

	public abstract void removeCustomerDetail(CustomerDetail val);

	public abstract void removeCustomerDetail(Long id);

	public abstract CustomerDetail findCustomerDetailById(Long id);

	public abstract List<CustomerDetail> findAllCustomerDetail();

	public abstract CustomerDetail getCustomerDetailLastByCustomerNo(Customer customer);

	public abstract List<UploadedFile> findPhoto1List();

	public abstract List<UploadedFile> findPhoto2List();

	public abstract List<UploadedFile> findPhoto3List();

	public abstract List<UploadedFile> findPhoto4List();

	public abstract List<UploadedFile> findPhoto5List();

	public abstract List<CustomerDetail> getCustomerDetailListByCustomerNo(Customer customer);

	public abstract List<CustomerDetail> getCustomerDetailListByCustomerByQuery(Customer customer, String key);

	// Product
	public abstract Product findProductById(String id);

	public abstract List<Product> findAllProduct();

	public abstract List<Product> getProductListByCondition(String name, String id);

	// Freight
	public abstract void saveFreight(Freight val);

	public abstract void removeFreight(Freight val);

	public abstract void removeFreight(Long id);

	public abstract Freight findFreightById(Long id);

	public abstract List<Freight> findAllFreight();

	// BillAuthority
	public abstract void saveBillAuthority(BillAuthority val);

	public abstract void removeBillAuthority(BillAuthority val);

	public abstract void removeBillAuthority(Long id);

	public abstract BillAuthority findBillAuthorityById(Long id);

	public abstract List<BillAuthority> findAllBillAuthority();

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

	public abstract CustomerScreen findCustomerScreenById(Long id);

	public abstract List<CustomerScreen> findAllCustomerScreen();

	public abstract List<CustomerScreen> getCustomerScreenListByCustomerDetail(CustomerDetail c);

	public abstract List<CustomerScreen> getCustomerScreenListByBill(Bill bill);

	// ProductClass
	public abstract void saveProductClass(ProductClass val);

	public abstract void removeProductClass(ProductClass val);

	public abstract void removeProductClass(String id);

	public abstract ProductClass findProductClassById(String id);

	public abstract List<ProductClass> findAllProductClass();

	// OutputEquipment
	public abstract void saveOutputEquipment(OutputEquipment val);

	public abstract void removeOutputEquipment(OutputEquipment val);

	public abstract void removeOutputEquipment(Long id);

	public abstract OutputEquipment findOutputEquipmentById(Long id);

	public abstract List<OutputEquipment> findAllOutputEquipment();

	// BillFinish
	public abstract void saveBillFinish(BillFinish val);

	public abstract void removeBillFinish(BillFinish val);

	public abstract void removeBillFinish(Long id);

	public abstract BillFinish findBillFinishById(Long id);

	public abstract List<BillFinish> findAllBillFinish();

	public abstract BillFinish findBillFinishByBill(Bill b);

	// ProcessState
	public abstract List<ProcessState> findAllProcessState(String billNo, Group group, boolean status, int xor, String worker);

	public abstract List<ProcessState> findAllProcessState();

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

	public abstract StandardCost findStandardCostById(Long id);

	public abstract List<StandardCost> findAllStandardCost(String salesNo);

	// CustomerStandardCost
	public abstract void saveCustomerStandardCost(CustomerStandardCost val);

	public abstract void removeCustomerStandardCost(CustomerStandardCost val);

	public abstract void removeCustomerStandardCost(Long id);

	public abstract CustomerStandardCost findCustomerStandardCostById(Long id);

	public abstract List<CustomerStandardCost> findAllCustomerStandardCost(Customer customer);

	// BillQA
	public abstract void saveBillQA(BillQA val);

	public abstract void removeBillQA(BillQA val);

	public abstract void removeBillQA(Long id);

	public abstract BillQA findBillQAById(Long id);

	public abstract List<BillQA> findAllBillQA(Bill bill);

	public abstract List<BillQA> findAllBillQA(String startDate, String endDate, String billno, Customer customer);

	// Logistics
	public abstract void saveLogistics(Logistics val);

	public abstract void removeLogistics(Long id);

	public abstract Logistics findLogisticsById(Long id);

	public abstract List<Logistics> findAllLogistics(String keyword, Date startDate, Date endDate);

	// SenderDB
	public abstract List<SenderDB> findAllSenderDB(String keyword);

	// LogisticsCode
	public abstract void saveLogisticsCode(LogisticsCode val);

	public abstract void removeLogisticsCode(Logistics val);

	public abstract LogisticsCode getLastOneLogisticsCode(AppProperty freightCompany);

	// RecipientDB
	public abstract List<RecipientDB> findAllRecipientDB(String keyword);

	// Weights
	public abstract void saveWeights(Weights val);

	public abstract void removeWeights(Weights val);

	public abstract void removeWeights(Long id);

	public abstract Weights findWeightsById(Long id);

	public abstract List<Weights> findAllWeights(OutputEquipment outputEquipment);

	public abstract String[] getIdsFromProductClassList(List<ProductClass> lst);

	public abstract List<ProductClass> getProductClassListByIds(String[] ids);

	// PostProductions
	public abstract void savePostProductions(PostProductions val);

}
