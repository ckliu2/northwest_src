package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.*;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class ProfitAction extends CommonActionSupport {
	private Profit profit;
	private ProfitDetail profitDetail;
	String projectNo, startDate, endDate;
	Customer customer;
	Member salesmen;
	String customerId, salesmenId;
	ProfitSum profitSum;
	String productClassId, myproductId;
	Product product;
	String[] selectedProductIds, selectedCustomerIds;
	String productKeyWord, customerKeyWord, q;
	String scost;
	int tag;
	BigDecimal profitPerc;

	public Profit getProfit() {
		return profit;
	}

	public void setProfit(Profit val) {
		profit = val;
	}

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Member getSalesmen() {
		return salesmen;
	}

	public void setSalesmen(Member salesmen) {
		this.salesmen = salesmen;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSalesmenId() {
		return salesmenId;
	}

	public void setSalesmenId(String salesmenId) {
		this.salesmenId = salesmenId;
	}

	public ProfitSum getProfitSum() {
		return profitSum;
	}

	public void setProfitSum(ProfitSum profitSum) {
		this.profitSum = profitSum;
	}

	public ProfitDetail getProfitDetail() {
		return profitDetail;
	}

	public void setProfitDetail(ProfitDetail profitDetail) {
		this.profitDetail = profitDetail;
	}

	public String getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(String productClassId) {
		this.productClassId = productClassId;
	}

	public String getMyproductId() {
		return myproductId;
	}

	public void setMyproductId(String myproductId) {
		this.myproductId = myproductId;
	}

	public String list() {
		return SUCCESS;
	}

	public String[] getSelectedProductIds() {
		return selectedProductIds;
	}

	public void setSelectedProductIds(String[] selectedProductIds) {
		this.selectedProductIds = selectedProductIds;
	}

	public String[] getSelectedCustomerIds() {
		return selectedCustomerIds;
	}

	public void setSelectedCustomerIds(String[] selectedCustomerIds) {
		this.selectedCustomerIds = selectedCustomerIds;
	}

	public String getProductKeyWord() {
		return productKeyWord;
	}

	public void setProductKeyWord(String productKeyWord) {
		this.productKeyWord = productKeyWord;
	}

	public String getCustomerKeyWord() {
		return customerKeyWord;
	}

	public void setCustomerKeyWord(String customerKeyWord) {
		this.customerKeyWord = customerKeyWord;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public List<Profit> getProfitList() {
		customer = getGenericManager().getCustomerById(customerId);
		salesmen = getGenericManager().getMemberById(salesmenId);
		List<Profit> al = getGenericManager().getProfitList(projectNo, startDate, endDate, customer, salesmen);
		profitSum = getGenericManager().getProfitListSum(al);

		return al;
	}

	public List<Profit> getProfitList_bk() {
		int pageIndex = getPageIndex();
		int pageSize = getPageSize();
		System.out.println("projectNo=" + projectNo + "--customerId=" + customerId + "--startDate=" + startDate
				+ "--endDate=" + endDate + "--pageIndex=" + pageIndex + "--pageSize=" + pageSize + "---scost=" + scost);

		List<Profit> al = new ArrayList<Profit>();
		customer = getGenericManager().getCustomerById(customerId);
		salesmen = getGenericManager().getMemberById(salesmenId);
		int resultSize = getGenericManager().getProfitListByConditionCount(projectNo, startDate, endDate, customer,
				salesmen);
		getSession().setAttribute("RESULT_SIZE", new Integer(resultSize));
		System.out.println("resultSize=" + resultSize);
		al = getGenericManager().getProfitList(projectNo, startDate, endDate, customer, salesmen, pageSize, pageIndex);
		int c = checkCondition(projectNo, startDate, endDate, customer, salesmen);
		if (c > 0) {
			profitSum = getGenericManager().getProfitListSum(projectNo, startDate, endDate, customer, salesmen);
		}
		return al;
	}

	public List<Profit> getProfitList2() {
		System.out.println("getProfitList2===1");
		List<Profit> al = new ArrayList<Profit>();
		profit = getGenericManager().getProfitBySalesNo("20110314007");
		if (profit == null) {
			System.out.println("getProfitList2 profit==null");
		} else {
			System.out.println("getProfitList2 profit!null");

		}
		al.add(profit);
		return al;
	}

	public int checkCondition(String projectNo, String start, String end, Customer customer, Member salesmen) {
		int i = 0;
		if (projectNo != null) {
			if (!projectNo.equals("")) {
				i++;
			}
		}

		if (start != null) {
			if (!start.equals("")) {
				i++;
			}
		}

		if (end != null) {
			if (!end.equals("")) {
				i++;
			}
		}

		if (customer != null) {
			i++;
		}

		if (salesmen != null) {
			i++;
		}

		return i;
	}

	public List<ProfitDetail> getProfitDetailList() {
		profit = getGenericManager().getProfitBySalesNo(profit.getSalesNo());
		List<ProfitDetail> ls = getGenericManager().getProfitDetailListBySalesNo(profit.getSalesNo());
		for (int i = 0; i < ls.size(); i++) {
			ProfitDetail a = ls.get(i);
			System.out.println("id=" + a.getId() + "---company=" + a.getCompany());
		}
		return ls;
	}

	public List<Member> getSalesmenList() {
		ArrayList<Member> al = new ArrayList<Member>();
		Group g = getGenericManager().getGroupById(21L);
		Set s = g.getMembers();
		if (s != null) {
			Iterator i = s.iterator();
			while (i.hasNext()) {
				Member u = (Member) i.next();
				al.add(u);
			}
		}
		ComparatorMember comparator = new ComparatorMember();
		Collections.sort(al, comparator);
		return al;
	}

	public List<ProductClass> getProductClassList() {
		return getGenericManager().getProductClassList();
	}

	public List<Product> getProductList() {
		ArrayList<Product> al = new ArrayList<Product>();
		if (selectedProductIds != null) {
			for (int i = 0; i < selectedProductIds.length; i++) {
				System.out.print("selectedProductIds=" + selectedProductIds[i]);
				Product p = getGenericManager().getProductById(selectedProductIds[i]);
				al.add(p);
			}
		}
		return al;

	}

	public List<Customer> getCustomerList() {
		ArrayList<Customer> al = new ArrayList<Customer>();
		if (selectedCustomerIds != null) {
			for (int i = 0; i < selectedCustomerIds.length; i++) {
				// System.out.print("selectedCustomerIds=" +
				// selectedCustomerIds[i]);
				Customer c = getGenericManager().getCustomerById(selectedCustomerIds[i]);
				al.add(c);
			}
		}
		return al;
	}

	public JSONArray findProductByJSON() {
		System.out.println("findProductByJSON q=" + q);
		JSONArray jsonArray = new JSONArray();
		try {
			List ls = getGenericManager().getProductListByCondition(q, q);
			// System.out.println("findMemberByJSON size="+ls.size());
			for (int i = 0; i < ls.size(); i++) {
				Product s = (Product) ls.get(i);
				JSONObject jo = new JSONObject();
				jo.accumulate("id", s.getId());
				jo.accumulate("name", s.getProductName());
				jsonArray.put(jo);
			}
			// System.out.println("findMemberByJSON
			// JSONArray="+jsonArray.toString());
		} catch (Exception e) {
			System.out.println("findProductByJSON error..");
		}
		return jsonArray;
	}

	public JSONArray findCustomerByJSON() {
		System.out.println("findCustomerByJSON q=" + q);
		JSONArray jsonArray = new JSONArray();
		try {
			List ls = getGenericManager().getCustomerByKeyWord(q);
			// System.out.println("findMemberByJSON size="+ls.size());
			for (int i = 0; i < ls.size(); i++) {
				Customer s = (Customer) ls.get(i);
				JSONObject jo = new JSONObject();
				jo.accumulate("id", s.getId());
				jo.accumulate("name", s.getName());
				jsonArray.put(jo);
			}
			// System.out.println("findCustomerByJSON
			// JSONArray="+jsonArray.toString());
		} catch (Exception e) {
			System.out.println("findCustomerByJSON error..");
		}
		return jsonArray;
	}

	public List<Profit> getProfitRateList() {
		return getGenericManager().getProfitRateList(startDate, endDate, tag, profitPerc);
	}

	public List<ProfitProduct> getProfitProductList() {
		ArrayList<ProfitProduct> al = new ArrayList<ProfitProduct>();
		System.out.println("getProfitProductList-----");
		
		if (selectedProductIds != null) {
			for (int j = 0; j < selectedProductIds.length; j++) {
				try {
					product = getGenericManager().getProductById(selectedProductIds[j]);
					ProfitProduct p = getGenericManager().getProfitProductList(startDate, endDate, product);
					if (p != null) {
						al.add(p);
					}
				} catch (Exception e) {
					System.out.println("getProfitProductList Action err=" + e.toString());
				}

			}
		}

		// System.out.println("al.size="+al.size());
		return al;
	}

	public List<ProfitFee> getProfitFee() {
		System.out.println("getProfitFee profit.getId()=" + profit.getId());
		Profit p = getGenericManager().getProfitBySalesNo(profit.getSalesNo());
		Bill bill = getGenericManager().getBillById(p.getProjectNo());
		System.out.println("getProfitFee bill.id=" + bill.getId());
		return getGenericManager().getProfitFeeByBill(bill);
	}

	public boolean standcostAdmin() {
		System.out.println("standcostAdmin...");
		return checkGroup(getSessionUser(), "standcost");
	}

	public String getScost() {
		return scost;
	}

	public void setScost(String scost) {
		this.scost = scost;
	}

	public Product getProductById() {
		product = getGenericManager().getProductById(product.getId());
		return product;
	}

	public List getProfitDetailListByProduct() {
		product = getProductById();
		System.out.println(
				"product.name=" + product.getProductName() + "--startDate=" + startDate + "--endDate=" + endDate);
		return getGenericManager().getProfitDetailListByProduct(startDate, endDate, product);
	}

	public String calculateProfitJSON() {
		try {
			System.out.println("dbo.CalculationProfit");
			String sql = " dbo.CalculationProfit ";
			getGenericManager().executeSQL(sql);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "";
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public BigDecimal getProfitPerc() {
		return profitPerc;
	}

	public void setProfitPerc(BigDecimal profitPerc) {
		this.profitPerc = profitPerc;
	}

}
