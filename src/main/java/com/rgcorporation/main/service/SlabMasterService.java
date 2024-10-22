package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.SlabMaster;
import com.rgcorporation.main.repository.SlabMasterRepositoryInterface;
@Service
public class SlabMasterService implements SlabMasterServiceInterface {

	@Autowired
   private SlabMasterRepositoryInterface slabMasterRepository;
//	@Override
//	public boolean addSlabMasterDetails(SlabMaster slabMaster) {
//		return slabMasterRepository.addSlabMasterDetails(slabMaster);
//	}
//
//	@Override
//	public boolean updateSlabMasterDetails(SlabMaster slabMaster) {
//		return slabMasterRepository.updateSlabMasterDetails(slabMaster);
//	}
//
//	@Override
//	public boolean deleteSlabBySlabId(int slabId) {
//		return slabMasterRepository.deleteSlabBySlabId(slabId);
//	}

	@Override
	public SlabMaster getSlabBySlabId(int slabId) {
		return slabMasterRepository.getSlabBySlabId(slabId);
	}

	@Override
	public List<SlabMaster> getAllSlabs() {
		return slabMasterRepository.getAllSlabs();
	}

}
