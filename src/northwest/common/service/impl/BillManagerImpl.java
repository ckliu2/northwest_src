package northwest.common.service.impl;

import northwest.common.service.BillManager;
import northwest.common.dao.BillDAO;
import northwest.common.value.*;

import com.base.value.*;

import java.math.BigDecimal;
import java.util.*;

import com.common.service.impl.CommonManagerImpl;
import com.common.value.Member;

public class BillManagerImpl extends CommonManagerImpl implements BillManager {

	public BillManagerImpl() {
	}

	public BillDAO getGenericDAO() {
		return (BillDAO) super.getGenericDAO();
	}

	public void setGenericDAO(BillDAO dao) {
		super.setGenericDAO(dao);
	}

	// Bill
	public List<Bill> getBillByNo(String keyword) {
		return getGenericDAO().findBillByNo(keyword);
	}

	public Bill getBillById(String id) {
		return getGenericDAO().findBillById(id);
	}

	public List<Bill> getBillList() {
		return getGenericDAO().findAllBill();
	}

	public List<Bill> getBills(int pageSize, int pageIndex) {
		return getGenericDAO().getBills(pageSize, pageIndex);
	}

	public List<BillDetail> getBillDetailListByBillNo(String BillNo) {

		return getGenericDAO().getBillDetailListByBillNo(BillNo);
	}

	public List<BillDetail> getBillDetailListByBillNo(String BillNo, int fromRow1, int fromRow2) {
		return getGenericDAO().getBillDetailListByBillNo(BillNo, fromRow1, fromRow2);
	}

	public List<Group> getBillGroupAuthority() {
		return getGenericDAO().getBillGroupAuthority();
	}

	public List<Bill> getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate, int pageSize, int pageIndex) {
		return getGenericDAO().getBillListByCondition(customer, billNo, state, startDate, endDate, pageSize, pageIndex);
	}

	public int getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate) {
		return getGenericDAO().getBillListByCondition(customer, billNo, state, startDate, endDate);
	}

	/*
	 * public List<Bill> getBillListByCondition(int condition,Customer
	 * customer,String billNo,int pageSize,int pageIndex,Group group,boolean
	 * state){ return
	 * getGenericDAO().getBillListByCondition(condition,customer,billNo,pageSize
	 * ,pageIndex,group,state); }
	 * 
	 * public int getBillListByConditionCount(int condition,Customer
	 * customer,String billNo,Group group,boolean state){ return
	 * getGenericDAO().getBillListByConditionCount(condition,customer,billNo,
	 * group,state); }
	 */

	public List<Bill> getProcessStateByCondition(int condition, Customer customer, String billNo, int pageSize, int pageIndex, Group group, boolean isCheck) {
		return getGenericDAO().getProcessStateByCondition(condition, customer, billNo, pageSize, pageIndex, group, isCheck);
	}

	// BillFiles
	public BillFiles getBillFilesByBill(Bill bill) {
		return getGenericDAO().getBillFilesByBill(bill);
	}

	public void saveBillFilesByBill(BillFiles val) {
		getGenericDAO().saveBillFilesByBill(val);
	}

	public void saveBillFiles(BillFiles val) {
		getGenericDAO().saveBillFiles(val);
	}

	public BillFiles getBillFilesById(Long id) {
		return getGenericDAO().findBillFilesById(id);
	}

	// BillDetail
	public BillDetail getBillDetailById(String id) {
		return getGenericDAO().findBillDetailById(id);
	}

	public List<BillDetail> getBillDetailList() {
		return getGenericDAO().findAllBillDetail();
	}

	public List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex) {
		return getGenericDAO().getBillScheduleListByCondition(step, product, result, pageSize, pageIndex);
	}

	public List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result) {
		return getGenericDAO().getBillScheduleListByCondition(step, product, result);
	}

	public List<Meter> getMeterListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex) {
		return getGenericDAO().getMeterListByCondition(step, product, result, pageSize, pageIndex);
	}

	public List<Meter> getMeterListByCondition(Long step, Product product, boolean result) {
		return getGenericDAO().getMeterListByCondition(step, product, result);
	}

	public List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex) {
		return getGenericDAO().getBillDetailListByBillNo(bill, pageSize, pageIndex);
	}

	public List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex, Member worker) {
		return getGenericDAO().getBillDetailListByBillNo(bill, pageSize, pageIndex, worker);
	}

	public int getBillDetailListByBillNoWorker(Bill bill, Member worker) {
		return getGenericDAO().getBillDetailListByBillNoWorker(bill, worker);
	}

	// BillSchedule
	public void saveBillSchedule(BillSchedule val) {
		getGenericDAO().saveBillSchedule(val);
	}

	public void removeBillSchedule(BillSchedule val) {
		getGenericDAO().removeBillSchedule(val);
	}

	public void removeBillSchedule(String id) {
		getGenericDAO().removeBillSchedule(id);
	}

	public BillSchedule getBillScheduleById(String id) {
		return getGenericDAO().findBillScheduleById(id);
	}

	public BillSchedule getBillScheduleByCode(String code) {
		return getGenericDAO().findBillScheduleByCode(code);
	}

	public List<BillSchedule> getBillScheduleList() {
		return getGenericDAO().findAllBillSchedule();
	}

	public List<UploadedFile> getCheck4photo1List() {
		return getGenericDAO().findCheck4photo1List();
	}

	public List<UploadedFile> getCheck4photo2List() {
		return getGenericDAO().findCheck4photo2List();
	}

	public List<UploadedFile> getCompletionphoto1List() {
		return getGenericDAO().findCompletionphoto1List();
	}

	public List<UploadedFile> getCompletionphoto2List() {
		return getGenericDAO().findCompletionphoto2List();
	}

	public List<UploadedFile> getCompletionphoto3List() {
		return getGenericDAO().findCompletionphoto3List();
	}

	public List<UploadedFile> getCompletionphoto4List() {
		return getGenericDAO().findCompletionphoto4List();
	}

	public List<UploadedFile> getCompletionphoto5List() {
		return getGenericDAO().findCompletionphoto5List();
	}

	public BillSchedule getBillScheduleByBillDetail(BillDetail obj) {
		return getGenericDAO().getBillScheduleByBillDetail(obj);
	}

	public void initialBillSchedule(String id) {
		getGenericDAO().initialBillSchedule(id);
	}

	public Group previousStep(BillSchedule billSchedule, Group group) {
		return getGenericDAO().previousStep(billSchedule, group);
	}

	public void saveBarcode(BillSchedule billSchedule, Member member, Group group) {
		getGenericDAO().saveBarcode(billSchedule, member, group);
	}

	public List<BillSchedule> getSameProductList(BillSchedule billSchedule) {
		return getGenericDAO().getSameProductList(billSchedule);
	}

	public List<BillSchedule> getSameProductItemMarkList(BillSchedule billSchedule) {
		return getGenericDAO().getSameProductItemMarkList(billSchedule);
	}

	public void saveBarcodeCuticle(BillSchedule billSchedule, Member member, boolean result) {
		getGenericDAO().saveBarcodeCuticle(billSchedule, member, result);
	}

	// Customer
	public Customer getCustomerById(String id) {
		return getGenericDAO().findCustomerById(id);
	}

	public List<Customer> getCustomerList() {
		return getGenericDAO().findAllCustomer();
	}

	public List<Customer> getCustomerByKeyWord(String KeyWord) {
		return getGenericDAO().getCustomerByKeyWord(KeyWord);
	}

	// CustomerDetail
	public void saveCustomerDetail(CustomerDetail val) {
		getGenericDAO().saveCustomerDetail(val);
	}

	public void removeCustomerDetail(CustomerDetail val) {
		getGenericDAO().removeCustomerDetail(val);
	}

	public void removeCustomerDetail(Long id) {
		getGenericDAO().removeCustomerDetail(id);
	}

	public CustomerDetail getCustomerDetailById(Long id) {
		return getGenericDAO().findCustomerDetailById(id);
	}

	public List<CustomerDetail> getCustomerDetailList() {
		return getGenericDAO().findAllCustomerDetail();
	}

	public CustomerDetail getCustomerDetailLastByCustomerNo(Customer customer) {
		return getGenericDAO().getCustomerDetailLastByCustomerNo(customer);
	}

	public List<UploadedFile> getPhoto1List() {
		return getGenericDAO().findPhoto1List();
	}

	public List<UploadedFile> getPhoto2List() {
		return getGenericDAO().findPhoto2List();
	}

	public List<UploadedFile> getPhoto3List() {
		return getGenericDAO().findPhoto3List();
	}

	public List<UploadedFile> getPhoto4List() {
		return getGenericDAO().findPhoto4List();
	}

	public List<UploadedFile> getPhoto5List() {
		return getGenericDAO().findPhoto5List();
	}

	public List<CustomerDetail> getCustomerDetailListByCustomerNo(Customer customer) {
		return getGenericDAO().getCustomerDetailListByCustomerNo(customer);
	}

	public List<CustomerDetail> getCustomerDetailListByCustomerByQuery(Customer customer, String key) {
		return getGenericDAO().getCustomerDetailListByCustomerByQuery(customer, key);
	}

	// Product
	public Product getProductById(String id) {
		return getGenericDAO().findProductById(id);
	}

	public List<Product> getProductList() {
		return getGenericDAO().findAllProduct();
	}

	public List<Product> getProductListByCondition(String name, String id) {
		return getGenericDAO().getProductListByCondition(name, id);
	}

	// Freight
	public void saveFreight(Freight val) {
		getGenericDAO().saveFreight(val);
	}

	public void removeFreight(Freight val) {
		getGenericDAO().removeFreight(val);
	}

	public void removeFreight(Long id) {
		getGenericDAO().removeFreight(id);
	}

	public Freight getFreightById(Long id) {
		return getGenericDAO().findFreightById(id);
	}

	public List<Freight> getFreightList() {
		return getGenericDAO().findAllFreight();
	}

	// BillAuthority
	public void saveBillAuthority(BillAuthority val) {
		getGenericDAO().saveBillAuthority(val);
	}

	public void removeBillAuthority(BillAuthority val) {
		getGenericDAO().removeBillAuthority(val);
	}

	public void removeBillAuthority(Long id) {
		getGenericDAO().removeBillAuthority(id);
	}

	public BillAuthority getBillAuthorityById(Long id) {
		return getGenericDAO().findBillAuthorityById(id);
	}

	public List<BillAuthority> getBillAuthorityList() {
		return getGenericDAO().findAllBillAuthority();
	}

	public List<BillAuthority> getBillAuthorityListByBill(Bill bill) {
		return getGenericDAO().getBillAuthorityListByBill(bill);
	}

	public List<BillAuthority> getBillAuthorityListByBill(String bill) {
		return getGenericDAO().getBillAuthorityListByBill(bill);
	}

	public List<BillAuthority> getBillAuthorityListByByIds(Long[] ids) {
		return getGenericDAO().getBillAuthorityListByByIds(ids);
	}

	public List<Group> getDeleteStepList(BillSchedule billSchedule) {
		return getGenericDAO().getDeleteStepList(billSchedule);
	}

	public int getAllCompleteStatusByBill(Bill bill, Group group, boolean status) {
		return getGenericDAO().getAllCompleteStatusByBill(bill, group, status);
	}

	public boolean isStepEnabled(Bill bill, Group group) {
		return getGenericDAO().isStepEnabled(bill, group);
	}

	public boolean isSettingPermissions(Member member, Group group) {
		return getGenericDAO().isSettingPermissions(member, group);
	}

	public boolean isEnabledEdit1(BillSchedule billSchedule, Group group) {
		return getGenericDAO().isEnabledEdit1(billSchedule, group);
	}

	public boolean isEnabledEdit(BillSchedule billSchedule, Group group) {
		return getGenericDAO().isEnabledEdit(billSchedule, group);
	}

	public Vector isAlreadyEdits(BillSchedule billSchedule, Group group) {
		return getGenericDAO().isAlreadyEdits(billSchedule, group);
	}

	public void deleteBarcode(BillSchedule billSchedule, Group group) {
		getGenericDAO().deleteBarcode(billSchedule, group);
	}

	public Boolean Checker(BillSchedule billSchedule, Member member, Group group) {
		return getGenericDAO().Checker(billSchedule, member, group);
	}

	public Vector completeDetail(BillSchedule billSchedule) {
		return getGenericDAO().completeDetail(billSchedule);
	}

	// CustomerScreen
	public void saveCustomerScreen(CustomerScreen val) {
		getGenericDAO().saveCustomerScreen(val);
	}

	public void removeCustomerScreen(CustomerScreen val) {
		getGenericDAO().removeCustomerScreen(val);
	}

	public void removeCustomerScreen(Long id) {
		getGenericDAO().removeCustomerScreen(id);
	}

	public CustomerScreen getCustomerScreenById(Long id) {
		return getGenericDAO().findCustomerScreenById(id);
	}

	public List<CustomerScreen> getCustomerScreenList() {
		return getGenericDAO().findAllCustomerScreen();
	}

	public List<CustomerScreen> getCustomerScreenListByCustomerDetail(CustomerDetail c) {
		return getGenericDAO().getCustomerScreenListByCustomerDetail(c);
	}

	public List<CustomerScreen> getCustomerScreenListByBill(Bill bill) {
		return getGenericDAO().getCustomerScreenListByBill(bill);
	}

	// ProductClass
	public void saveProductClass(ProductClass val) {
		getGenericDAO().saveProductClass(val);
	}

	public void removeProductClass(ProductClass val) {
		getGenericDAO().removeProductClass(val);
	}

	public void removeProductClass(String id) {
		getGenericDAO().removeProductClass(id);
	}

	public ProductClass getProductClassById(String id) {
		return getGenericDAO().findProductClassById(id);
	}

	public List<ProductClass> getProductClassList() {
		return getGenericDAO().findAllProductClass();
	}

	// OutputEquipment
	public void saveOutputEquipment(OutputEquipment val) {
		getGenericDAO().saveOutputEquipment(val);
	}

	public void removeOutputEquipment(OutputEquipment val) {
		getGenericDAO().removeOutputEquipment(val);
	}

	public void removeOutputEquipment(Long id) {
		getGenericDAO().removeOutputEquipment(id);
	}

	public OutputEquipment getOutputEquipmentById(Long id) {
		return getGenericDAO().findOutputEquipmentById(id);
	}

	public List<OutputEquipment> getOutputEquipmentList() {
		return getGenericDAO().findAllOutputEquipment();
	}

	// BillFinish
	public void saveBillFinish(BillFinish val) {
		getGenericDAO().saveBillFinish(val);
	}

	public void removeBillFinish(BillFinish val) {
		getGenericDAO().removeBillFinish(val);
	}

	public void removeBillFinish(Long id) {
		getGenericDAO().removeBillFinish(id);
	}

	public BillFinish getBillFinishById(Long id) {
		return getGenericDAO().findBillFinishById(id);
	}

	public List<BillFinish> getBillFinishList() {
		return getGenericDAO().findAllBillFinish();
	}

	public BillFinish getBillFinishByBill(Bill b) {
		return getGenericDAO().findBillFinishByBill(b);
	}

	// ProcessState
	public List<ProcessState> getProcessStateList(String billNo, Group group, boolean status, int xor, String worker) {
		return getGenericDAO().findAllProcessState(billNo, group, status, xor, worker);
	}

	public List<ProcessState> getProcessStateList() {
		return getGenericDAO().findAllProcessState();
	}

	// Profit

	public ProfitSum getProfitListSum(List<Profit> ls) {
		return getGenericDAO().getProfitListSum(ls);
	}

	public ProfitSum getProfitListSum(String projectNo, String start, String end, Customer customer, Member salesmen) {
		return getGenericDAO().getProfitListSum(projectNo, start, end, customer, salesmen);
	}

	public List<Profit> getProfitList(String projectNo, String start, String end, Customer customer, Member salesmen, int pageSize, int pageIndex) {
		return getGenericDAO().getProfitList(projectNo, start, end, customer, salesmen, pageSize, pageIndex);
	}

	public int getProfitListByConditionCount(String projectNo, String start, String end, Customer customer, Member salesmen) {
		return getGenericDAO().getProfitListByConditionCount(projectNo, start, end, customer, salesmen);
	}

	public Profit getProfitById(String id) {
		return getGenericDAO().getProfitById(id);
	}

	public Profit getProfitBySalesNo(String salesNo) {
		return getGenericDAO().getProfitBySalesNo(salesNo);
	}

	public List<Profit> getProfitList(String projectNo, String start, String end, Customer customer, Member salesmen) {
		return getGenericDAO().getProfitList(projectNo, start, end, customer, salesmen);
	}

	public List<Profit> getProfitRateList(String start, String end, int tag, BigDecimal profitPerc) {
		return getGenericDAO().getProfitRateList(start, end, tag, profitPerc);
	}

	// ProfitDetail
	public List<ProfitDetail> getProfitDetailList(Profit profit) {
		return getGenericDAO().getProfitDetailList(profit);
	}

	public List<ProfitDetail> getProfitDetailListBySalesNo(String salesNo) {
		return getGenericDAO().getProfitDetailListBySalesNo(salesNo);
	}

	public List getProfitDetailListByProduct(String startDate, String endDate, Product product) {
		return getGenericDAO().getProfitDetailListByProduct(startDate, endDate, product);
	}

	// ProfitProduct
	public ProfitProduct getProfitProductList(String startDate, String endDate, Product product) {
		return getGenericDAO().getProfitProductList(startDate, endDate, product);
	}

	// WorkEfficiency
	public List<WorkEfficiency> getWorkEfficiencyByMember(String startDate, String endDate, Member member) {
		return getGenericDAO().getWorkEfficiencyByMember(startDate, endDate, member);
	}

	// profitFee
	public List<ProfitFee> getProfitFeeByBill(Bill bill) {
		return getGenericDAO().getProfitFeeByBill(bill);
	}

	// StandardCost
	public void saveStandardCost(StandardCost val) {
		getGenericDAO().saveStandardCost(val);
	}

	public void removeStandardCost(StandardCost val) {
		getGenericDAO().removeStandardCost(val);
	}

	public void removeStandardCost(Long id) {
		getGenericDAO().removeStandardCost(id);
	}

	public StandardCost getStandardCostById(Long id) {
		return getGenericDAO().findStandardCostById(id);
	}

	public List<StandardCost> getStandardCostList(String salesNo) {
		return getGenericDAO().findAllStandardCost(salesNo);
	}

	// CustomerStandardCost
	public void saveCustomerStandardCost(CustomerStandardCost val) {
		getGenericDAO().saveCustomerStandardCost(val);
	}

	public void removeCustomerStandardCost(CustomerStandardCost val) {
		getGenericDAO().removeCustomerStandardCost(val);
	}

	public void removeCustomerStandardCost(Long id) {
		getGenericDAO().removeCustomerStandardCost(id);
	}

	public CustomerStandardCost getCustomerStandardCostById(Long id) {
		return getGenericDAO().findCustomerStandardCostById(id);
	}

	public List<CustomerStandardCost> getCustomerStandardCostList(Customer customer) {
		return getGenericDAO().findAllCustomerStandardCost(customer);
	}

	// BillQA
	public void saveBillQA(BillQA val) {
		getGenericDAO().saveBillQA(val);
	}

	public void removeBillQA(BillQA val) {
		getGenericDAO().removeBillQA(val);
	}

	public void removeBillQA(Long id) {
		getGenericDAO().removeBillQA(id);
	}

	public BillQA getBillQAById(Long id) {
		return getGenericDAO().findBillQAById(id);
	}

	public List<BillQA> getBillQAList(Bill bill) {
		return getGenericDAO().findAllBillQA(bill);
	}

	public List<BillQA> getBillQAList(String startDate, String endDate, String billno, Customer customer) {
		return getGenericDAO().findAllBillQA(startDate, endDate, billno, customer);
	}

	// Logistics
	public void saveLogistics(Logistics val) {
		getGenericDAO().saveLogistics(val);
	}

	public void removeLogistics(Long id) {
		getGenericDAO().removeLogistics(id);
	}

	public Logistics getLogisticsById(Long id) {
		return getGenericDAO().findLogisticsById(id);
	}

	public List<Logistics> getLogisticsList(String keyword, Date startDate, Date endDate) {
		return getGenericDAO().findAllLogistics(keyword, startDate, endDate);
	}

	// SenderDB
	public List<SenderDB> getSenderDBList(String keyword) {
		return getGenericDAO().findAllSenderDB(keyword);
	}

	// LogisticsCode
	public void saveLogisticsCode(LogisticsCode val) {
		getGenericDAO().saveLogisticsCode(val);
	}

	public void removeLogisticsCode(Logistics val) {
		getGenericDAO().removeLogisticsCode(val);
	}

	public LogisticsCode getLastOneLogisticsCode() {
		return getGenericDAO().getLastOneLogisticsCode();
	}

	// RecipientDB
	public List<RecipientDB> getRecipientDBList(String keyword) {
		return getGenericDAO().findAllRecipientDB(keyword);
	}
}
