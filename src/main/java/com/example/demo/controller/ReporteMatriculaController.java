package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.IMatriculaService;
import com.example.demo.service.to.MatriculaTO;

@Controller
@RequestMapping(value = "/reportes") //localhost:8081/reporte/iniciarVistaReporte
public class ReporteMatriculaController {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping(value = "/iniciarVistaReporte") // para visualizar las matriculas 
    public String iniciarVista(MatriculaDTO matriculaDTO, Model model) {
		List<MatriculaDTO> matriculas = this.iMatriculaService.reporte();
		model.addAttribute("reporteModel", matriculas);
        return "vistaReporteMatricula";
    }
	


}
