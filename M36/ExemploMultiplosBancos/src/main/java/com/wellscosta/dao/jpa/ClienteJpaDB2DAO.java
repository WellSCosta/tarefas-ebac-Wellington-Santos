/**
 * 
 */
package com.wellscosta.dao.jpa;

import com.wellscosta.dao.generic.jpa.GenericJpaDB2DAO;
import com.wellscosta.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
