package org.rgCorporation.main.model;

public class SlabMaster {
	private int slabMasterId;
	private String designation;
	private int slab;
	private String travelMode;
	public SlabMaster() {
		
	}
	public SlabMaster(int slabMasterId, String designation, int slab, String travelMode) {
		super();
		this.slabMasterId = slabMasterId;
		this.designation = designation;
		this.slab = slab;
		this.travelMode = travelMode;
	}
	public int getSlabMasterId() {
		return slabMasterId;
	}
	public void setSlabMasterId(int slabMasterId) {
		this.slabMasterId = slabMasterId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSlab() {
		return slab;
	}
	public void setSlab(int slab) {
		this.slab = slab;
	}
	public String getTravelMode() {
		return travelMode;
	}
	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}
	@Override
	public String toString() {
		return "SlabMaster [slabMasterId=" + slabMasterId + ", designation=" + designation + ", slab=" + slab
				+ ", travelMode=" + travelMode + "]";
	}
	
	
	
}