package com.mindgate.main.pojo;

import org.springframework.stereotype.Component;
@Component
public class TravelAgentDetails {

	private int agentId;
	private LoginDetails loginDetails;
	private String agentName;

	public TravelAgentDetails() {
	}

	public TravelAgentDetails(int agentId, LoginDetails loginDetails, String agentName) {
		super();
		this.agentId = agentId;
		this.loginDetails = loginDetails;
		this.agentName = agentName;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@Override
	public String toString() {
		return "TravelAgentDetails [agentId=" + agentId + ", loginDetails=" + loginDetails + ", agentName=" + agentName
				+ "]";
	}
    

}
