package com.base.value;
import java.util.*;
import java.text.*;

public class GroupComparator implements Comparator{	
	public int compare(Object o1,Object o2) {
        Group p1=(Group)o1;
        Group p2=(Group)o2; 
        int i=0;
        try{        
          if(p1.getId() > p2.getId()){
              //return 1;
        	  i=1;
          }
          else{
              //return 0;
        	  i=0;
          }       
          System.out.println("GroupComparator compare p1"+p1.getId()+"--p2="+p2.getId());
        }catch(Exception e){
        	 System.out.println("e="+e.toString());
        }
        //return 0;
        return i;
      }

}
