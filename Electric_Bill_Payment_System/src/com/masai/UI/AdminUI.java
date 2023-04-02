package com.masai.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Color.ConsoleColors;
import com.masai.DAO.BillsDAO;
import com.masai.DAO.BillsDAOImple;
import com.masai.DAO.ConsumerDAO;
import com.masai.DAO.ConsumerDAOImple;
import com.masai.DTO.BillDTO;
import com.masai.DTO.ConsumerDTO;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class AdminUI {
	
	public static void viewAllConsumer() {
		ConsumerDAO conDao = new ConsumerDAOImple();
		
		try {
			List<ConsumerDTO> conDto = conDao.viewAllConsumer();
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			conDto.forEach(i -> System.out.println("Consumer Details:- First Name -> "+i.getFirstName()
			+", Last Name -> "+i.getLastName() +", Mobile Number -> " +i.getMobileNo()+
			", Email -> "+i.getEmail() + ", Adress -> " + i.getAddress()));
			System.out.println(ConsoleColors.RESET);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND +e.getMessage() + ConsoleColors.RESET);
		}
	}
	
	public static void deleteConsumer(Scanner input) {
		System.out.println("Enter user Id of consumer");
		int userId = input.nextInt();
		ConsumerDAO conDao = new ConsumerDAOImple();
		try {
			conDao.deleteConsumer(userId);
			System.out.println("Consumer is deleted succesfully ");
		} catch (SomethingWentWrongException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND +e.getMessage() + ConsoleColors.RESET);
		}
	}
	
	public static void viewBillsOfConsumer(Scanner input) {
		System.out.print("Enter Consumer Id ");
		int consumer_Id = input.nextInt();
		
		BillsDAO billsDAO = new BillsDAOImple();
		List<BillDTO> list = new ArrayList<>();
		try {
			list = billsDAO.viewBillsOfConsumer(consumer_Id);
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			list.forEach(i -> System.out.println("Bill:-> Consumer Id : " + i.getConsumer_id()
			+ ", status :"+ i.getStatus() + ", Bill start date : " + i.getStartDate()
			+ ", bill end date : " + i.getEndDate() + ", Unit consumed this month : " + i.getUnitConsumed()
			+ ", Monthly Bill : " + i.getCurrMonBill()));
			System.out.println(ConsoleColors.RESET);
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
		}
		
	}
	
	
	public static void viewAllBills() {
		BillsDAO billsDAO = new BillsDAOImple();
		List<BillDTO> list = new ArrayList<>();
		
		try {
			list = billsDAO.viewAllBill();
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			list.forEach(i -> System.out.println("Bill:-> Consumer Id : " + i.getConsumer_id()
			+ ", status :"+ i.getStatus() + ", Bill start date : " + i.getStartDate()
			+ ", bill end date : " + i.getEndDate() + ", Unit consumed this month : " + i.getUnitConsumed()
			+ ", Monthly Bill : " + i.getCurrMonBill()));
			System.out.println(ConsoleColors.RESET);

		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
		}
	}
	
	public static void viewAllBillPaidAndPending() {
		List<ConsumerDTO> list = new ArrayList<>();
		
		ConsumerDAO consumerDAO = new ConsumerDAOImple();
		
		try {
			list = consumerDAO.viewAllPaidAndPendingBill();
			System.out.println(ConsoleColors.BLACK+ConsoleColors.TEAL_BACKGROUND);
			list.forEach(System.out::print);
			System.out.println(ConsoleColors.RESET);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + e.getMessage() + ConsoleColors.RESET);
		}
	}

}
