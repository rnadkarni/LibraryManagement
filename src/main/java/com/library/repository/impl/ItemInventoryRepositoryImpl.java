package com.library.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.model.Item;
import com.library.model.ItemInventory;
import com.library.repository.ItemInventoryRepository;
import com.library.repository.ItemRepository;

@Repository
public class ItemInventoryRepositoryImpl implements ItemInventoryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ItemRepository itemRepo;
	
	

	@Override
	public void addIteminIventory(Item item) {
		Integer itemId = itemRepo.findItemByNameandType(item.getItemName(), item.getItemType().toUpperCase());
		String insertQuery = "insert into item_inventory values(?,?)";
		Object [] property = {null,itemId};
		try {
			jdbcTemplate.update(insertQuery, property);
		}catch (Exception e) {
			//LOG IT USING LOGGER
		}

	}
	
	
	public ItemInventory availableItem(Item item) {
        String sql = "select * " +
                " from item_inventory ti " +
                " inner join item t on (t.itemId = ti.itemId)" +
                " inner join item_type tt on (tt.itemtypeId = t.itemTypeId)" +
                " left outer join loan l on (l.iteminvId = ti.iteminvId)" +
                " where " +
                " COALESCE(l.loanReturnId,1)!=0" +
                " and t.itemName = ?" +
                " and tt.itemTypeName = ?";
        try {
        	 return jdbcTemplate.query(sql,createRowMapper(),
                     new Object[]{item.getItemName(), item.getItemType().toUpperCase()}
                     ).get(0);
        }catch (Exception ignore){

        }
        return null;
    }
	
	private RowMapper<ItemInventory> createRowMapper(){
		return new RowMapper<ItemInventory>() {

			@Override
			public ItemInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new ItemInventory(
						rs.getInt("iteminvId"), 
						rs.getInt("itemId"),
						rs.getString("itemName"),
						rs.getString("itemTypeName"));
			}
		};
	}
	
	public ItemInventory getInventoryItem(Integer id) {
        String sql = "select * " +
                " from item_inventory ti " +
                " inner join item t on (t.itemId = ti.itemId)" +
                " inner join item_type tt on (tt.itemtypeId = t.itemTypeId)" +
                " where " +
                " ti.iteminvId = ?";
        try {
        	 return jdbcTemplate.query(sql,createRowMapper(),
                     new Object[]{id}
                     ).get(0);
        }catch (Exception ignore){

        }
        return null;
    }
	
	
	 public List<Item> findAvailable() {
	        String sql = "select * from v_inventory";
	        try {
	            return jdbcTemplate.query(sql, new Object[]{},
	                    new InventoryMapper());
	        }catch (Exception ignore){
	        }
	        return Collections.emptyList();
	    }

	    private final class InventoryMapper implements RowMapper {
	        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	            return  new Item(rs.getString("itemName"), rs.getString("itemTypeName"),rs.getInt("num_items"));
	        }
	    }

}
