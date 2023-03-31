package com.masai.DTO;

import java.time.LocalDate;

public interface TransactionDTO {
	public int getAmount();
	public void setAmount(int amount);
	public LocalDate getTransaction_date();
	public void setTransaction_date(LocalDate transaction_date);
	
}
