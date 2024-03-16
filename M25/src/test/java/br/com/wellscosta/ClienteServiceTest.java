/**
 * 
 */
package br.com.wellscosta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.wellscosta.dao.ClienteDAOMock;
import br.com.wellscosta.dao.IClienteDAO;
import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;
import br.com.wellscosta.services.ClienteService;
import br.com.wellscosta.services.IClienteService;

/**
 * @author Wellington
 */
public class ClienteServiceTest {
	
	private Cliente cliente;
	
	private IClienteService clienteService;

	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDAOMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(10L);
		cliente.setNome("Wellington");
		cliente.setTel(75991012167L);
		cliente.setCidade("Feira de Santana");
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.salvar(cliente);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Wellington Santos");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Wellington Santos", cliente.getNome());
	}
}
