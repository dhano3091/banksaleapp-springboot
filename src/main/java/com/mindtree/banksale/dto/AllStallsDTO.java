package com.mindtree.banksale.dto;

public class AllStallsDTO {

	private long stallId;
	private String stallName;
	private String stallLocation;
	
	public AllStallsDTO() {
		
	}

	public AllStallsDTO(long stallId, String stallName, String stallLocation) {
		super();
		this.stallId = stallId;
		this.stallName = stallName;
		this.stallLocation = stallLocation;
	}

	public long getStallId() {
		return stallId;
	}

	public void setStallId(long stallId) {
		this.stallId = stallId;
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public String getStallLocation() {
		return stallLocation;
	}

	public void setStallLocation(String stallLocation) {
		this.stallLocation = stallLocation;
	}

	@Override
	public String toString() {
		return "AllStallsDTO [stallId=" + stallId + ", stallName=" + stallName + ", stallLocation=" + stallLocation
				+ "]";
	}

	
	
	
}
