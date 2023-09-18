package com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.ItemType;
import com.library.repository.ItemTypeRepository;
import com.library.service.ItemTypeService;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {
	
	@Autowired
	ItemTypeRepository itemTypeRepo;

	@Override
	public void addItemType(String itemTypeName) {
		ItemType itemType = new ItemType(-1, itemTypeName);
		itemTypeRepo.addItemType(itemType);
	}

}
