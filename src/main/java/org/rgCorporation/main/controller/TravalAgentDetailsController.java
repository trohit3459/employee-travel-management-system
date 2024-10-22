package org.rgCorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.rgCorporation.main.model.TravelAgentDetails;
import org.rgCorporation.main.service.TravalAgentDetailsServiceInterface;


@RestController
@CrossOrigin(origins ="*")
@RequestMapping("agentdetails")
public class TravalAgentDetailsController {
	
	@Autowired
	private TravalAgentDetailsServiceInterface detailsServiceInterface;
	
	@RequestMapping(value = "agentdetail/{id}", method = RequestMethod.GET)
	public TravelAgentDetails getTravalAgentDetailsByAgentId(@PathVariable("id") int agentId)
	{
		return detailsServiceInterface.getTravalAgentDetailsByAgentId(agentId);
		
	}
	@RequestMapping(value = "agentdetail", method = RequestMethod.GET)
	public List<TravelAgentDetails>getAllTravalAgentDetails()
	{
		return detailsServiceInterface.getAllTravalAgentDetails();
		
	}

}
