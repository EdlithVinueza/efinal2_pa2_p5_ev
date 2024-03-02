package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping(value = "/materia") //localhost:8081/materia/iniciarVista
public class IngresarMateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping(value = "/iniciarVista")
    public String iniciarVista(Materia materia) {
        return "vistaIngresarMateria";
    }

    @PostMapping(value = "/insertar")
    public String insertar(Materia materia) {
        this.iMateriaService.guardar(materia);
        return "redirect:/materia/iniciarVista";  //para refrescar la vista 
    }
	

}
