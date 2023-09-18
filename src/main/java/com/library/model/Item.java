package com.library.model;

public class Item {
	
	private Integer itemId;
	private String itemType;
	private String itemName;
	private Integer itemCount;
	
	public Item(Integer itemId, String itemName,String itemType) {
		this.itemId=itemId;
		this.itemName = itemName;
		this.itemType = itemType;
	}
	
	public Item(String itemName,String itemType) {
		this.itemId=-1;
		this.itemName = itemName;
		this.itemType = itemType;
	}
	
	public Item(String itemName,String itemType,Integer itemCount) {
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemCount = itemCount;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item)o;
		if (itemId != item.itemId) return false;
		if (itemType != null ? !itemType.equals(item.itemType) : item.itemType != null) return false;
			return !(itemName != null ? !itemName.equals(item.itemName) : item.itemName != null);
	}
	
    @Override
    public int hashCode() {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item {" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemCount='" + itemCount + '\'' +
                '}';
    }

}
