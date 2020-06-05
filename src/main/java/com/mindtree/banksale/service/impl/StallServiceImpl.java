package com.mindtree.banksale.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.banksale.dto.AddStallDTO;
import com.mindtree.banksale.dto.AllStallsDTO;
import com.mindtree.banksale.dto.UpdateStallDTO;
import com.mindtree.banksale.entity.Stall;
import com.mindtree.banksale.exception.service.BankSaleServiceException;
import com.mindtree.banksale.exception.service.custom.DuplicateLocationCodeException;
import com.mindtree.banksale.exception.service.custom.DuplicateNameException;
import com.mindtree.banksale.exception.service.custom.StallNotFoundException;
import com.mindtree.banksale.repository.StallRepository;
import com.mindtree.banksale.service.StallService;

@Service
public class StallServiceImpl implements StallService {

	@Autowired
	private StallRepository stallRepository;

	@Override
	public String addStall(AddStallDTO addStallDTO) throws BankSaleServiceException {
		List<Stall> stallList = stallRepository.findAll();
		for (Stall stall : stallList) {
			if (stall.getStallName().equals(addStallDTO.getStallName())) {
				throw new DuplicateNameException("Duplicate stall name entered");
			} else if (stall.getStallLocation().equals(addStallDTO.getStallLocation())) {
				throw new DuplicateLocationCodeException("Duplicate location code entered");
			}
		}
		Stall stall = new Stall();
		stall.setStallLocation(addStallDTO.getStallLocation());
		stall.setStallName(addStallDTO.getStallName());
		stallRepository.save(stall);
		return "Stall saved successfully";
	}

	@Override
	public List<AllStallsDTO> getAllStalls() {
		List<Stall> stallList = stallRepository.findAll();
		List<AllStallsDTO> resultList = stallList.stream().map((stall) -> {
			return new AllStallsDTO(stall.getStallId(), stall.getStallName(), stall.getStallLocation());
		}).collect(Collectors.toList());
		return resultList;
	}

	@Override
	public String updateStall(UpdateStallDTO updateStallDTO) throws BankSaleServiceException {
		Stall stall = stallRepository.findById(updateStallDTO.getStallId())
				.orElseThrow(() -> new StallNotFoundException("Stall not found"));
		List<Stall> stallList = stallRepository.findAll();
		for (Stall sstall : stallList) {
			if (sstall.getStallLocation().equals(updateStallDTO.getStallLocation())) {
				throw new DuplicateLocationCodeException("Duplicate location entered");
			} else if (sstall.getStallName().equals(updateStallDTO.getStallName())) {
				throw new DuplicateNameException("Duplicate stall name entered");
			}
		}
		stall.setStallLocation(updateStallDTO.getStallLocation());
		stall.setStallName(updateStallDTO.getStallName());
		stallRepository.save(stall);
		return ("Stall details updated");
	}

	@Override
	public String deleteStall(long stallId) throws BankSaleServiceException {
		Stall stall = stallRepository.findById(stallId)
				.orElseThrow(() -> new StallNotFoundException("Stall not found"));
		stallRepository.delete(stall);
		return ("Stall deleted");
	}

}
