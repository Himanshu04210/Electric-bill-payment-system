package com.masai.UI;

import java.util.Scanner;

import com.masai.Color.ConsoleColors;

public class UIMain {
	private static ConsumerUI consumerUI;
	private static AdminUI adminUI;
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
		int choice = 0;
		
		do {
			displayMenu();
			System.out.println("Enter Section ");
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
					System.out.println("Invalid Section");
			
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
			System.out.print("Enter Section ");
			choice = input.nextInt();
			
			switch(choice) {
				case 1:
					AdminUI.viewAllConsumer();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					AdminUI.deleteConsumer(input);
					break;
				case 0:
					System.out.println("Admin logged out..");
					break;
				default:
					System.out.println("Invalid Section");
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
		if(!ConsumerUI.login()) return;
	}

}
