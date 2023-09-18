package com.library.repository;

import com.library.model.Item;

public interface ItemRepository {
	
	public void addItem(Item item);
	public Integer findItemByNameandType(String name, String type);
}
