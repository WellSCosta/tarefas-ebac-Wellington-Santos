/**
 *
 */
package br.com.wellscosta.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import br.com.wellscosta.dao.Persistente;

/**
 * @author WellSCosta
 */
public interface IGenericDAO<T extends Persistente, E extends Serializable> {
	
	/**
    * Método para cadastrar novos registro no banco de dados
    *
    * @param entity a ser cadastrado
    * @return retorna o objeto salvo
    */
	public T cadastrar(T entity);
	
	/**
	 * Método para excluir os registros no banco de dados
	 * 
	 * @param entity
	 */
	public void excluir(T entity);
	
	/**
	 * Método para atualizar registros no banco de dados
	 * 
	 * @param entity a ser atualizado
	 * @return retorna o objeto atualizado
	 */
	public T alterar(T entity);
	
	/**
	 * Método para consultar um registro no banco de dados
	 * 
	 * @param id chave única do dado a ser consultado
	 * @return retorna o resultado da consulta
	 */
	public T consultar(E id);
	
	/**
	 * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
	 * 
	 * @return Registros encontrados
	 */
	public Collection<T> buscarTodos();
}
