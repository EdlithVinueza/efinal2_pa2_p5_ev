package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public void insertar(Estudiante estudiante);  //para el apartado P1

	public Estudiante seleccionarPorCedula(String cedula); //para el apartado P3

}
