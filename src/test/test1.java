package test;

public class test1 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int width = 3264; 
	int limitWidth=456;
	double scaleRate=Double.parseDouble(String.valueOf(limitWidth))/Double.parseDouble(String.valueOf(width));      
	
	double s=Double.parseDouble(String.valueOf(width)) * scaleRate; 
	
	java.text.DecimalFormat df = new java.text.DecimalFormat("#0.####"); 
	System.out.println("scaleRate df="+df.format(scaleRate));
	
	System.out.println("scaleRate df="+df.format(scaleRate));
	
	
	 
	int s1=Integer.parseInt(df.format(Double.parseDouble(String.valueOf(width)) * scaleRate));
	System.out.println("s1="+s1);
    }

}
