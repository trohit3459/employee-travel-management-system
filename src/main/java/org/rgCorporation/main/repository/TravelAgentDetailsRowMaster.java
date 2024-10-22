package org.rgCorporation.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.LoginDetails;
import org.rgCorporation.main.model.SlabMaster;
import org.rgCorporation.main.model.TravelAgentDetails;

@Repository
@Scope("prototype")

public class TravelAgentDetailsRowMaster implements RowMapper<TravelAgentDetails> {

	@Autowired
	private LoginDetailsRepository loginDetailsRepository;
	@Autowired
	private SlabMasterRepository masterRepository;

	@Override
	public TravelAgentDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		int agentId = resultSet.getInt("TRAVLE_AGENT_ID");
		String travelAgentName = resultSet.getString("TRAVEL_AGENT_NAME");

		int slabMasterId = resultSet.getInt("SLAB_MASTER_ID");
		SlabMaster slabMaster = masterRepository.getSlabMasterBySlabMasterId(slabMasterId);
		int loginId = resultSet.getInt("LOGIN_ID");
		LoginDetails loginDetails = loginDetailsRepository.getLoginDetailsByLoginId(loginId);

		TravelAgentDetails travalAgentDetails = new TravelAgentDetails(agentId, travelAgentName, slabMaster,
				loginDetails);
		return travalAgentDetails;

	}

}
