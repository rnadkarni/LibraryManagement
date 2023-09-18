package com.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.library.model.Borrower;
import com.library.model.Item;
import com.library.model.ItemInventory;
import com.library.model.LoanDetails;
import com.library.utils.InventoryUtil;
import com.library.utils.LibraryUtil;

@SpringBootApplication
public class LibraryManagement implements CommandLineRunner {
	
	@Autowired
	InventoryUtil inventoryUtil;
	
	@Autowired
	LibraryUtil libUtil;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagement.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Register type of items
		inventoryUtil.registerInitialItemTypes();
		
		//Register Items
		inventoryUtil.registerInitialItems();
		
		//Register Borrowers
		libUtil.registerBorrower("Rahul");
		
		//Lend the items to borrower
	  libUtil.lend(new Borrower(1,"Rahul"), new Item(3, "The Art of Programming", "Book"));
		
		//find overDue items
		List<LoanDetails> loanDetails =  libUtil.findOverDueLoans();
		loanDetails.stream().forEach(each -> System.out.println(each));
		
	//	find current Inventory
	  System.out.println("Inventory after lending the item");
		List<Item> items =  libUtil.findAvailable();
		items.stream().forEach(each -> System.out.println(each));
		
		//find it item is available
		ItemInventory itemInv = libUtil.availableItem(new Item(1, "Pi", "DVD"));
		if(itemInv!=null) {
			System.out.println("Item is available");
		}else {
			System.out.println("Item is available , please select some other item");
		}
		
		//return the item
		libUtil.returnItem(3);
		
		System.out.println("Inventory after returning  the item");
//		Inventory after returning the items
		List<Item> afterRetunInv =  libUtil.findAvailable();
		afterRetunInv.stream().forEach(each -> System.out.println(each));
		
	}

	

}
