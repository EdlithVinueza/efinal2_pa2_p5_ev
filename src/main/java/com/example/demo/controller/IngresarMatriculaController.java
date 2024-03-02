package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMatriculaService;
import com.example.demo.service.to.MatriculaTO;
@Controller
@RequestMapping(value = "/matriculas")
public class IngresarMatriculaController { //localhost:8081/matriculas/iniciarVistaMatricula
 
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping(value = "/iniciarVistaMatricula")
	public String iniciarMatricula(MatriculaTO matriculaTO) {
	    return "vistaMatricularEstudiante";
	}


    @PostMapping(value = "/insertarMatricula")
    public String insertar(MatriculaTO matriculaTO) {
        this.iMatriculaService.matriculaMultihilo(matriculaTO);
        return "redirect:/matriculas/iniciarVistaMatricula";  //para refrescar la vista 
    }
	
}
