package com.proyecto.protectora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.repositories.RazaRepository;
import com.proyecto.protectora.services.interfaces.RazaService;

@Service
public class RazaServiceImpl implements RazaService {

	@Autowired
	private RazaRepository razaRepository;

	@Override
	public List<Raza> findAllRazas() {
		
	  List<Raza> razas = razaRepository.findAll();

		return razas;
	}


	@Override
	public void save(Raza raza) {
		
		raza.setNombre(raza.getNombre().toUpperCase());
		
		razaRepository.save(raza);

	}

	@Override
	public Optional<Raza> findById(Long id) {
		
		Optional<Raza> raza =  razaRepository.findById(id);
		
		return raza;
	}

	@Override
	public void delete(Raza raza) {

		razaRepository.delete(raza);

	}

	

	

}
