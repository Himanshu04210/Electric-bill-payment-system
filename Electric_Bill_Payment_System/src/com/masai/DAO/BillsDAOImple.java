package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DBCon.DBUtils;
import com.masai.DTO.BillDTO;
import com.masai.DTO.BillDTOImple;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
public class BillsDAOImple implements BillsDAO {

	@Override
	public int totalPaidBill() throws SomethingWentWrongException, NoRecordFoundException{
		int totalPaidBill = 0;
		
		Connection con = null;
		
		try {
			con = DBUtils.createConnectionBet();
			String query = "SELECT total_paid_bill FROM bills WHERE consumer_id = ? ORDER BY bill_end_date DESC LIMIT 1";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, LoggInUser.loggInUserId);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("No previous record availble ");
			else {
				rs.next();
				totalPaidBill = rs.getInt("total_paid_bill");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to excute this query " + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
		
		return totalPaidBill;
	}

	@Override
	public int totalPendingBill() throws SomethingWentWrongException, NoRecordFoundException {
		int totalPendingBill = 0;

		Connection con = null;
		
		try {
			con = DBUtils.createConnectionBet();
			String query = "SELECT total_pending_bill FROM bills WHERE consumer_id = ? ORDER BY bill_end_date DESC LIMIT 1";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, LoggInUser.loggInUserId);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("No previous record availble ");
			else {
				rs.next();
				totalPendingBill = rs.getInt("total_pending_bill");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Unable to excute the query " + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
		return totalPendingBill;
	}

	@Override
	public void addBill(BillDTO billDTO) throws SomethingWentWrongException {
		Connection con = null;
		
		try {
			con = DBUtils.createConnectionBet();
			
			String query = "INSERT INTO bills "
					+ "(consumer_Id, bill_start_date, bill_end_date, curr_mon_bill, status, total_paid_bill, total_pending_bill, mon_unit_consumed) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, LoggInUser.loggInUserId);
			ps.setDate(2, Date.valueOf(billDTO.getStartDate()));
			ps.setDate(3, Date.valueOf(billDTO.getEndDate()));
			ps.setInt(4, billDTO.getCurrMonBill());
			ps.setString(5, billDTO.getStatus());
			ps.setInt(6, billDTO.getTotalPaidBill());
			ps.setInt(7, billDTO.getTotalPendingBill());
			ps.setInt(8, billDTO.getUnitConsumed());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong " + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
	}

	@Override
	public List<BillDTO> viewBillsOfConsumer(int consumer_Id)
			throws SomethingWentWrongException, NoRecordFoundException {
		List<BillDTO> list = new ArrayList<>();
		
		Connection con = null;
		try {
			con = DBUtils.createConnectionBet();
			String query = "SELECT consumer_id, status, bill_start_date, bill_end_date, mon_unit_consumed, curr_mon_bill FROM bills where consumer_Id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, consumer_Id);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("No Data availble for this consumer Id");
			else {
				while(rs.next()) {
					list.add(new BillDTOImple(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getDate(4).toLocalDate(), rs.getInt(5), rs.getInt(6)));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong " + e.getMessage());
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				
			}
		}
		
		
		return list;
	}

	@Override
	public List<BillDTO> viewAllBill() throws SomethingWentWrongException, NoRecordFoundException {
		List<BillDTO> list = new ArrayList<>();
		
		Connection con = null;
		try {
			con = DBUtils.createConnectionBet();
			String query = "SELECT consumer_id, status, bill_start_date, bill_end_date, mon_unit_consumed, curr_mon_bill FROM bills order by consumer_id";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) throw new NoRecordFoundException("No Data availble for this consumer Id");
			else {
				while(rs.next()) {
					list.add(new BillDTOImple(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getDate(4).toLocalDate(), rs.getInt(5), rs.getInt(6)));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SomethingWentWrongException("Something went wrong " + e.getMessage());
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
