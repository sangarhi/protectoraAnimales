package com.proyecto.protectora.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.protectora.entities.Animal;
import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.entities.Refugio;
import com.proyecto.protectora.repositories.AnimalRepository;
import com.proyecto.protectora.services.interfaces.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	Logger log = LoggerFactory.getLogger(Animal.class);

	@Override
	public List<Animal> findAllAnimales() {

		List<Animal> animales = animalRepository.findAll();

		return animales;
	}

	@Override
	public void save(Animal animal) {

		animalRepository.save(animal);

	}

	@Override
	public Optional<Animal> findById(Long id) {

		Optional<Animal> animal = animalRepository.findById(id);

		return animal;
	}

	@Override
	public void delete(Animal animal) {
		
		animalRepository.delete(animal);
		
	}

}
