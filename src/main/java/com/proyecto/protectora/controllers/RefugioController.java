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

import com.proyecto.protectora.entities.Refugio;
import com.proyecto.protectora.services.RefugioServiceImpl;

@Controller
@RequestMapping("/refugio")
public class RefugioController {

	/*
	 * @Autowired RefugioServiceImpl service;
	 */
	Logger log = LoggerFactory.getLogger(Refugio.class);

	@Autowired
	RefugioServiceImpl service;

	@GetMapping
	public String getRefugios(Model model) {

		log.debug("getRefugios");

		model.addAttribute("listado", service.findAllRefugios());
		model.addAttribute("refugio", new Refugio());

		return "refugios";
	}

	@PostMapping
	public String createRefugio(@Valid @ModelAttribute Refugio refugio, BindingResult br, Model model,
			RedirectAttributes attribute) {

		log.debug("createRefugio");

		if (br.hasErrors()) {

			model.addAttribute("listado", service.findAllRefugios());
			model.addAttribute(refugio);

			return "refugios";
		}

		/*
		 * if(refugio != null) { if(refugio.getNombre() != null) {
		 * //refugio.getNombre().length() > 3 } }
		 */

		service.save(refugio);

		attribute.addFlashAttribute("success", "El refugio se ha creado con éxito.");

		return "redirect:/refugio";

	}

	@GetMapping("/{id}")
	public String findRefugio(Model model, @PathVariable("id") Long id) {
		log.debug("findRefugio");

		Optional<Refugio> refugioOpt = this.service.findById(id);

		if (!refugioOpt.isPresent()) {
			log.error("El id especificado no se encuentra en la bbdd");
			return "error/error-specific";
		}

		Refugio refugio = refugioOpt.get();

		model.addAttribute(refugio);

		return "refugio";
	}

	@PostMapping("/{id}")
	public String updateRefugio(Model model, @ModelAttribute Refugio refugio, @PathVariable Long id, BindingResult br,
			RedirectAttributes attribute) {

		log.debug("updateRefugio");

		if (br.hasErrors()) {

			return "redirect:/refugio/" + id;
		}
		service.save(refugio);

		attribute.addFlashAttribute("success", "El refugio se ha modificado correctamente.");

		return "redirect:/refugio/" + id;

	}

	@RequestMapping("/r/{id}")
	public String deleteRefugio(@PathVariable("id") Long id, RedirectAttributes attribute) {
		log.debug("deleteRefugio");

		Optional<Refugio> refugioOpt = this.service.findById(id);

		if (!refugioOpt.isPresent()) {
			log.error("El id especificado no se encuentra en la bbdd");
			return "error/error-specific";
		}

		Refugio refugio = refugioOpt.get();

		service.delete(refugio);

		attribute.addFlashAttribute("error", "El refugio se ha eliminado correctamente.");

		return "redirect:/refugio";
	}

}
