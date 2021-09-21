package com.proyecto.protectora.services.interfaces;

import java.util.List;

import com.proyecto.protectora.entities.Animal;

public interface AnimalService {

	public List<Animal> findAllAnimales();
	
	public List<Animal> findAnimalByGenero();
	
	public void save(Animal animal);
	
	public Animal getById(Long id);
	
	public void delete(Long id);
	
}
