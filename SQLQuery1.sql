20110831056 
------------------------------------
W20110125024


select step1,worker,costs,checker1,* from Northwest_BillSchedule where billDetail like'%20110831056%'
and step1=1

update Northwest_BillSchedule set step1=0,worker=null,costs=null,checker1=null,check1=null
where billDetail like'%20110831056%'

select * from Northwest_BillDetail where billNo='20110831056'
order by id asc

select 
id=tbl1.billno,
bill=tbl1.billno,
tbl1.c,
step1=cast when tbl2.step1=tbl1.c then 1 else 0 end

from 
(select d.billNo,count(*) c from 
dbo.Northwest_BillSchedule s,dbo.Northwest_BillDetail d
where s.id=d.id  
and d.billNo='20110831056'
group by d.billNo) tbl1
left outer join 
(select d.billno,step1=sum(step1),step2=sum(step2),step3=sum(step3),step4=sum(step4),step5=sum(step5),step6=sum(step6),step7=sum(step7),step8=sum(step8),step9=sum(step9),step10=sum(step10),step11=sum(step11),step12=sum(step12) from 
dbo.Northwest_BillSchedule s,dbo.Northwest_BillDetail d
where s.id=d.id  
and d.billNo='20110831056'
group by d.billno
) tbl2 on tbl1.billno=tbl2.billno

select * from Northwest_ProcessState

processStateList
----------------------------------------------------

select worker,* from Northwest_BillSchedule

JOE;HAMMA

SELECT     tbl1.BillNO AS id, tbl1.BillNO AS bill, CASE WHEN tbl2.step1 = tbl1.c THEN 1 ELSE 0 END AS step1, 
                      CASE WHEN tbl2.step2 = tbl1.c THEN 1 ELSE 0 END AS step2, CASE WHEN tbl2.step3 = tbl1.c THEN 1 ELSE 0 END AS step3, 
                      CASE WHEN tbl2.step4 = tbl1.c THEN 1 ELSE 0 END AS step4, CASE WHEN tbl2.step5 = tbl1.c THEN 1 ELSE 0 END AS step5, 
                      CASE WHEN tbl2.step6 = tbl1.c THEN 1 ELSE 0 END AS step6, CASE WHEN tbl2.step7 = tbl1.c THEN 1 ELSE 0 END AS step7, 
                      CASE WHEN tbl2.step8 = tbl1.c THEN 1 ELSE 0 END AS step8, CASE WHEN tbl2.step9 = tbl1.c THEN 1 ELSE 0 END AS step9, 
                      CASE WHEN tbl2.step10 = tbl1.c THEN 1 ELSE 0 END AS step10, CASE WHEN tbl2.step11 = tbl1.c THEN 1 ELSE 0 END AS step11, 
                      CASE WHEN tbl2.step12 = tbl1.c THEN 1 ELSE 0 END AS step12
FROM         (SELECT     d.BillNO, COUNT(*) AS c
                       FROM          dbo.Northwest_BillSchedule AS s INNER JOIN
                                              dbo.Northwest_BillDetail AS d ON s.id = d.ID INNER JOIN
                                              dbo.Northwest_BillAuthority AS a ON d.BillNO = a.billID
                       GROUP BY d.BillNO) AS tbl1 LEFT OUTER JOIN
                          (SELECT     d.BillNO, SUM(s.step1) AS step1, SUM(s.step2) AS step2, SUM(s.step3) AS step3, SUM(s.step4) AS step4, SUM(s.step5) AS step5, 
                                                   SUM(s.step6) AS step6, SUM(s.step7) AS step7, SUM(s.step8) AS step8, SUM(s.step9) AS step9, SUM(s.step10) AS step10, SUM(s.step11) 
                                                   AS step11, SUM(s.step12) AS step12
                            FROM          dbo.Northwest_BillSchedule AS s INNER JOIN
                                                   dbo.Northwest_BillDetail AS d ON s.id = d.ID
                            GROUP BY d.BillNO) AS tbl2 ON tbl1.BillNO = tbl2.BillNO




select * from com_group



SELECT     BillNO, CProjectName, CustomerID, Remark
FROM         CHIComp99.dbo.ordBillMain
WHERE     (Flag = 2)