package com.proyecto.protectora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.protectora.entities.Animal;
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
