package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.TravelAgentDetails;
import com.rgcorporation.main.service.TravelAgentDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("travelAgentDetails")
public class TravelAgentDetailsController
{
	@Autowired
	private TravelAgentDetailsServiceInterface travelAgentDetailsService;

	@RequestMapping(value = "travelagent/{loginId}", method = RequestMethod.GET)
	public @ResponseBody TravelAgentDetails getTravelAgentDetailsById(@PathVariable int loginId) {

		System.out.println("in TravelAgentDetails service Byid");
		return travelAgentDetailsService.getAgentDetailsById(loginId);

	}

	@RequestMapping(value = "travelagent", method = RequestMethod.GET)
	public @ResponseBody List<TravelAgentDetails> getProducts() {
		return travelAgentDetailsService.getAllAgentDetails();
	}
	
	@RequestMapping(value = "agentdetailsbyagentid" , method = RequestMethod.GET)
	public @ResponseBody TravelAgentDetails getTravelAgentByAgentId(@PathVariable int agentId) {
		return travelAgentDetailsService.getTravelAgentByAgentId(agentId);
	}

}
