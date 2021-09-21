package com.proyecto.protectora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.entities.Refugio;
import com.proyecto.protectora.repositories.RefugioRepository;
import com.proyecto.protectora.services.interfaces.RefugioService;

@Service
public class RefugioServiceImpl implements RefugioService {

	@Autowired
	private RefugioRepository refugioRepository;

	@Override
	public List<Refugio> findAllRefugios() {

		List<Refugio> refugios = refugioRepository.findAll();

		return refugios;
	}


	@Override
	public void save(Refugio refugio) {
		
		refugioRepository.save(refugio);

	}

	@Override
	public Refugio getById(Long id) {
		
		Refugio refugio =  refugioRepository.getById(id);
		
		return refugio;
	}

	@Override
	public void delete(Long id) {

		refugioRepository.deleteById(id);

	}

	

	

}
