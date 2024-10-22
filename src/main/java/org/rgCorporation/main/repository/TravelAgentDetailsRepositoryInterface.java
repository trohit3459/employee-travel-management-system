package org.rgCorporation.main.repository;

import java.util.List;

import org.rgCorporation.main.model.TravelAgentDetails;

public interface TravelAgentDetailsRepositoryInterface {

	public TravelAgentDetails getTravalAgentDetailsByAgentId(int agentId);

	public List<TravelAgentDetails> getAllTravalAgentDetails();

}
