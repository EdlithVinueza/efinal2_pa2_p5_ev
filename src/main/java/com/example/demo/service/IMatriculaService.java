package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.to.MatriculaTO;

public interface IMatriculaService {

	public Matricula crearMatriculaConCedulaCodigo(String cedulaEstudiante,String codigoMateria);

	public List<Matricula> generarMatriculasDesdeTO(MatriculaTO matriculaTO);

	public void matriculaMultihilo(MatriculaTO matriculaTO); // para el apartado P3

	public List<MatriculaDTO> reporte(); // retorna un DTO por que no queremos todos los datos apartado P4
}
