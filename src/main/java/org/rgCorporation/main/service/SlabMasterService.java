package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.SlabMaster;
import org.rgCorporation.main.repository.SlabMasterRepositoryInterface;

@Service
public class SlabMasterService implements SlabMasterServiceInterface {
	@Autowired
	private SlabMasterRepositoryInterface masterRepositoryInterface;

	@Override
	public SlabMaster getSlabMasterBySlabMasterId(int slabMasterId) {
		return masterRepositoryInterface.getSlabMasterBySlabMasterId(slabMasterId);
	}

	@Override
	public List<SlabMaster> getAllSlabMaster() {
		return masterRepositoryInterface.getAllSlabMaster();
	}

}
