package com.proyecto.protectora.controllers;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.protectora.entities.Animal;
import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.services.interfaces.AnimalService;
import com.proyecto.protectora.services.interfaces.RazaService;
import com.proyecto.protectora.services.interfaces.RefugioService;

@Controller
@RequestMapping("/animal")
public class AnimalController {

	/*
	 * @Autowired AnimalServiceImpl service;
	 */
	Logger log = LoggerFactory.getLogger(Animal.class);

	@Autowired
	AnimalService service;
	
	@Autowired
	RazaService razaService;
	
	@Autowired
	RefugioService refugioService;

	@GetMapping
	public String getAnimales(Model model) {

		log.debug("getAnimales");

		model.addAttribute("listado", service.findAllAnimales());
		model.addAttribute("animal", new Animal());
		model.addAttribute("razas", razaService.findAllRazas());
		model.addAttribute("refugios", refugioService.findAllRefugios());

		return "animales";
	}

	@PostMapping
	public String createAnimal(@Valid @ModelAttribute Animal animal, BindingResult br, RedirectAttributes attribute) {

		log.debug("createAnimal");
		
		if(br.hasErrors()) {
			
			return "animales";
		}
		
		service.save(animal);
		
		attribute.addFlashAttribute("success", "El animal se ha creado con éxito.");

		return "redirect:/animal";

	}

	@GetMapping("/{id}")
	public String findAnimal(Model model, @PathVariable("id") Long id) {

		log.debug("findAnimal");

		Animal animal = service.getById(id);

		model.addAttribute(animal);
		model.addAttribute("razas", razaService.findAllRazas());
		model.addAttribute("refugios", refugioService.findAllRefugios());

		return "animal";
	}

	@PostMapping("/{id}")
	public String updateAnimal(Model model, @ModelAttribute Animal animal, @PathVariable Long id, RedirectAttributes attribute) {

		log.debug("updateAnimal");

		service.save(animal);
		
		attribute.addFlashAttribute("success", "El animal se ha modificado correctamente.");

		return "redirect:/animal/" + id;

	}
	
	@RequestMapping("/r/{id}")
	public String deleteAnimal(@PathVariable("id") Long id, RedirectAttributes attribute) {
		
		log.debug("deleteAnimal: "+id);
		
		service.delete(id);

		attribute.addFlashAttribute("error", "El animal se ha eliminado correctamente.");
		
		log.debug("animal borrado: "+id);
		
		return "redirect:/animal";
	}

}
