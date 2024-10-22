package org.rgCorporation.main.service;

import java.util.List;

import org.rgCorporation.main.model.SlabMaster;

public interface SlabMasterServiceInterface {

	public SlabMaster getSlabMasterBySlabMasterId(int slabMasterId);

	public List<SlabMaster> getAllSlabMaster();
}
