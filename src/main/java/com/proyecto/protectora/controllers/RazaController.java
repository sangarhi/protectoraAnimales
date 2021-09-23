package com.proyecto.protectora.controllers;

import java.util.Optional;

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

import com.proyecto.protectora.entities.Raza;
import com.proyecto.protectora.services.interfaces.RazaService;

@Controller
@RequestMapping("/raza")
public class RazaController {

	@Autowired
	RazaService service;

	@Autowired
	ExceptionController ec;

	Logger log = LoggerFactory.getLogger(Raza.class);

	@GetMapping
	public String getRazas(Model model) {

		log.debug("getRazas");

		model.addAttribute("listado", service.findAllRazas());
		model.addAttribute("raza", new Raza());

		return "razas";
	}

	@PostMapping
	public String createRaza(@Valid @ModelAttribute Raza raza, Model model, BindingResult br,
			RedirectAttributes attribute) {

		log.debug("createRaza");
		log.debug("Raza" + raza);
		log.debug("Nombre: " + raza.getNombre());
		log.debug("Tipo: " + raza.getTipo());

		if (br.hasErrors()) {
			attribute.addFlashAttribute("error", "Ha habido un error");
			model.addAttribute("listado", service.findAllRazas());
			model.addAttribute("raza", raza);

			return "razas";
		}

		service.save(raza);

		attribute.addFlashAttribute("success", "La raza se ha creado con éxito.");
		return "redirect:/raza";

	}

	@GetMapping("/{id}")
	public String findRaza(Model model, @PathVariable("id") Long id) {
		log.debug("findRaza");
		
		Optional<Raza> razaOpt = this.service.findById(id);

		if (!razaOpt.isPresent()) {
			log.error("El id especificado no se encuentra en la bbdd");
			return "error/error-specific";
		}

		Raza raza = razaOpt.get();

		model.addAttribute(raza);

		return "raza";
	}

	@PostMapping("/{id}")
	public String updateRaza(Model model, @ModelAttribute Raza raza, @PathVariable Long id,
			RedirectAttributes attribute) {

		log.debug("updateRaza");

		service.save(raza);

		attribute.addFlashAttribute("success", "La raza se ha modificado correctamente.");

		return "redirect:/raza/" + id;

	}

	@RequestMapping("/r/{id}")
	public String deleteRaza(@PathVariable("id") Long id, RedirectAttributes attribute) {

		log.debug("deleteRaza");
		Optional<Raza> razaOpt = this.service.findById(id);

		if (!razaOpt.isPresent()) {
			log.error("El id especificado no se encuentra en la bbdd");
			return "error/error-specific";
		}

		Raza raza = razaOpt.get();

		service.delete(raza);
		attribute.addFlashAttribute("error", "La raza se ha eliminado correctamente.");

		return "redirect:/raza";
	}

}
