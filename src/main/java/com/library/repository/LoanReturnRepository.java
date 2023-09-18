package com.library.repository;

import com.library.model.LoanReturnDetails;

public interface LoanReturnRepository {
	 public void save(LoanReturnDetails entity);
	 public LoanReturnDetails findById(Integer loanId);
}
