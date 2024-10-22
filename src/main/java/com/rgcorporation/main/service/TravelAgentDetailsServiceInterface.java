package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.TravelAgentDetails;

public interface TravelAgentDetailsServiceInterface {
//	public boolean addNewTravelAgent(TravelAgentDetails travelAgentDetails);
//    
//    public boolean updateTravelAgent(TravelAgentDetails travelAgentDetails);
//    
//    public boolean deleteTravelAgentByAgentId(int agentId);

	public TravelAgentDetails getAgentDetailsById(int loginId);

	public List<TravelAgentDetails> getAllAgentDetails();

	public TravelAgentDetails getTravelAgentByAgentId(int agentId);
}
