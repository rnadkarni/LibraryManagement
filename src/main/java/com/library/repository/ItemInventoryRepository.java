package com.library.repository;

import java.util.List;

import com.library.model.Item;
import com.library.model.ItemInventory;

public interface ItemInventoryRepository {
	public void addIteminIventory(Item item);
	public ItemInventory availableItem(Item item);
	public ItemInventory getInventoryItem(Integer id);
	public List<Item> findAvailable();
}
