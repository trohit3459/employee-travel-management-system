package org.rgCorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.EmployeeDetails;
import org.rgCorporation.main.model.LoginDetails;

@Repository
@Scope("prototype")
public class EmployeeDetailsRowMapper implements RowMapper<EmployeeDetails> {

	@Autowired
	private LoginDetailsRepository loginDetailsRepository;

	public EmployeeDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		
		int employeeDetailsId = resultSet.getInt("EMPLOYEE_ID");
		String firstName = resultSet.getString("FIRST_NAME");
		String lastName = resultSet.getString("LAST_NAME");
		String address = resultSet.getString("ADDRESS");
		int managerId = resultSet.getInt("MANAGER_ID");
		String city = resultSet.getString("CITY");
		String state = resultSet.getString("STATE");
		String emailId = resultSet.getString("EMAIL_ID");
		String contactNo = resultSet.getString("CONTACT_NO");
		String designation = resultSet.getString("DESIGNATION");
		int loginId = resultSet.getInt("LOGIN_ID");
		LoginDetails loginDetails = loginDetailsRepository.getLoginDetailsByLoginId(loginId);
		EmployeeDetails employeeDetails = new EmployeeDetails(employeeDetailsId, firstName, lastName, address,
				managerId, city, state, emailId, contactNo, designation, loginDetails);
		return employeeDetails;
		

	}

}
