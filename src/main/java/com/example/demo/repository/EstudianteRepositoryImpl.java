package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		String jPQL = "SELECT o FROM Estudiante o WHERE o.cedula=:cedula";
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(jPQL, Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
