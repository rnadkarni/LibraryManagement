package com.library.repository;

import java.util.List;

import com.library.model.LoanDetails;

public interface LoanRepository {
	 public void save(LoanDetails entity);
	 public List<LoanDetails> findOverDue();
	 public LoanDetails findByInvId(Integer invId);
}
