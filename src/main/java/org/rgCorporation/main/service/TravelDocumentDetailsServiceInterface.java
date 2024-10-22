package org.rgCorporation.main.service;

import java.util.List;

import org.rgCorporation.main.model.TravelDocumentDetails;

public interface TravelDocumentDetailsServiceInterface {

	public boolean addTravelDocumentDetails(TravelDocumentDetails documentDetails);

	public TravelDocumentDetails getTravelDocumentDetailsByTravelDetailsId(int documentId);

	public List<TravelDocumentDetails> getAllTravelDocumentDetails();

}
