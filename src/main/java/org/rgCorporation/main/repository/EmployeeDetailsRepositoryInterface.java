package org.rgCorporation.main.repository;



import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import org.rgCorporation.main.model.EmployeeDetails;

public interface EmployeeDetailsRepositoryInterface {
	public boolean addEmployeeDetails(EmployeeDetails employeeDetails);
	public EmployeeDetails getEmployeeDetailsByEmployeeDetailsId(int employeeDetailsId);
	public List<EmployeeDetails>getAllEmployeeDetails();
	public EmployeeDetails getEmployeeDetailsByLoginId(int loginid) ;
  }
