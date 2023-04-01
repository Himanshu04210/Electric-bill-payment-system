package com.masai.UI;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.Color.ConsoleColors;
import com.masai.DAO.BillsDAO;
import com.masai.DAO.BillsDAOImple;
import com.masai.DAO.ConsumerDAO;
import com.masai.DAO.ConsumerDAOImple;
import com.masai.DAO.TransacationDAOImple;
import com.masai.DAO.TransactionDAO;
import com.masai.DTO.BillDTO;
import com.masai.DTO.BillDTOImple;
import com.masai.DTO.ConsumerDTO;
import com.masai.DTO.ConsumerDTOImple;
import com.masai.DTO.TransactionDTOImple;
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
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"Sign-up succesfull for " + firstName + " " + lastName+ConsoleColors.RESET);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String login() {
		
		String name = null;
		System.out.print("Enter your user name ");
		String userName = scanner.next();
		
		System.out.print("Enter your password ");
		String password = scanner.next();
		
		ConsumerDAO conDao = new ConsumerDAOImple();
		try {
			name = conDao.login(userName, password);
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return name;
	}
	
	public static void logOut() {
		ConsumerDAO consumerDAO = new ConsumerDAOImple();
		consumerDAO.logOut();
	}
	
	public static void payBill() {
		System.out.print("Enter start date(yyyy-MM-dd) ");
		LocalDate bill_start_date = LocalDate.parse(scanner.next());
		
		System.out.print("Enter end date(yyyy-MM-dd) ");
		LocalDate bill_end_date = LocalDate.parse(scanner.next());
		
		System.out.print("Enter unit consumed ");
		int unit = scanner.nextInt();
		int curr_mon_total = (int) ((unit*10)+80+ (((unit*10)+80)*2.5)/100);
		
		
		int totalPaidBill = 0;
		int totalPendingBill = 0;
		
		BillsDAO billsDAO = new BillsDAOImple();
		try {
			totalPaidBill = billsDAO.totalPaidBill();
			totalPendingBill = billsDAO.totalPendingBill();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Total bill of this month is "+ curr_mon_total);
		
		totalPendingBill = totalPendingBill + curr_mon_total;
		System.out.println("Your total pending bill including this month is " + totalPendingBill);
		
		String status = null;
		System.out.print("Do you want to pay bill now or later (now/later) ");
		
		BillDTO billDTO = null;
		
		status = scanner.next();
		if(status.equalsIgnoreCase("now")) {
			status = "paid";
			System.out.print("Enter amount you want to pay ");
			int amount = scanner.nextInt();
			totalPendingBill = totalPendingBill - amount;
			totalPaidBill = totalPaidBill + amount;
			System.out.println("Your total paid bill is (Including this month) " + totalPaidBill);
			System.out.println("Your total pending bill is (Including this month) " + totalPendingBill);
			billDTO = new BillDTOImple(unit, bill_start_date, bill_end_date, status, curr_mon_total, totalPaidBill, totalPendingBill);
			TransactionDAO traDao = new TransacationDAOImple();
			try {
				traDao.addTransaction(new TransactionDTOImple(amount, bill_end_date));
			} catch (SomethingWentWrongException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			status = "pending";
			System.out.println("Your total paid bill is (Including this month) " + totalPaidBill);
			billDTO = new BillDTOImple(unit, bill_start_date, bill_end_date, status, curr_mon_total, totalPaidBill, totalPendingBill);
		}
		
		try {
			billsDAO.addBill(billDTO);
			System.out.println("Bill generated successfully :)");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
