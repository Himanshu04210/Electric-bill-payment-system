package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DBCon.DBUtils;
import com.masai.DTO.TransactionDTO;
import com.masai.DTO.TransactionDTOImple;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class TransacationDAOImple implements TransactionDAO{

	@Override
	public void addTransaction(TransactionDTO transactionDTO) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.createConnectionBet();
			String query = "INSERT INTO transactions (consumer_id, amount, transaction_date) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, LoggInUser.loggInUserId);
			ps.setInt(2, transactionDTO.getAmount());
			ps.setDate(3, Date.valueOf(transactionDTO.getTransaction_date()));
			
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to insert the data " + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
		
		
	}

	@Override
	public List<TransactionDTO> viewTransaction() throws SomethingWentWrongException, NoRecordFoundException {
		List<TransactionDTO> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.createConnectionBet();
			
			String query = "SELECT amount, transaction_date FROM transactions where consumer_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, LoggInUser.loggInUserId);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("No transaction history availble ");
			
			else {
				while(rs.next()) {
					list.add(new TransactionDTOImple(rs.getInt(1), rs.getDate(2).toLocalDate()));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to show the data because " + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
		return list;
		
	}

}
