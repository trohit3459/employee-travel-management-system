package org.rgCorporation.main.service;

import java.util.List;

import org.rgCorporation.main.model.EmployeeDetails;

public interface EmployeeDetailsServiceInterface {
	
	public boolean addEmployeeDetails(EmployeeDetails employeeDetails);
	public EmployeeDetails getEmployeeDetailsByEmployeeDetailsId(int employeeDetailsId);
	public List<EmployeeDetails>getAllEmployeeDetails();
	public EmployeeDetails getEmployeeDetailsByLoginId(int loginid) ;

}
