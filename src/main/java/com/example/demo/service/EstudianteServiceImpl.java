package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		iEstudianteRepository.insertar(estudiante);

	}

}
