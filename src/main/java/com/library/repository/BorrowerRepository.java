package com.library.repository;

import com.library.model.Borrower;

public interface BorrowerRepository {
	public void add(String name);
	public Borrower findById(Integer id);
}
