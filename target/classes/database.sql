create database libraryStore;

Item Type Table
----------------------------------

create table item_type(
  itemtypeId int UNSIGNED not null AUTO_INCREMENT
 ,itemTypeName varchar(255) not null 
 ,primary key(itemtypeId)
);
create index idx_ti_item on item_type(itemtypeId);


Item Table
-------------------------------
create table item(
  itemId int UNSIGNED not null AUTO_INCREMENT
 ,primary key(itemId)
 ,itemTypeId int not null
 ,itemName varchar(255) not null
 
);
create unique index idx_t_pk on item(itemTypeId, itemName);
create index idx_t_type on item(itemTypeId);
create index idx_t_name on item(itemName);
----------------------------------------------
Item Transact Table
---------------------------------------------
create table item_inventory(
  iteminvId int UNSIGNED not null AUTO_INCREMENT
 ,itemId int not null
 ,primary key(iteminvId)
);
create index idx_ti_inv on item_inventory(itemId);
-------------------------------------------------------------
Borrower 
-------------------------------------------------
create table borrower(
  borrowerId int UNSIGNED not null AUTO_INCREMENT
 ,borrowerName varchar(150) not null
 ,primary key(borrowerId)
);
create unique index idx_b_name on borrower(borrowerName);
--------------------------------------------------------------
Loan Table
--------------------------------------------------------------
create table loan(
  loanId int UNSIGNED not null AUTO_INCREMENT
 ,iteminvId int not null
 ,borrowerId int not null
 ,borrowedDate int not null
 ,dueDate int not null
 ,loanReturnId int 
 ,primary key(loanId)
);
create index idx_l_who on loan(borrowerId);
create index idx_l_taken on loan(borrowedDate);
create index idx_l_due on loan(dueDate);
create index idx_l_returned on loan(loanReturnId);
---------------------------------------------------------------------
Loan Return Table
---------------------------------------------------------------
create table loan_return(
  loanreturnId int UNSIGNED not null AUTO_INCREMENT
 ,loanId int not null
 ,primary key(loanReturnId)
);
create unique index idx_lr_pk on loan_return(loanReturnId,loanId);
create index idx_lr_loan on loan_return(loanId);