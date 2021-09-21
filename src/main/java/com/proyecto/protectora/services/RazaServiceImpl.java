package com.proyecto.protectora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.protectora.entities.Animal;
import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.repositories.AnimalRepository;
import com.proyecto.protectora.repositories.RazaRepository;
import com.proyecto.protectora.services.interfaces.AnimalService;
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
		
		razaRepository.save(raza);

	}

	@Override
	public Raza getById(Long id) {
		
		Raza raza =  razaRepository.getById(id);
		
		return raza;
	}

	@Override
	public void delete(Long id) {

		razaRepository.deleteById(id);

	}

	

	

}
