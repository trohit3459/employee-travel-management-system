package com.rgcorporation.main.model;

import org.springframework.stereotype.Component;

@Component
public class SlabMaster {

	private int slabId;
	private double slabAmount;
	private String designation;

	public SlabMaster() {
	}

	public SlabMaster(int slabId, double slabAmount, String designation) {
		super();
		this.slabId = slabId;
		this.slabAmount = slabAmount;
		this.designation = designation;
	}

	public int getSlabId() {
		return slabId;
	}

	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}

	public double getSlabAmount() {
		return slabAmount;
	}

	public void setSlabAmount(double slabAmount) {
		this.slabAmount = slabAmount;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "SlabMaster [slabId=" + slabId + ", slabAmount=" + slabAmount + ", designation=" + designation + "]";
	}

	

}
