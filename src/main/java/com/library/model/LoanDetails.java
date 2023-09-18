package com.library.model;

public class LoanDetails {
	
	private Integer loanId;
	private Integer borrowerId;
	private Integer itemInv;
	private Integer borroweredDate;
	private Integer dueDate;
	private Integer loanReturnId;
	private Borrower borrower;
	private ItemInventory inventory;
	
	
    public LoanDetails(Integer id, Integer borrowerId, Integer itemInv, int borrowedDate, int dueDate, Integer loanReturnId) {
        this.loanId = id;
        this.borrowerId = borrowerId;
        this.itemInv = itemInv;
        this.borroweredDate = borrowedDate;
        this.dueDate = dueDate;
        this.loanReturnId = loanReturnId;
    }
	
    public LoanDetails(Integer id, Borrower borrower, ItemInventory itemInv, int borrowedDate, int dueDate, Integer loanReturnId) {
        this.loanId = id;
        this.setBorrower(borrower);
        this.setInventory(itemInv);
        this.borroweredDate = borrowedDate;
        this.dueDate = dueDate;
        this.loanReturnId = loanReturnId;
    }
	
    public Integer getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}
	
	
	public Integer getItemInv() {
		return itemInv;
	}

	public void setItemInv(Integer itemInv) {
		this.itemInv = itemInv;
	}

	public Integer getLoanReturnId() {
		return loanReturnId;
	}

	public void setLoanReturnId(Integer loanReturnId) {
		this.loanReturnId = loanReturnId;
	}

	public Integer getBorroweredDate() {
		return borroweredDate;
	}
	public void setBorroweredDate(Integer borroweredDate) {
		this.borroweredDate = borroweredDate;
	}
	public Integer getDueDate() {
		return dueDate;
	}
	public void setDueDate(Integer dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public ItemInventory getInventory() {
		return inventory;
	}

	public void setInventory(ItemInventory inventory) {
		this.inventory = inventory;
	}
	
	public String toString() {
        return "Loan{" +
                "id=" + loanId +
                ", borrower=" + borrower.getBorrowerName() +
                ", item=" +  inventory.getItemName()+
                ", borrowedDate= " + getBorroweredDate() +
                ", dueBack=" + getDueDate()+
                ", loanReturnId=" + loanReturnId +
                '}';
    }
	
	

}
