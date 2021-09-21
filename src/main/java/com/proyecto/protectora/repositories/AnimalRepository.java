package com.proyecto.protectora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.protectora.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
