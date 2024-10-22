package org.rgCorporation.main.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.EmployeeDetails;
import org.rgCorporation.main.model.TravelDetails;
import org.rgCorporation.main.model.TravelDocumentDetails;
import org.rgCorporation.main.model.TravellingRequestDetails;

@Repository
@Scope("prototype")
public class TravlingRequestDetailsRowMapper implements RowMapper<TravellingRequestDetails>{
    @Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired 
    private TravelDocumentDetailsRepository detailsRepository;
    @Autowired 
    private TravelDetailsRepository travelDetailsRepository;
	@Override
	public TravellingRequestDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		int travelRequestId = resultSet.getInt("TRAVEL_REQUEST_ID");
		LocalDate localDate = resultSet.getDate("TRAVEL_DEPARTURE_DATE").toLocalDate();
		LocalDate localDate1 = resultSet.getDate("TRAVEL_RETURN_DATE").toLocalDate();
		String travelReason = resultSet.getString("TRAVEL_REASON");
		String vtravelMode = resultSet.getString("TRAVEL_MODE");
		String tarvelStatus = resultSet.getString("TRAVEL_STATUS");
		String projectManagerStatus = resultSet.getString("PROJECT_MANAGER_STATUS");
		String directorStatus = resultSet.getString("DIRECTOR_STATUS");
		String travelLocation = resultSet.getString("TRAVEL_LOCATION");
	      int	employeeDetailsId = resultSet.getInt("EMPLOYEE_ID");
		EmployeeDetails employeeDetails=null;
		if(employeeDetailsId !=0 )
		{
		employeeDetails=employeeDetailsRepository.getEmployeeDetailsByEmployeeDetailsId(employeeDetailsId);
		}
		int travelDetailsId =  resultSet.getInt("TRAVEL_DETAILS_ID");
		TravelDetails travelDetails =null;
		if(travelDetailsId!=0)
		{
		 travelDetails =travelDetailsRepository.getTravelDetailsByTravelDetailsId(travelDetailsId);
		}
		int documentId = resultSet.getInt("DOCUMENT_ID");
		TravelDocumentDetails travelDocumentDetails=null;
		if(documentId!=0)
		{
		 travelDocumentDetails =detailsRepository.getTravelDocumentDetailsByTravelDetailsId(documentId);
		}
		TravellingRequestDetails travellingRequestDetails=new TravellingRequestDetails(travelRequestId, localDate, localDate1, travelReason, vtravelMode, tarvelStatus, projectManagerStatus, directorStatus, travelLocation, employeeDetails, travelDetails, travelDocumentDetails);
		return travellingRequestDetails;
	}
}
