package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepository {

	public void insertar(Matricula matricula); //para el apartado P3
	
	public List<MatriculaDTO> seleccionarTodos(); //retorna un DTO por que no queremos todos los datos 
}
