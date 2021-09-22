package com.proyecto.protectora.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Refugio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer numero;

	private Double tamanio;

	@OneToMany(mappedBy="refugio", cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
	 @OnDelete( action = OnDeleteAction.CASCADE )
	private List<Animal> animal;

	public Refugio() {
		super();
	}

	public Refugio(Long id, Integer numero, Double tamanio) {
		super();
		this.id = id;
		this.numero = numero;
		this.tamanio = tamanio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getTamanio() {
		return tamanio;
	}

	public void setTamanio(Double tamanio) {
		this.tamanio = tamanio;
	}

}
