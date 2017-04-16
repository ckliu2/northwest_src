package com.base.value;
import java.util.*;
import java.text.*;

public class GroupComparatorDesc implements Comparator{	
	public int compare(Object o1,Object o2) {
        Group p1=(Group)o1;
        Group p2=(Group)o2;        
        try{        
          if(p1.getId() < p2.getId()){
              return 1;
          }
          else{
              return 0;
          }          
        }catch(Exception e){
        	 System.out.println("e="+e.toString());
        }
        return 0;
      }

}
