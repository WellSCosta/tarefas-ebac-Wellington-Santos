/**
 * 
 */
package br.com.wellscosta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wellscosta.domain.Marca;

/**
 * @author Wellington
 */
public class MarcaDAO implements IMarcaDAO{

	@Override
	public Marca cadastrar(Marca marca) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(marca);
		entityManager.getTransaction().commit();
		
		entityManagerFactory.close();
		entityManager.close();
		
		return marca;
	}

}
