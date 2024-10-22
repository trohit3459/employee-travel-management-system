package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.TravelDocumentDetails;
import org.rgCorporation.main.model.TravellingRequestDetails;

@Repository
public class TravlingRequestDetailsRepository implements TravlingRequestDetailsRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private TravlingRequestDetailsRowMapper travlingRequestDetailsRowMapper;
	@Autowired
	private TravelDocumentDetailsRepository TravelDocumentDetailsRepository;
	private int resultCount;

	private static final String SELECT_ALL_TRAVELING_REQUEST_DETAILS = "SELECT * FROM TRAVELLING_REQUEST_DETAILS ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_SINGLE_TRAVELING_REQUEST_DETAILS_BY_TRAVEL_REQUEST_ID = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE TRAVEL_REQUEST_ID= ? ORDER BY TRAVEL_REQUEST_ID";
	private static final String INSERT_TRAVELING_REQUEST_DETAILS = " INSERT INTO TRAVELLING_REQUEST_DETAILS(TRAVEL_REQUEST_ID,TRAVEL_DEPARTURE_DATE,TRAVEL_RETURN_DATE,TRAVEL_REASON ,TRAVEL_MODE ,TRAVEL_STATUS ,PROJECT_MANAGER_STATUS ,DIRECTOR_STATUS ,TRAVEL_LOCATION,EMPLOYEE_ID,DOCUMENT_ID  )VALUES (SEQ_TRAVELLING_REQUEST_DETAILS.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_TTRAVELING_REQUEST_DETAILS_BY_EMP_ID = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE EMPLOYEE_ID=?  ORDER BY TRAVEL_REQUEST_ID";
	private static final String UPDATE_TRAVELING_REQUEST_DETAILS_BY_TRAVEL_REQUEST_ID = "UPDATE TRAVELLING_REQUEST_DETAILS SET TRAVEL_STATUS=?   WHERE TRAVEL_REQUEST_ID = ?";
	private static final String UPDATE_MANAGER_STATUS = "UPDATE TRAVELLING_REQUEST_DETAILS SET PROJECT_MANAGER_STATUS=?   WHERE TRAVEL_REQUEST_ID = ?";
	private static final String UPDATE_DIRECTOR_STATUS = "UPDATE TRAVELLING_REQUEST_DETAILS SET DIRECTOR_STATUS=?,PROJECT_MANAGER_STATUS =?   WHERE TRAVEL_REQUEST_ID = ?";
	private static final String SELECT_ALL_TRAVELINGREQ_FOR_AGENT = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE PROJECT_MANAGER_STATUS  ='APPROVED' ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_TRAVELING_REQUEST_BY_MANAGER_ID = "SELECT *  FROM TRAVELLING_REQUEST_DETAILS WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEE_DETAILS WHERE MANAGER_ID =?) ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_PENDING_TRAVELINGREQUEST_BY_MANAGERID = "SELECT *  FROM TRAVELLING_REQUEST_DETAILS WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEE_DETAILS WHERE MANAGER_ID =?) AND PROJECT_MANAGER_STATUS = 'PENDING' ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_ACCEPT_TRAVELINGREQUEST_BY_MANAGERID = "SELECT *  FROM TRAVELLING_REQUEST_DETAILS WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEE_DETAILS WHERE MANAGER_ID =?) AND PROJECT_MANAGER_STATUS = 'APPROVED' ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_REJECT_TRAVELINGREQUEST_BY_MANAGERID = "SELECT *  FROM TRAVELLING_REQUEST_DETAILS WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEE_DETAILS WHERE MANAGER_ID =?) AND PROJECT_MANAGER_STATUS = 'REJECTED' ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_TRVALING_REQUEST_FOR_DIRECTOR = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE TRAVEL_STATUS='Slab Not Matched'    ORDER BY TRAVEL_REQUEST_ID ";
	private static final String SELECT_ALL_ACCEPTED_TRVALING_REQUEST_FOR_AGENT = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE PROJECT_MANAGER_STATUS='APPROVED'ORDER BY TRAVEL_REQUEST_ID";
	private static final String UPDATE_SAMPLE = "UPDATE TRAVELLING_REQUEST_DETAILS SET TRAVEL_DETAILS_ID =(SELECT MAX(TRAVEL_DETAILS_ID) FROM TRAVELLING_DETAILS)  WHERE TRAVEL_REQUEST_ID = ?";
	private static final String SELECT_ALL_TRAVALING_REQUEST_FOR_AGENT = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE  PROJECT_MANAGER_STATUS ='APPROVED' AND TRAVEL_STATUS= 'APPROVED'ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_PENDING_TRAVALING_REQUEST_FOR_AGENT_ = "SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE  PROJECT_MANAGER_STATUS IN ('APPROVED')  AND TRAVEL_STATUS NOT IN('APPROVED') ORDER BY TRAVEL_REQUEST_ID";
	private static final String SELECT_ALL_MANAGER_TRAVALING_REQUEST_FOR_DIRECTOR_ = "  SELECT * FROM TRAVELLING_REQUEST_DETAILS WHERE EMPLOYEE_ID IN(SELECT EMPLOYEE_ID FROM EMPLOYEE_DETAILS WHERE MANAGER_ID IN(SELECT EMPLOYEE_ID FROM EMPLOYEE_DETAILS WHERE DESIGNATION ='DIRECTOR'))ORDER BY TRAVEL_REQUEST_ID";
	private static final String UPDATE_DOCUMENT_ID = "UPDATE TRAVELLING_REQUEST_DETAILS SET DOCUMENT_ID=(SELECT MAX(DOCUMENT_ID) FROM TRAVEL_DOCUMENTS_DETAILS)   WHERE TRAVEL_REQUEST_ID = ?";
	private static final String UPDATE_DIRECTOR_STATUSA = "UPDATE TRAVELLING_REQUEST_DETAILS SET DIRECTOR_STATUS=? WHERE TRAVEL_REQUEST_ID = ?";

	@Override
	public boolean addTravellingRequestDetails(TravellingRequestDetails travellingRequestDetails) {

		TravelDocumentDetails details = TravelDocumentDetailsRepository.getTravelDocumentDetailForUpdate();
		travellingRequestDetails.setTravelDocumentDetails(details);
		Object[] args = { travellingRequestDetails.getTravelDepartureDate(),
				travellingRequestDetails.getTravelReturnDate(), travellingRequestDetails.getTravelReason(),
				travellingRequestDetails.getTravelMode(), travellingRequestDetails.getTarvelStatus(),
				travellingRequestDetails.getProjectManagerStatus(), travellingRequestDetails.getDirectorStatus(),
				travellingRequestDetails.getTravelLocation(),
				travellingRequestDetails.getEmployeeDetails().getEmployeeDetailsId(),
				travellingRequestDetails.getTravelDocumentDetails().getDocumentId() };
		resultCount = jdbcTemplate.update(INSERT_TRAVELING_REQUEST_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public TravellingRequestDetails getTravellingRequestDetailsBytravelRequestId(int travelRequestId) {
		Object[] args = { travelRequestId };
		TravellingRequestDetails travellingRequestDetails = jdbcTemplate.queryForObject(
				SELECT_SINGLE_TRAVELING_REQUEST_DETAILS_BY_TRAVEL_REQUEST_ID, travlingRequestDetailsRowMapper, args);
		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetails() {
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_TRAVELING_REQUEST_DETAILS, travlingRequestDetailsRowMapper);
		return travellingRequestDetails;
	}

	@Override
	public boolean updateTravellingRequestDetailsBytravelRequestId(TravellingRequestDetails travellingRequestDetails) {

		Object[] args = { travellingRequestDetails.getTarvelStatus(), travellingRequestDetails.getTravelRequestId() };
		resultCount = jdbcTemplate.update(UPDATE_TRAVELING_REQUEST_DETAILS_BY_TRAVEL_REQUEST_ID, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateManagerStatusBytravelRequestId(TravellingRequestDetails travellingRequestDetails) {
		Object[] args = { travellingRequestDetails.getProjectManagerStatus(),
				travellingRequestDetails.getTravelRequestId() };
		resultCount = jdbcTemplate.update(UPDATE_MANAGER_STATUS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateDirectorStatusBytravelRequestId(TravellingRequestDetails travellingRequestDetails) {
		Object[] args = { travellingRequestDetails.getDirectorStatus(), travellingRequestDetails.getDirectorStatus(),
				travellingRequestDetails.getTravelRequestId() };
		resultCount = jdbcTemplate.update(UPDATE_DIRECTOR_STATUS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsByEmployeeId(int employeeId) {
		Object[] args = { employeeId };
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_TTRAVELING_REQUEST_DETAILS_BY_EMP_ID, travlingRequestDetailsRowMapper, args);

		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForAgent() {

		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate.query(SELECT_ALL_TRAVELINGREQ_FOR_AGENT,
				travlingRequestDetailsRowMapper);
		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestByManagerId(int managerId) {
		Object[] args = { managerId };
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_TRAVELING_REQUEST_BY_MANAGER_ID, travlingRequestDetailsRowMapper, args);
		return travellingRequestDetails;

	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingPendingRequestByManagerId(int managerId) {
		Object[] args = { managerId };
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_PENDING_TRAVELINGREQUEST_BY_MANAGERID, travlingRequestDetailsRowMapper, args);

		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingAcceptRequestByManagerId(int managerId) {
		Object[] args = { managerId };
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_ACCEPT_TRAVELINGREQUEST_BY_MANAGERID, travlingRequestDetailsRowMapper, args);

		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRejectedRequestByManagerId(int managerId) {
		Object[] args = { managerId };
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_REJECT_TRAVELINGREQUEST_BY_MANAGERID, travlingRequestDetailsRowMapper, args);

		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForDirector() {
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_TRVALING_REQUEST_FOR_DIRECTOR, travlingRequestDetailsRowMapper);
		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getAllAcceptedTravellingRequestDetailsForAgent() {

		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_ACCEPTED_TRVALING_REQUEST_FOR_AGENT, travlingRequestDetailsRowMapper);
		return travellingRequestDetails;
	}

	@Override
	public boolean insertTravalDetails(TravellingRequestDetails travellingRequestDetails) {
		Object[] args = { travellingRequestDetails.getTravelRequestId() };
		resultCount = jdbcTemplate.update(UPDATE_SAMPLE, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<TravellingRequestDetails> getAllApprovedTravellingRequestForTravelAgent() {
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_TRAVALING_REQUEST_FOR_AGENT, travlingRequestDetailsRowMapper);
		return travellingRequestDetails;

	}

	@Override
	public List<TravellingRequestDetails> getPendingTravellingRequestForTravelAgent() {
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_PENDING_TRAVALING_REQUEST_FOR_AGENT_, travlingRequestDetailsRowMapper);
		return travellingRequestDetails;
	}

	@Override
	public List<TravellingRequestDetails> getManagerTravellingRequestForDirector() {
		List<TravellingRequestDetails> travellingRequestDetails = jdbcTemplate
				.query(SELECT_ALL_MANAGER_TRAVALING_REQUEST_FOR_DIRECTOR_, travlingRequestDetailsRowMapper);
		return travellingRequestDetails;
	}

	@Override
	public boolean updateDirectorStatusBytravelRequestIdForEmployee(TravellingRequestDetails travellingRequestDetails) {
		System.out.println(travellingRequestDetails);
		Object[] args = { travellingRequestDetails.getDirectorStatus(), travellingRequestDetails.getTravelRequestId() };
		resultCount = jdbcTemplate.update(UPDATE_DIRECTOR_STATUSA, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

}
