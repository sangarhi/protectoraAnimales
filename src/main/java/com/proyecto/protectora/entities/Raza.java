package com.proyecto.protectora.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.proyecto.protectora.common.Tamanio;
import com.proyecto.protectora.common.Tipo;
import com.sun.istack.NotNull;

@Entity
public class Raza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@javax.validation.constraints.NotNull(message = "LastName can not be null!!")
    @NotEmpty(message = "LastName can not be empty!!")
	private String nombre;

	@Enumerated(value = EnumType.STRING)
	private Tipo tipo;

	@Enumerated(value = EnumType.STRING)
	private Tamanio tamanio;

	@OneToMany(mappedBy = "raza", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Animal> animal;

	public Raza() {
		super();
	}

	public Raza(Long id, Tipo tipo, String nombre, com.proyecto.protectora.common.Tamanio tamanio) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.tamanio = tamanio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setRaza(String nombre) {
		this.nombre = nombre;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

}
