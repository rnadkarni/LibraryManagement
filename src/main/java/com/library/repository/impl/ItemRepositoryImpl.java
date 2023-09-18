package com.library.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.model.Item;
import com.library.repository.ItemRepository;
import com.library.repository.ItemTypeRepository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
	
	@Autowired
	ItemTypeRepository itemTypeRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addItem(Item item) {
		//Check if exists 
		Integer itemId =  findItemByNameandType(item.getItemName(), item.getItemType().toUpperCase());
		if( itemId == null) {
			Integer itemTypeID =  itemTypeRepository.findItemTypeId(item.getItemType());
			String insertQuery = "insert into item values(?,?,?)";
			Object [] property = {null,itemTypeID,item.getItemName()};
			jdbcTemplate.update(insertQuery, property);
		}
	}

	
	
	public Integer findItemByNameandType(String name, String type) {
        String sql = "select itemId" +
                " from item where itemName = ? " +
                " and itemTypeId = (" +
                "  select itemtypeId from item_type where itemTypeName = ?" +
                ")";
        try {
            Integer id = jdbcTemplate.queryForObject(sql,
                    new Object[]{name, type.toUpperCase()},
                    Integer.class);
            return id;
        }catch (Exception ignore){

        }
        return null;
    }

//	public Item findById(Long id) {
//		try {
//			Object [] property = {id.intValue()};
//            return jdbcTemplate.queryForObject("select * from item where itemId = ? ", property,Item.class)
//            		jdbcTemplate.query(null, property, null)
//        }catch (Exception ignore){
//
//        }
//		return null;
//	}
	
	
//	public  RowMapper<Item> createRowMapper() {
//        return new RowMapper<Item>() {
//            @Override
//            public Item mapRow(ResultSet rs, int i) throws SQLException {
//                return new Item(
//                         rs.getInt("itemId")
//                        ,itemTypeRepository.findById(rs.getLong("title_id"))
//                );
//            }
//        };
//    }
	
	
	
}
