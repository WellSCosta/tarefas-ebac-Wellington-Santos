/**
 * 
 */
package br.com.wellscosta.dao;

import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;

/**
 * @author Wellington
 */
public class ClienteDAOMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean excluir(Long valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}


}
