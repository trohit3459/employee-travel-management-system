package com.mindgate.main.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mindgate.main.pojo.DocumentDetails;
import com.mindgate.main.pojo.EmployeeDetails;
import com.mindgate.main.pojo.TravelRequestDetails;
import com.mindgate.main.repository.DocumentDetailRepository;
import com.mindgate.main.repository.EmployeeDetailsRepository;

@Component
public final class TravelRequestDetailsRowMapper implements RowMapper<TravelRequestDetails> {

	public TravelRequestDetailsRowMapper() {
		System.out.println("Object Created");
	}

	@Autowired
	private DocumentDetailRepository detailRepository;

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public TravelRequestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("mapRow");
		int travelRequestId = rs.getInt("TRAVEL_REQUEST_ID");
		String travelPurpose = rs.getString("TRAVEL_PURPOSE");
		Date startDate = rs.getDate("TRAVEL_START_DATE");
		LocalDate newStartDate = startDate.toLocalDate();
		Date endDate = rs.getDate("TRAVEL_END_DATE");
		LocalDate newEndDate = endDate.toLocalDate();
		String managerStatus = rs.getString("MANAGER_STATUS");
		String agentStatus = rs.getString("AGENT_STATUS");
		String directorStatus = rs.getString("DIRECTOR_STATUS");
		String destinationFrom = rs.getString("DESTINATION_FROM");
		String destinationTo = rs.getString("DESTINATION_TO");
		int documentId = rs.getInt("DOCUMENT_ID");
		int employeeId = rs.getInt("EMPLOYEE_ID");
		DocumentDetails documentDetails = null;
		if (documentId != 0) {
			documentDetails = detailRepository.getDocumentDetailsById(documentId);
		}
		EmployeeDetails detailsRepository = employeeDetailsRepository.getEmployeeByEmployeeId(employeeId);

		TravelRequestDetails travelRequestDetails = new TravelRequestDetails();
		travelRequestDetails.setTravelRequestId(travelRequestId);
		travelRequestDetails.setTravelPurpose(travelPurpose);
		travelRequestDetails.setStartDate(newStartDate);
		travelRequestDetails.setEndDate(newEndDate);
		travelRequestDetails.setManagerStatus(managerStatus);
		travelRequestDetails.setAgentStatus(agentStatus);
		travelRequestDetails.setDirectorStatus(directorStatus);
		travelRequestDetails.setDestinationFrom(destinationFrom);
		travelRequestDetails.setDestinationTo(destinationTo);
		travelRequestDetails.setDocumentDetails(documentDetails);
		travelRequestDetails.setEmployeeDetails(detailsRepository);
		System.out.println(travelRequestDetails);
		return travelRequestDetails;
	}

}