package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.pojo.TravelAgentDetails;
import com.mindgate.main.repository.TravelAgentDetailsRepositoryInterface;

@Service
public class TravelAgentDetailsService  implements TravelAgentDetailsServiceInterface{
	
	@Autowired
	private TravelAgentDetailsRepositoryInterface travelAgentDetailsRepository;
//	@Override
//	public boolean addNewTravelAgent(TravelAgentDetails travelAgentDetails) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean updateTravelAgent(TravelAgentDetails travelAgentDetails) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean deleteTravelAgentByAgentId(int agentId) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public TravelAgentDetails getAgentDetailsById(int loginId) {
		// TODO Auto-generated method stub
		return travelAgentDetailsRepository.getAgentDetailsById(loginId);
	}

	@Override
	public List<TravelAgentDetails> getAllAgentDetails() {
		// TODO Auto-generated method stub
		return travelAgentDetailsRepository.getAllAgentDetails();
	}
	
	@Override
	public TravelAgentDetails getTravelAgentByAgentId(int agentId) {
		
		return travelAgentDetailsRepository.getTravelAgentByAgentId(agentId);
	}


}
