create view v_inventory as
select
  t.itemName
 ,tt.itemTypeName
 ,count(*) num_items
from
 item t
 inner join item_type tt on(t.itemTypeId = tt.itemtypeId)
 inner join item_inventory ti on(t.itemId = ti.itemId)
 left outer join loan l on(l.iteminvId = ti.iteminvId)
where
 COALESCE(l.loanReturnId,1)!=0
group by
 t.itemName
 ,tt.itemTypeName
;