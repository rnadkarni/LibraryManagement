package com.library.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.model.LoanReturnDetails;
import com.library.repository.LoanReturnRepository;

@Repository
public class LoanReturnRepositoryImpl implements LoanReturnRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void save(LoanReturnDetails entity) {
		try {
			 jdbcTemplate.update(
	                    "insert into loan_return (loanreturnId, loanId) values( ?, ?)"
	                    ,null
	                    ,entity.getLoanId());
		}catch (Exception e) {
			System.out.println("Exception is "+e.toString());
		}
		
	}
	
	
	public LoanReturnDetails findById(Integer loanId) {
		try {
			Object [] property = {loanId};
	        return jdbcTemplate.query("select * from loan_return where loanId = ? ",createRowMapper(), property).get(0);
	        		
	    }catch (Exception ignore){
	    	//use logger
	    }
			return null;
		}


	public  RowMapper<LoanReturnDetails> createRowMapper() {
	    return new RowMapper<LoanReturnDetails>() {
	        @Override
	        public LoanReturnDetails mapRow(ResultSet rs, int i) throws SQLException {
	            return new LoanReturnDetails(rs.getInt("loanreturnId"),rs.getInt("loanId"));
	        }
	    };
	}

	

}
