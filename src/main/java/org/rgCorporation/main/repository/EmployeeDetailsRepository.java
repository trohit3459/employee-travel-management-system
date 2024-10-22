package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.EmployeeDetails;

@Repository
public class EmployeeDetailsRepository implements EmployeeDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmployeeDetailsRowMapper employeeDetailsRowMapper;

	private static final String INSERT_EMPLOYEE_DETAILS = "INSERT INTO EMPLOYEE_DETAILS(FIRST_NAME,LAST_NAME,ADDRESS,MANAGER_ID, CITY,STATE,EMAIL_ID,CONTACT_NO,DESIGNATION,LOGIN_ID) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_EMPLOYEE_DETAILS = "SELECT * FROM EMPLOYEE_DETAILS";
	private static final String SELECT_SINGLE_EMPLOYEE_DETAILS = "SELECT * FROM EMPLOYEE_DETAILS WHERE EMPLOYEE_ID = ?";
	private static final String GET_EMPLOYEE_BY_EMPLOYEE_ID="SELECT * FROM EMPLOYEE_DETAILS WHERE LOGIN_ID=?";
	private int resultCount;

	@Override
	public boolean addEmployeeDetails(EmployeeDetails employeeDetails) {

		Object[] args = { employeeDetails.getFirstName(), employeeDetails.getLastName(), employeeDetails.getAddress(),
				employeeDetails.getManagerId(), employeeDetails.getCity(), employeeDetails.getState(),
				employeeDetails.getEmailId(), employeeDetails.getContactNo(), employeeDetails.getDesignation(),
				employeeDetails.getLoginDetails().getLoginId() };

		resultCount = jdbcTemplate.update(INSERT_EMPLOYEE_DETAILS, args);

		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByEmployeeDetailsId(int employeeDetailsId) {
		Object[] args = {employeeDetailsId};
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_EMPLOYEE_DETAILS,
				employeeDetailsRowMapper, args);
		return employeeDetails;
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		List<EmployeeDetails> employeeDetails = jdbcTemplate.query(SELECT_ALL_EMPLOYEE_DETAILS,
				employeeDetailsRowMapper);
		return employeeDetails;
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByLoginId(int loginid) {
		Object[] args = {loginid};
		EmployeeDetails employeeDetails=jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_EMPLOYEE_ID,employeeDetailsRowMapper, args);
		return employeeDetails;
	}

}
