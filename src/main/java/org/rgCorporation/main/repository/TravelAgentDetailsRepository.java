package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.TravelAgentDetails;

@Repository
public class TravelAgentDetailsRepository implements TravelAgentDetailsRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TravelAgentDetailsRowMaster agentDetailRowMaster;

	private static final String SELECT_ALL_TravalAgentDetails = "SELECT * FROM TRAVEL_AGENT_DETAILS";
	private static final String SELECT_SINGLE_TravalAgentDetails = "SELECT * FROM TRAVEL_AGENT_DETAILS WHERE TRAVLE_AGENT_ID = ?";

	private int resultCount;

	@Override
	public TravelAgentDetails getTravalAgentDetailsByAgentId(int agentId) {
		Object[] args = { agentId };
		TravelAgentDetails travalAgentDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_TravalAgentDetails,
				agentDetailRowMaster, args);
		return travalAgentDetails;
	}

	@Override
	public List<TravelAgentDetails> getAllTravalAgentDetails() {
		List<TravelAgentDetails> travalAgentDetails = jdbcTemplate.query(SELECT_ALL_TravalAgentDetails,
				agentDetailRowMaster);
		return travalAgentDetails;
	}

}
