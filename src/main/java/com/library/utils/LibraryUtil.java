package com.library.utils;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Borrower;
import com.library.model.Item;
import com.library.model.ItemInventory;
import com.library.model.LoanDetails;
import com.library.model.LoanReturnDetails;
import com.library.repository.BorrowerRepository;
import com.library.repository.ItemInventoryRepository;
import com.library.repository.LoanRepository;
import com.library.repository.LoanReturnRepository;

@Service
public class LibraryUtil {
	
	@Autowired
	BorrowerRepository borrowerRepo;
	
	@Autowired
	ItemInventoryRepository invRepo;
	
	@Autowired
	LoanRepository loanRepo ;
	
	@Autowired
	LoanReturnRepository loanReturnRepo ;
	
	public void registerBorrower(String name) {
		borrowerRepo.add(name);
	}
	
	 public void lend(Borrower borrower, Item item) {
	        int borrowerDate = (int) LocalDate.now().toEpochDay();
	        int dueDate = (int) LocalDate.now().plusDays(7).toEpochDay();
	        LoanDetails loan = new LoanDetails(null, borrower.getBorrowerId(), invRepo.availableItem(item).getItemInventoryId(), borrowerDate, dueDate, 0);
	        loanRepo.save(loan);
	    }
	 
	 public List<LoanDetails> findOverDueLoans(){
		 return loanRepo.findOverDue();
	 }
	 
	 public List<Item> findAvailable(){
		 return invRepo.findAvailable();
	 }
	 
	 public ItemInventory availableItem(Item item) {
		 return invRepo.availableItem(item);
	 }
	 
	 public void returnItem(Integer itemInvId) {
		 LoanDetails loan = loanRepo.findByInvId(itemInvId);
	     LoanReturnDetails loanReturn = new LoanReturnDetails();
	     loanReturn.setLoanId(loan.getLoanId());
	     loanReturnRepo.save(loanReturn);
	     LoanReturnDetails savedReturn = loanReturnRepo.findById(loan.getLoanId()); 
	     loan.setLoanReturnId(savedReturn.getLoanreturnId());
	     loanRepo.save(loan);
	 }

}
