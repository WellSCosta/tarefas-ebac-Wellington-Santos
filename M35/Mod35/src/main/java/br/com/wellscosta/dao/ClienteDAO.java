/**
 *
 */
package br.com.wellscosta.dao;

import br.com.wellscosta.dao.generic.GenericDAO;
import br.com.wellscosta.domain.Cliente;

/**
 * @author WellSCosta
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO{

	public ClienteDAO() {
		super(Cliente.class);
	}

}
