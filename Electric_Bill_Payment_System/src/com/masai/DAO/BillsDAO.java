package com.masai.DAO;

import java.util.List;

import com.masai.DTO.BillDTO;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public interface BillsDAO {
	public int totalPaidBill() throws SomethingWentWrongException, NoRecordFoundException;
	public int totalPendingBill() throws SomethingWentWrongException, NoRecordFoundException; 
	public void addBill(BillDTO billDTO) throws SomethingWentWrongException;
	public List<BillDTO> viewBillsOfConsumer(int consumer_Id) throws SomethingWentWrongException, NoRecordFoundException;
	public List<BillDTO> viewAllBill() throws SomethingWentWrongException, NoRecordFoundException;
	
}
