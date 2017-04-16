package northwest.common.value;

import java.text.DecimalFormat;

import com.base.util.Tools;

public class ProfitSum {
	
	int salesCostSum,purchaseSum,salesPriceSum,profitSum,profitFeeSum;
	String salesCostSumStr,purchaseSumStr,salesPriceSumStr,profitSumStr,profitFeeSumStr;
	float profitPerc;
	DecimalFormat df=new DecimalFormat("#.##");
	
	public String getProfitPerc() {
		float x=Float.parseFloat(String.valueOf(profitSum))/Float.parseFloat(String.valueOf(salesPriceSum)) * 100;
		String s=df.format(x);
		return s;
	}
	
	public int getSalesCostSum() {
		return salesCostSum;
	}

	public void setSalesCostSum(int salesCostSum) {
		this.salesCostSum = salesCostSum;
	}

	public int getPurchaseSum() {
		return purchaseSum;
	}

	public void setPurchaseSum(int purchaseSum) {
		this.purchaseSum = purchaseSum;
	}

	public int getSalesPriceSum() {
		return salesPriceSum;
	}

	public void setSalesPriceSum(int salesPriceSum) {
		this.salesPriceSum = salesPriceSum;
	}

	public int getProfitSum() {
		return profitSum;
	}

	public void setProfitSum(int profitSum) {
		this.profitSum = profitSum;
	}
	
	
	public String getSalesCostSumStr() {
		return Tools.thousandsFormat(salesCostSum);
	}

	public String getPurchaseSumStr() {
		return Tools.thousandsFormat(purchaseSum);
	}

	public String getSalesPriceSumStr() {
		return Tools.thousandsFormat(salesPriceSum);
	}

	public String getProfitSumStr() {
		return Tools.thousandsFormat(profitSum);
	}
	
	public int getProfitFeeSum() {
		return profitFeeSum;
	}

	public void setProfitFeeSum(int profitFeeSum) {
		this.profitFeeSum = profitFeeSum;
	}

	public String getProfitFeeSumStr() {
		return Tools.thousandsFormat(profitFeeSum);
	}

	
	
}
