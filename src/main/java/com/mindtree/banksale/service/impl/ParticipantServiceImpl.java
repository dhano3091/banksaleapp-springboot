package com.mindtree.banksale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.banksale.dto.ParticipantDTO;
import com.mindtree.banksale.entity.Participant;
import com.mindtree.banksale.entity.Stall;
import com.mindtree.banksale.exception.service.BankSaleServiceException;
import com.mindtree.banksale.exception.service.custom.StallNotFoundException;
import com.mindtree.banksale.repository.ParticipantRepository;
import com.mindtree.banksale.repository.StallRepository;
import com.mindtree.banksale.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private StallRepository stallRepository;
	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public String addParticipant(ParticipantDTO participantDTO) throws BankSaleServiceException {
		Participant participant = new Participant();
		Stall stall = stallRepository.findById(participantDTO.getStallId())
				.orElseThrow(() -> new StallNotFoundException("Stall not found"));
		participant.setParticipantName(participantDTO.getParticipantName());
		participant.setProductPurchased(participantDTO.getProductName());
		participant.setStall(stall);
		participantRepository.save(participant);
		return ("Particpant added");
	}

}
