package com.api.digiAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.digiAPI.models.Digimon;

@Repository
public interface DigiRepository extends JpaRepository<Digimon, Long>{
	
}
