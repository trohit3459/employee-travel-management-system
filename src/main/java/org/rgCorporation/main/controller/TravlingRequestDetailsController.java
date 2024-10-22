package org.rgCorporation.main.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.rgCorporation.main.model.TravellingRequestDetails;
import org.rgCorporation.main.service.TravlingRequestDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("travlingrequests")
public class TravlingRequestDetailsController {
	@Autowired
	private TravlingRequestDetailsServiceInterface detailsServiceInterface;

	@RequestMapping(value = "allmanagerrequestfordirector", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getManagerTravellingRequestForDirector() {
		return detailsServiceInterface.getManagerTravellingRequestForDirector();
	}

	@RequestMapping(value = "pendingtravlingrequestsforagent", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getPendingTravellingRequestForTravelAgent() {
		return detailsServiceInterface.getPendingTravellingRequestForTravelAgent();
	}

	@RequestMapping(value = "travlingrequestsforagent", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllApprovedTravellingRequestForTravelAgent() {
		return detailsServiceInterface.getAllApprovedTravellingRequestForTravelAgent();

	}

	@RequestMapping(value = "inserttravaldetail", method = RequestMethod.PUT)
	public boolean insertTravalDetails(@RequestBody TravellingRequestDetails travellingRequestDetails) {
		return detailsServiceInterface.insertTravalDetails(travellingRequestDetails);
	}

	@RequestMapping(value = "acceptedrequestsforagent", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllAcceptedTravellingRequestDetailsForAgent() {
		return detailsServiceInterface.getAllAcceptedTravellingRequestDetailsForAgent();

	}

	@RequestMapping(value = "requestsfordirector", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForDirector() {
		return detailsServiceInterface.getAllTravellingRequestDetailsForDirector();

	}

	@RequestMapping(value = "pendingtravlingrequeststatus/{id}", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingPendingRequestByManagerId(@PathVariable("id") int managerId) {
		return detailsServiceInterface.getAllTravellingPendingRequestByManagerId(managerId);
	}

	@RequestMapping(value = "accepttravlingrequeststatus/{id}", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingAcceptRequestByManagerId(@PathVariable("id") int managerId) {
		return detailsServiceInterface.getAllTravellingAcceptRequestByManagerId(managerId);
	}

	@RequestMapping(value = "rejecttravlingrequeststatus/{id}", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingRejectedRequestByManagerId(
			@PathVariable("id") int managerId) {
		return detailsServiceInterface.getAllTravellingRejectedRequestByManagerId(managerId);
	}

	@RequestMapping(value = "requestsformanager/{id}", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingRequestByManagerId(@PathVariable("id") int managerId)

	{
		return detailsServiceInterface.getAllTravellingRequestByManagerId(managerId);

	}

	@RequestMapping(value = "requestsforagent", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForAgent()

	{
		return detailsServiceInterface.getAllTravellingRequestDetailsForAgent();

	}

	@RequestMapping(value = "requestsbyemployeeid/{id}", method = RequestMethod.GET)
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsByEmployeeId(
			@PathVariable("id") int employeeId) {
		return detailsServiceInterface.getAllTravellingRequestDetailsByEmployeeId(employeeId);

	}

	@RequestMapping(value = "updatemanager", method = RequestMethod.PUT)
	public boolean updateManagerStatusByTravelRequestId(
			@RequestBody TravellingRequestDetails travellingRequestDetails) {
		return detailsServiceInterface.updateManagerStatusByTravelRequestId(travellingRequestDetails);
	}

	@RequestMapping(value = "updatedirector", method = RequestMethod.PUT)
	public boolean updateDirectorStatusByTravelRequestId(
			@RequestBody TravellingRequestDetails travellingRequestDetails) {
		return detailsServiceInterface.updateDirectorStatusByTravelRequestId(travellingRequestDetails);
	}

	@RequestMapping(value = "travlingrequest", method = RequestMethod.POST)
	public boolean addTravellingRequestDetails(@RequestBody TravellingRequestDetails travellingRequestDetails) {
		
		return detailsServiceInterface.addTravellingRequestDetails(travellingRequestDetails);
	}

	@RequestMapping(value = "travlingrequest/{id}", method = RequestMethod.GET)

	public TravellingRequestDetails getTravellingRequestDetailsBytravelRequestId(
			@PathVariable("id") int travelRequestId) {
		return detailsServiceInterface.getTravellingRequestDetailsBytravelRequestId(travelRequestId);

	}

	@RequestMapping(value = "travlingrequest", method = RequestMethod.GET)

	public List<TravellingRequestDetails> getAllTravellingRequestDetails() {
		return detailsServiceInterface.getAllTravellingRequestDetails();

	}

	@RequestMapping(value = "travlingrequest", method = RequestMethod.PUT)

	public boolean updateTravellingRequestDetailsByTravelRequestId(
			@RequestBody TravellingRequestDetails travellingRequestDetails) {
		return detailsServiceInterface.updateTravellingRequestDetailsByTravelRequestId(travellingRequestDetails);

	}


}
