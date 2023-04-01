package com.masai.DTO;

import java.time.LocalDate;

public class TransactionDTOImple implements TransactionDTO {
	int amount;
	LocalDate transaction_date;
	public TransactionDTOImple(int amount, LocalDate transaction_date) {
		this.amount = amount;
		this.transaction_date = transaction_date;
	}
	@Override
	public String toString() {
		return "Transaction: amount=" + amount + ", transaction_date=" + transaction_date + "\n";
	}
	
	@Override
	public int getAmount() {
		return amount;
	}
	
	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public LocalDate getTransaction_date() {
		return transaction_date;
	}
	
	@Override
	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	
}
