package com.common.value;

import java.util.*;

public class ComparatorMember implements Comparator{

	public int compare(Object arg0, Object arg1) {
		  Member m=(Member)arg0;
		  Member m1=(Member)arg1;
		  
		  String a=m.getName();
		  String b=m.getName();
		  
		  int flag=a.compareTo(b);
		  //int flag=reader0.getName().compareTo(reader1.getName());
		  if(flag==0){
		   return m.getName().compareTo(m1.getName());
		  }else{
		   return flag;
		  }  
		 }
	


}
