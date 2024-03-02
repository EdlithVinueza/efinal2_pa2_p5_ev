package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.to.MatriculaTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	
	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	@Autowired
	private IMateriaRepository iMateriaRepository;
	@Autowired
	private IMatriculaRepository iMatriculaRepository;;
	
	@Override
	public Matricula crearMatriculaConCedulaCodigo(String cedulaEstudiante,String codigoMateria) {
		// TODO Auto-generated method stub
		
		Matricula matricula = new Matricula();
        matricula.setFechaMatricula(LocalDateTime.now());

        Estudiante estudiante = this.iEstudianteRepository.seleccionarPorCedula(cedulaEstudiante);
        Materia materia = this.iMateriaRepository.seleccionarPorCodigo(codigoMateria);

        matricula.setEstudiante(estudiante);
        matricula.setMateria(materia);

        return matricula;
	
	}

	@Override
	public List<Matricula> generarMatriculasDesdeTO(MatriculaTO matriculaTO) {
		// TODO Auto-generated method stub
		List<Matricula> matriculas = new ArrayList<>();
        matriculas.add(this.crearMatriculaConCedulaCodigo(matriculaTO.getCedulaEstudiante(),matriculaTO.getCodigoUno()));
        matriculas.add(this.crearMatriculaConCedulaCodigo(matriculaTO.getCedulaEstudiante(),matriculaTO.getCodigoDos()));
        matriculas.add(this.crearMatriculaConCedulaCodigo(matriculaTO.getCedulaEstudiante(),matriculaTO.getCodigoTres()));
        matriculas.add(this.crearMatriculaConCedulaCodigo(matriculaTO.getCedulaEstudiante(), matriculaTO.getCodigoCuadro()));

        return matriculas;
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculaMultihilo(MatriculaTO matriculaTO) {
	    List<Matricula> matriculas = this.generarMatriculasDesdeTO(matriculaTO);
	    matriculas.parallelStream().forEach(matricula -> {
	        matricula.setNombreHilo(Thread.currentThread().getName());
	        this.iMatriculaRepository.insertar(matricula);
	    });
	}


	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporte() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarTodos();
	}

}
