package com.masai.DTO;

import java.time.LocalDate;

public class BillDTOImple implements BillDTO {
	private int unitConsumed;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	private int currMonBill;
	private int totalPaidBill;
	private int totalPendingBill;
	private int consumer_id;
	
	@Override
	public String toString() {
		return "totalPaidBill=" + totalPaidBill + ", totalPendingBill=" + totalPendingBill ;
	}

	public BillDTOImple(int unitConsumed, LocalDate startDate, LocalDate endDate, String status, int currMonBill,
			int totalPaidBill, int totalPendingBill) {
		this.unitConsumed = unitConsumed;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.currMonBill = currMonBill;
		this.totalPaidBill = totalPaidBill;
		this.totalPendingBill = totalPendingBill;
		
	}
	
	public BillDTOImple(int consumer_id, String status, LocalDate startDate, LocalDate endDate, int unitConsumed, int currMonBill) {
		this.consumer_id = consumer_id;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currMonBill = currMonBill;
		this.unitConsumed = unitConsumed;
	}
	
	public BillDTOImple( int totalPaidBill, int totalPendingBill) {
		this.totalPaidBill = totalPaidBill;
		this.totalPendingBill = totalPendingBill;
	}
	

	@Override
	public int getConsumer_id() {
		return consumer_id;
	}
	
	@Override
	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}

	@Override
	public int getUnitConsumed() {
		return unitConsumed;
	}
	
	@Override
	public void setUnitConsumed(int unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	
	@Override
	public LocalDate getStartDate() {
		return startDate;
	}
	
	@Override
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public LocalDate getEndDate() {
		return endDate;
	}
	
	@Override
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int getCurrMonBill() {
		return currMonBill;
	}
	
	@Override
	public void setCurrMonBill(int currMonBill) {
		this.currMonBill = currMonBill;
	}
	
	@Override
	public int getTotalPaidBill() {
		return totalPaidBill;
	}
	
	@Override
	public void setTotalPaidBill(int totalPaidBill) {
		this.totalPaidBill = totalPaidBill;
	}
	
	@Override
	public int getTotalPendingBill() {
		return totalPendingBill;
	}
	
	@Override
	public void setTotalPendingBill(int totalPendingBill) {
		this.totalPendingBill = totalPendingBill;
	}
	
}
