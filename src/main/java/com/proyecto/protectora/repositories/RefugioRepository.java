package com.proyecto.protectora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.protectora.entities.Refugio;

public interface RefugioRepository extends JpaRepository<Refugio, Long> {

	@Query("SELECT t FROM Refugio t WHERE t.numero = ?1")
    Refugio findByNumeroRefugio(Integer numeroRefugio);
	
}
