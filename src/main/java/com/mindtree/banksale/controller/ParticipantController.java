package com.mindtree.banksale.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.banksale.dto.ParticipantDTO;
import com.mindtree.banksale.dto.ResponseBody;
import com.mindtree.banksale.exception.service.BankSaleServiceException;
import com.mindtree.banksale.service.ParticipantService;

@RestController
@RequestMapping("/banksaleapp")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@PostMapping("/saveparticipant")
	public ResponseEntity<ResponseBody<String>> addParticipant(@Valid @RequestBody ParticipantDTO participantDTO)
			throws BankSaleServiceException {
		return new ResponseEntity<ResponseBody<String>>(new ResponseBody<String>(
				participantService.addParticipant(participantDTO), null, true, "participant added"), HttpStatus.OK);
	}
}
