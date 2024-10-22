package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.TravelDocumentDetails;

@Service
public class TravelDocumentDetailsService implements TravelDocumentDetailsServiceInterface {
	@Autowired
	private org.rgCorporation.main.repository.TravelDocumentDetailsRepsitoryInterface TravelDocumentDetailsRepsitoryInterface;

	@Override
	public boolean addTravelDocumentDetails(TravelDocumentDetails documentDetails) {
		return TravelDocumentDetailsRepsitoryInterface.addTravelDocumentDetails(documentDetails);
	}

	@Override
	public TravelDocumentDetails getTravelDocumentDetailsByTravelDetailsId(int documentId) {
		return TravelDocumentDetailsRepsitoryInterface.getTravelDocumentDetailsByTravelDetailsId(documentId);
	}

	@Override
	public List<TravelDocumentDetails> getAllTravelDocumentDetails() {
		return TravelDocumentDetailsRepsitoryInterface.getAllTravelDocumentDetails();
	}

}
