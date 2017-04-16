package com.common.web.action;

import java.text.DateFormat;
import java.util.*;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.Group;

import com.base.value.*;
import com.base.value.SessionUser;
import com.base.web.action.BaseActionSupport;
import com.common.service.CommonManager;
import com.common.value.CheckingState;
import com.common.value.Member;
import com.common.value.Unit;
import com.tep.survey.value.Option;
import com.tep.survey.value.Question;




public abstract class CommonActionSupport extends BaseActionSupport
{
    private String whichAction;
    private String submitChecking;

    public SessionUser copyToSessionUser(Member user)
    {
        SessionUser su = new SessionUser();
        su.setId(user.getId());
        su.setLoginId(user.getId());        
        su.setName(user.getName());
        //su.setEnabled(user.getEnabled()); 
        su.setRole(user.getGroups());
        su.setIp(getClientIP());
        su.setMember(user);   

        MenuService ms = new MenuService(getContextRootPath());
        su.setMenuStr(ms.renderMenu(getGenericManager().findFunctionListBySessionUser(su), su)); 
        //System.out.println("===========>" + su.getMenuStr());
        return su;
    }
    
    public String getWhichAction()
    {
        return whichAction;
    }

    public String getStateLabel(String state)
    {
        return CheckingState.getStateLabel(state);
    }
    
    public String toAccessName(String s)
    {
        if (s != null)
            return Tools.firstCharToUpperCase(toObjectName(s));
        
        return s;
    }

    public String toLowerCase(String s)
    {
        if (s != null)
            return s.toLowerCase();
        
        return s;
    }

    public String toObjectName(String s)
    {
        StringTokenizer st = new StringTokenizer(s, "_");
        int i = 0;
        String tmp = "";
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if (i == 0) {
                tmp = str.toLowerCase();
            } else {
                tmp = tmp + Tools.firstCharToUpperCase(str.toLowerCase());
            }
            i++;
        }
        
        return tmp;
    }


    /**
     * 
     * @param orginIds original ID array 
     * @param inserted inserted ID Array
     * @param deleted deleted ID Array
     * @return
     */
    public static Long[] filterIdArray(Long[] orginIds, Long[] inserted, Long[] deleted)
    {
        java.util.LinkedHashSet hs = new java.util.LinkedHashSet();
        for (int i=0; orginIds != null && i < orginIds.length; i++) {
            hs.add(orginIds[i]);
        }

        for (int i=0; inserted != null && i < inserted.length; i++) {
            hs.add(inserted[i]);
        }

        for (int i=0; deleted != null && i < deleted.length; i++) {
            hs.remove(deleted[i]);
        }

        Long[] ids = new Long[hs.size()];

        hs.toArray(ids);
        
        //bubbleSort(ids);
        
        return ids;
        
    }
    
    public static void bubbleSort(Long[] x) {
        int n = x.length;
        for (int pass=1; pass < n; pass++) {  // count how many times
            for (int i=0; i < n-pass; i++) {
                if (x[i].longValue() > x[i+1].longValue()) {
                    Long temp = x[i];  x[i] = x[i+1];  x[i+1] = temp;
                }
            }
        }
    }

    
    /**
     * 
     * @param pdIdStr  id string with separator ",", e.g, "1,4,6,2"
     * @return
     */
    public static Long[] parseIdStringToIdArray(String pdIdStr)
    {
        if (pdIdStr == null || pdIdStr.length() == 0)
            return null;
        
        ArrayList<Long> al = new ArrayList<Long>();
        StringTokenizer st = new StringTokenizer(pdIdStr, ",");
        while (st.hasMoreTokens()) {
            Long id = new Long(Long.parseLong(st.nextToken()));
            al.add(id);
        }
        Long[] ret = new Long[al.size()];
        al.toArray(ret);

        return ret;
    }

    public void setWhichAction(String whichAction)
    {
        this.whichAction = whichAction;
    }
   
    public CommonActionSupport()
    {
        super();
    }  
    
    public void setGenericManager(CommonManager m)
    {
        super.setBaseManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager)super.getBaseManager();
    }
    
    public Function getFunction()
    {
        return new Function();
    }
    
    public String getFunctionOpenPeriodMessage()
    {
        Function fun = getFunction();
        if (fun == null || fun.getEditBegin() == null &&  fun.getEditEnd() == null)
            return null; // open period is anytime
        
        String tmp = "";
        if (fun.getEditBegin() != null) {
            tmp = DateFormat.getInstance().format(fun.getEditBegin()) + " ~ ";
        }
        
        if (fun.getEditEnd() != null) {
            tmp = tmp + DateFormat.getInstance().format(fun.getEditEnd());
        }
        
        return tmp;
        
    }
    public boolean getRecordEditable()
    {
        Date now = new Date();
        Function fun = getFunction();
        if (fun == null || (fun.getEditBegin() == null &&   fun.getEditEnd() == null))
            return true;

        if (fun == null || fun.getEditBegin() != null && now.before(fun.getEditBegin()) == true) {
            return false;
        }
        
        if (fun == null || fun.getEditEnd() != null && now.after(fun.getEditEnd()) == true) {
            return false;
        }
        
        return true;
    }
   
    public String getCssFile()
    {
        return getText("common.style.Labor");
    }
        
    public boolean checkGroup(SessionUser su, String groupKey)
    {
        if (su == null || su.getRole() == null || su.getRole().size() == 0) {
            return false;
        }
        
        Set groups=su.getMember().getGroups();
		if(groups!=null){
	   	      Iterator i = groups.iterator(); 
	   	      while (i.hasNext()) {
	   	    	 Group group= (Group) i.next();   
	   	    	 if(groupKey.equals(group.getGroupKey())) {
	                return true;
	             }
	   	      } 
	   	} 

            
        return false;        
    }
    
    public List getAuthorOrderList()
    {
        ArrayList<NameValue> al = new ArrayList<NameValue>();
        NameValue nv = null;
        nv = new NameValue(1, getText("1")); al.add(nv);
        nv = new NameValue(2, getText("2")); al.add(nv);
        nv = new NameValue(3, getText("3")); al.add(nv);
        nv = new NameValue(4, getText("4")); al.add(nv);
        nv = new NameValue(5, getText("5")); al.add(nv);
        nv = new NameValue(6, getText("6")); al.add(nv);
        nv = new NameValue(7, getText("7")); al.add(nv);
        nv = new NameValue(8, getText("8")); al.add(nv);
        nv = new NameValue(9, getText("9")); al.add(nv);
        nv = new NameValue(10, getText("10")); al.add(nv);
        return al;  
    }


    public Long[] getIdsFromGroupList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Group t = (Group) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;       
    }
    
    public Long[] getIdsFromUnitList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
            	Unit t = (Unit) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;       
    }
 
    public List getGroupListByIds(Long[] tlist)
    {
        ArrayList<Group> al = new ArrayList<Group>();
        if (tlist != null) {
            for (int i = 0; i < tlist.length; i++) {
                Group t = (Group) getGenericManager().getGroupById(tlist[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
    
    public List getUnitListByIds(Long[] tlist)
    {
        ArrayList<Unit> al = new ArrayList<Unit>();
        if (tlist != null) {
            for (int i = 0; i < tlist.length; i++) {
            	Unit t = (Unit) getGenericManager().getUnitById(tlist[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }

    public String getSubmitChecking()
    {
        return submitChecking;
    }

    public void setSubmitChecking(String submitChecking)
    {
        this.submitChecking = submitChecking;
    }
    
    
    public List getTextFontList()
    {
        return getAppPropertyList("common.textFont");
    }

    public List removeFromList(List mainLst, List subList)
    {
        if (subList == null || mainLst == null)
            return mainLst;
        
        List al = new ArrayList();
        for (int i=0; i < mainLst.size(); i++) {
            if (! subList.contains(mainLst.get(i))) {
                al.add(mainLst.get(i));
            }
        }
        
        return al;
    }

    public List<NameValue> getOptionTypeList()
    {
        List<NameValue> al = new ArrayList<NameValue>();
        al.add(new NameValue(Option.OPTION_TYPE_USER_INPUT,     getText("option.type.userInput")));
        al.add(new NameValue(Option.OPTION_TYPE_SYS_DEFINED,    getText("option.type.sysDefined")));

        return al;
    }

    public List<NameValue> getQtypeList()
    {
        List<NameValue> al = new ArrayList<NameValue>();
        al.add(new NameValue(Question.QTYPE_SINGLE_CHOICE,      getText("question.qtype.singleChoice")));  //1
        al.add(new NameValue(Question.QTYPE_MULTIPLE_CHOICE,    getText("question.qtype.multipleChoice"))); // 2
        al.add(new NameValue(Question.QTYPE_OPEN_END_NUMERIC,   getText("question.qtype.numericOpenEnd"))); // 11
        al.add(new NameValue(Question.QTYPE_OPEN_END_TEXT,      getText("question.qtype.textOpenEnd")));  //12
        al.add(new NameValue(Question.QTYPE_RATING_SCALE,       getText("question.qtype.ratingScale"))); //21
        al.add(new NameValue(Question.QTYPE_AGGREEMENT_SCALE,   getText("question.qtype.aggreementScale"))); // 22

        return al;
    }

    public List<NameValue> getGradeNumberList()
    {
        List<NameValue> al = new ArrayList<NameValue>();
        al.add(new NameValue(Question.GRADE_NUM_3, getText("question.gradeNum.3grade")));
        al.add(new NameValue(Question.GRADE_NUM_5, getText("question.gradeNum.5grade")));
        al.add(new NameValue(Question.GRADE_NUM_7, getText("question.gradeNum.7grade")));

        return al;
    }

    public List<NameValue> getGradeTypeList()
    {    
        List<NameValue> al = new ArrayList<NameValue>();
        al.add(new NameValue(Question.GRADE_TYPE_IMPORTANCE, getText("question.gradeType.importance")));
        al.add(new NameValue(Question.GRADE_TYPE_SATISFIED, getText("question.gradeType.satisfied")));
        al.add(new NameValue(Question.GRADE_TYPE_AGREEMENT, getText("question.gradeType.agreement")));
        al.add(new NameValue(Question.GRADE_TYPE_GOOD, getText("question.gradeType.good")));
        al.add(new NameValue(Question.GRADE_TYPE_RELATED, getText("question.gradeType.related")));

        return al;        
    }
    
  /**門禁機編號*/
    public List<NameValue> getCardNoList()
    {
        List<NameValue> al = new ArrayList<NameValue>();
         for(int i=1;i<=16;i++){
            al.add(new NameValue(i, getText("cardReader.cardNo")+String.valueOf(i) ) );
         }
        return al;
    }

    protected HashMap prepareGradeTextHashMap()
    {
        HashMap hm = new HashMap();
        
        List<NameValue> al = getGradeNumberList();
        for (int i=0; i < al.size(); i++) {
            NameValue nv = (NameValue) al.get(i);
            for (int j=1; j <= nv.getId(); j++) {
                String kk = "question." + nv.getId() + "g.imp." + j;
                hm.put(kk, getText(kk));
                kk = "question." + nv.getId() + "g.sat." + j;
                hm.put(kk, getText(kk));
                kk = "question." + nv.getId() + "g.agr." + j;
                hm.put(kk, getText(kk));
                kk = "question." + nv.getId() + "g.goo." + j;
                hm.put(kk, getText(kk));
                kk = "question." + nv.getId() + "g.rel." + j;
                hm.put(kk, getText(kk));

            }
        }
        
        return hm;
    }
    public Member getMemberFromSessionUser()
    {
        Member m = null;
        SessionUser su = null;
        try {
            su = getSessionUser();
        } catch (Exception ex) {
            // DO Nothing
        }
        
        if (su != null && su.getId() != null) {
            m = getGenericManager().getMemberById(su.getId());
        }

        
        return m;
    }
    
    public String getChineseWeek(int week){
    	String c="";
    	switch(week){
            case 1: 
    		  c="日";
    	    break;	
            case 2: 
      		  c="一";
      	    break;
            case 3: 
      		  c="二";
      	    break;
            case 4: 
      		  c="三";
      	    break;
            case 5: 
      		  c="四";
      	    break;
            case 6: 
      		  c="五";
      	    break;
            case 7: 
      		  c="六";
      	    break;
    	}
    	//System.out.println("---getChineseWeek---");
    	return c;
    }
    
    public List<NameValue> getWeekList()
    {
        List<NameValue> al = new ArrayList<NameValue>();
        al.add(new NameValue(1,"星期日"));
        al.add(new NameValue(2,"星期一"));
        al.add(new NameValue(3,"星期二"));
        al.add(new NameValue(4,"星期三"));
        al.add(new NameValue(5,"星期四"));
        al.add(new NameValue(6,"星期五"));
        al.add(new NameValue(7,"星期六"));    
        return al;
    }
    
    
    public Group getMemberRole()
    {
    	 Group group=null;
    	 ArrayList <String> groupList = new ArrayList<String>();
		 SessionUser s=(SessionUser)getSession().getAttribute("user");
		 Set roles=s.getRole();
		 if(roles!=null){				 
	   	        Iterator i = roles.iterator(); 
	   	    		 while (i.hasNext()) {		   	    			 
	   	    		    group= (Group) i.next(); 
	   	    			groupList.add(group.getGroupKey());
	   	    		}
		    }		 
		 Collections.sort(groupList);
		 group=getGenericManager().getGroupByGroupKey(groupList.get(0));
   
 
		return group;		
    }
    
    public List getChoice()
    {
        ArrayList<NameValue> al = new ArrayList<NameValue>();
        NameValue nv = null;
        nv = new NameValue(0, "大於等於"); 
        al.add(nv);
        nv = new NameValue(1, "小於等於"); 
        al.add(nv); 
        return al;  
    }
    
    public List<AppProperty> getLogisticsTimeList() {
		return super.getAppPropertyList("logistics.time");
	}

}
