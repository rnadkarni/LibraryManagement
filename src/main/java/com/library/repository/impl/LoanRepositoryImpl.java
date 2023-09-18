package com.library.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.model.LoanDetails;
import com.library.repository.BorrowerRepository;
import com.library.repository.ItemInventoryRepository;
import com.library.repository.LoanRepository;

@Repository
public class LoanRepositoryImpl implements LoanRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	@Autowired
	private BorrowerRepository borrowerRepo;
	
	@Autowired
	private ItemInventoryRepository itemInvRepo;
	
	@Override
	public void save(LoanDetails entity) {
		try {
		if(entity.getLoanId() == null || entity.getLoanId()<1) {	
			jdbcTemplate.update(
	                "insert into loan (loanId, iteminvId, borrowerId, borrowedDate, dueDate, loanReturnId) values( ?, ?, ?, ?, ?, ?)"
	                ,null
	                ,entity.getItemInv()
	                ,entity.getBorrowerId()
	                ,entity.getBorroweredDate()
	                ,entity.getDueDate()
	                ,0);
			}else {
				jdbcTemplate.update(
	                    "update loan set loanReturnId = ? where loanId = ?"
	                    ,entity.getLoanReturnId()
	                    ,entity.getLoanId())
	            ;
			}
		}catch(Exception e) {
			//log it using logger
		}
	}
	
    protected RowMapper<LoanDetails> createRowMapper() {
        return new RowMapper<LoanDetails>() {
			@Override
			public LoanDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new LoanDetails(
						rs.getInt("loanId"),
						borrowerRepo.findById(rs.getInt("borrowerId")),
						itemInvRepo.getInventoryItem(rs.getInt("iteminvId")), 
						rs.getInt("borrowedDate"), 
						rs.getInt("dueDate"), 
						rs.getInt("loanReturnId"));
			}
        };
    }
    
	 public List<LoanDetails> findOverDue() {
	         int today = (int) LocalDate.now().toEpochDay();
	        String sql = "select * from loan where dueDate < ?";
	        try {
	            return jdbcTemplate.query(sql, new Object[]{today},
	                    createRowMapper());
	        }catch (Exception ignore){

	        }
	        return Collections.emptyList();
	    }
	 
	  public LoanDetails findByInvId(Integer invId) {
	        String sql = "select * from loan where  COALESCE(loanReturnId,0)=0  and iteminvId = ?";
	        try {
	            return jdbcTemplate.query(sql, new Object[]{invId},
	                    createRowMapper()).get(0);

	        }catch (Exception ignore){

	        }
	        return null;
	    }
}
