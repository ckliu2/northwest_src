---美工.輸出.後製.包裝
--Step6,7,8,9,10
/*
step1. Northwest_BillAuthority  groupId=15,12,14
step2. dbo.InitialBillSchedule @billNo
*/
select  Remark,* from Northwest_Bill where BillDate='20111004'
--20111004003

dbo.AutoWorkFlow

SELECT * FROM AutoClosePrj where billNo='20111006005'

INSERT INTO AutoClosePrj(billNo)VALUES()

DELETE AutoClosePrj

select DISTINCT BillDate from Northwest_Bill ORDER BY BillDate DESC

dbo.AutoWorkFlow

SELECT * FROM Northwest_BillFinish

dbo.InitialBillSchedule '20111004003'

@item=17
@step6=9

SELECT count(*) FROM Northwest_BillDetail d,Northwest_BillSchedule s
   WHERE d.ID=s.id AND d.BillNO='20111004003'
   
SELECT * FROM Northwest_BillDetail d,Northwest_Product p,Northwest_ProductClass c
WHERE 
d.ProdID=p.ProdID AND p.ClassID=c.ClassID
AND BillNO='20111004003' AND c.ClassID NOT IN
(
  SELECT productId FROM Northwest_ExpectionFlows WHERE groupId=11  
)

 

  

SELECT * FROM Northwest_ExpectionFlows
SELECT * FROM COM_Group

SELECT * FROM Northwest_Product where ProdID='ACCB-BAA'


02	數位輸出類

SELECT * FROM Northwest_ProductClass where ClassID='02'

SELECT * FROM Northwest_BillDetail d,Northwest_BillSchedule s
   WHERE d.ID=s.id AND d.BillNO='20111006005'
   
   
SELECT * FROM Northwest_BillFinish

CREATE PROCEDURE [dbo].[ResetAutoClosed]
@BillNo varchar(20)
AS

dbo.AutoClosed
SELECT * FROM Northwest_BillAuthority
WHERE groupId NOT IN(15,14,12,11) AND billID= '20111006005'
