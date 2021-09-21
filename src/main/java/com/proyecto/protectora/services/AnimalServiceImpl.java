package com.proyecto.protectora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.protectora.entities.Animal;
import com.proyecto.protectora.repositories.AnimalRepository;
import com.proyecto.protectora.services.interfaces.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Override
	public List<Animal> findAllAnimales() {

		List<Animal> animales = animalRepository.findAll();

		return animales;
	}

	@Override
	public List<Animal> findAnimalByGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Animal animal) {
		
		animalRepository.save(animal);

	}

	@Override
	public Animal getById(Long id) {
		
		Animal animal =  animalRepository.getById(id);
		
		return animal;
	}

	@Override
	public void delete(Long id) {

		animalRepository.deleteById(id);

	}

}
