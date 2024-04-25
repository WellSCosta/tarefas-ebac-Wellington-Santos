/**
 * 
 */
package br.com.wellscosta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wellscosta.domain.Acessorio;

/**
 * @author Wellington
 */
public class AcessorioDAO implements IAcessorioDAO{

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		
		entityManagerFactory.close();
		entityManager.close();
		return acessorio;
	}

}
