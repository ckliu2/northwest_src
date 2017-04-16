package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.SessionUser;

public class StandardCostAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private StandardCost standardCost, standardCost1;
	private Long[] selectedStandardCostIds;
	private Profit profit;
	String keyword = new String();
	String q, productIds;
	Product product, product1;
	CustomerStandardCost customerStandardCost, customerStandardCost1;
	Customer customer;
	int submitId;

	public StandardCostAction() {
		log = LogFactory.getLog(northwest.common.web.action.StandardCostAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("STANDARDCOST");
	}

	public StandardCost getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(StandardCost val) {
		standardCost = val;
	}

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeStandardCost(standardCost.getId());
		return DELETE;
	}

	public String edit() {
		if (standardCost == null) {
			standardCost = new StandardCost();
		} else if (standardCost.getId() != null) {
			standardCost = getGenericManager().getStandardCostById(standardCost.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedStandardCostIds != null && selectedStandardCostIds.length > 0) {
			StandardCost obj = getGenericManager().getStandardCostById(selectedStandardCostIds[0]);
			obj.setId(null);
			standardCost = obj;
		}
		beanToForm();

		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		if (getDelete() != null) {
			return delete();
		} else {
			formToBean();
			if (inputValidation(standardCost) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(StandardCost val) {
		return true;
	}

	public String save1() throws Exception {
		JSONObject jo = new JSONObject();
		
		if (getDelete() != null) {					
			customerStandardCost=getGenericManager().getCustomerStandardCostById(customerStandardCost.getId());
			
			jo.put("returnValue", true);
			jo.put("customerId", customerStandardCost.getCustomerId());
			
			getGenericManager().removeCustomerStandardCost(customerStandardCost.getId());
			
		} else {
			System.out.println("productIds=" + productIds);
			customer=getGenericManager().getCustomerById(customerStandardCost.getCustomerId());
			String[] tokens = productIds.split(",");
			for (int i = 0; i < tokens.length; i++) {
				System.out.println("tokens=" + tokens[i]);
				Product p = getGenericManager().getProductById(tokens[i]);
				customerStandardCost1 = new CustomerStandardCost();
				customerStandardCost1.setCost(customerStandardCost.getCost());
				customerStandardCost1.setProduct(p);
				customerStandardCost1.setCustomer(customer);				
				getGenericManager().saveCustomerStandardCost(customerStandardCost1);
			}
			
			
			jo.put("customerId", customer.getId());
			jo.put("returnValue", true);
		}

		return jo.toString();

	}

	public String save() {
		// System.out.println("save()....");
		if (getDelete() != null) {
			System.out.println("delete");
			delete();
		} else {
			System.out.println("edit insert");
			if (standardCost.getId() != null) {
				standardCost1 = getGenericManager().getStandardCostById(standardCost.getId());
			} else {
				standardCost1 = new StandardCost();
			}
			System.out.println("standardCost.getProductId()=" + standardCost.getProductId());
			System.out.println("standardCost.getCost()=" + standardCost.getCost());

			standardCost1.setSalesNo(standardCost.getSalesNo());
			standardCost1.setProduct(getGenericManager().getProductById(standardCost.getProductId()));
			standardCost1.setCost(standardCost.getCost());

			getGenericManager().saveStandardCost(standardCost1);

		}

		appendXworkParam("profit.salesNo=" + standardCost.getSalesNo());
		return SUCCESS;

	}

	public String list() {
		profit = getGenericManager().getProfitBySalesNo(profit.getSalesNo());

		if (standardCost == null) {
			standardCost = new StandardCost();
		} else if (standardCost.getId() != null) {
			standardCost = getGenericManager().getStandardCostById(standardCost.getId());
		}
		return SUCCESS;
	}

	public String list2() {
		if (submitId == 0) {
			submitId = 1;
		}

		try {
			customerStandardCost = getGenericManager().getCustomerStandardCostById(customerStandardCost.getId());
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public String list1() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		standardCost.setProduct(getGenericManager().getProductById(standardCost.getProductId()));
		log.info("exit formToBean()");
	}

	public List<Product> getProductList() {
		return getGenericManager().getProductList(); // TODO
	}

	public List<StandardCost> getStandardCostList() {
		return getGenericManager().getStandardCostList(profit.getSalesNo());
	}

	public List<CustomerStandardCost> getCustomerStandardCostList() {
		System.out.println("customerStandardCostList");
		try {
			customer = getGenericManager().getCustomerById(customer.getId());
		} catch (Exception e) {
			customer = null;
		}
		return getGenericManager().getCustomerStandardCostList(customer);
	}

	public String customerJSON() {
		JSONArray ja = new JSONArray();
		try {

			try {
				if (customer.getId() != null && keyword.equals("")) {
					customer = getGenericManager().getCustomerById(customer.getId());
					if (customer != null) {
						JSONObject jo = new JSONObject();
						jo.put("value", customer.getId());
						jo.put("text", customer.getId() + "  [" + customer.getName() + "]");
						jo.put("selected", true);
						ja.put(jo);
					}
				}
			} catch (Exception e) {
				System.out.println("customer.id==null");
			}

			if (!keyword.equals("")) {
				System.out.println("keyword=" + keyword);

				List<Customer> ls = getGenericManager().getCustomerByKeyWord(keyword);
				System.out.println("keyword=" + keyword + "--ls.size=" + ls.size());
				for (int i = 0; i < ls.size(); i++) {
					customer = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("value", customer.getId());
					jo.put("text", customer.getId() + "  [" + customer.getName() + "]");
					ja.put(jo);
				}
			}

		} catch (Exception e) {
			System.out.println("customerJSON=" + e.toString());
		}
		return ja.toString();
	}

	public String productJSON() {
		JSONArray ja = new JSONArray();
		try {
			System.out.println("productJSON q=" + q);
			try {
				if (product.getId() != null && q.equals("")) {
					product1 = getGenericManager().getProductById(product.getId());
					if (product1 != null) {
						JSONObject jo = new JSONObject();
						jo.put("value", String.valueOf(product1.getId()));
						jo.put("text", product1.getId() + "  [" + product1.getProductName() + "]");
						jo.put("selected", true);
						ja.put(jo);
					}
				}
			} catch (Exception e) {
				System.out.println("product.id==null");
			}

			if (!q.equals("")) {
				System.out.println("q=" + q);

				List<Product> ls = getGenericManager().getProductListByCondition(q, q);
				System.out.println("q=" + q + "--ls.size=" + ls.size());
				for (int i = 0; i < ls.size(); i++) {
					product = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("value", String.valueOf(product.getId()));
					jo.put("text", product.getId() + "  [" + product.getProductName() + "]");
					ja.put(jo);
				}
			}

		} catch (Exception e) {
			System.out.println("productJSON=" + e.toString());
		}
		return ja.toString();
	}

	public void setSelectedStandardCostIds(Long[] val) {
		selectedStandardCostIds = val;
	}

	public Long[] getSelectedStandardCostIds() {
		return selectedStandardCostIds;
	}

	public Profit getProfit() {
		return profit;
	}

	public void setProfit(Profit profit) {
		this.profit = profit;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerStandardCost getCustomerStandardCost() {
		return customerStandardCost;
	}

	public void setCustomerStandardCost(CustomerStandardCost customerStandardCost) {
		this.customerStandardCost = customerStandardCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSubmitId() {
		return submitId;
	}

	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

}
