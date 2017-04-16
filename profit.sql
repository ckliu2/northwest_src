SELECT * FROM (
SELECT 
buyNo=isnull(p.採購單號,''),
P.項次,
P.RowNo
FROM 
Northwest_Sales s LEFT OUTER JOIN
(
SELECT m.*,d.產品編號,d.採購金額,d.採購細項,d.採購分錄,d.項次,d.RowNo FROM Northwest_PurchaseMaster m,Northwest_PurchaseDetail d
WHERE m.採購單號=d.採購單號 
)p ON s.專案編號=p.專案編號 AND s.RowNO=p.RowNo
WHERE s.專案編號='20120101003'
)A WHERE buyNo <>''
ORDER BY buyNo,RowNo

SELECT 項次,RowNO,產品編號 FROM Northwest_Sales 
WHERE 專案編號='20120101003'
 
 
SELECT   
s.SerNO,s.RowNO,ProdID
FROM         CHIComp01.dbo.ordBillSub AS s INNER JOIN
                      dbo.Northwest_Bill AS b ON s.BillNO = b.BillNO
WHERE     (s.Flag = 2)
and s.BillNO='20120101002'
order BY s.SerNO asc 