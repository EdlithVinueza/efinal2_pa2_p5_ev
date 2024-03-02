package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping(value = "/estudiantes") //http://localhost:8080/estudiantes/iniciarVista/insertar
public class IngresarEstudianteController {
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	@GetMapping(value = "/iniciarVista")
	public String iniciarVista(Estudiante estudiante) {
		return "vistaIngresarEstudiante";
	}
	
	@PostMapping(value = "/insertar")
	public String insertar(Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		return "redirect:/estudiantes/iniciarVista";  //para que la pagina se refresque y quede en blanco
	}
	

}
