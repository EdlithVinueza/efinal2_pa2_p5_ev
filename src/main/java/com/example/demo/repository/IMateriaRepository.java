package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertar(Materia materia); //para el apartado P1

	public Materia seleccionarPorCodigo(String codigo); //para el apartado P3

}
