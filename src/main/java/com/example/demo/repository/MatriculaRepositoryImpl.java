package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED) // por el procesamiento multihilo
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		System.out.println("verificar transacción en insertar de matricula repository");
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarTodos() {
		// TODO Auto-generated method stub
		String paquete = "com.example.demo.repository.modelo.dto.MatriculaDTO";
		String contructor = "(o.cedulaEstudiante, o.codigoMateria, o.fechaMatricula, o.nombreHilo)";

		TypedQuery<MatriculaDTO> myQuery = this.entityManager
				.createQuery("SELECT NEW com.example.demo.repository.modelo.dto.MatriculaDTO(o.cedulaEstudiante, o.codigoMateria, o.fechaMatricula, o.nombreHilo) FROM Matricula o"
						, MatriculaDTO.class);
		return myQuery.getResultList();
	}

}
