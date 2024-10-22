package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.pojo.TravelRequestDetails;
import com.mindgate.main.rowmapper.TravelRequestDetailsRowMapper;

@Repository
public class TravelRequestDetailsRepository implements TravelRequestDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TravelRequestDetailsRowMapper travelRequestDetailsRowMapper;

	private int result;

	private static final String POST_TRAVEL_REQUEST = "INSERT INTO TRAVEL_REQUEST(TRAVEL_REQUEST_ID,TRAVEL_PURPOSE,TRAVEL_START_DATE,TRAVEL_END_DATE,MANAGER_STATUS,AGENT_STATUS,DIRECTOR_STATUS,DESTINATION_FROM,DESTINATION_TO,EMPLOYEE_ID)"
			+ "VALUES(SEQ_TRAVEL_REQUEST.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	private static final String GET_TRAVEL_REQUEST_DETAILS_BY_ID = "SELECT * FROM TRAVEL_REQUEST WHERE TRAVEL_REQUEST_ID=?";
	private static final String GET_ALL_TRAVEL_REQUEST_DETAILS = "SELECT * FROM TRAVEL_REQUEST";
	private static final String GET_ALL_REQUEST_BY_EMPLOYEE_ID = "SELECT * FROM TRAVEL_REQUEST WHERE EMPLOYEE_ID = ? ";
	private static final String GET_ALL_REQUEST_BY_MANAGER_NO = "SELECT * FROM travel_request WHERE EMPLOYEE_ID IN(SELECT EMPLOYEE_ID FROM employee_details WHERE MANAGER_NO = ?)";
	private static final String GET_ALL_REQUEST_BY_MANAGER_STATUS = "select * from travel_request where manager_status = 'APPROVED'";
	private static final String GET_ALL_REJECTED_REQUEST_BY_AGENT = "select * from travel_request where agent_status IN ('SLAB NOT MATCHED')";
	private static final String UPDATE_THE_REQUEST = "update travel_request set manager_status=? where travel_request_id = ?";
	private static final String GET_ALL_APPROVED_REQUEST_BY_DIRECTOR = "select * from travel_request where director_status = 'APPROVED'";
	private static final String UPDATE_AGENT_STATUS_IF_REJECTED = "UPDATE TRAVEL_REQUEST SET AGENT_STATUS = ?,DIRECTOR_STATUS = ? WHERE TRAVEL_REQUEST_ID = ?";
	private static final String UPDATE_DIRECTOR_STATUS = "UPDATE TRAVEL_REQUEST SET DIRECTOR_STATUS = ? WHERE TRAVEL_REQUEST_ID = ?";
	private static final String DELETE_REQUEST_BY_REQUEST_ID = "delete from travel_request where travel_request_id = ?";
	
	@Override
	public TravelRequestDetails getSingleRequestByRequestId(int travelRequestId) {
		TravelRequestDetails travelRequestDetails = jdbcTemplate.queryForObject(GET_TRAVEL_REQUEST_DETAILS_BY_ID,
				travelRequestDetailsRowMapper, new Object[] { travelRequestId });
		return travelRequestDetails;
	}

	@Override
	public List<TravelRequestDetails> getAllRequestDetails() {
		List<TravelRequestDetails> requestDetails = jdbcTemplate.query(GET_ALL_TRAVEL_REQUEST_DETAILS,
				travelRequestDetailsRowMapper);
		return requestDetails;
	}

	@Override
	public boolean addTravelRequest(TravelRequestDetails travelRequestDetails) {
		// TRAVEL_REQUEST_ID,TRAVEL_PURPOSE,TRAVEL_START_DATE,TRAVEL_END_DATE,MANAGER_STATUS,AGENT_STATUS,DIRECTOR_STATUS,DESTINATION_FROM,DESTINATION_TO,EMPLOYEE_ID
		result = jdbcTemplate.update(POST_TRAVEL_REQUEST, travelRequestDetails.getTravelPurpose(),
				travelRequestDetails.getStartDate(), travelRequestDetails.getEndDate(),
				travelRequestDetails.getManagerStatus(), travelRequestDetails.getAgentStatus(),
				travelRequestDetails.getDirectorStatus(), travelRequestDetails.getDestinationFrom(),
				travelRequestDetails.getDestinationTo(), travelRequestDetails.getEmployeeDetails().getEmployeeId());
		System.out.println("repository");
		System.out.println(travelRequestDetails);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public List<TravelRequestDetails> getAllRequestByEmployeeId(int employeeId) {
		List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(GET_ALL_REQUEST_BY_EMPLOYEE_ID,
				travelRequestDetailsRowMapper, new Object[] { employeeId });
		return travelRequestDetails;
	}

	@Override
	public List<TravelRequestDetails> getAllRequestByManagerno(int employeeId) {
		System.out.println("employeeId :: " + employeeId);
		List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(GET_ALL_REQUEST_BY_MANAGER_NO,
				travelRequestDetailsRowMapper, new Object[] { employeeId });
		System.out.println(travelRequestDetails);
		return travelRequestDetails;
	}

	@Override
	public List<TravelRequestDetails> getAllRequestByManagerStatus() {
		List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(GET_ALL_REQUEST_BY_MANAGER_STATUS, travelRequestDetailsRowMapper);
		return travelRequestDetails;
	}

	@Override
	public List<TravelRequestDetails> getAllRejectedRequestByAgent() {
		List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(GET_ALL_REJECTED_REQUEST_BY_AGENT, travelRequestDetailsRowMapper);
		return travelRequestDetails;
	}

	@Override
	public boolean updateTravelRequest(TravelRequestDetails travelRequestDetails) {
		System.out.println("in repo update");
		result = jdbcTemplate.update(UPDATE_THE_REQUEST, new Object[] {travelRequestDetails.getManagerStatus() , travelRequestDetails.getTravelRequestId()});
		System.out.println(result);
		if(result > 0)
			return true;
		return false;
	}

	@Override
	public List<TravelRequestDetails> getAllApprovedRequestByDirector() {
		List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(GET_ALL_APPROVED_REQUEST_BY_DIRECTOR, travelRequestDetailsRowMapper);
		return travelRequestDetails;
	}

	@Override
	public boolean updateAgentStatusIfRejected(TravelRequestDetails travelRequestDetails) {
		result = jdbcTemplate.update(UPDATE_AGENT_STATUS_IF_REJECTED, new Object[] {travelRequestDetails.getAgentStatus(),travelRequestDetails.getDirectorStatus(), travelRequestDetails.getTravelRequestId()});
		if(result > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateDirectorStatus(TravelRequestDetails travelRequestDetails) {
		System.out.println(travelRequestDetails);
		result = jdbcTemplate.update(UPDATE_DIRECTOR_STATUS, new Object[] {travelRequestDetails.getDirectorStatus(),travelRequestDetails.getTravelRequestId()});
		
		System.out.println(travelRequestDetails.getDirectorStatus());
		if(result > 0)
			return true;
		return false;
	}
	
	

	@Override
	public boolean deleteTravelRequestByRequestId(int travelRequestId) {
		result= jdbcTemplate.update(DELETE_REQUEST_BY_REQUEST_ID, new Object[] {travelRequestId});
		   if(result>0)
			   return true;
		
		return false;
	}
	
	
	
	
}
