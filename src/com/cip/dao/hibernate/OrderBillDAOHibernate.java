package com.cip.dao.hibernate;

import com.base.util.Tools;
import com.cip.value.*;
import com.cip.dao.OrderBillDAO;

import java.sql.*;
import java.util.*;

import com.common.dao.hibernate.*;

import northwest.common.dao.hibernate.*;
import northwest.common.value.Bill;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrderBillDAOHibernate extends BillDAOHibernate implements OrderBillDAO
{

    public OrderBillDAOHibernate()
    {
    }

    public void saveOrderBill(OrderBill val)
    {
        getHibernateTemplate().saveOrUpdate(val);
        try{
            Connection conn = getHibernateSession().connection();
	    Statement Stmt = conn.createStatement();
	    String today=Tools.todayString();
	    String sql = " dbo.syncOrderBill "+val.getId();
	    Stmt.executeQuery(sql);	  
	    Stmt.close();
	    conn.close();
        }catch(Exception e){
            System.out.println("sync SQL dbo.syncOrderBill error="+e.toString());
        }
        
    }

    public void removeOrderBill(OrderBill val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeOrderBill(Long id)
    {
        OrderBill obj = findOrderBillById(id);
        getHibernateTemplate().delete(obj);
    }

    public OrderBill findOrderBillById(Long id)
    {
	if (id == null)
            return null;
        OrderBill obj = (OrderBill)getHibernateTemplate().get(OrderBill.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(OrderBill.class, id);
        else
            return obj;
    }

    public List<OrderBill> findAllOrderBill()
    {
        return getHibernateTemplate().find("from OrderBill");
    }
    public List<Project> findProjectList()
    {
        return new ArrayList<Project>(); // TODO
    }

    //Project
    public void saveProject(Project val)
    {       
        getHibernateTemplate().saveOrUpdate(getHibernateTemplate().merge(val));
    }

    public void removeProject(Project val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeProject(String id)
    {
        Project obj = findProjectById(id);
        getHibernateTemplate().delete(obj);
    }

    public Project findProjectById(String id)
    {
	Project obj = null;
	try {	    
	    Criteria c = getHibernateSession().createCriteria(Project.class);
	    c.add(Expression.eq("id", id));
	    List result = c.list();
	    if (result.size() > 0)
		obj = (Project) result.get(0);
	} catch (Exception ex) {
	    System.out.println(ex.toString());
	}
	return obj;    
    }

    public List<Project> findAllProject()
    {
        return getHibernateTemplate().find("from Project");
    }
    
    //OrdBillSub
    public OrdBillSub findOrdBillSubById(Long id)
    {
	if (id == null)
            return null;
	OrdBillSub obj = (OrdBillSub)getHibernateTemplate().get(OrdBillSub.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(OrdBillSub.class, id);
        else
            return obj;
    }   
    
    
    public List<OrdBillSub> findAllOrdBillSub(OrderBill orderBill)
    {
	if(orderBill.getId()==null){
	    List<OrdBillSub> ls= new ArrayList<OrdBillSub>();
	    return ls;
	}else{
	    Criteria c = getHibernateSession().createCriteria(OrdBillSub.class);
	    c.add(Expression.eq("orderBill", orderBill));
	    c.addOrder(Order.asc("rowNO"));
	    return c.list();
	}
    }
    
    public void saveOrdBillSub(OrdBillSub val)
    {
	getHibernateTemplate().saveOrUpdate(val);
	
	try{
            Connection conn = getHibernateSession().connection();
	    Statement Stmt = conn.createStatement();
	    String today=Tools.todayString();
	    String sql = " dbo.syncOrderBill "+val.getOrderBill().getId();
	    Stmt.executeQuery(sql);	  
	    Stmt.close();
	    conn.close();
        }catch(Exception e){
            System.out.println("sync SQL dbo.syncOrderBill error="+e.toString());
        }
    }
    
    public OrdBillSub getOrdBillSub(int flag,OrderBill orderBill,int rowNo)
    {
	OrdBillSub obj = null;
	try {	    
	    Criteria c = getHibernateSession().createCriteria(OrdBillSub.class);
	    c.add(Expression.eq("flag", flag));
	    c.add(Expression.eq("billNo", orderBill));
	    c.add(Expression.eq("rowNo", rowNo));	    
	    List result = c.list();
	    if (result.size() > 0)
		obj = (OrdBillSub) result.get(0);
	} catch (Exception ex) {
	    System.out.println(ex.toString());
	}
	return obj;  
    }
    
    public void removeOrdBillSub(Long id)
    {
	OrdBillSub obj = findOrdBillSubById(id);
        getHibernateTemplate().delete(obj);
    }
    
    public String orderBillCurrentProjectNo()
    {
	String projectNo="";
	try{
	    Connection conn = getHibernateSession().connection();
	    Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    String today=Tools.todayString();
	    String sql = " Select projectNo=Max(A.BillNO) From CHIComp02.dbo.OrdBillMain A Where A.Flag=2 And A.BillNO like '"+today+"___' ";
	    //System.out.println(sql);
	    ResultSet rs = Stmt.executeQuery(sql);	    
	    if (rs.last()) {
		projectNo=rs.getString("projectNo");
	    }
	    rs.close();
	    conn.close();
	    
	    if(projectNo==null){		
		projectNo=today+"001";
	    }else{
		projectNo=String.valueOf(Integer.parseInt(projectNo)+1);
	    }	    
	    System.out.println("projectNo="+projectNo);	    
	    
	}catch(Exception e){
	    System.out.println("orderBillCurrentProjectNo() error="+e.toString());
	}
	return projectNo;
    }
    
    public int ordBillSubRowNo(OrderBill orderBill)
    {
	 int rowNO=1;	 
	   Criteria c = getHibernateSession().createCriteria(OrdBillSub.class);
	   c.add(Expression.eq("orderBill", orderBill));
	   c.addOrder(Order.desc("rowNO"));
	   List ls=c.list();
	    if(ls.size()>0){	     
	      OrdBillSub a=(OrdBillSub)ls.get(0);
	      rowNO=a.getRowNO()+1;
	    }	 
	 System.out.println("hiber ordBillSubRowNo="+rowNO);
	 return rowNO;	    
    }

}

