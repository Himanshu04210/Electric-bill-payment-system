package com.masai.UI;

import java.util.Scanner;

import com.masai.Color.ConsoleColors;

public class UIMain {
	
	public static void displayMenu() {
	   System.out.println(ConsoleColors.RED_BRIGHT+"+-----------------+\n"
						+ "|  0. Exit        |\n"
						+ "|  1. Admin login |\n"
						+ "|  2. User login  |\n"	
						+ "+-----------------+"+ ConsoleColors.RESET);
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		do {
			displayMenu();
			System.out.println("Enter Section ");
			choice = input.nextInt();
			
			switch(choice) {
			
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
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

}
