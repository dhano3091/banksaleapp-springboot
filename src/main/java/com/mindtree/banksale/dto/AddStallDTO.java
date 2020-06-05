package com.mindtree.banksale.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddStallDTO {

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$",message = "Invalid Stall Name")
	private String stallName;
	@NotBlank
	@Pattern(regexp = "^[A-Z0-9-]*$",message = "Invalid Location Code")
	@Size(min=5, max = 5, message = "stallLocation must be of length 5")
	private String stallLocation;
	
	public AddStallDTO() {
		
	}

	public AddStallDTO(String stallName, String stallLocation) {
		super();
		this.stallName = stallName;
		this.stallLocation = stallLocation;
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
		return "AddStallDTO [stallName=" + stallName + ", stallLocation=" + stallLocation + "]";
	}
	
	
}
