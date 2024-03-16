/**
 * 
 */
package br.com.wellscosta.dao;

import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.generic.GenericDAO;

/**
 * @author Wellington
 */
public class ClienteDAO extends GenericDAO <Cliente> implements IClienteDAO {
	
	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente objetoCadastrado) {
		// TODO Auto-generated method stub
		
	}
}
