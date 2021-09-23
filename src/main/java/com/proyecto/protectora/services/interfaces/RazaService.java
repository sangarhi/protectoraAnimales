package com.proyecto.protectora.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.protectora.entities.Raza;

public interface RazaService {
	
	public List<Raza> findAllRazas() ;

	public void save(Raza raza);

	public Optional<Raza> findById(Long id);

	public void delete(Raza raza);

}
