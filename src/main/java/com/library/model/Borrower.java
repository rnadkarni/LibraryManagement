package com.library.model;

public class Borrower {
		private Integer borrowerId;
		private String borrowerName;
		
		public Borrower(Integer id,String name) {
			this.borrowerId = id;
			this.borrowerName = name;
		}
		
		public Integer getBorrowerId() {
			return borrowerId;
		}
		public void setBorrowerId(Integer borrowerId) {
			this.borrowerId = borrowerId;
		}
		public String getBorrowerName() {
			return borrowerName;
		}
		public void setBorrowerName(String borrowerName) {
			this.borrowerName = borrowerName;
		}
		
		
		
}
