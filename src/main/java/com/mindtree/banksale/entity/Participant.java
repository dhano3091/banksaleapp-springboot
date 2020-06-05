package com.mindtree.banksale.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long participantId;
	
	private String participantName;
	private String productPurchased;
	@ManyToOne(fetch = FetchType.LAZY)
	private Stall stall;
	
	public Participant() {
		
	}

	public Participant(long participantId, String participantName, String productPurchased, Stall stall) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.productPurchased = productPurchased;
		this.stall = stall;
	}

	public long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getProductPurchased() {
		return productPurchased;
	}

	public void setProductPurchased(String productPurchased) {
		this.productPurchased = productPurchased;
	}

	public Stall getStall() {
		return stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", participantName=" + participantName
				+ ", productPurchased=" + productPurchased + ", stall=" + stall + "]";
	}
	
	
    
}
