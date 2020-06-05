package com.mindtree.banksale.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Stall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stallId;
	private String stallName;
	private String stallLocation;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "stall")
	private List<Participant> participantList;

	public Stall() {

	}

	public Stall(long stallId, String stallName, String stallLocation, List<Participant> participantList) {
		super();
		this.stallId = stallId;
		this.stallName = stallName;
		this.stallLocation = stallLocation;
		this.participantList = participantList;
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

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}

	@Override
	public String toString() {
		return "Stall [stallId=" + stallId + ", stallName=" + stallName + ", stallLocation=" + stallLocation
				+ ", participantList=" + participantList + "]";
	}

}
