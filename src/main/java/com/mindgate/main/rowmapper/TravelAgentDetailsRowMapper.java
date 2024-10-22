package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mindgate.main.pojo.LoginDetails;
import com.mindgate.main.pojo.TravelAgentDetails;
import com.mindgate.main.repository.LoginDetailsRepository;

@Component
public final class TravelAgentDetailsRowMapper implements RowMapper<TravelAgentDetails> {

		@Autowired
		private LoginDetailsRepository loginDetailsRepository;
		
		@Override
		public TravelAgentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			int agentId =rs.getInt("AGENT_ID");
			int loginId= rs.getInt("LOGIN_ID");
			LoginDetails loginDetails = loginDetailsRepository.getLoginDetailsById(loginId);
			String agentName=rs.getString("AGENT_NAME");
			
			TravelAgentDetails travelAgentDetails=new TravelAgentDetails();
			
			travelAgentDetails.setAgentId(agentId);
			travelAgentDetails.setLoginDetails(loginDetails);
			travelAgentDetails.setAgentName(agentName);
			return travelAgentDetails;
		}

	}