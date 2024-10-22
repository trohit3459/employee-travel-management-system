package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.rgCorporation.main.model.TravellingRequestDetails;

public interface TravlingRequestDetailsRepositoryInterface {
	public boolean addTravellingRequestDetails(TravellingRequestDetails travellingRequestDetails);
    
	public boolean insertTravalDetails( TravellingRequestDetails travellingRequestDetails);

	
	public List<TravellingRequestDetails> getManagerTravellingRequestForDirector();
	
	public List<TravellingRequestDetails> getAllAcceptedTravellingRequestDetailsForAgent(); 
	
	public List<TravellingRequestDetails> getAllApprovedTravellingRequestForTravelAgent();
	public List<TravellingRequestDetails> getPendingTravellingRequestForTravelAgent();


	
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForDirector();   
	public List<TravellingRequestDetails> getAllTravellingPendingRequestByManagerId( int managerId);
	public List<TravellingRequestDetails> getAllTravellingAcceptRequestByManagerId(int managerId);
	public List<TravellingRequestDetails> getAllTravellingRejectedRequestByManagerId(int managerId);  


	
	public TravellingRequestDetails getTravellingRequestDetailsBytravelRequestId(int travelRequestId);
	public List<TravellingRequestDetails> getAllTravellingRequestDetails();
	
	
	public boolean updateTravellingRequestDetailsBytravelRequestId(TravellingRequestDetails travellingRequestDetails);
	public boolean updateManagerStatusBytravelRequestId(TravellingRequestDetails travellingRequestDetails);
	public boolean updateDirectorStatusBytravelRequestId(TravellingRequestDetails travellingRequestDetails);
	
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsByEmployeeId(int employeeId);
	
	
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForAgent();
	public List<TravellingRequestDetails> getAllTravellingRequestByManagerId(int managerId);
	
	public boolean updateDirectorStatusBytravelRequestIdForEmployee(TravellingRequestDetails travellingRequestDetails);

	
	//public boolean updateManagerStatusByTravelRequestIdForManager(TravellingRequestDetails travellingRequestDetails);
	


}
