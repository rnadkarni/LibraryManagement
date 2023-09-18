package com.library.model;

public class ItemInventory {
		private Integer itemInventoryId;
		private Integer itemId;
		
		private String itemName;
		private String itemTypeName;
		
		public ItemInventory() {
			
		}
		public ItemInventory(Integer itemInventoryId,Integer itemId,String itemName,String itemTypeName) {
			this.itemId=itemId;
			this.itemInventoryId = itemInventoryId;
			this.itemName = itemName;
			this.itemTypeName = itemTypeName;
		}
		
		public Integer getItemInventoryId() {
			return itemInventoryId;
		}
		public void setItemInventoryId(Integer itemInventoryId) {
			this.itemInventoryId = itemInventoryId;
		}
		public Integer getItemId() {
			return itemId;
		}
		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemTypeName() {
			return itemTypeName;
		}
		public void setItemTypeName(String itemTypeName) {
			this.itemTypeName = itemTypeName;
		}
		
		
}
