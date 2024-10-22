package org.rgCorporation.main.model;




public class TravelAgentDetails {
	private int agentId;
	private String travelAgentName;
	SlabMaster slabMaster;
	LoginDetails loginDetails;
	
	public TravelAgentDetails() {
		// TODO Auto-generated constructor stub
	}

	public TravelAgentDetails(int agentId, String travelAgentName, SlabMaster slabMaster, LoginDetails loginDetails) {
		super();
		this.agentId = agentId;
		this.travelAgentName = travelAgentName;
		this.slabMaster = slabMaster;
		this.loginDetails = loginDetails;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getTravelAgentName() {
		return travelAgentName;
	}

	public void setTravelAgentName(String travelAgentName) {
		this.travelAgentName = travelAgentName;
	}

	public SlabMaster getSlabMaster() {
		return slabMaster;
	}

	public void setSlabMaster(SlabMaster slabMaster) {
		this.slabMaster = slabMaster;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	@Override
	public String toString() {
		return "TravalAgentDetails [agentId=" + agentId + ", travelAgentName=" + travelAgentName + ", slabMaster="
				+ slabMaster + ", loginDetails=" + loginDetails + "]";
	}
	
	

}
