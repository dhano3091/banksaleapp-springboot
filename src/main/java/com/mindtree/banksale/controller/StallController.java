package com.mindtree.banksale.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.banksale.dto.AddStallDTO;
import com.mindtree.banksale.dto.AllStallsDTO;
import com.mindtree.banksale.dto.ResponseBody;
import com.mindtree.banksale.dto.UpdateStallDTO;
import com.mindtree.banksale.exception.BankSaleApplicationException;
import com.mindtree.banksale.exception.service.BankSaleServiceException;
import com.mindtree.banksale.service.StallService;

@RestController
@RequestMapping("/banksaleapp")
public class StallController {

	@Autowired
	private StallService stallService;

	@PostMapping("/stall")
	public ResponseEntity<ResponseBody<String>> addStall(@Valid @RequestBody AddStallDTO addStallDTO)
			throws BankSaleApplicationException {

		return new ResponseEntity<ResponseBody<String>>(
				new ResponseBody<String>(stallService.addStall(addStallDTO), null, true, "stall added"), HttpStatus.OK);
	}

	@GetMapping("/allstalls")
	public ResponseEntity<ResponseBody<List<AllStallsDTO>>> getAllStalls() {
		return new ResponseEntity<ResponseBody<List<AllStallsDTO>>>(
				new ResponseBody<List<AllStallsDTO>>(stallService.getAllStalls(), null, true, "shown success"),
				HttpStatus.OK);
	}

	@PutMapping("/newstalldetails")
	public ResponseEntity<ResponseBody<String>> updateStall(@Valid @RequestBody UpdateStallDTO updateStallDTO)
			throws BankSaleServiceException {
		return new ResponseEntity<ResponseBody<String>>(
				new ResponseBody<String>(stallService.updateStall(updateStallDTO), null, true, "updated success"),
				HttpStatus.OK);
	}

	@DeleteMapping("/removestall/{stallId}")
	public ResponseEntity<ResponseBody<String>> deleteStall(@PathVariable long stallId) throws BankSaleServiceException {
		return new ResponseEntity<ResponseBody<String>>(
				new ResponseBody<String>(stallService.deleteStall(stallId), null, true, "deleted success"),
				HttpStatus.OK);
	}

}
