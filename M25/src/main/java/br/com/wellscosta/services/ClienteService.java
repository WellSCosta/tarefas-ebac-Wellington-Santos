/**
 * 
 */
package br.com.wellscosta.services;

import br.com.wellscosta.dao.ClienteDAO;
import br.com.wellscosta.dao.IClienteDAO;
import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;

/**
 * @author Wellington
 */
public class ClienteService implements IClienteService {

	private IClienteDAO clienteDAO;

	public ClienteService(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
		return clienteDAO.cadastrar(cliente);
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		return clienteDAO.consultar(cpf);
	}

	@Override
	public void excluir(Long cpf) {
		clienteDAO.excluir(cpf);
	}

	@Override
	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
		clienteDAO.alterar(cliente);
		
	}

}
