package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.pojo.EmployeeDetails;
import com.mindgate.main.rowmapper.EmployeeDetailsRowMapper;

@Repository
public class EmployeeDetailsRepository implements EmployeeDetailsRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeDetailsRowMapper employeeDetailsRowMapper;

	private int result;
//	private static final String INSERT_EMPLOYEE_DETAILS = "INSERT INTO EMPLOYEE_DETAILS(LOGIN_ID,EMPLOYEE_NAME,ADDRESS"
//			+ ",DATE_OF_BIRTH,CONTACT_NO,EMAIL,DATE_OF_JOINING,"
//			+ "MANAGER_NO,DESIGNATION) VALUES (?,?,?,?,?,?,?,?,?)";
//	private static final String UPDATE_EMPLOYEE_DETAILS_BY_EMPLOYEE_ID = "UPDATE EMPLOYEE_DETAILS SET LOGIN_ID=?,EMPLOYEE_NAME=?,ADDRESS=?"
//			+ ",DATE_OF_BIRTH=?,CONTACT_NO=?,EMAIL=?,DATE_OF_JOINING=?,MANAGER_NO=?,DESIGNATION=?  WHERE EMPLOYEE_ID=?";
//	private static final String DELETE_EMPLOYEE_DETAILS_BY_ID = "DELETE FROM EMPLOYEE_DETAILS WHERE EMPLOYEE_ID=?";
	private static final String GET_EMPLOYEE_LOGIN_ID = "SELECT * from EMPLOYEE_DETAILS where Login_Id = ?";
	private static final String GET_EMPLOYEE_DETAILS_BY_ID = "SELECT * FROM EMPLOYEE_DETAILS WHERE EMPLOYEE_ID=?";
	private static final String GET_ALL_EMPLOYEE_DETAILS = "SELECT* FROM EMPLOYEE_DETAILS";
	private static final String GET_EMPLOYEE_DETAILS_BY_TRAVEL_REQUEST_ID = 
					"select * from employee_details inner join travel_request on employee_details.employee_id = travel_request.employee_id where travel_request.travel_request_id = ?";
	
//	@Override
//	public boolean addNewEmployee(EmployeeDetails employeeDetails) {
//		result = jdbcTemplate.update(INSERT_EMPLOYEE_DETAILS, employeeDetails.getLoginDetails().getLoginId(),
//				employeeDetails.getEmployeeName(), employeeDetails.getAddress(), employeeDetails.getDateOfBirth(),
//				employeeDetails.getContactNo(), employeeDetails.getEmailId(), employeeDetails.getDateOfJoining(),
//				employeeDetails.getManagersNo(), employeeDetails.getDesignation());
//
//		if (result > 0)
//			return true;
//
//		return false;
//	}
//
//	@Override
//	public boolean updateEmployeeDetails(EmployeeDetails employeeDetails) {
//		result = jdbcTemplate.update(UPDATE_EMPLOYEE_DETAILS_BY_EMPLOYEE_ID,
//				new Object[] { employeeDetails.getLoginDetails().getLoginId(), employeeDetails.getEmployeeName(),
//						employeeDetails.getAddress(), employeeDetails.getDateOfBirth(), employeeDetails.getContactNo(),
//						employeeDetails.getEmailId(), employeeDetails.getDateOfJoining(),
//						employeeDetails.getManagersNo(), employeeDetails.getDesignation(),
//						employeeDetails.getEmployeeId() });
//
//		if (result > 0)
//			return true;
//
//		return false;
//	}

//	@Override
//	public boolean deleteEmployeeByEmployeeId(int employeeId) {
//
//		result = jdbcTemplate.update(DELETE_EMPLOYEE_DETAILS_BY_ID, employeeId);
//		if (result > 0)
//			return true;
//
//		return false;
//	}

	@Override
	public EmployeeDetails getEmployeeByEmployeeId(int employeeId) {
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(GET_EMPLOYEE_DETAILS_BY_ID,
				employeeDetailsRowMapper, new Object[] { employeeId });
		return employeeDetails;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {

		List<EmployeeDetails> listOfEmployee = jdbcTemplate.query(GET_ALL_EMPLOYEE_DETAILS,
				employeeDetailsRowMapper);
		return listOfEmployee;
	}
	
	@Override
	public EmployeeDetails getEmployeeByloginId(int loginId) {
		System.out.println(loginId);
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(GET_EMPLOYEE_LOGIN_ID, employeeDetailsRowMapper,new Object[] { loginId } );
		return employeeDetails;
	}

	@Override
	public EmployeeDetails getDetailsByRequstId(int travelRequestId) {
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(GET_EMPLOYEE_DETAILS_BY_TRAVEL_REQUEST_ID, employeeDetailsRowMapper,new Object[] { travelRequestId } );
		return employeeDetails;
	}

}
