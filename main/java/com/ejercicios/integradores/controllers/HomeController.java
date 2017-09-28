package com.ejercicios.integradores.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ejercicios.integradores.model.Alumno;
import com.ejercicios.integradores.repository.UserRepository;

@Controller
public class HomeController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	UserRepository userRepo;
	
	private Alumno beforeSearch;
	
	@RequestMapping("/")
	public String home(Model model) {
		log.info("Method home");
		model.addAttribute("alumno", new Alumno());
		return "index";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String goHomeResults(@ModelAttribute Alumno alumno, Model model) {
		log.info("Method goHomeResults");
		beforeSearch = alumno;
		model.addAttribute("alumnos", 
				userRepo.findAlumnoByDniOrNombreOrApellidoOrAnoOrCurso(
				alumno.getDni(), alumno.getNombre(),
				alumno.getApellido(), alumno.getAno(), alumno.getCurso()));
		return "index";
	}
	
	@RequestMapping(path="/edit/{id}")
	public String goEditPage(Model model, @PathVariable int id) {
		log.info("Method goEditPage");
		model.addAttribute("alumno", userRepo.findOne(id));
		return "edit";
	}
	
	@RequestMapping(path="/edit", method=RequestMethod.POST)
	public String editAlumno(Model model, @ModelAttribute Alumno alumno) {
		log.info("Method editAlumno");
		userRepo.saveAndFlush(alumno);
		model.addAttribute("alumno", beforeSearch);
		model.addAttribute("alumnos", userRepo.findAlumnoByDniOrNombreOrApellidoOrAnoOrCurso(
				beforeSearch.getDni(), beforeSearch.getNombre(),
				beforeSearch.getApellido(), beforeSearch.getAno(), beforeSearch.getCurso()));
		return "index";
	}	

}
