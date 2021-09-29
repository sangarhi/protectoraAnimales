package com.proyecto.protectora.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.proyecto.protectora.common.Genero;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String nombre;

	@Enumerated(value = EnumType.STRING)
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "id_refugio")
	private Refugio refugio;

	@ManyToOne
	@JoinColumn(name = "id_raza")
	private Raza raza;

	public Animal() {
		super();
	}

	public Animal(Long id, String nombre, Genero genero, Refugio refugio, Raza raza) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.refugio = refugio;
		this.raza = raza;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Refugio getRefugio() {
		return refugio;
	}

	public void setRefugio(Refugio refugio) {
		this.refugio = refugio;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

}
