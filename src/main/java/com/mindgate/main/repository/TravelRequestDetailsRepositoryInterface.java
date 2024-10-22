package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.pojo.TravelAgentDetails;
import com.mindgate.main.pojo.TravelRequestDetails;

public interface TravelRequestDetailsRepositoryInterface {
	
//	    public boolean addNewTravelAgent(TravelRequest travelRequest);
//	     
	    public boolean updateTravelRequest(TravelRequestDetails travelRequestDetails);
//	     
//	    public boolean deleteTravelAgentByAgentId(int agentId);
	     
	    public TravelRequestDetails getSingleRequestByRequestId(int travelRequestId);
	     
	    public List<TravelRequestDetails> getAllRequestDetails();
	    
	    public boolean addTravelRequest(TravelRequestDetails travelRequestDetails);
	    
	    public List<TravelRequestDetails> getAllRequestByEmployeeId(int employeeId);
	    
	    public List<TravelRequestDetails> getAllRequestByManagerno(int employeeId);
	    
	    public List<TravelRequestDetails> getAllRequestByManagerStatus();
	    
	    public List<TravelRequestDetails> getAllRejectedRequestByAgent();
	    
	    public List<TravelRequestDetails> getAllApprovedRequestByDirector();
	    
	    public boolean updateAgentStatusIfRejected(TravelRequestDetails travelRequestDetails);
	    
	    public boolean updateDirectorStatus(TravelRequestDetails travelRequestDetails);
	    
	    public boolean deleteTravelRequestByRequestId(int travelRequestId);
	    
	    
	}
