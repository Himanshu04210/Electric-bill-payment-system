package com.masai.UI;

import java.util.Scanner;
import com.masai.Color.ConsoleColors;
import com.masai.DAO.LoggInUser;

public class UIMain {
	private static ConsumerUI consumerUI;
	private static AdminUI adminUI;
	private static BillUI billUI;
	public static void displayMenu() {
	   System.out.println(ConsoleColors.RED_BRIGHT
			   		     +"+-------------------+\n"
						+ "|  0. Exit          |\n"
						+ "|  1. Admin login   |\n"
						+ "|  2. User login    |\n"
						+ "|  3. User Sign-up  |\n"	
						+ "+-------------------+"+
						ConsoleColors.RESET);
		

	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		consumerUI = new ConsumerUI(input);
		billUI = new BillUI(input);
		int choice = 0;
		
		do {
			displayMenu();
			System.out.print(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Enter Section "+ConsoleColors.RESET);
			choice = input.nextInt();
			
			switch(choice) {
			
				case 1:
					loginAdmin(input);
					break;
				case 2:
					userLogin(input);
					break;
				case 3:
					ConsumerUI.sign_up();
					break;
				case 0:
					System.out.println("Thanks for visiting here");
					break;
				default:
					System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Section"+ConsoleColors.RESET);
			
			}
			
		}
		while(choice != 0);
	}
	
	public static void displayAdminMenu() {
		System.out.println(ConsoleColors.RED_BRIGHT
		     	+"+----------------------------------------+\n"
				+ "|  0. Logout                             |\n"
				+ "|  1. View all consumers                 |\n"
				+ "|  2. View the bill of the consumer      |\n"
				+ "|  3. View all the bills                 |\n"
				+ "|  4. View all bills paid and pending    |\n"
				+ "|  5. Delete consumer                    |\n"	
				+ "+----------------------------------------+"
				+ConsoleColors.RESET);
	}
	
	public static void loginAdmin(Scanner input) {
		System.out.print("Enter User Name ");
		String userName = input.next();
		
		System.out.print("Enter Password ");
		String password = input.next();
		
		if(userName.equals("admin") && password.equals("admin")) {
			System.out.println(ConsoleColors.GREEN+"Welcome admin..");
			adminMenu(input);
		}
		else
		System.out.println(ConsoleColors.RED+"Credential Mismatch.."+ConsoleColors.RESET);
		
	}
	
	public static void adminMenu(Scanner input) {
		int choice = 0;
		
		do {
			displayAdminMenu();
			System.out.print(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Enter Section "+ConsoleColors.RESET);
			choice = input.nextInt();
			
			switch(choice) {
				case 1:
					AdminUI.viewAllConsumer();
					break;
				case 2:
					AdminUI.viewBillsOfConsumer(input);
					break;
				case 3:
					AdminUI.viewAllBills();
					break;
				case 4:
					AdminUI.viewAllBillPaidAndPending();
					break;
				case 5:
					AdminUI.deleteConsumer(input);
					break;
				case 0:
					System.out.println("Admin logged out..");
					break;
				default:
					System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Section"+ConsoleColors.RESET);
			}
			
		}
		while(choice != 0);
	}
	
	public static void displayUserMenu() {
		System.out.println(ConsoleColors.RED_BRIGHT
		     	+"+--------------------------------+\n"
				+ "|  0. Logout                    |\n"
				+ "|  1. pay bill                  |\n"
				+ "|  2. View transaction History  |\n"
				+ "+-------------------------------+"
				+ConsoleColors.RESET);
	}
	
	public static void userLogin(Scanner input) {
		String name = ConsumerUI.login();
		if(name == null) return;
		else System.out.println("Hi, "+name + " What do you want to choose. ");
		
		int choice = 0;
		
		do {
			displayUserMenu();
			System.out.print(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Enter Section "+ConsoleColors.RESET);
			choice = input.nextInt();
			switch(choice) {
				case 0:
					ConsumerUI.logOut();
					System.out.println("Thank you for using our services. Visit again,,");
					break;
				case 1:
					ConsumerUI.payBill();
					break;
				case 2:
					TransactionUI.viewAllTransaction();
					break;
				default:
					System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Section, try again"+ConsoleColors.RESET);
			}
		}
		while(choice != 0);
	}

}
