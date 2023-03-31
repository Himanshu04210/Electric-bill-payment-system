package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DBCon.DBUtils;
import com.masai.DTO.ConsumerDTO;
import com.masai.DTO.ConsumerDTOImple;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class ConsumerDAOImple implements ConsumerDAO {

	@Override
	public List<ConsumerDTO> viewAllConsumer() throws SomethingWentWrongException, NoRecordFoundException {
		List<ConsumerDTO> list = new ArrayList<>();
		
		Connection con = null;
		
		try {
			con = DBUtils.createConnectionBet();
			String query = "SELECT firstName, lastName, mobileNO, email, address FROM consumers WHERE isDelete = 1";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("No consumer availble in database");
			else {
				while(rs.next()) {
					list.add(new ConsumerDTOImple(rs.getString("firstName"), rs.getString("lastName")
							, rs.getString("mobileNo"), rs.getString("email"), rs.getString("address")));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to show the data");
			
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void deleteConsumer(int userId) throws SomethingWentWrongException {
		Connection con = null;
		
		try {
			con = DBUtils.createConnectionBet();
			String query = "UPDATE consumers SET isDelete = 0 WHERE userID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
		
			throw new SomethingWentWrongException("Unable to delete the record. -> "+e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void addConsumer(ConsumerDTO conDto) throws SomethingWentWrongException {
		Connection con = null;
		
		try {
			con = DBUtils.createConnectionBet();
			String query = "INSERT INTO consumers "
					+ "(firstName, lastName, userName, password, address, mobileNo, email, connection_date) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, conDto.getFirstName());
			ps.setString(2, conDto.getLastName());
			ps.setString(3, conDto.getUserName());
			ps.setString(4, conDto.getPassword());
			ps.setString(5, conDto.getAddress());
			ps.setString(6, conDto.getMobileNo());
			ps.setString(7, conDto.getEmail());
			ps.setDate(8,Date.valueOf(conDto.getConnectionDate()));
			
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to register data ->" + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
	}

	@Override
	public String login(String userName, String password) throws SomethingWentWrongException, NoRecordFoundException {
		Connection con = null;
		String name = null;
		
		try {
			con = DBUtils.createConnectionBet();
			String query = "SELECT firstName, userId FROM consumers WHERE userName = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("Consumer need to sign up first");
			
			rs.next();
			name = rs.getString("firstName");
			LoggInUser.loggInUserId = rs.getInt("userId");
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong -> "+ e.getMessage() );
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
		return name;
	}

	@Override
	public void logOut() {
		LoggInUser.loggInUserId = 0;
	}

}
