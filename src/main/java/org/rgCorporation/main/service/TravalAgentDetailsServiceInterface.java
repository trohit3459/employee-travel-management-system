package org.rgCorporation.main.service;

import java.util.List;

import org.rgCorporation.main.model.TravelAgentDetails;

public interface TravalAgentDetailsServiceInterface {

	public TravelAgentDetails getTravalAgentDetailsByAgentId(int agentId);

	public List<TravelAgentDetails> getAllTravalAgentDetails();

}
