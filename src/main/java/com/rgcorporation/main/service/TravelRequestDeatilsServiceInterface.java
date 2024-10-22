package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.TravelRequestDetails;


public interface TravelRequestDeatilsServiceInterface {
//public boolean addNewTravelAgent(TravelAgentDetails travelAgentDetails);
//    
	public boolean updateTravelRequest(TravelRequestDetails travelRequestDetails);
//    
//    public boolean deleteTravelAgentByAgentId(int agentId);
    
    public TravelRequestDetails getTravelRequestDetailsById(int travelRequestId);
    
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
