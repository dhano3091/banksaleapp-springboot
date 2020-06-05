package com.mindtree.banksale.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateStallDTO {

	@NotNull
	private long stallId;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "Invalid Stall Name")
	private String stallName;
	@NotBlank
	@Pattern(regexp = "^[A-Z0-9-]*$", message = "Invalid Location Code")
	@Size(min = 5, max = 5, message = "stallLocation must be of length 5")
	private String stallLocation;

	public UpdateStallDTO() {

	}

	public UpdateStallDTO(
			@NotBlank @Pattern(regexp = "^[1-9]{1}$|^[1-4]{1}[0-9]{1}$|^500$", message = "Invalid stall Id") long stallId,
			@NotBlank @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "Invalid Stall Name") String stallName,
			@NotBlank @Pattern(regexp = "^[A-Z0-9-]*$", message = "Invalid Location Code") @Size(min = 5, max = 5, message = "stallLocation must be of length 5") String stallLocation) {
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
		return "UpdateStallDTO [stallId=" + stallId + ", stallName=" + stallName + ", stallLocation=" + stallLocation
				+ "]";
	}

}
