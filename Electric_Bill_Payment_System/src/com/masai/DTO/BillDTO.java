package com.masai.DTO;

import java.time.LocalDate;

public interface BillDTO {
	public int getUnitConsumed();
	public void setUnitConsumed(int unitConsumed);
	public LocalDate getStartDate();
	public void setStartDate(LocalDate startDate);
	public LocalDate getEndDate();
	public void setEndDate(LocalDate endDate);
	public String getStatus();
	public void setStatus(String status);
	public int getCurrMonBill();
	public void setCurrMonBill(int currMonBill);
	public int getTotalPaidBill();
	public void setTotalPaidBill(int totalPaidBill);
	public int getTotalPendingBill();
	public void setTotalPendingBill(int totalPendingBill);
	public int getConsumer_id();
	public void setConsumer_id(int consumer_id) ;
}
