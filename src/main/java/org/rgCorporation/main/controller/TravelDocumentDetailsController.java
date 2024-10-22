package org.rgCorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.rgCorporation.main.model.TravelDocumentDetails;
import org.rgCorporation.main.service.TravelDocumentDetailsServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("documentdetails")
public class TravelDocumentDetailsController {
	@Autowired
	private TravelDocumentDetailsServiceInterface travelDocumentDetails;

	@RequestMapping(value = "documentdetail", method = RequestMethod.POST)
	public boolean addTravelDocumentDetails(@RequestBody TravelDocumentDetails TravelDocumentDetails) {
		return travelDocumentDetails.addTravelDocumentDetails(TravelDocumentDetails);

	}

	@RequestMapping(value = "documentdetail/{id}", method = RequestMethod.GET)

	public TravelDocumentDetails getTravelDocumentDetailsByTravelDetailsId(@PathVariable("id") int documentId) {
		return travelDocumentDetails.getTravelDocumentDetailsByTravelDetailsId(documentId);

	}

	@RequestMapping(value = "documentdetail", method = RequestMethod.GET)

	public List<TravelDocumentDetails> getAllTravelDocumentDetails() {
		return travelDocumentDetails.getAllTravelDocumentDetails();

	}
}
