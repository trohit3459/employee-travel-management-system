package org.rgCorporation.main.repository;

import java.util.List;

import org.rgCorporation.main.model.SlabMaster;

public interface SlabMasterRepositoryInterface {

	public SlabMaster getSlabMasterBySlabMasterId(int slabMasterId);

	public List<SlabMaster> getAllSlabMaster();

}
