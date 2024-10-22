package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.pojo.TravelRequestDetails;
import com.mindgate.main.repository.TravelAgentDetailsRepositoryInterface;
import com.mindgate.main.repository.TravelRequestDetailsRepositoryInterface;

@Service
public class TravelRequestDetailsService implements TravelRequestDeatilsServiceInterface {

	@Autowired
	TravelRequestDetailsRepositoryInterface travelRequestDetailsRepositoryInterface;

	@Override
	public TravelRequestDetails getTravelRequestDetailsById(int travelRequestId) {

		return travelRequestDetailsRepositoryInterface.getSingleRequestByRequestId(travelRequestId);
	}

	@Override
	public List<TravelRequestDetails> getAllRequestDetails() {
		return travelRequestDetailsRepositoryInterface.getAllRequestDetails();
	}

	@Override
	public boolean addTravelRequest(TravelRequestDetails travelRequestDetails) {
		System.out.println("service request");
		System.out.println(travelRequestDetails);
		return travelRequestDetailsRepositoryInterface.addTravelRequest(travelRequestDetails);
	}

	@Override
	public List<TravelRequestDetails> getAllRequestByEmployeeId(int employeeId) {
		
		return travelRequestDetailsRepositoryInterface.getAllRequestByEmployeeId(employeeId);
	}

	@Override
	public List<TravelRequestDetails> getAllRequestByManagerno(int employeeId) {
		
		return travelRequestDetailsRepositoryInterface.getAllRequestByManagerno(employeeId);
	}

	@Override
	public List<TravelRequestDetails> getAllRequestByManagerStatus() {
		
		return travelRequestDetailsRepositoryInterface.getAllRequestByManagerStatus();
	}

	@Override
	public List<TravelRequestDetails> getAllRejectedRequestByAgent() {
		
		return travelRequestDetailsRepositoryInterface.getAllRejectedRequestByAgent();
	}

	@Override
	public boolean updateTravelRequest(TravelRequestDetails travelRequestDetails) {
		
		return travelRequestDetailsRepositoryInterface.updateTravelRequest(travelRequestDetails);
	}

	@Override
	public List<TravelRequestDetails> getAllApprovedRequestByDirector() {
		
		return travelRequestDetailsRepositoryInterface.getAllApprovedRequestByDirector();
	}

	@Override
	public boolean updateAgentStatusIfRejected(TravelRequestDetails travelRequestDetails) {
		
		return travelRequestDetailsRepositoryInterface.updateAgentStatusIfRejected(travelRequestDetails);
	}

	@Override
	public boolean updateDirectorStatus(TravelRequestDetails travelRequestDetails) {
		
		return travelRequestDetailsRepositoryInterface.updateDirectorStatus(travelRequestDetails);
	}
	@Override
	public boolean deleteTravelRequestByRequestId(int travelRequestId) {
		// TODO Auto-generated method stub
		return travelRequestDetailsRepositoryInterface.deleteTravelRequestByRequestId(travelRequestId);
	}
	
	
}
