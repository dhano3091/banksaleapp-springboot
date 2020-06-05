package com.mindtree.banksale.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class ParticipantDTO {

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\-' ]*[a-zA-Z ]$", message = "Invalid participant name")
	private String participantName;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\-' ]*[a-zA-Z ]$", message = "Invalid product name")
	private String productName;
	@NotNull
	private long stallId;
	
	public ParticipantDTO() {
		
	}

	public ParticipantDTO(
			@NotBlank @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\-' ]*[a-zA-Z ]$", message = "Invalid participant name") String participantName,
			@NotBlank @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\-' ]*[a-zA-Z ]$", message = "Invalid product name") String productName,
			@NotBlank @Pattern(regexp = "^[1-9]{1}$|^[1-4]{1}[0-9]{1}$|^500$", message = "Invalid stall Id") long stallId) {
		super();
		this.participantName = participantName;
		this.productName = productName;
		this.stallId = stallId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getStallId() {
		return stallId;
	}

	public void setStallId(long stallId) {
		this.stallId = stallId;
	}

	@Override
	public String toString() {
		return "ParticipantDTO [participantName=" + participantName + ", productName=" + productName + ", stallId="
				+ stallId + "]";
	}
	
	
}
