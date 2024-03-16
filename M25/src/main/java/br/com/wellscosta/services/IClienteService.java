/**
 * 
 */
package br.com.wellscosta.services;

import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;

/**
 * @author Wellington
 */
public interface IClienteService {

	Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCpf(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
	
}
