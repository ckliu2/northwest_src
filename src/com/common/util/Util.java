package com.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Util
{
      public static String CONTEXT_ROOT_NAME = "";
//    public static String CONTEXT_ROOT = "/";

    public static String IMAGE_CONTEXT_ROOT_PATH = "/"; // this will be rested by other program, it should be the contect root name, for example, /survey

    public Util()
    { 
        super();
    }
    
    /**
     * Convert string with separator, such as ",|;", to integer array
     */
    public static int[] convertStringToIntArray(String dataStr, String sep)
    {
        if (dataStr == null || dataStr.length() == 0)
            return new int[0];
        ArrayList al = new ArrayList();
        StringTokenizer st = new StringTokenizer(dataStr.trim(), sep);
        for (int i=0; st.hasMoreTokens(); i++) {
            int tm = 0;
            try {
                tm = Integer.parseInt(st.nextToken().trim());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            al.add(new Integer(tm));
        }
        int ret[] = new int[al.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = ((Integer)al.get(i)).intValue();
        }
        
        return  ret;
    }

    public static List convertStringToIntArrayList(String dataStr, String sep)
    {
        if (dataStr == null || dataStr.length() == 0)
            return new ArrayList();
        ArrayList al = new ArrayList();
        StringTokenizer st = new StringTokenizer(dataStr.trim(), sep);
        for (int i=0; st.hasMoreTokens(); i++) {
            int tm = 0;
            try {
                tm = Integer.parseInt(st.nextToken().trim());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            al.add(new Integer(tm));
        }
        
        return  al;
    }

    /**
     * Convert string with separator "," to integer array
     */
    public static int[] convertStringToIntArray(String dataStr)
    {
        return convertStringToIntArray(dataStr, ",");
    }

    public static List convertStringToIntArrayList(String dataStr) {
        return convertStringToIntArrayList(dataStr, ",");
    }
}
