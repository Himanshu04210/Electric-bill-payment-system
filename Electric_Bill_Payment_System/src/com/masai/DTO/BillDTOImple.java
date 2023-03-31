package com.masai.DTO;

import java.time.LocalDate;

public class BillDTOImple implements BillDTO {
	int unitConsumed;
	LocalDate startDate;
	LocalDate endDate;
	String status;
	int currMonBill;
	int totalPaidBill;
	int totalPendingBill;
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
