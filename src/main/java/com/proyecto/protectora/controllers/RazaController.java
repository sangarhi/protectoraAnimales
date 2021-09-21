package com.proyecto.protectora.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.protectora.common.Tamanio;
import com.proyecto.protectora.common.Tipo;
import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.services.interfaces.RazaService;

@Controller
@RequestMapping("/raza")
public class RazaController {

	@Autowired
	RazaService service;

	Logger log = LoggerFactory.getLogger(Raza.class);

	@GetMapping
	public String getRazas(Model model) {

		log.debug("getRazas");

		model.addAttribute("listado", service.findAllRazas());
		model.addAttribute("raza", new Raza());

		return "razas";
	}

	@PostMapping
	public String createRaza(@Valid @ModelAttribute Raza raza, BindingResult br) {
	
		log.debug("createRaza");
		log.debug("Raza" + raza);
		log.debug("Nombre: " + raza.getNombre());
		log.debug("Tipo: " + raza.getTipo());

		if(br.hasErrors()) {
			
			return "razas";
		}
		

		service.save(raza);

		return "redirect:/raza";

	}

	@GetMapping("/{id}")
	public String findRaza(Model model, @PathVariable("id") Long id) {

		log.debug("findRaza");

		Raza raza = service.getById(id);

		model.addAttribute(raza);

		return "raza";
	}

	@PostMapping("/{id}")
	public String updateRaza(Model model, @ModelAttribute Raza raza, @PathVariable Long id) {

		log.debug("updateRaza");

		service.save(raza);

		return "redirect:/raza/" + id;

	}

	@RequestMapping("/r/{id}")
	public String deleteRaza(@PathVariable("id") Long id) {

		log.debug("deleteRaza");

		service.delete(id);

		return "redirect:/raza";
	}

}
