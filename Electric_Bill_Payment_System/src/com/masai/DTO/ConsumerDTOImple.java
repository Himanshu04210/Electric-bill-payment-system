package com.masai.DTO;

import java.time.LocalDate;

public class ConsumerDTOImple implements ConsumerDTO {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;
	private String mobileNo;
	private String email;
	private LocalDate connectionDate;
	private BillDTO billDTO;
	
	
	public ConsumerDTOImple(String firstName, String lastName, String userName, String password, String address,
			String mobileNo, String email, String connectionDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.connectionDate = LocalDate.parse(connectionDate);
	}

	public ConsumerDTOImple(String firstName, String lastName, String mobileNo, String email
			, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
	}
	
	public ConsumerDTOImple(String firstName, String lastName, String mobileNo, String email
			, String address, BillDTO billDTO) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.billDTO = billDTO;
	}
	
	
	
	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", email=" + email + "," + billDTO + "\n";
	}

	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String getUserName() {
		return userName;
	}
	
	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getAddress() {
		return address;
	}
	
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String getMobileNo() {
		return mobileNo;
	}
	
	@Override
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public LocalDate getConnectionDate() {
		return connectionDate;
	}
	
	@Override
	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

}
