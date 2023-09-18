package com.library.repository;

import com.library.model.ItemType;

public interface ItemTypeRepository {
	public Integer findItemTypeId(String type);
	public void addItemType(ItemType itemType);
}
