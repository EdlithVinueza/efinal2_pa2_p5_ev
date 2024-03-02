package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		String jPQL = "SELECT o FROM Materia o WHERE o.codigo=:codigo";
		TypedQuery<Materia> myQuery = this.entityManager.createQuery(jPQL,Materia.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
	}

}
