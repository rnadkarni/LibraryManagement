package com.library.model;

public class LoanReturnDetails {
		private Integer loanreturnId;
		private Integer loanId;
		
		public LoanReturnDetails() {
			
		}
		
		public LoanReturnDetails(Integer loanReturnId,Integer loanId) {
			this.loanreturnId = loanReturnId;
			this.loanId = loanId;
		}
		
		public Integer getLoanreturnId() {
			return loanreturnId;
		}
		public void setLoanreturnId(Integer loanreturnId) {
			this.loanreturnId = loanreturnId;
		}
		public Integer getLoanId() {
			return loanId;
		}
		public void setLoanId(Integer loanId) {
			this.loanId = loanId;
		}
		
		
}
