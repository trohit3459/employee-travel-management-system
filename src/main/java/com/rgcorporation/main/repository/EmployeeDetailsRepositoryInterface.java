package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.EmployeeDetails;

public interface EmployeeDetailsRepositoryInterface {

//	public boolean addNewEmployee(EmployeeDetails employeeDetails);
//
//	public boolean updateEmployeeDetails(EmployeeDetails employeeDetails);
//
//	public boolean deleteEmployeeByEmployeeId(int employeeId);

	public EmployeeDetails getEmployeeByEmployeeId(int employeeId);

	public List<EmployeeDetails> getAllEmployees();
	public EmployeeDetails getEmployeeByloginId(int loginId);
	
	public EmployeeDetails getDetailsByRequstId(int travelRequestId);

}
