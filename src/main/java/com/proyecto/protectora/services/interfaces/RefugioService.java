package com.proyecto.protectora.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.protectora.entities.Refugio;

public interface RefugioService {

	public List<Refugio> findAllRefugios();

	public void save(Refugio refugio);

	public Optional<Refugio> findById(Long id);

	public void delete(Refugio refugio);

}
