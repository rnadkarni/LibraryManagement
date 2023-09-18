package com.library.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.model.ItemType;
import com.library.repository.ItemTypeRepository;

@Repository
public class ItemTypeRepositoryImpl implements ItemTypeRepository {
		
	@Autowired
		private JdbcTemplate jdbcTemplate;

		public Integer findItemTypeId(String type) {
	        String sql = "select itemtypeId from item_type where itemTypeName = ?";
	        try {
	            Integer id = jdbcTemplate.queryForObject(sql,
	                    new Object[]{type.toUpperCase()},
	                    Integer.class);
	            return id;
	        }catch (Exception ignore){
	        		//LOG IT USING LOGGER
	        }
	        return null;
	    }

		@Override
		public void addItemType(ItemType itemType) {
			String insertQuery = "insert into item_type values(?,?)";
			Object [] property = {null,itemType.getItemTypeName().toUpperCase()};
			try {
				jdbcTemplate.update(insertQuery, property);
			}catch (Exception e) {
				//LOG IT USING LOGGER
			}
		}
}
