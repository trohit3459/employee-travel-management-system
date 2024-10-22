package org.rgCorporation.main.repository;

import java.util.List;

import org.rgCorporation.main.model.TravelDocumentDetails;

public interface TravelDocumentDetailsRepsitoryInterface {
	public boolean addTravelDocumentDetails(TravelDocumentDetails documentDetails);

	public TravelDocumentDetails getTravelDocumentDetailsByTravelDetailsId(int documentId);

	public List<TravelDocumentDetails> getAllTravelDocumentDetails();

}
