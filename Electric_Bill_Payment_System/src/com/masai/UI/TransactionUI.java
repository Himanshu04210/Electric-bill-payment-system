package com.masai.UI;

import java.util.ArrayList;
import java.util.List;

import com.masai.Color.ConsoleColors;
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
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			list.forEach(System.out::println);
			System.out.println(ConsoleColors.RESET);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
