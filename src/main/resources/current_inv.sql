create view current_inv as
select
  i.itemName
 ,tt.title_type_name
 ,count(*) num_items
 ,count(l.title_item_id) on_loan
from
 item i
 inner join item_type it on(i.itemTypeId = it.title_type_id)
 inner join title_item ti on(t.title_id = ti.title_id)
 left outer join loan l on(l.title_item_id = ti.title_item_id)
where
 nvl(l.loan_return_id,1) != 0
group by
 t.title_name
 ,tt.title_type_name
--having count(*) > count(l.title_item_id)
;