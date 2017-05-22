package northwest.common.dao.hibernate;

import northwest.common.value.*;
import northwest.common.dao.BillDAO;

import java.util.*;
import java.util.Date;
import java.text.*;

import com.base.util.Tools;
import com.base.value.*;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.common.dao.hibernate.CommonDAOHibernate;
import com.common.value.Member;
import com.opensymphony.xwork.ActionContext;

import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class BillDAOHibernate extends CommonDAOHibernate implements BillDAO {

	public BillDAOHibernate() {
	}

	// Bill
	public List<Bill> findBillByNo(String keyword) {
		ArrayList<Bill> al = new ArrayList<Bill>();
		try {
			Criteria c = getHibernateSession().createCriteria(Bill.class);
			c.add(Expression.like("id", "%" + keyword + "%"));
			c.setMaxResults(30);
			List result = c.list();
			return result;
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return al;
	}

	public Bill findBillById(String id) {
		Bill bill = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Bill.class);
			c.add(Expression.eq("id", id));
			List result = c.list();
			if (result.size() > 0)
				bill = (Bill) result.get(0);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return bill;
	}

	public List<Bill> findAllBill() {
		return getHibernateTemplate().find("from Bill");
	}

	public List<Bill> getBills(int pageSize, int pageIndex) {
		ArrayList<Bill> al = new ArrayList<Bill>();
		Criteria c = getHibernateSession().createCriteria(Bill.class);
		// c.addOrder(Order.desc("completionTime"));
		c.addOrder(Order.desc("id"));

		System.out.println("pageSize=" + pageSize + "  pageIndex=" + pageIndex);
		c.setFirstResult(pageSize * pageIndex);
		c.setMaxResults(pageSize);
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((Bill) result.get(i));
		}
		return al;
	}

	// BillFiles
	public BillFiles getBillFilesByBill(Bill bill) {
		BillFiles obj = null;
		Criteria c = getHibernateSession().createCriteria(BillFiles.class);
		c.add(Expression.eq("bill", bill));
		List result = c.list();
		if (result.size() > 0) {
			obj = (BillFiles) result.get(0);
		}
		return obj;
	}

	public void saveBillFilesByBill(BillFiles val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void saveBillFiles(BillFiles val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public BillFiles findBillFilesById(Long id) {
		if (id == null)
			return null;
		BillFiles obj = (BillFiles) getHibernateTemplate().get(northwest.common.value.BillFiles.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.BillFiles.class, id);
		else
			return obj;
	}

	public List<Bill> getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate, int pageSize, int pageIndex) {

		Criteria c = getHibernateSession().createCriteria(Bill.class);

		if (customer != null) {
			c.add(Expression.eq("customer", customer));
		}

		if (billNo != "") {
			System.out.println("hiber billNo!");
			c.add(Expression.like("id", "%" + billNo + "%"));
		}

		if (state != 0) {
			if (state == 1) {
				c.add(Expression.eq("state", true));
			} else {
				c.add(Expression.eq("state", false));
			}
		}
		if (!startDate.equals("") && startDate != null) {
			c.add(Expression.ge("billDate", startDate));
		}
		if (!endDate.equals("") && endDate != null) {
			c.add(Expression.le("billDate", endDate));
		}

		c.addOrder(Order.desc("id"));
		c.setFirstResult(pageSize * pageIndex);
		c.setMaxResults(pageSize);
		return c.list();
	}

	public int getBillListByCondition(Customer customer, String billNo, int state, String startDate, String endDate) {
		Criteria c = getHibernateSession().createCriteria(Bill.class);

		if (customer != null) {
			c.add(Expression.eq("customer", customer));
		}

		if (billNo != "") {
			c.add(Expression.like("id", "%" + billNo + "%"));
		}

		if (state != 0) {
			if (state == 1) {
				c.add(Expression.eq("state", true));
			} else {
				c.add(Expression.eq("state", false));
			}
		}
		if (!startDate.equals("") && startDate != null) {
			c.add(Expression.ge("billDate", startDate));
		}
		if (!endDate.equals("") && endDate != null) {
			c.add(Expression.le("billDate", endDate));
		}

		return c.list().size();
	}

	// ProcessState

	public List<Bill> getProcessStateByCondition(int condition, Customer customer, String billNo, int pageSize, int pageIndex, Group group, boolean isCheck) {
		ArrayList<Bill> al = new ArrayList<Bill>();
		String hsql, customerstr = "", billNostr = "";
		String step = group.getGroupNameEn();
		if (customer != null) {
			customerstr = " and s.bill.customer=:customer ";
		}
		hsql = "from ProcessState s where s.step" + step + "=:isCheck " + customerstr + " and s.bill.id like :billNo   order by s.bill.id desc ";
		System.out.println("getProcessStateByCondition hsql=" + hsql + "  isCheck=" + isCheck);
		Query query = getHibernateSession().createQuery(hsql);
		query.setParameter("isCheck", isCheck);
		query.setParameter("billNo", "%" + billNo + "%");
		if (customer != null) {
			query.setParameter("customer", customer);
		}
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			ProcessState state = (ProcessState) result.get(i);
			Bill bill = state.getBill();
			System.out.println("getProcessStateByCondition bill=" + bill.getId());
		}

		return al;
	}

	// BillDetail
	public List<BillDetail> getBillDetailListByBillNo(String BillNo) {
		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		Criteria c = getHibernateSession().createCriteria(BillDetail.class);
		c.add(Expression.eq("bill", findBillById(BillNo)));
		c.addOrder(Order.asc("fromRow"));
		return c.list();
	}

	public List<BillDetail> getBillDetailListByBillNo(String BillNo, int fromRow1, int fromRow2) {
		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		Criteria c = getHibernateSession().createCriteria(BillDetail.class);
		c.add(Expression.eq("bill", findBillById(BillNo)));
		c.add(Expression.between("fromRow", fromRow1, fromRow2));
		c.addOrder(Order.asc("fromRow"));
		System.out.println("hiber getBillDetailListByBillNo=" + c.list().size());
		return c.list();
	}

	public List<Group> getBillGroupAuthority() {
		ArrayList<Group> al = new ArrayList<Group>();
		Criteria c = getHibernateSession().createCriteria(Group.class);
		c.add(Restrictions.like("groupKey", "CK%"));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((Group) result.get(i));
		}
		return al;
	}

	// BillDetail
	public BillDetail findBillDetailById(String id) {
		BillDetail billDetail = null;
		try {
			Criteria c = getHibernateSession().createCriteria(BillDetail.class);
			c.add(Expression.eq("id", id));
			List result = c.list();
			if (result.size() > 0)
				billDetail = (BillDetail) result.get(0);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return billDetail;
	}

	public List<BillDetail> findAllBillDetail() {
		return getHibernateTemplate().find("from BillDetail");
	}

	/*
	 * public List<BillDetail> getBillScheduleListByCondition(Long step,Product
	 * product,boolean result){ ArrayList<BillDetail> al = new
	 * ArrayList<BillDetail>(); String hsql; if(product==null){ hsql =
	 * "from BillSchedule s left join s.billDetail as b where  s.step"
	 * +step+"=:result order by s.billDetail.bill.id"; }else{ hsql =
	 * "from BillSchedule s left join s.billDetail as b where b.product=:product and s.step"
	 * +step+"=:result order by s.billDetail.bill.id"; }
	 * 
	 * //System.out.println("hsql="+hsql);
	 * 
	 * Query query = getHibernateSession().createQuery(hsql);
	 * 
	 * if(product!=null){ query.setParameter("product", product); }
	 * DecimalFormat df = new DecimalFormat("00"); Group
	 * group=findGroupByGroupKey("CK"+df.format(step));
	 * query.setParameter("result", result); List ls = query.list(); Iterator
	 * it=ls.iterator(); while(it.hasNext()){ Object[] r=(Object[])it.next();
	 * try{ BillDetail m=(BillDetail)r[1];
	 * 
	 * if(isStepEnabled(m.getBill(),group) ){ BillFinish
	 * finish=findBillFinishByBill(m.getBill()); if(finish==null &&
	 * m.getProduct(
	 * ).getProductClass().getExpectionFlows().contains(group)==false){
	 * al.add(m); } } }catch(Exception e){ System.out.println(e.toString()); } }
	 * return al; }
	 */

	public List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result) {
		System.out.println("getBillScheduleListByCondition start=" + Tools.getCurrentTimestamp());

		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		String hsql;
		if (product == null) {
			hsql = "from BillSchedule s left join s.billDetail as b where  s.step" + step + "=:result order by s.billDetail.bill.id";
		} else {
			hsql = "from BillSchedule s left join s.billDetail as b where b.product=:product and s.step" + step + "=:result order by s.billDetail.bill.id";
		}

		// System.out.println("hsql="+hsql);
		Query query = getHibernateSession().createQuery(hsql);
		if (product != null) {
			query.setParameter("product", product);
		}
		DecimalFormat df = new DecimalFormat("00");
		Group group = findGroupByGroupKey("CK" + df.format(step));
		query.setParameter("result", result);
		List ls = query.list();
		Iterator it = ls.iterator();
		while (it.hasNext()) {
			Object[] r = (Object[]) it.next();
			try {
				BillDetail m = (BillDetail) r[1];

				if (isStepEnabled(m.getBill(), group)) {
					BillFinish finish = findBillFinishByBill(m.getBill());
					if (finish == null && m.getProduct().getProductClass().getExpectionFlows().contains(group) == false) {
						al.add(m);
					}
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		System.out.println("getBillScheduleListByCondition end=" + Tools.getCurrentTimestamp());

		return al;
	}

	public List<BillDetail> getBillScheduleListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex) {
		System.out.println("getBillScheduleListByCondition start=" + Tools.getCurrentTimestamp());

		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		String hsql;
		if (product == null) {
			hsql = "from BillSchedule s left join s.billDetail as b where  s.step" + step + "=:result order by s.billDetail.bill.id";
		} else {
			hsql = "from BillSchedule s left join s.billDetail as b where b.product=:product and s.step" + step + "=:result order by s.billDetail.bill.id";
		}

		// System.out.println("hsql="+hsql);
		Query query = getHibernateSession().createQuery(hsql);
		if (product != null) {
			query.setParameter("product", product);
		}
		// query.setFirstResult(pageSize * pageIndex);
		// query.setMaxResults(pageSize);

		DecimalFormat df = new DecimalFormat("00");
		Group group = findGroupByGroupKey("CK" + df.format(step));
		query.setParameter("result", result);
		List ls = query.list();
		System.out.println("ls.size()=" + ls.size());
		Iterator it = ls.iterator();
		while (it.hasNext()) {
			Object[] r = (Object[]) it.next();
			try {
				BillDetail m = (BillDetail) r[1];

				if (isStepEnabled(m.getBill(), group)) {
					BillFinish finish = findBillFinishByBill(m.getBill());
					if (finish == null && m.getProduct().getProductClass().getExpectionFlows().contains(group) == false) {
						al.add(m);
					}
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		System.out.println("getBillScheduleListByCondition end=" + Tools.getCurrentTimestamp());

		return al;
	}

	public List<Meter> getMeterListByCondition(Long step, Product product, boolean result, int pageSize, int pageIndex) {
		ArrayList<Meter> al = new ArrayList<Meter>();
		Criteria c = getHibernateSession().createCriteria(Meter.class);

		if (product != null) {
			c.add(Expression.eq("product", product));
		}
		c.add(Expression.eq("group" + String.valueOf(step), true));
		c.add(Expression.eq("step" + String.valueOf(step), result));
		c.addOrder(Order.desc("check" + String.valueOf(step)));
		// c.addOrder(Order.desc("bill"));
		c.setFirstResult(pageSize * pageIndex);
		c.setMaxResults(pageSize);
		List r = c.list();
		for (int i = 0; i < r.size(); i++) {
			al.add((Meter) r.get(i));
		}
		return al;
	}

	public List<Meter> getMeterListByCondition(Long step, Product product, boolean result) {
		ArrayList<Meter> al = new ArrayList<Meter>();
		Criteria c = getHibernateSession().createCriteria(Meter.class);

		if (product != null) {
			c.add(Expression.eq("product", product));
		}
		c.add(Expression.eq("group" + String.valueOf(step), true));
		c.add(Expression.eq("step" + String.valueOf(step), result));
		c.addOrder(Order.desc("bill"));
		List r = c.list();
		for (int i = 0; i < r.size(); i++) {
			al.add((Meter) r.get(i));
		}
		return al;
	}

	public List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex) {
		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		Criteria c = getHibernateSession().createCriteria(BillDetail.class);
		c.add(Expression.eq("bill", bill));
		c.addOrder(Order.asc("fromRow"));
		System.out.println("pageSize=" + pageSize + "  pageIndex=" + pageIndex);
		c.setFirstResult(pageSize * pageIndex);
		c.setMaxResults(pageSize);
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			BillDetail b = (BillDetail) result.get(i);
			System.out.println(b.getFromRow());
			al.add(b);
		}
		return al;
	}

	public List<BillDetail> getBillDetailListByBillNo(Bill bill, int pageSize, int pageIndex, Member worker) {
		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		String hsql = "from BillSchedule s where s.billDetail.bill.id =:billNo and s.worker=:mworker  ";
		Query query = getHibernateSession().createQuery(hsql);
		query.setParameter("billNo", bill.getId());
		query.setParameter("mworker", worker);
		query.setFirstResult(pageSize * pageIndex);
		query.setMaxResults(pageSize);
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			BillSchedule s = (BillSchedule) result.get(i);
			System.out.println("hiber getBillDetailListByBillNo s=" + s.getId());
			al.add(s.getBillDetail());
		}
		return al;
	}

	public int getBillDetailListByBillNoWorker(Bill bill, Member worker) {
		ArrayList<BillDetail> al = new ArrayList<BillDetail>();
		String hsql = "from BillSchedule s where s.billDetail.bill.id =:billNo and s.worker=:mworker  ";
		Query query = getHibernateSession().createQuery(hsql);
		query.setParameter("billNo", bill.getId());
		query.setParameter("mworker", worker);
		List result = query.list();
		return result.size();
	}

	// BillSchedule
	public void saveBillSchedule(BillSchedule val) {
		if (val.getId() == null) {
			getHibernateTemplate().saveOrUpdate(val);
		} else {
			getHibernateTemplate().save(val);
		}
	}

	public void removeBillSchedule(BillSchedule val) {
		getHibernateTemplate().delete(val);
	}

	public void removeBillSchedule(String id) {
		BillSchedule obj = findBillScheduleById(id);
		getHibernateTemplate().delete(obj);
	}

	public BillSchedule findBillScheduleById(String id) {
		System.out.println("findBillScheduleById");
		BillSchedule obj = (BillSchedule) getHibernateTemplate().get(BillSchedule.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(BillSchedule.class, id);
		else
			return obj;
	}

	public BillSchedule findBillScheduleByCode(String code) {
		BillSchedule obj = null;
		try {
			Criteria c = getHibernateSession().createCriteria(BillSchedule.class);
			c.add(Expression.eq("code", code));
			List result = c.list();
			if (result.size() > 0) {
				obj = (BillSchedule) result.get(0);
			}
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}

		return obj;
	}

	public List<BillSchedule> findAllBillSchedule() {
		return getHibernateTemplate().find("from BillSchedule");
	}

	public List<UploadedFile> findCheck4photo1List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findCheck4photo2List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findCompletionphoto1List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findCompletionphoto2List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findCompletionphoto3List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findCompletionphoto4List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findCompletionphoto5List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<BillDetail> findBillDetailList() {
		return new ArrayList<BillDetail>(); // TODO
	}

	public BillSchedule getBillScheduleByBillDetail(BillDetail j) {
		BillSchedule obj = null;
		try {
			Criteria c = getHibernateSession().createCriteria(BillSchedule.class);
			c.add(Expression.eq("billDetail", j));
			List result = c.list();
			if (result.size() > 0) {
				obj = (BillSchedule) result.get(0);
			}
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}
		return obj;
	}

	public void initialBillSchedule(String id) {
		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement();
			Stmt.execute("InitialBillSchedule '" + id + "'");
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public List<BillSchedule> getSameProductList(BillSchedule billSchedule) {
		String hsql = "select s from BillSchedule s where s.billDetail.product=:product and s.billDetail.bill=:bill ";
		Query query = getHibernateSession().createQuery(hsql);
		Product product = billSchedule.getBillDetail().getProduct();
		Bill bill = billSchedule.getBillDetail().getBill();
		query.setParameter("product", product);
		query.setParameter("bill", bill);
		return query.list();
	}

	public List<BillSchedule> getSameProductItemMarkList(BillSchedule billSchedule) {
		String hsql = "select s from BillSchedule s where s.billDetail.product=:product and  s.billDetail.detail like :detail  and s.billDetail.bill=:bill ";
		Query query = getHibernateSession().createQuery(hsql);
		Product product = billSchedule.getBillDetail().getProduct();
		Bill bill = billSchedule.getBillDetail().getBill();
		query.setParameter("product", product);
		query.setParameter("bill", bill);

		String s = billSchedule.getBillDetail().getDetail();
		if (s.indexOf("-") != -1) {
			s = s.substring(0, s.indexOf("-"));
		}
		// System.out.println("getSameProductItemMarkList s="+s);
		query.setParameter("detail", "%" + s + "%");

		return query.list();
	}

	// Customer
	public Customer findCustomerById(String id) {
		Customer customer = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Customer.class);
			c.add(Expression.eq("id", id));
			List result = c.list();
			if (result.size() > 0)
				customer = (Customer) result.get(0);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return customer;
	}

	public List<Customer> findAllCustomer() {
		return getHibernateTemplate().find("from Customer order by id asc");
	}

	public List<Customer> getCustomerByKeyWord(String KeyWord) {
		ArrayList<Customer> al = new ArrayList<Customer>();
		try {
			Criteria c = getHibernateSession().createCriteria(Customer.class);
			c.add(Restrictions.or(Restrictions.like("id", "%" + KeyWord + "%"), Restrictions.like("name", "%" + KeyWord + "%")));
			List result = c.list();
			for (int i = 0; i < result.size(); i++) {
				Customer m = (Customer) result.get(i);
				al.add(m);
			}
			return al;
		} catch (HibernateException ex) {
			System.out.println("getCustomerByKeyWord error!");
			return al;
		}
	}

	// CustomerDetail
	public void saveCustomerDetail(CustomerDetail val) {
		getHibernateTemplate().saveOrUpdate(getHibernateTemplate().merge(val));
	}

	public void removeCustomerDetail(CustomerDetail val) {
		getHibernateTemplate().delete(val);
	}

	public void removeCustomerDetail(Long id) {
		CustomerDetail obj = findCustomerDetailById(id);
		getHibernateTemplate().delete(obj);
	}

	public CustomerDetail findCustomerDetailById(Long id) {
		if (id == null)
			return null;
		CustomerDetail obj = (CustomerDetail) getHibernateTemplate().get(CustomerDetail.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(CustomerDetail.class, id);
		else
			return obj;
	}

	public CustomerDetail getCustomerDetailLastByCustomerNo(Customer customer) {
		CustomerDetail obj = null;
		try {
			Criteria c = getHibernateSession().createCriteria(CustomerDetail.class);
			c.add(Expression.eq("customer", customer));
			c.addOrder(Order.desc("id"));
			List result = c.list();
			if (result.size() > 0) {
				obj = (CustomerDetail) result.get(0);
			}
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}

		return obj;
	}

	public List<CustomerDetail> findAllCustomerDetail() {
		return getHibernateTemplate().find("from CustomerDetail");
	}

	public List<UploadedFile> findPhoto1List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findPhoto2List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findPhoto3List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findPhoto4List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<UploadedFile> findPhoto5List() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public List<CustomerDetail> getCustomerDetailListByCustomerNo(Customer customer) {
		ArrayList<CustomerDetail> al = new ArrayList<CustomerDetail>();
		Criteria c = getHibernateSession().createCriteria(CustomerDetail.class);
		c.add(Expression.eq("customer", customer));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((CustomerDetail) result.get(i));
		}
		return al;
	}

	public List<CustomerDetail> getCustomerDetailListByCustomerByQuery(Customer customer, String key) {
		ArrayList<CustomerDetail> al = new ArrayList<CustomerDetail>();
		Criteria c = getHibernateSession().createCriteria(CustomerDetail.class);
		c.add(Expression.eq("customer", customer));
		c.add(Restrictions.or(Restrictions.like("counterNo", "%" + key + "%"), Restrictions.like("counter", "%" + key + "%")));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((CustomerDetail) result.get(i));
		}
		return al;
	}

	// Product

	public Product findProductById(String id) {
		Product product = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Product.class);
			c.add(Expression.eq("id", id));
			List result = c.list();
			if (result.size() > 0)
				product = (Product) result.get(0);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return product;
	}

	public List<Product> findAllProduct() {
		return getHibernateTemplate().find("from Product order by id asc");
	}

	public List<Product> getProductListByCondition(String name, String id) {
		ArrayList<Product> al = new ArrayList<Product>();
		Criteria c = getHibernateSession().createCriteria(Product.class);
		c.add(Restrictions.or(Restrictions.like("id", "%" + id + "%"), Restrictions.like("productName", "%" + name + "%")));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			Product m = (Product) result.get(i);
			al.add(m);
		}
		return al;
	}

	// Freight
	public void saveFreight(Freight val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeFreight(Freight val) {
		getHibernateTemplate().delete(val);
	}

	public void removeFreight(Long id) {
		Freight obj = findFreightById(id);
		getHibernateTemplate().delete(obj);
	}

	public Freight findFreightById(Long id) {
		if (id == null)
			return null;
		Freight obj = (Freight) getHibernateTemplate().get(northwest.common.value.Freight.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.Freight.class, id);
		else
			return obj;
	}

	public List<Freight> findAllFreight() {
		return getHibernateTemplate().find("from Freight");
	}

	// BillAuthority
	public void saveBillAuthority(BillAuthority val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeBillAuthority(BillAuthority val) {
		getHibernateTemplate().delete(val);
	}

	public void removeBillAuthority(Long id) {
		BillAuthority obj = findBillAuthorityById(id);
		getHibernateTemplate().delete(obj);
	}

	public BillAuthority findBillAuthorityById(Long id) {
		if (id == null)
			return null;
		BillAuthority obj = (BillAuthority) getHibernateTemplate().get(northwest.common.value.BillAuthority.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.BillAuthority.class, id);
		else
			return obj;
	}

	public List<BillAuthority> findAllBillAuthority() {
		return getHibernateTemplate().find("from BillAuthority");
	}

	public List<BillAuthority> getBillAuthorityListByBill(Bill bill) {
		ArrayList<BillAuthority> al = new ArrayList<BillAuthority>();
		Criteria c = getHibernateSession().createCriteria(BillAuthority.class);
		c.add(Expression.eq("bill", bill));
		c.addOrder(Order.asc("group"));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((BillAuthority) result.get(i));
		}
		return al;
	}

	public List<BillAuthority> getBillAuthorityListByBill(String bill) {
		ArrayList<BillAuthority> al = new ArrayList<BillAuthority>();
		Criteria c = getHibernateSession().createCriteria(BillAuthority.class);
		c.add(Expression.eq("bill", findBillById(bill)));
		c.addOrder(Order.asc("group"));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((BillAuthority) result.get(i));
		}
		return al;
	}

	public List<BillAuthority> getBillAuthorityListByByIds(Long[] ids) {
		ArrayList<BillAuthority> al = new ArrayList<BillAuthority>();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				BillAuthority t = (BillAuthority) findBillAuthorityById(ids[i]);
				if (t != null)
					al.add(t);
			}
		}
		return al;
	}

	public List<Group> getDeleteStepList(BillSchedule billSchedule) {
		ArrayList<Group> al = new ArrayList<Group>();
		Criteria c = getHibernateSession().createCriteria(BillAuthority.class);
		c.add(Expression.eq("bill", billSchedule.getBillDetail().getBill()));
		c.addOrder(Order.desc("group"));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			BillAuthority a = (BillAuthority) result.get(i);
			Group g = a.getGroup();
			al.add(g);
		}
		return al;
	}

	public int getAllCompleteStatusByBill(Bill bill, Group group, boolean status) {
		int sum = 0;
		boolean result;
		List<BillDetail> ls = getBillDetailListByBillNo(bill.getId());
		for (int i = 0; i < ls.size(); i++) {
			BillDetail b = (BillDetail) ls.get(i);
			result = b.getProduct().getProductClass().getExpectionFlows().contains(group);
			if (result == false) {
				BillSchedule s = getBillScheduleByBillDetail(b);
				int step = Integer.parseInt(group.getGroupKey().substring(2, 4));
				switch (step) {
				case 1:
					if (s.getStep1() == status) {
						sum++;
					}
					break;
				case 2:
					if (s.getStep2() == status) {
						sum++;
					}
					break;
				case 3:
					if (s.getStep3() == status) {
						sum++;
					}
					break;
				case 4:
					if (s.getStep4() == status) {
						sum++;
					}
					break;
				case 5:
					if (s.getStep5() == status) {
						sum++;
					}
					break;
				case 6:
					if (s.getStep6() == status) {
						sum++;
					}
					break;
				case 7:
					if (s.getStep7() == status) {
						sum++;
					}
					break;
				case 8:
					if (s.getStep8() == status) {
						sum++;
					}
					break;
				case 9:
					if (s.getStep9() == status) {
						sum++;
					}
					break;
				case 10:
					if (s.getStep10() == status) {
						sum++;
					}
					break;
				case 11:
					if (s.getStep11() == status) {
						sum++;
					}
					break;
				case 12:
					if (s.getStep12() == status) {
						sum++;
					}
					break;
				}
			}

		}
		return sum;
	}

	public boolean isStepEnabled(Bill bill, Group group) {
		boolean result = false;
		List<BillAuthority> ls = getBillAuthorityListByBill(bill.getId());
		for (int i = 0; i < ls.size(); i++) {
			BillAuthority b = (BillAuthority) ls.get(i);
			Group s = b.getGroup();
			if (group.getGroupKey().equals(s.getGroupKey())) {
				result = true;
				return result;
			}
		}

		return result;
	}

	public boolean isSettingPermissions(Member member, Group group) {
		boolean result = true;
		Set members = group.getMembers();
		if (members != null) {
			Iterator i = group.getMembers().iterator();
			while (i.hasNext()) {
				Member m = (Member) i.next();
				if (m.getId().equals(member.getId())) {
					result = false;
					return result;
				}
			}
		}
		return result;
	}

	public List<Group> billGroups(BillSchedule billSchedule) {
		ArrayList<Group> groups = new ArrayList<Group>();
		List<BillAuthority> al = getBillAuthorityListByBill(billSchedule.getBillDetail().getBill());
		ArrayList<String> stepList = new ArrayList<String>();
		for (int i = 0; i < al.size(); i++) {
			BillAuthority obj = (BillAuthority) al.get(i);
			Group g = obj.getGroup();
			stepList.add(g.getGroupKey());
		}
		Collections.sort(stepList);
		for (int i = 0; i < stepList.size(); i++) {
			String gx = stepList.get(i);
			Group g = findGroupByGroupKey(gx);
			groups.add(g);
		}
		return groups;
	}

	public Group previousStep(BillSchedule billSchedule, Group group) {
		Group step;
		int result = 0;
		List<BillAuthority> al = getBillAuthorityListByBill(billSchedule.getBillDetail().getBill());
		ArrayList<String> stepList = new ArrayList<String>();
		for (int i = 0; i < al.size(); i++) {
			BillAuthority obj = (BillAuthority) al.get(i);
			Group g = obj.getGroup();
			stepList.add(g.getGroupKey());
		}
		Collections.sort(stepList);

		String previousCode = "";
		int index = 0;
		for (int i = 0; i < stepList.size(); i++) {
			String gx = stepList.get(i);
			if (gx.equals(group.getGroupKey())) {
				index = i;
			}
		}

		if (index > 0) {
			previousCode = stepList.get(index - 1);
		} else {
			previousCode = stepList.get(0);
		}

		return findGroupByGroupKey(previousCode);
	}

	public void deleteBarcode(BillSchedule billSchedule, Group group) {
		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement();
			String sql = "dbo.deleteBarcode '" + billSchedule.getId() + "','" + group.getId() + "' ";
			System.out.println(sql);
			Stmt.execute(sql);
			conn.close();
		} catch (Exception e) {
			System.out.println("deleteBarcode error=" + e.toString());
		}
	}

	/*
	 * public void deleteBarcode(BillSchedule billSchedule,Group group){ try{
	 * Connection conn=getHibernateSession().connection(); Statement Stmt =
	 * conn.createStatement(); String
	 * sql="dbo.deleteBarcode '"+billSchedule.getId()+"','"+group.getId()+"' ";
	 * System.out.println(sql); Stmt.execute(sql); conn.close();
	 * }catch(Exception e){
	 * System.out.println("deleteBarcode error="+e.toString()); } }
	 */

	public void saveBarcodeCuticle(BillSchedule billSchedule, Member member, boolean result) {
		try {
			if (result == true) {
				billSchedule.setCuticle(Tools.getCurrentTimestamp());
				billSchedule.setCuticleer(member);
				billSchedule.setCuticlestep(true);
			} else {
				billSchedule.setCuticle(null);
				billSchedule.setCuticleer(null);
				billSchedule.setCuticlestep(false);
			}
		} catch (Exception e) {
			System.out.println("saveBarcodeCuticle error=" + e.toString());
		}
	}

	public void saveBarcode(BillSchedule billSchedule, Member member, Group group) {
		try {
			// 如果是ByPass不能掃描
			ProductClass productClass = billSchedule.getBillDetail().getProduct().getProductClass();

			boolean b = false;

			List ls = productClass.getExpectionFlows();
			if (ls != null) {
				b = productClass.getExpectionFlows().contains(group);
			}
			System.out.println("saveBarcode b=" + b);

			if (b == false) {

				int step = Integer.parseInt(group.getGroupKey().substring(2, 4));
				switch (step) {
				case 1:
					billSchedule.setStep1(true);
					billSchedule.setCheck1(Tools.getCurrentTimestamp());
					billSchedule.setChecker1(member);
					break;

				case 2:
					billSchedule.setStep2(true);
					billSchedule.setCheck2(Tools.getCurrentTimestamp());
					billSchedule.setChecker2(member);
					break;

				case 3:
					billSchedule.setStep3(true);
					billSchedule.setCheck3(Tools.getCurrentTimestamp());
					billSchedule.setChecker3(member);
					break;

				case 4:
					billSchedule.setStep4(true);
					billSchedule.setCheck4(Tools.getCurrentTimestamp());
					billSchedule.setChecker4(member);
					break;

				case 5:
					billSchedule.setStep5(true);
					billSchedule.setCheck5(Tools.getCurrentTimestamp());
					billSchedule.setChecker5(member);
					break;

				case 6:
					billSchedule.setStep6(true);
					billSchedule.setCheck6(Tools.getCurrentTimestamp());
					billSchedule.setChecker6(member);
					break;

				case 7:
					billSchedule.setStep7(true);
					billSchedule.setCheck7(Tools.getCurrentTimestamp());
					billSchedule.setChecker7(member);
					break;

				case 8:
					billSchedule.setStep8(true);
					billSchedule.setCheck8(Tools.getCurrentTimestamp());
					billSchedule.setChecker8(member);
					break;

				case 9:
					billSchedule.setStep9(true);
					billSchedule.setCheck9(Tools.getCurrentTimestamp());
					billSchedule.setChecker9(member);
					break;

				case 10:
					billSchedule.setStep10(true);
					billSchedule.setCheck10(Tools.getCurrentTimestamp());
					billSchedule.setChecker10(member);
					break;

				case 11:
					billSchedule.setStep11(true);
					billSchedule.setCheck11(Tools.getCurrentTimestamp());
					billSchedule.setChecker11(member);
					break;

				case 12:
					billSchedule.setStep12(true);
					billSchedule.setCheck12(Tools.getCurrentTimestamp());
					billSchedule.setChecker12(member);
					break;
				}
				getHibernateTemplate().saveOrUpdate(billSchedule);

			}
		} catch (Exception e) {
			System.out.println("saveBarcode error=" + e.toString());
		}
	}

	public Boolean currentBillScheduleStatus(BillSchedule billSchedule, Group group) {
		boolean r = false;
		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int i = Integer.parseInt(group.getGroupKey().substring(2, 4));
			String step = "step" + i;
			String sql = "select " + step + " from Northwest_BillSchedule where id='" + billSchedule.getId() + "'";

			ResultSet rs = Stmt.executeQuery(sql);
			int s = 0;
			if (rs.last()) {
				s = rs.getInt(step);
			}
			if (s == 0) {
				r = true;
			}
			// System.out.println(sql+"--"+step+"="+s);
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("currentBillScheduleStatus error=" + e.toString());
		}
		return r;
	}

	public Boolean isLastStep(BillSchedule billSchedule, Group group) {
		boolean r = false;
		try {
			List<Group> groups = billGroups(billSchedule);
			int j;
			int i = groups.indexOf(group);
			if (groups.size() == i + 1) {
				j = groups.size() - 1;
			} else {
				j = i + 1;
			}

			System.out.println(groups.get(j).getGroupKey().substring(2, 4) + "--NextStep=" + groups.get(j) + "--group=" + group.getGroupName());

			if (group.getId() == groups.get(j).getId()) {
				r = true;
			} else {
				Group g = groups.get(j);
				r = currentBillScheduleStatus(billSchedule, g);
			}

		} catch (Exception e) {
			System.out.println("isLastStep error=" + e.toString());
		}
		return r;
	}

	public Boolean Checker(BillSchedule billSchedule, Member member, Group group) {
		boolean r = false;
		int step = Integer.parseInt(group.getGroupKey().substring(2, 4));
		boolean laststep = isLastStep(billSchedule, group);
		// System.out.println("laststep="+laststep);
		switch (step) {
		case 1:
			if (billSchedule.getChecker1() == null) {
				r = true;
			}
			if (billSchedule.getChecker1().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 2:
			if (billSchedule.getChecker2() == null) {
				r = true;
			}
			if (billSchedule.getChecker2().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 3:
			if (billSchedule.getChecker3() == null) {
				r = true;
			}
			if (billSchedule.getChecker3().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 4:
			if (billSchedule.getChecker4() == null) {
				r = true;
			}
			if (billSchedule.getChecker4().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 5:
			if (billSchedule.getChecker5() == null) {
				r = true;
			}
			if (billSchedule.getChecker5().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 6:
			if (billSchedule.getChecker6() == null) {
				r = true;
			}
			if (billSchedule.getChecker6().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 7:
			if (billSchedule.getChecker7() == null) {
				r = true;
			}
			if (billSchedule.getChecker7().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 8:
			if (billSchedule.getChecker8() == null) {
				r = true;
			}
			if (billSchedule.getChecker8().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 9:
			if (billSchedule.getChecker9() == null) {
				r = true;
			}
			if (billSchedule.getChecker9().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 10:
			if (billSchedule.getChecker10() == null) {
				r = true;
			}
			if (billSchedule.getChecker10().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 11:
			if (billSchedule.getChecker11() == null) {
				r = true;
			}
			if (billSchedule.getChecker11().getId().equals(member.getId())) {
				r = true;
			}
			break;

		case 12:
			if (billSchedule.getChecker12() == null) {
				r = true;
			}
			if (billSchedule.getChecker12().getId().equals(member.getId())) {
				r = true;
			}
			break;
		}

		if (laststep == false) {
			r = false;
		}
		return r;
	}

	public Vector completeDetail(BillSchedule billSchedule) {
		Vector vc = new Vector();
		String complete = "";
		String uncomplete = "";
		billSchedule = findBillScheduleById(billSchedule.getId());
		try {
			List<Group> ls = billGroups(billSchedule);
			for (int i = 0; i < ls.size(); i++) {
				Group g = ls.get(i);
				int step = Integer.parseInt(g.getGroupKey().substring(2, 4));
				switch (step) {
				case 1:
					if (billSchedule.getStep1() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 2:
					if (billSchedule.getStep2() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 3:
					if (billSchedule.getStep3() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 4:
					if (billSchedule.getStep4() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 5:
					if (billSchedule.getStep5() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 6:
					if (billSchedule.getStep6() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 7:
					if (billSchedule.getStep7() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 8:
					if (billSchedule.getStep8() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 9:
					if (billSchedule.getStep9() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 10:
					if (billSchedule.getStep10() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				case 11:
					if (billSchedule.getStep11() == true) {
						complete += g.getGroupName() + "/";
					} else {
						uncomplete += g.getGroupName() + "/";
					}
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("completeDetail error=" + e.toString());
		}

		// System.out.println("complete="+complete);
		// System.out.println("uncomplete="+uncomplete);

		vc.add(complete);
		vc.add(uncomplete);
		return vc;
	}

	public boolean isEnabledEdit1(BillSchedule billSchedule, Group group) {
		boolean result = false;
		Group s = previousStep(billSchedule, group);

		if (s.getGroupKey().equals(group.getGroupKey())) {
			result = true;
		} else {

			int step = Integer.parseInt(group.getGroupKey().substring(2, 4));
			switch (step) {
			case 1:
				result = true;
				break;
			case 2:
				if (billSchedule.getStep2() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 3:
				if (billSchedule.getStep3() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 4:
				if (billSchedule.getStep4() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 5:
				if (billSchedule.getStep5() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 6:
				if (billSchedule.getStep6() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 7:
				if (billSchedule.getStep7() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 8:
				if (billSchedule.getStep8() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 9:
				if (billSchedule.getStep9() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 10:
				if (billSchedule.getStep10() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 11:
				if (billSchedule.getStep11() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			}
		}
		return result;
	}

	public boolean isEnabledEdit(BillSchedule billSchedule, Group group) {
		boolean result = false;
		Group s = previousStep(billSchedule, group);
		System.out.println("isEnabledEdit group=" + group.getGroupKey() + "--previous=" + s.getGroupKey());

		if (s.getGroupKey().equals(group.getGroupKey())) {
			result = true;
		} else {

			// int step=Integer.parseInt(group.getGroupKey().substring(2,4));
			int step = Integer.parseInt(s.getGroupKey().substring(2, 4));
			switch (step) {
			case 1:
				result = true;
				break;
			case 2:
				if (billSchedule.getStep2() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 3:
				if (billSchedule.getStep3() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 4:
				if (billSchedule.getStep4() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 5:
				if (billSchedule.getStep5() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 6:
				if (billSchedule.getStep6() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 7:
				if (billSchedule.getStep7() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 8:
				if (billSchedule.getStep8() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 9:
				if (billSchedule.getStep9() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 10:
				if (billSchedule.getStep10() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			case 11:
				if (billSchedule.getStep11() == true) {
					result = true;
				} else {
					result = false;
				}
				break;
			}
		}

		/*
		 * if(group.getGroupKey().equals("cuticle")) { result=true; }
		 */

		return result;
	}

	public Vector isAlreadyEdits(BillSchedule billSchedule, Group group) {
		Vector vc = new Vector();
		boolean result = false;
		String remark = "";
		int step = Integer.parseInt(group.getGroupKey().substring(2, 4));
		switch (step) {
		case 1:
			if (billSchedule.getStep1() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker1() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck1()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 2:
			if (billSchedule.getStep2() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker2() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck2()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 3:
			if (billSchedule.getStep3() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker3() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck3()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 4:
			if (billSchedule.getStep4() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker4() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck4()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 5:
			if (billSchedule.getStep5() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker5() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck5()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 6:
			if (billSchedule.getStep6() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker6() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck6()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 7:
			if (billSchedule.getStep7() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker7() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck7()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 8:
			if (billSchedule.getStep8() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker8() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck8()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 9:
			if (billSchedule.getStep9() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker9() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck9()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 10:
			if (billSchedule.getStep10() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker10() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck10()) + ")<br>";
			} else {
				result = false;
			}
			break;
		case 11:
			if (billSchedule.getStep11() == true) {
				result = true;
				remark += "請接洽(" + group.getGroupName() + " / " + billSchedule.getChecker11() + " / " + Tools.formatSimpleDate1(billSchedule.getCheck11()) + ")<br>";
			} else {
				result = false;
			}
			break;
		}
		vc.add(result);
		vc.add(remark);
		return vc;
	}

	// CustomerScreen

	public void saveCustomerScreen(CustomerScreen val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeCustomerScreen(CustomerScreen val) {
		getHibernateTemplate().delete(val);
	}

	public void removeCustomerScreen(Long id) {
		CustomerScreen obj = findCustomerScreenById(id);
		getHibernateTemplate().delete(obj);
	}

	public CustomerScreen findCustomerScreenById(Long id) {
		if (id == null)
			return null;
		CustomerScreen obj = (CustomerScreen) getHibernateTemplate().get(northwest.common.value.CustomerScreen.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.CustomerScreen.class, id);
		else
			return obj;
	}

	public List<CustomerScreen> findAllCustomerScreen() {
		return getHibernateTemplate().find("from CustomerScreen");
	}

	public List<CustomerScreen> getCustomerScreenListByCustomerDetail(CustomerDetail cd) {
		ArrayList<CustomerScreen> al = new ArrayList<CustomerScreen>();
		Criteria c = getHibernateSession().createCriteria(CustomerScreen.class);
		c.add(Expression.eq("customerDetail", cd));
		List result = c.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((CustomerScreen) result.get(i));
		}
		return al;
	}

	public List<CustomerScreen> getCustomerScreenListByBill(Bill bill) {
		ArrayList<CustomerScreen> al = new ArrayList<CustomerScreen>();
		List<CustomerDetail> cd = getCustomerDetailListByCustomerNo(bill.getCustomer());
		for (int i = 0; i < cd.size(); i++) {
			CustomerDetail c = (CustomerDetail) cd.get(i);
			List<CustomerScreen> s = getCustomerScreenListByCustomerDetail(c);
			for (int j = 0; j < s.size(); j++) {
				CustomerScreen screen = (CustomerScreen) s.get(j);
				al.add(screen);
			}
		}
		return al;
	}

	// ProductClass
	public void saveProductClass(ProductClass val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeProductClass(ProductClass val) {
		getHibernateTemplate().delete(val);
	}

	public void removeProductClass(String id) {
		ProductClass obj = findProductClassById(id);
		getHibernateTemplate().delete(obj);
	}

	public ProductClass findProductClassById(String id) {
		if (id == null)
			return null;
		ProductClass obj = (ProductClass) getHibernateTemplate().get(northwest.common.value.ProductClass.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.ProductClass.class, id);
		else
			return obj;
	}

	public List<ProductClass> findAllProductClass() {
		return getHibernateTemplate().find("from ProductClass");
	}

	// OutputEquipment

	public void saveOutputEquipment(OutputEquipment val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeOutputEquipment(OutputEquipment val) {
		getHibernateTemplate().delete(val);
	}

	public void removeOutputEquipment(Long id) {
		OutputEquipment obj = findOutputEquipmentById(id);
		getHibernateTemplate().delete(obj);
	}

	public OutputEquipment findOutputEquipmentById(Long id) {
		if (id == null)
			return null;
		OutputEquipment obj = (OutputEquipment) getHibernateTemplate().get(northwest.common.value.OutputEquipment.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.OutputEquipment.class, id);
		else
			return obj;
	}

	public List<OutputEquipment> findAllOutputEquipment() {
		return getHibernateTemplate().find("from OutputEquipment");
	}

	// BillFinish
	public void saveBillFinish(BillFinish val) {
		getHibernateTemplate().save(val);
	}

	public void removeBillFinish(BillFinish val) {
		getHibernateTemplate().delete(val);
	}

	public void removeBillFinish(Long id) {
		BillFinish obj = findBillFinishById(id);
		getHibernateTemplate().delete(obj);
	}

	public BillFinish findBillFinishById(Long id) {
		if (id == null)
			return null;
		BillFinish obj = (BillFinish) getHibernateTemplate().get(BillFinish.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(BillFinish.class, id);
		else
			return obj;
	}

	public List<BillFinish> findAllBillFinish() {
		return getHibernateTemplate().find("from BillFinish");
	}

	public BillFinish findBillFinishByBill(Bill b) {
		BillFinish bill = null;
		try {
			Criteria c = getHibernateSession().createCriteria(BillFinish.class);
			c.add(Expression.eq("bill", b));
			List result = c.list();
			if (result.size() > 0)
				bill = (BillFinish) result.get(0);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return bill;
	}

	// ProcessState
	public List<ProcessState> findAllProcessState(String billNo, Group group, boolean status, int xor, String worker) {
		ArrayList<ProcessState> al = new ArrayList<ProcessState>();
		int step = Integer.parseInt(group.getGroupNameEn());
		String x = "", x1 = "";
		if (xor == 1) {
			x = " and ";
		} else {
			x = " or ";
		}

		if (group != null) {
			x1 = x + " s.step" + step + "=:status ";
		}
		String hsql = "from ProcessState s where  s.bill.id like :billNo  " + x1 + " and s.worker like :worker  order by s.bill.id";

		System.out.println(hsql);
		System.out.println("status=" + status);

		Query query = getHibernateSession().createQuery(hsql);
		query.setParameter("billNo", "%" + billNo + "%");
		query.setParameter("worker", "%" + worker + "%");

		if (group != null) {
			query.setParameter("status", status);
		}
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			al.add((ProcessState) result.get(i));
		}
		return al;

	}

	public List<ProcessState> findAllProcessState() {
		return getHibernateTemplate().find("from ProcessState");
	}

	public ProfitSum getProfitListSum(List<Profit> ls) {
		ProfitSum p = new ProfitSum();

		int salesCostSum = 0, purchaseSum = 0, salesPriceSum = 0, profitSum = 0, profitFeeSum = 0;
		for (int i = 0; i < ls.size(); i++) {
			Profit f = (Profit) ls.get(i);
			salesCostSum += f.getSalesCost();
			purchaseSum += f.getPurchase();
			salesPriceSum += f.getSalesPrice();
			profitSum += f.getProfit();
			profitFeeSum += f.getFee();
		}

		p.setSalesCostSum(salesCostSum);
		p.setPurchaseSum(purchaseSum);
		p.setSalesPriceSum(salesPriceSum);
		p.setProfitSum(profitSum);
		p.setProfitFeeSum(profitFeeSum);
		return p;
	}

	public ProfitSum getProfitListSum(String projectNo, String start, String end, Customer customer, Member salesmen) {
		ProfitSum p = new ProfitSum();
		String filter = "";
		Vector v = new Vector();

		if (projectNo != null) {
			if (!projectNo.equals("")) {
				System.out.println("projectNo=" + projectNo);
				v.add(" salesNo like '%" + projectNo + "%' ");
				v.add(" billNo like '%" + projectNo + "%' ");
				v.add(" projectNo like '%" + projectNo + "%' ");
			}
		}

		if (start != null) {
			if (!start.equals("")) {
				System.out.println("start=" + start);
				v.add(" billDate >= '" + start + "' ");
			}
		}

		if (end != null) {
			if (!end.equals("")) {
				System.out.println("end=" + end);
				v.add(" billDate <= '" + end + "' ");
			}
		}

		if (customer != null) {
			v.add(" customerId = '" + customer.getId() + "' ");
		}

		if (salesmen != null) {
			v.add(" salesmenId = '" + salesmen.getId() + "' ");
		}

		int salesCostSum = 0, purchaseSum = 0, salesPriceSum = 0, profitSum = 0;

		String s = " and ";
		for (int i = 0; i < v.size(); i++) {
			if (i == 0) {
				filter += " where ";
			}
			if (i == v.size() - 1) {
				s = "";
			}
			filter += v.get(i) + s;
		}

		String sql = "select salesCostSum=isnull(cast(sum(salesCost) as varchar),'0') ,purchaseSum=isnull(cast(sum(purchase) as varchar),'0') ,salesPriceSum=isnull(cast(sum(salesPrice) as varchar),'0') ,profitSum=isnull(cast(sum(profit) as varchar),'0')  from Northwest_Profit " + filter;
		System.out.println(sql);

		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = Stmt.executeQuery(sql);
			if (rs.last()) {
				salesCostSum = Integer.parseInt(rs.getString("salesCostSum"));
				purchaseSum = Integer.parseInt(rs.getString("purchaseSum"));
				salesPriceSum = Integer.parseInt(rs.getString("salesPriceSum"));
				profitSum = Integer.parseInt(rs.getString("profitSum"));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("getProfitListSum error=" + e.toString());
		}

		p.setSalesCostSum(salesCostSum);
		p.setPurchaseSum(purchaseSum);
		p.setSalesPriceSum(salesPriceSum);
		p.setProfitSum(profitSum);
		return p;

	}

	public List<Profit> getProfitList(String projectNo, String start, String end, Customer customer, Member salesmen, int pageSize, int pageIndex) {
		Criteria c = getHibernateSession().createCriteria(Profit.class);
		c.addOrder(Order.desc("salesNo"));
		c.setFirstResult(pageSize * pageIndex);
		c.setMaxResults(pageSize);

		if (projectNo != null) {
			if (!projectNo.equals("")) {
				c.add(Restrictions.or(Restrictions.like("salesNo", "%" + projectNo + "%"), Restrictions.like("billNo", "%" + projectNo + "%")));
				c.add(Expression.like("projectNo", "%" + projectNo + "%"));
				// c.add(Restrictions.or(Expression.eq("salesNo", projectNo),
				// Expression.eq("billNo", projectNo)));
			}
		}

		if (start != null) {

			if (!start.equals("")) {
				c.add(Restrictions.ge("billDate", start));
			}
		}
		if (end != null) {
			if (!end.equals("")) {
				c.add(Restrictions.le("billDate", end));
			}
		}
		if (customer != null) {
			c.add(Expression.eq("customer", customer));
		}
		if (salesmen != null) {
			c.add(Expression.eq("salesmen", salesmen));
		}

		return c.list();

	}

	public List<Profit> getProfitRateList(String start, String end, int tag, BigDecimal profitPerc) {
		Criteria c = getHibernateSession().createCriteria(Profit.class);
		if (start == null && end == null) {
			System.out.println("start == null && end == null");
			c.add(Expression.eq("id", 0L));
		}

		System.out.println(start + "*****" + end);

		if (start != null && end != null) {
			System.out.println(start + "--" + end);
			c.add(Restrictions.between("billDate", start, end));
		}

		if (tag == 0) {
			c.add(Restrictions.ge("profitPerc", profitPerc));
		} else {
			c.add(Restrictions.le("profitPerc", profitPerc));
		}

		c.addOrder(Order.asc("billDate"));

		List ls = c.list();

		System.out.println("ls.size=" + ls.size());

		return ls;
	}

	public int getProfitListByConditionCount(String projectNo, String start, String end, Customer customer, Member salesmen) {
		Criteria c = getHibernateSession().createCriteria(Profit.class);
		c.addOrder(Order.asc("profit"));
		if (projectNo != null) {
			if (!projectNo.equals("")) {
				c.add(Restrictions.or(Expression.eq("salesNo", projectNo), Expression.eq("billNo", projectNo)));
				// c.add(Restrictions.like("salesNo", "%"+projectNo+"%"));
			}
		}

		if (start != null) {
			if (!start.equals("")) {
				c.add(Restrictions.ge("billDate", start));
			}
		}
		if (end != null) {
			if (!end.equals("")) {
				c.add(Restrictions.le("billDate", end));
			}
		}
		if (customer != null) {
			c.add(Expression.eq("customer", customer));
		}
		if (salesmen != null) {
			c.add(Expression.eq("salesmen", salesmen));
		}
		return c.list().size();
	}

	public Profit getProfitById(String id) {
		if (id == null)
			return null;
		Profit obj = (Profit) getHibernateTemplate().get(northwest.common.value.Profit.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.Profit.class, id);
		else
			return obj;
	}

	public Profit getProfitBySalesNo(String salesNo) {
		Profit profit = null;
		Criteria c = getHibernateSession().createCriteria(Profit.class);
		c.add(Expression.eq("salesNo", salesNo));
		List ls = c.list();
		if (ls.size() > 0) {
			profit = (Profit) ls.get(0);
		}
		return profit;
	}

	public List<Profit> getProfitList(String projectNo, String start, String end, Customer customer, Member salesmen) {
		Criteria c = getHibernateSession().createCriteria(Profit.class);
		c.addOrder(Order.desc("salesNo"));
		int i = 0;
		if (projectNo != null) {
			if (!projectNo.equals("")) {
				System.out.println("hiber projectNo=" + projectNo);
				c.add(Restrictions.or(Restrictions.like("salesNo", "%" + projectNo + "%"), Restrictions.like("billNo", "%" + projectNo + "%")));
				i++;
			}
		}

		if (start != null) {

			if (!start.equals("")) {
				System.out.println("!start.equals()");
				c.add(Restrictions.ge("billDate", start));
				i++;
			}
		}
		if (end != null) {
			if (!end.equals("")) {
				System.out.println("!end.equals()");
				c.add(Restrictions.le("billDate", end));
				i++;
			}
		}
		if (customer != null) {
			System.out.println("customer != null");
			c.add(Expression.eq("customer", customer));
			i++;
		}
		if (salesmen != null) {
			System.out.println("salesmen != null");
			c.add(Expression.eq("salesmen", salesmen));
			i++;
		}

		System.out.println("hiber i=" + i + "--c.list().size()=" + c.list().size());

		if (i == 0) {
			List<Profit> ls = new ArrayList<Profit>();
			return ls;
		} else {

			return c.list();
		}

	}

	// ProfitDetail
	public List<ProfitDetail> getProfitDetailList(Profit project) {
		Criteria c = getHibernateSession().createCriteria(ProfitDetail.class);
		c.add(Expression.eq("project", project));
		c.addOrder(Order.asc("item"));
		return c.list();
	}

	public List<ProfitDetail> getProfitDetailListBySalesNo(String salesNo) {
		Criteria c = getHibernateSession().createCriteria(ProfitDetail.class);
		c.add(Expression.eq("salesNo", salesNo));
		c.addOrder(Order.asc("item"));
		return c.list();
	}

	public List<ProfitDetail> getProfitDetailListByProduct(String startDate, String endDate, Product product) {
		Criteria c = getHibernateSession().createCriteria(ProfitDetail.class);
		c.createCriteria("profitNo", "p");
		c.add(Expression.eq("product", product));
		c.add(Restrictions.between("p.billDate", startDate, endDate));
		c.addOrder(Order.asc("p.salesNo"));
		return c.list();
	}

	// ProfitProduct
	public ProfitProduct getProfitProductList(String startDate, String endDate, Product product) {

		// String hsql = "select
		// sum(p.salesPrice),sum(p.purchasePrice),sum(p.salesCost),sum(p.profit),(sum(p.profit)/sum(p.salesPrice)
		// *100 ),sum(p.unit1),sum(p.unit2),sum(p.unit3) from ProfitDetail p
		// inner join p.profitNo as profit where profit.billDate between
		// :startDate and :endDate and p.product=:product";
		ProfitProduct p = null;
		try {
			String hsql = "select sum(p.salesPrice),sum(p.purchasePrice),sum(p.salesCost),sum(p.profit),(0),sum(p.unit1),sum(p.unit2),sum(p.unit3) from ProfitDetail p inner join p.profitNo as profit where profit.billDate between :startDate and :endDate and p.product=:product";
			Query query = getHibernateSession().createQuery(hsql);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("product", product);

			System.out.println(hsql);

			System.out.println("startDate=" + startDate);
			System.out.println("endDate=" + endDate);
			System.out.println("product.ProductName=" + product.getProductName());

			Iterator ite = query.list().iterator();
			while (ite.hasNext()) {
				Object[] objects = (Object[]) ite.next();
				System.out.println("salesPrice= " + objects[0]);
				System.out.println("purchasePrice= " + objects[1]);
				System.out.println("salesCost= " + objects[2]);
				System.out.println("profit= " + objects[3]);
				System.out.println("profitRate= " + String.valueOf(objects[4]));

				p = new ProfitProduct();
				p.setSalesPrice(String.valueOf(objects[0]));
				p.setPurchasePrice(String.valueOf(objects[1]));
				p.setSalesCost(String.valueOf(objects[2]));
				p.setProfit(String.valueOf(objects[3]));
				p.setProfitRate(String.valueOf(objects[4]));
				p.setUnit1(String.valueOf(objects[5]));
				p.setUnit2(String.valueOf(objects[6]));
				p.setUnit3(String.valueOf(objects[7]));

				p.setBeginDate(Tools.convertToDate1(startDate));
				p.setEndDate(Tools.convertToDate1(endDate));
				p.setProduct(product);
			}
			return p;
		} catch (Exception e) {
			System.out.println("getProfitProductList err=" + e.toString());
			return null;
		}
	}

	// WorkEfficiency
	public List<WorkEfficiency> getWorkEfficiencyByMember(String startDate, String endDate, Member member) {
		ArrayList<WorkEfficiency> al = new ArrayList<WorkEfficiency>();
		try {
			List<Group> groups = findAllGroupWorkfllow();
			for (int i = 0; i < groups.size(); i++) {
				Group group = groups.get(i);
				System.out.println("GroupName=" + group.getGroupName());

				String hsql;
				if (group.getGroupKey().equals("cuticle")) {

					hsql = " select d.product,sum(d.quantity),sum(d.basicQuantity),count(*) from BillSchedule s inner join s.billDetail as d where s.cuticle" + " between :startDate and :endDate " + " and s.cuticleer" + "=:member " + " group by d.product ";

				} else {
					hsql = " select d.product,sum(d.quantity),sum(d.basicQuantity),count(*) from BillSchedule s inner join s.billDetail as d where s.check" + group.getGroupNameEn() + " between :startDate and :endDate " + " and s.checker" + group.getGroupNameEn() + "=:member " + " group by d.product ";
				}
				// System.out.println(hsql);

				Query query = getHibernateSession().createQuery(hsql);
				query.setParameter("startDate", Tools.convertToDate1(startDate));
				query.setParameter("endDate", Tools.convertToDateEnd(endDate));
				query.setParameter("member", member);

				WorkEfficiency w = new WorkEfficiency();
				w.setMember(member);
				w.setGroup(group);
				ArrayList<ProductX> products = new ArrayList<ProductX>();
				ArrayList<ProductUnitX> productUnits = new ArrayList<ProductUnitX>();
				int sumNumber = 0;
				for (Iterator it = query.iterate(); it.hasNext();) {
					Object[] row = (Object[]) it.next();
					Product product = (Product) row[0];
					ProductX p = new ProductX();
					p.setProduct(product);
					p.setPid(String.valueOf(Math.random()));
					p.setProductId(product.getId());
					p.setProductName(product.getProductName());
					p.setUnit(product.getUnit());
					p.setSumQuantity(Integer.parseInt(String.valueOf(row[1])));
					p.setSumBasicQuantity(Integer.parseInt(String.valueOf(row[2])));
					p.setSumNumber(Integer.parseInt(String.valueOf(row[3])));
					sumNumber += p.getSumNumber();

					ProductUnit unit = product.getProductUnit();
					ProductUnitX u = new ProductUnitX(unit.getId(), unit.getName());

					if (contains(productUnits, u) == false) {
						u.setCount(p.getSumBasicQuantity());
						productUnits.add(u);
					} else {
						u = getProductUnitX(productUnits, u.getId());
						u.setCount(u.getCount() + p.getSumBasicQuantity());
					}

					if (group.getId() == 14L) {
						// System.out.println(group.getId()+"--"+p.getPid()+"--SumBasicQuantit="+p.getSumBasicQuantity()+"--SumNumber="+p.getSumNumber()+"--u.count="+u.getCount());
					}

					products.add(p);
				}
				w.setProducts(products);
				w.setSumNumber(sumNumber);
				w.setProductUnits(productUnits);
				al.add(w);
				// System.out.println(group.getGroupNameCh()+"--"+group.getGroupNameEn()+"--product.size="+w.getProducts().size());
			}
		} catch (Exception e) {
			System.out.println("Query error=" + e.toString());
		}
		return al;
	}

	public ProductUnitX getProductUnitX(ArrayList<ProductUnitX> ls, String unitId) {
		ProductUnitX u = new ProductUnitX();
		for (int i = 0; i < ls.size(); i++) {
			ProductUnitX a = ls.get(i);
			if (a.getId().equals(unitId)) {
				return a;
			}
		}
		return u;
	}

	public boolean contains(ArrayList<ProductUnitX> ls, ProductUnitX u) {
		for (int i = 0; i < ls.size(); i++) {
			ProductUnitX a = ls.get(i);
			if (a.getId().equals(u.getId())) {
				return true;
			}
		}
		return false;
	}

	// profitFee
	public List<ProfitFee> getProfitFeeByBill(Bill bill) {
		Criteria c = getHibernateSession().createCriteria(ProfitFee.class);
		c.add(Expression.eq("bill", bill));
		return c.list();
	}

	// StandardCost
	public void saveStandardCost(StandardCost val) {
		Criteria c = getHibernateSession().createCriteria(StandardCost.class);
		c.add(Expression.eq("salesNo", val.getSalesNo()));
		c.add(Expression.eq("product", val.getProduct()));
		List ls = c.list();
		for (int i = 0; i < ls.size(); i++) {
			StandardCost s = (StandardCost) ls.get(i);
			removeStandardCost(s);
		}
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeStandardCost(StandardCost val) {
		getHibernateTemplate().delete(val);
	}

	public void removeStandardCost(Long id) {
		StandardCost obj = findStandardCostById(id);
		getHibernateTemplate().delete(obj);
	}

	public StandardCost findStandardCostById(Long id) {
		if (id == null)
			return null;
		StandardCost obj = (StandardCost) getHibernateTemplate().get(northwest.common.value.StandardCost.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.StandardCost.class, id);
		else
			return obj;
	}

	public List<StandardCost> findAllStandardCost(String salesNo) {
		Criteria c = getHibernateSession().createCriteria(StandardCost.class);
		c.add(Expression.eq("salesNo", salesNo));
		return c.list();
	}

	// CustomerStandardCost
	public void saveCustomerStandardCost(CustomerStandardCost val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeCustomerStandardCost(CustomerStandardCost val) {
		getHibernateTemplate().delete(val);
	}

	public void removeCustomerStandardCost(Long id) {
		CustomerStandardCost obj = findCustomerStandardCostById(id);
		getHibernateTemplate().delete(obj);
	}

	public CustomerStandardCost findCustomerStandardCostById(Long id) {
		if (id == null)
			return null;
		CustomerStandardCost obj = (CustomerStandardCost) getHibernateTemplate().get(northwest.common.value.CustomerStandardCost.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.CustomerStandardCost.class, id);
		else
			return obj;
	}

	public List<CustomerStandardCost> findAllCustomerStandardCost(Customer customer) {
		Criteria c = getHibernateSession().createCriteria(CustomerStandardCost.class);
		if (customer != null) {
			c.add(Expression.eq("customer", customer));
		}
		return c.list();
	}

	// BillQA
	public void saveBillQA(BillQA val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeBillQA(BillQA val) {
		getHibernateTemplate().delete(val);
	}

	public void removeBillQA(Long id) {
		BillQA obj = findBillQAById(id);
		getHibernateTemplate().delete(obj);
	}

	public BillQA findBillQAById(Long id) {
		if (id == null)
			return null;
		BillQA obj = (BillQA) getHibernateTemplate().get(northwest.common.value.BillQA.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.BillQA.class, id);
		else
			return obj;
	}

	public List<BillQA> findAllBillQA(Bill bill) {
		Criteria c = getHibernateSession().createCriteria(BillQA.class);
		c.add(Expression.eq("bill", bill));
		return c.list();
	}

	public List<BillQA> findAllBillQA(String startDate, String endDate, String billno, Customer customer) {
		System.out.println("hiber findAllBillQA billno=" + billno);

		Criteria c = getHibernateSession().createCriteria(BillQA.class);
		c.createCriteria("bill", "b");
		if (billno != null) {
			c.add(Expression.like("b.id", "%" + billno + "%"));
		}

		if (customer != null) {
			c.add(Expression.like("b.customer", customer));
		}

		if (startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")) {
			c.add(Restrictions.between("b.billDate", startDate, endDate));
		}

		c.setMaxResults(300);

		c.addOrder(Order.asc("bill"));

		return c.list();
	}

	// Logistics
	public void saveLogistics(Logistics val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeLogistics(Long id) {
		Logistics obj = findLogisticsById(id);
		getHibernateTemplate().delete(obj);
	}

	public Logistics findLogisticsById(Long id) {
		if (id == null)
			return null;
		Logistics obj = (Logistics) getHibernateTemplate().get(northwest.common.value.Logistics.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(northwest.common.value.Logistics.class, id);
		else
			return obj;
	}

	public List<Logistics> findAllLogistics(String keyword, Date startDate, Date endDate) {
		Criteria c = getHibernateSession().createCriteria(Logistics.class);
		c.createCriteria("bill", "b");
		c.createCriteria("freightCompany", "c");
		if (keyword != null) {		
			Disjunction disjunction = Restrictions.disjunction();
			Criterion c1 = Restrictions.like("b.id", "%" + keyword + "%");
			Criterion c2 = Restrictions.like("code", "%" + keyword + "%");
			Criterion c3 = Restrictions.like("otherBills", "%" + keyword + "%");
			Criterion c4 = Restrictions.like("memo", "%" + keyword + "%");
			Criterion c5 = Restrictions.like("c.valueTw", "%" + keyword + "%");			
			Criterion c6 = Restrictions.like("sender", "%" + keyword + "%");
			Criterion c7 = Restrictions.like("recipient", "%" + keyword + "%");
			
			disjunction.add(c1);
			disjunction.add(c2);
			disjunction.add(c3);
			disjunction.add(c4);
			disjunction.add(c5);
			disjunction.add(c6);
			disjunction.add(c7);
			c.add(disjunction);
		}

		if (startDate != null) {
			c.add(Restrictions.ge("serviceDate", startDate));
		}

		if (startDate != null) {
			c.add(Restrictions.le("serviceDate", endDate));
		}

		c.addOrder(Order.desc("id"));
		c.setMaxResults(300);
		return c.list();
	}

	// SenderDB
	public List<SenderDB> findAllSenderDB(String keyword) {
		Criteria c = getHibernateSession().createCriteria(SenderDB.class);
		c.add(Expression.like("sender", "%" + keyword + "%"));
		return c.list();
	}

	// LogisticsCode
	public void saveLogisticsCode(LogisticsCode val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeLogisticsCode(Logistics val) {
		Criteria c = getHibernateSession().createCriteria(LogisticsCode.class);
		c.add(Expression.eq("logistics", val));
		List ls = c.list();
		for (int i = 0; i < ls.size(); i++) {
			getHibernateTemplate().delete((LogisticsCode) ls.get(i));
		}
	}

	public LogisticsCode getLastOneLogisticsCode(AppProperty freightCompany) {
		Criteria c = getHibernateSession().createCriteria(LogisticsCode.class);
		c.add(Expression.eq("freightCompany", freightCompany));
		c.addOrder(Order.desc("id"));
		List ls = c.list();
		if (ls.size() > 0) {
			return (LogisticsCode) ls.get(0);
		} else {
			return null;
		}
	}

	// RecipientDB
	public List<RecipientDB> findAllRecipientDB(String keyword) {
		Criteria c = getHibernateSession().createCriteria(RecipientDB.class);
		c.add(Expression.like("recipient", "%" + keyword + "%"));
		return c.list();
	}

}
