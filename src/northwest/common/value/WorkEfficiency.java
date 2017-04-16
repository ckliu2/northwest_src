package northwest.common.value;

import java.util.*;

import com.base.value.*;
import com.common.value.*;

public class WorkEfficiency {	
	Member member;
	Group group;
	int sumNumber; 
	List<ProductX> products; 
	List<ProductUnitX> productUnits; 
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}	
	
	public List<ProductX> getProducts() {
		return products;
	}
	public void setProducts(List<ProductX> products) {
		this.products = products;
	}
	
    public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public int getSumNumber() {
		return sumNumber;
	}
	public void setSumNumber(int sumNumber) {
		this.sumNumber = sumNumber;
	}
	public List<ProductUnitX> getProductUnits() {
		return productUnits;
	}
	public void setProductUnits(List<ProductUnitX> productUnits) {
		this.productUnits = productUnits;
	}

}
