package com.proyecto.protectora.services.interfaces;

import java.util.List;

import com.proyecto.protectora.entities.Refugio;

public interface RefugioService {

	public List<Refugio> findAllRefugios();

	public void save(Refugio refugio);

	public Refugio getById(Long id);

	public void delete(Long id);

}
