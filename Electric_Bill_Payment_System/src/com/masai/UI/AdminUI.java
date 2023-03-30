package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.ConsumerDAO;
import com.masai.DAO.ConsumerDAOImple;
import com.masai.DTO.ConsumerDTO;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class AdminUI {
	
	public static void viewAllConsumer() {
		ConsumerDAO conDao = new ConsumerDAOImple();
		
		try {
			List<ConsumerDTO> conDto = conDao.viewAllConsumer();
			conDto.forEach(i -> System.out.println("Consumer Details:- First Name -> "+i.getFirstName()
			+", Last Name -> "+i.getLastName() +", Mobile Number -> " +i.getMobileNo()+
			", Email -> "+i.getEmail() + ", Adress -> " + i.getAddress()));
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
		}
	}

}
