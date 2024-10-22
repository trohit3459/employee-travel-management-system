package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.TravelRequestDetails;
import com.rgcorporation.main.service.TravelRequestDeatilsServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("travelRequestDetails")

public class TravelRequestDetailsController {
	@Autowired
	private TravelRequestDeatilsServiceInterface travelRequestDeatilsService;

	@RequestMapping(value = "travelrequest/{id}", method = RequestMethod.GET)
	public @ResponseBody TravelRequestDetails getTravelRequestDetailsById(@PathVariable("id") int travelRequestId) {
		System.out.println("in Travel Request Service Byid");
		return travelRequestDeatilsService.getTravelRequestDetailsById(travelRequestId);
	}

	@RequestMapping(value = "travelrequest", method = RequestMethod.GET)
	public @ResponseBody List<TravelRequestDetails> getProducts() {
		return travelRequestDeatilsService.getAllRequestDetails();
	}
	
	
	@RequestMapping(value = "deletebyrequestid/{travelRequestId}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteTravelRequestByRequestId(@PathVariable int travelRequestId) {
		return travelRequestDeatilsService.deleteTravelRequestByRequestId(travelRequestId);
	}
	
	@RequestMapping(value ="getallrequestbyemployeeid/{employeeId}" , method = RequestMethod.GET)
	public @ResponseBody List<TravelRequestDetails> getAllRequestByEmployeeId(@PathVariable int employeeId){
		return travelRequestDeatilsService.getAllRequestByEmployeeId(employeeId);
	}
	
	

	@RequestMapping(value = "travelrequest", method = RequestMethod.POST)
	public @ResponseBody boolean addTravelRequest(@RequestBody TravelRequestDetails travelRequestDetails) {
		System.out.println(travelRequestDetails);
		System.out.println("in add travel request");
		return travelRequestDeatilsService.addTravelRequest(travelRequestDetails);
	}
	
	@RequestMapping(value = "getallrequestbymanagerno/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<TravelRequestDetails> getAllRequestByManagerno(@PathVariable int employeeId){
		System.out.println("in controller manger no");
		return travelRequestDeatilsService.getAllRequestByManagerno(employeeId);
	}
	
	@RequestMapping(value = "getallapprovedrequests", method = RequestMethod.GET)
	public @ResponseBody List<TravelRequestDetails> getAllRequestByManagerStatus(){
		return travelRequestDeatilsService.getAllRequestByManagerStatus();
	}
	
	@RequestMapping(value = "getallrefusedrequests" , method = RequestMethod.GET)
	public @ResponseBody List<TravelRequestDetails> getAllRejectedRequestByAgent(){
		return travelRequestDeatilsService.getAllRejectedRequestByAgent();
	}
	
	@RequestMapping(value = "updaterequest", method = RequestMethod.PUT)
	public @ResponseBody boolean updateTravelRequest(@RequestBody TravelRequestDetails travelRequestDetails) {
		System.out.println("in controller");
		System.out.println(travelRequestDetails);
		return travelRequestDeatilsService.updateTravelRequest(travelRequestDetails);
	}
	
	@RequestMapping (value = "approvedrequestbydirector" , method = RequestMethod.GET)
	public @ResponseBody List<TravelRequestDetails> getAllApprovedRequestByDirector(){
		return travelRequestDeatilsService.getAllApprovedRequestByDirector();
	}
	
	@RequestMapping (value = "updateagentstatusifrejected" , method = RequestMethod.PUT)
	public @ResponseBody boolean updateAgentStatusIfRejected(@RequestBody TravelRequestDetails travelRequestDetails) {
		return travelRequestDeatilsService.updateAgentStatusIfRejected(travelRequestDetails);
	}
	
	@RequestMapping(value = "updatedirectorstatus" , method = RequestMethod.PUT)
	public @ResponseBody boolean updateDirectorStatus(@RequestBody TravelRequestDetails travelRequestDetails) {
		System.out.println(travelRequestDetails);
		return travelRequestDeatilsService.updateDirectorStatus(travelRequestDetails);
	}
}
