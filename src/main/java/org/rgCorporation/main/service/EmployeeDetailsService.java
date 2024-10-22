package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.EmployeeDetails;
import org.rgCorporation.main.repository.EmployeeDetailsRepositoryInterface;

@Service
public class EmployeeDetailsService implements EmployeeDetailsServiceInterface {
	@Autowired
	private EmployeeDetailsRepositoryInterface employeeDetailsRepositoryInterface;

	@Override
	public boolean addEmployeeDetails(EmployeeDetails employeeDetails) {
		return employeeDetailsRepositoryInterface.addEmployeeDetails(employeeDetails);
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByEmployeeDetailsId(int employeeDetailsId) {
		return employeeDetailsRepositoryInterface.getEmployeeDetailsByEmployeeDetailsId(employeeDetailsId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		return employeeDetailsRepositoryInterface.getAllEmployeeDetails();
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByLoginId(int loginid) {
		return employeeDetailsRepositoryInterface.getEmployeeDetailsByLoginId(loginid);
	}

}
