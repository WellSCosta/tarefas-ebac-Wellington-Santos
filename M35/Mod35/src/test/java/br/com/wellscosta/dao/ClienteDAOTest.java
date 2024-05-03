/**
 *
 */
package br.com.wellscosta.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Collection;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import br.com.wellscosta.domain.Cliente;
/**
 * @author WellSCosta
 */
public class ClienteDAOTest {
	
	IClienteDAO clienteDao;
	
	Random rd;
	
	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
		rd = new Random();
	}
	
	/**
	 * Após a execução de todos os testes o método end é executado.
	 * Busca no banco todos os clientes e os remove.
	 */
	@After
	public void end() {
		Collection<Cliente> clientes = clienteDao.buscarTodos();
		clientes.forEach(cli -> clienteDao.excluir(cli));
	}
	
	@Test
	public void cadastrarCliente() {
		Cliente cliente = criarCliente();
		
		//Cadastra o cliente e verifica se não é nulo
		Cliente clienteCadastrado = clienteDao.cadastrar(cliente);
		assertNotNull(clienteCadastrado);
		
		//Consulta o cliente e verifica se não é nulo
		Cliente clienteConsultado = clienteDao.consultar(clienteCadastrado.getId());
		assertNotNull(clienteConsultado);
		
		//Exclusão do cliente
		clienteDao.excluir(clienteConsultado);
		
		//Consulta do cliente excluido para verificar se agora é nulo
		Cliente clienteConsultadoExclusao = clienteDao.consultar(clienteCadastrado.getId());
		assertNull(clienteConsultadoExclusao);
	}
	
	@Test
	public void consultarCliente() {
		Cliente cliente = criarCliente();
		
		clienteDao.cadastrar(cliente);
		
		//Após a criação e cadastro do cliente no banco, consulta pelo Id e verifica se não é nulo
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNotNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() {
		
		Cliente cliente = criarCliente();
		
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Wellington Santos");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		assertNotNull(clienteAlterado);
		assertEquals("Wellington Santos", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assert.assertNull(clienteConsultado);
		
	}
	
	@Test
	public void excluirCliente() {
		
		Cliente cliente = criarCliente();
		
		clienteDao.cadastrar(cliente);
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodosCliente() {
		
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		Cliente cliente1 = criarCliente();
		Cliente retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<Cliente> clientes = clienteDao.buscarTodos();
		assertNotNull(clientes);
		assertEquals(2, clientes.size());
		
		clientes.forEach(cli -> clienteDao.excluir(cli));
		
		Collection<Cliente> clientes1 = clienteDao.buscarTodos();
		assertNotNull(clientes1);
		assertEquals(0, clientes1.size());
	}
	
	private Cliente criarCliente() {
		Cliente cliente = new Cliente();
		
		cliente.setCid("Feira de Santana");
		cliente.setCpf(rd.nextLong());
		cliente.setEnd("Endereco");
		cliente.setEst("BA");
		cliente.setNome("Wellington");
		cliente.setNum(246);
		cliente.setTel(1111111111111L);
		
		return cliente;
	}

}
