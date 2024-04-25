/**
 * 
 */
package br.com.wellscosta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wellscosta.domain.Carro;

/**
 * @author Wellington
 */
public class CarroDAO implements ICarroDAO{

	@Override
	public Carro cadastrar(Carro carro) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();
		
		entityManagerFactory.close();
		entityManager.close();
		
		return carro;
	}

}
