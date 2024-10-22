	package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.rgCorporation.main.model.TravellingRequestDetails;

public interface TravlingRequestDetailsServiceInterface {
	public boolean addTravellingRequestDetails(TravellingRequestDetails travellingRequestDetails);

	public List<TravellingRequestDetails> getManagerTravellingRequestForDirector();

	public List<TravellingRequestDetails> getAllApprovedTravellingRequestForTravelAgent();

	public List<TravellingRequestDetails> getPendingTravellingRequestForTravelAgent();

	public boolean insertTravalDetails(TravellingRequestDetails travellingRequestDetails);

	public List<TravellingRequestDetails> getAllAcceptedTravellingRequestDetailsForAgent();

	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForDirector();

	public List<TravellingRequestDetails> getAllTravellingPendingRequestByManagerId(int managerId);

	public List<TravellingRequestDetails> getAllTravellingAcceptRequestByManagerId(int managerId);

	public List<TravellingRequestDetails> getAllTravellingRejectedRequestByManagerId(int managerId);

	public TravellingRequestDetails getTravellingRequestDetailsBytravelRequestId(int travelRequestId);

	public List<TravellingRequestDetails> getAllTravellingRequestDetails();

	public boolean updateTravellingRequestDetailsByTravelRequestId(TravellingRequestDetails travellingRequestDetails);

	public boolean updateManagerStatusByTravelRequestId(TravellingRequestDetails travellingRequestDetails);

	public boolean updateDirectorStatusByTravelRequestId(TravellingRequestDetails travellingRequestDetails);

	public List<TravellingRequestDetails> getAllTravellingRequestDetailsByEmployeeId(int employeeId);

	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForaAgent();

	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForAgent();

	public List<TravellingRequestDetails> getAllTravellingRequestByManagerId(int managerId);


}
