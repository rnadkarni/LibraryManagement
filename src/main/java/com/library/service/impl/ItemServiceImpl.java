package com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Item;
import com.library.repository.ItemInventoryRepository;
import com.library.repository.ItemRepository;
import com.library.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private ItemInventoryRepository itemInvRepo;

	@Override
	public void addItem(String itemName,String itemType) {
		Item item = new Item(itemName,itemType);
		itemRepo.addItem(item);
		itemInvRepo.addIteminIventory(item);
	}
	
	

}
