package com.library.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.model.Borrower;
import com.library.model.LoanDetails;
import com.library.repository.BorrowerRepository;

@Repository
public class BorrowerRepositoryImpl implements BorrowerRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(String name) {
		String insertQuery = "insert into borrower values(?,?)";
		Object [] property = {null,name};
		try {
			jdbcTemplate.update(insertQuery, property);
		}catch (Exception e) {
			//LOG IT USING LOGGER
		}

	}
	
	  protected RowMapper<Borrower> createRowMapper() {
	        return new RowMapper<Borrower>() {
				@Override
				public Borrower mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					return new Borrower(
							rs.getInt("borrowerId"),
							rs.getString("borrowerName"));
				}
	        };
	    }
	
	public Borrower findById(Integer id) {
	try {
		Object [] property = {id};
        return jdbcTemplate.query("select * from borrower where borrowerId = ? ", createRowMapper(),property).get(0);
    }catch (Exception ignore){
    	//LOG IT USING LOGGER
    }
	return null;
}

}
