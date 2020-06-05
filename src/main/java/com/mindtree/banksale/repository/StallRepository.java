package com.mindtree.banksale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.banksale.entity.Stall;

@Repository
public interface StallRepository extends JpaRepository<Stall, Long> {

}
