package com.mindtree.banksale.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.banksale.dto.AddStallDTO;
import com.mindtree.banksale.dto.AllStallsDTO;
import com.mindtree.banksale.dto.UpdateStallDTO;
import com.mindtree.banksale.exception.service.BankSaleServiceException;

@Service
public interface StallService {

	String addStall(AddStallDTO addStallDTO) throws BankSaleServiceException;
	List<AllStallsDTO> getAllStalls();
	String updateStall(UpdateStallDTO updateStallDTO) throws BankSaleServiceException;
    String deleteStall(long stallId) throws BankSaleServiceException;
}
