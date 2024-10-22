package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.TravelDetails;
import org.rgCorporation.main.repository.TravelDetailsRepositoryInterface;

@Service
public class TravelDetailsService implements TravelDetailsServiceInterface {
	@Autowired
	private TravelDetailsRepositoryInterface travelDetailsRepositoryInterface;

	@Override
	public boolean addTravelDetails(TravelDetails travelDetails) {
		return travelDetailsRepositoryInterface.addTravelDetails(travelDetails);
	}

	@Override
	public boolean updateTravelDetailsByTravelDetailsId(TravelDetails travelDetails) {
		return travelDetailsRepositoryInterface.updateTravelDetailsByTravelDetailsId(travelDetails);
	}

	@Override
	public TravelDetails getTravelDetailsByTravelDetailsId(int travelDetailsId) {
		return travelDetailsRepositoryInterface.getTravelDetailsByTravelDetailsId(travelDetailsId);
	}

	@Override
	public List<TravelDetails> getAllTravelDetails() {
		return travelDetailsRepositoryInterface.getAllTravelDetails();
	}

}
