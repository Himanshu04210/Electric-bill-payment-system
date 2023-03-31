package com.masai.DAO;


import com.masai.DTO.TransactionDTO;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public interface TransactionDAO {
	public void addTransaction(TransactionDTO transactionDTO) throws SomethingWentWrongException;
	public void viewTransaction() throws SomethingWentWrongException, NoRecordFoundException;
}
