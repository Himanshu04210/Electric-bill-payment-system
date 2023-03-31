package com.masai.DAO;

import com.masai.DTO.BillDTO;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public interface BillsDAO {
	public int totalPaidBill() throws SomethingWentWrongException, NoRecordFoundException;
	public int totalPendingBill() throws SomethingWentWrongException, NoRecordFoundException; 
	public void addBill(BillDTO billDTO) throws SomethingWentWrongException;
}
