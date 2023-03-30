package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.ConsumerDAO;
import com.masai.DAO.ConsumerDAOImple;
import com.masai.DTO.ConsumerDTO;
import com.masai.DTO.ConsumerDTOImple;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class ConsumerUI {
	private static Scanner scanner;
	
	
	public ConsumerUI(Scanner scanner) {
		this.scanner = scanner;
	}

	public static void sign_up(){
		System.out.print("Enter your first name ");
		String firstName = scanner.next();
		
		System.out.print("Enter your last name ");
		String lastName = scanner.next();

		System.out.print("Enter unique user name ");
		String userName = scanner.next();
		
		System.out.print("Enter password ");
		String password = scanner.next();
		
		System.out.print("Enter address ");
		String address = scanner.next();
		
		System.out.print("Enter mobile number ");
		String mobileNo = scanner.next();
		
		System.out.print("Enter email Id ");
		String email = scanner.next();
		
		System.out.print ("Enter date (yyyy-MM-dd) ");
		String connection_date = scanner.next();
		
		ConsumerDTO conDto = new ConsumerDTOImple(firstName, lastName, userName, password, address, mobileNo, email, connection_date);
		
		ConsumerDAO conDao = new ConsumerDAOImple();
		try {
			conDao.addConsumer(conDto);
			System.out.println("Sign-up succesfull for " + firstName + " " + lastName);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static boolean login() {
		boolean loggedInSuccessful = false;
		
		System.out.print("Enter your user name ");
		String userName = scanner.next();
		
		System.out.print("Enter your password ");
		String password = scanner.next();
		
		ConsumerDAO conDao = new ConsumerDAOImple();
		
		try {
			conDao.login(userName, password);
			loggedInSuccessful = true;
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return loggedInSuccessful;
	}
}
