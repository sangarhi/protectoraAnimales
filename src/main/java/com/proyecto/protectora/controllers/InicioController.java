package com.proyecto.protectora.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.protectora.entities.Animal;
import com.proyecto.protectora.services.AnimalServiceImpl;

@Controller
@RequestMapping("")
public class InicioController {

	/*
	 * @Autowired AnimalServiceImpl service;
	 */
	Logger log = LoggerFactory.getLogger(Animal.class);

	@Autowired
	AnimalServiceImpl service;

	@GetMapping
	public String getAnimales(Model model) {

		log.debug("inicio");

		model.addAttribute("listado", service.findAllAnimales());

		return "inicio";
	}

}
