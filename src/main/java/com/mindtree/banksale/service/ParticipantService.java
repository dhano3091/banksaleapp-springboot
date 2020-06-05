package com.mindtree.banksale.service;

import org.springframework.stereotype.Service;

import com.mindtree.banksale.dto.ParticipantDTO;
import com.mindtree.banksale.exception.service.BankSaleServiceException;

@Service
public interface ParticipantService {

	String addParticipant(ParticipantDTO participantDTO) throws BankSaleServiceException;
}
