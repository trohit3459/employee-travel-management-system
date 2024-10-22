package org.rgCorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.rgCorporation.main.model.EmployeeDetails;
import org.rgCorporation.main.service.EmployeeDetailsServiceInterface;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("employeetraval")
public class EmployeeDetailsController {
	@Autowired
	private EmployeeDetailsServiceInterface employeeDetailsServiceInterface;

	@RequestMapping(value = "employeedetails", method = RequestMethod.POST)
	public boolean addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		
		return employeeDetailsServiceInterface.addEmployeeDetails(employeeDetails);

	}


	@RequestMapping(value = "employeedetails/{id}", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetailsByEmployeeDetailsId(@PathVariable("id") int employeeDetailsId) {
		return employeeDetailsServiceInterface.getEmployeeDetailsByEmployeeDetailsId(employeeDetailsId);

	}

	@RequestMapping(value = "employeedetails", method = RequestMethod.GET)
	public List<EmployeeDetails> getAllEmployeeDetails() {
		return employeeDetailsServiceInterface.getAllEmployeeDetails();

	}
	
	@RequestMapping(value = "employeedetailsbyloginid/{loginid}", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetailsByLoginId(@PathVariable("loginid") int loginid) {
		return employeeDetailsServiceInterface.getEmployeeDetailsByLoginId(loginid);

	}
	

}
