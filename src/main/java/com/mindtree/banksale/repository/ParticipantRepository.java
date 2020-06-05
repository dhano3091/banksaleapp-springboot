package com.mindtree.banksale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.banksale.entity.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
