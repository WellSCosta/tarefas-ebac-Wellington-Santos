/**
 *
 */
package br.com.wellscosta.dao.generic;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wellscosta.dao.Persistente;

/**
 * @author WellSCosta
 */
public class GenericDAO <T extends Persistente, E extends Serializable> implements IGenericDAO<T,E>{

	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	protected Class<T> persistenteClass;
	
	public GenericDAO(Class<T> persistenteClass) {
		this.persistenteClass = persistenteClass;
	}
	
	@Override
	public T cadastrar(T entity) {
		
		openConnection();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		closeConnection();
		
		return entity;
	}

	@Override
	public void excluir(T entity) {
		openConnection();
		
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		
		closeConnection();
	}

	@Override
	public T alterar(T entity) {
		openConnection();
		
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		
		closeConnection();
		return entity;
	}

	@Override
	public T consultar(E valor) {
		openConnection();
		T entity = entityManager.find(this.persistenteClass, valor);
		entityManager.getTransaction().commit();
		closeConnection();
		
		return entity;
	}

	@Override
	public Collection<T> buscarTodos() {
		openConnection();
		
		List<T> lista = entityManager.createQuery(getSelectQuery(), this.persistenteClass).getResultList();
		closeConnection();
		return lista;
	}
	
	protected String getSelectQuery() {
		return "SELECT obj FROM " + this.persistenteClass.getSimpleName() + " obj";
	}

	protected void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
	}
	
	protected void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
