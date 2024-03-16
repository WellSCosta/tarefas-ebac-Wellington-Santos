/**
 * 
 */
package br.com.wellscosta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.wellscosta.dao.ClienteDAO;
import br.com.wellscosta.dao.ClienteDAOMock;
import br.com.wellscosta.dao.IClienteDAO;
import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;

/**
 * @author Wellington
 */
public class ClienteDAOTest {
	
	private Cliente cliente;
	
	private IClienteDAO clienteDAO;
	
	public ClienteDAOTest() {
		clienteDAO = new ClienteDAOMock();
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
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteDAO.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void excluir() {
		clienteDAO.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Wellington Santos");
		clienteDAO.alterar(cliente);
		
		Assert.assertEquals("Wellington Santos", cliente.getNome());
	}
	
}
