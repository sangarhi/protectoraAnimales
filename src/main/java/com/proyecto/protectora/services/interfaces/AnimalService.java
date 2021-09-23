package com.proyecto.protectora.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.protectora.entities.Animal;

public interface AnimalService {

	public List<Animal> findAllAnimales();
	
	public void save(Animal animal);
	
	public Optional<Animal> findById(Long id);
	
	public void delete(Animal animal);
	
}
