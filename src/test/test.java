package test;

import java.text.DecimalFormat;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String barcode="»O¥_-1";
		if(barcode.indexOf("-")!=-1){
			barcode=barcode.substring(0, barcode.indexOf("-"));
		}
		System.out.println("barcode="+barcode);
				
		
	}

}
