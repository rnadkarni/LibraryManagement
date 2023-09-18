package com.library.model;

public class ItemType {
	
	private Integer itemtypeId;
	private String itemTypeName;
	
	public ItemType(Integer itemTypeId,String itemTypeName) {
		this.itemtypeId = itemTypeId;
		this.itemTypeName = itemTypeName;
	}
	
	public Integer getItemtypeId() {
		return itemtypeId;
	}
	public void setItemtypeId(Integer itemtypeId) {
		this.itemtypeId = itemtypeId;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	
	

}
