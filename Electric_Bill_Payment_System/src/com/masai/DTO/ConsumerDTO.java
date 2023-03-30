package com.masai.DTO;

import java.time.LocalDate;

public interface ConsumerDTO {
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getUserName();
	public void setUserName(String userName);
	public String getPassword();
	public void setPassword(String password);
	public String getAddress();
	public void setAddress(String address);
	public String getMobileNo();
	public void setMobileNo(String mobileNo);
	public String getEmail();
	public void setEmail(String email);
	public LocalDate getConnectionDate();
	public void setConnectionDate(LocalDate connectionDate);
}
