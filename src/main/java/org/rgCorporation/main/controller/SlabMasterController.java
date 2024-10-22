package org.rgCorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.rgCorporation.main.model.SlabMaster;
import org.rgCorporation.main.service.SlabMasterServiceInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("slab")
public class SlabMasterController {
	@Autowired
	private SlabMasterServiceInterface masterServiceInterface;
	
	@RequestMapping(value = "slabmaster/{id}", method = RequestMethod.GET)
	public SlabMaster getSlabMasterBySlabMasterId(@PathVariable("id")int slabMasterId)
	{
		return masterServiceInterface.getSlabMasterBySlabMasterId(slabMasterId);
		
	}
	@RequestMapping(value = "slabmaster", method = RequestMethod.GET)
	public List<SlabMaster>getAllSlabMaster()
	{
		return masterServiceInterface.getAllSlabMaster();
		
	}

}
