package com.masai.UI;

import java.util.ArrayList;
import java.util.List;

import com.masai.DAO.TransacationDAOImple;
import com.masai.DAO.TransactionDAO;
import com.masai.DTO.TransactionDTO;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class TransactionUI {
	public static void viewAllTransaction() {
		TransactionDAO transDao = new TransacationDAOImple();
		List<TransactionDTO> list = new ArrayList<>();
		
		try {
			list = transDao.viewTransaction();
			list.forEach(System.out::println);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
