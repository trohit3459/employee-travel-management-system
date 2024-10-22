package com.rgcorporation.main.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.EmployeeDetails;
import com.rgcorporation.main.model.LoginDetails;
import com.rgcorporation.main.repository.LoginDetailsRepository;

@Component
public final class EmployeeDetailsRowMapper implements RowMapper<EmployeeDetails> {
	
	
	@Autowired
	private LoginDetailsRepository loginDetailsRepository;

	@Override
	public EmployeeDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {

		int employeeId = resultSet.getInt("Employee_Id");
		String employeeName = resultSet.getString("Employee_Name");

		Date dateOfBirth = resultSet.getDate("Date_Of_Birth");
		System.out.println(dateOfBirth);
		// conversion of java.sql.Date into java.time.LocalDate
		LocalDate newdateOfBith =   dateOfBirth.toLocalDate();

		String address = resultSet.getString("Address");

		Date dateOfJoining = resultSet.getDate("Date_Of_Joining");// unable to store in LocalDate
		System.out.println(dateOfJoining);
		// conversion of java.sql.Date into java.time.LocalDate
		LocalDate newDateOfJoining=dateOfJoining.toLocalDate();
		String emailId = resultSet.getString("Email");
		int managersNo = resultSet.getInt("MANAGER_NO");
		long contactNo = resultSet.getLong("Contact_No");
		String designation = resultSet.getString("DESIGNATION");
		int loginId = resultSet.getInt("Login_Id");
		LoginDetails loginDetails = loginDetailsRepository.getLoginDetailsById(loginId);
		

		EmployeeDetails employeeDetails = new EmployeeDetails();
		
		employeeDetails.setEmployeeId(employeeId);
		employeeDetails.setEmployeeName(employeeName);
		employeeDetails.setDateOfBirth(newdateOfBith);// unable to set date in the object thats why it converts into
														// Local Date and set
		employeeDetails.setAddress(address);
		employeeDetails.setDateOfJoining(newDateOfJoining);
		employeeDetails.setEmailId(emailId);
		employeeDetails.setManagersNo(managersNo);
		employeeDetails.setContactNo(contactNo);
		employeeDetails.setDesignation(designation);
		employeeDetails.setLoginDetails(loginDetails);

		return employeeDetails;
	}

}
