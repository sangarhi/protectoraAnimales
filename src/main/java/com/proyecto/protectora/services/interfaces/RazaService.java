package com.proyecto.protectora.services.interfaces;

import java.util.List;

import com.proyecto.protectora.entities.Raza;

public interface RazaService {
	
	public List<Raza> findAllRazas();

	public void save(Raza raza);

	public Raza getById(Long id);

	public void delete(Long id);

}
