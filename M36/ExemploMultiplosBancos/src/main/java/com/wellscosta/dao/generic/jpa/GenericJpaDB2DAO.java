/**
 * 
 */
package com.wellscosta.dao.generic.jpa;

import java.io.Serializable;

import com.wellscosta.domain.jpa.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public abstract class GenericJpaDB2DAO <T extends Persistente, E extends Serializable>
	extends GenericJpaDAO<T,E> {

	public GenericJpaDB2DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre2");
	}

}
