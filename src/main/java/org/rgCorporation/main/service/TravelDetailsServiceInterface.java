package org.rgCorporation.main.service;

import java.util.List;

import org.rgCorporation.main.model.TravelDetails;

public interface TravelDetailsServiceInterface {
	public boolean addTravelDetails(TravelDetails travelDetails);

	public boolean updateTravelDetailsByTravelDetailsId(TravelDetails travelDetails);

	public TravelDetails getTravelDetailsByTravelDetailsId(int travelDetailsId);

	public List<TravelDetails> getAllTravelDetails();

}
