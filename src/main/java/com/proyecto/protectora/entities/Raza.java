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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.proyecto.protectora.common.Tamanio;
import com.proyecto.protectora.common.Tipo;

@Entity
public class Raza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String nombre;

	@Enumerated(value = EnumType.STRING)
	private Tipo tipo;

	@Enumerated(value = EnumType.STRING)
	private Tamanio tamanio;

	@OneToMany(mappedBy = "raza", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

}
