package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.TravelAgentDetails;
import org.rgCorporation.main.repository.TravelAgentDetailsRepositoryInterface;

@Service
public class TravalAgentDetailsService implements TravalAgentDetailsServiceInterface {
	@Autowired
	private TravelAgentDetailsRepositoryInterface detailsRepositoryInterface;

	@Override
	public TravelAgentDetails getTravalAgentDetailsByAgentId(int agentId) {
		return detailsRepositoryInterface.getTravalAgentDetailsByAgentId(agentId);
	}

	@Override
	public List<TravelAgentDetails> getAllTravalAgentDetails() {
		return detailsRepositoryInterface.getAllTravalAgentDetails();
	}

}
