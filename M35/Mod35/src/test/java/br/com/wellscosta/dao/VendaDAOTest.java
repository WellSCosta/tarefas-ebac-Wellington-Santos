/**
 *
 */
package br.com.wellscosta.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.domain.Produto;
import br.com.wellscosta.domain.Venda;
import br.com.wellscosta.domain.Venda.Status;
import br.com.wellscosta.mock.dao.VendaExclusaoDAO;

/**
 * @author WellSCosta
 */
public class VendaDAOTest {
	IVendaDAO vendaDao;
	IVendaDAO vendaExclusaoDao;
	
	IProdutoDAO produtoDao;
	IClienteDAO clienteDao;
	
	Produto produto;
	Cliente cliente;
	
	Random rd;
	
	public VendaDAOTest() {
		vendaDao = new VendaDAO();
		vendaExclusaoDao = new VendaExclusaoDAO();
		produtoDao = new ProdutoDAO();
		clienteDao = new ClienteDAO();
		
		rd = new Random();
	}
	
	@Before
	public void init() {
		this.cliente = criarCliente();
		this.produto = criarProduto("A1", BigDecimal.TEN);
	}
	
	@After
	public void end() {
		excluirVenda();
		excluirProdutos();
		clienteDao.excluir(this.cliente);
	}
	
	@Test
	public void cadastrar() {
		Venda venda = criarVenda("A1");
		Venda retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		
		assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		assertTrue(venda.getStatus().equals(Status.INICIADA));
		
		Venda vendaConsultada = vendaDao.consultar(venda.getId());
		assertTrue(vendaConsultada.getId() != null);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	private Venda criarVenda(String codigo) {
		Venda venda = new Venda();
		
		venda.setCliente(cliente);
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setStatus(Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		
		return venda;
	}
	
	@Test
	public void consultar() {
		Venda venda = criarVenda("A2");
		Venda retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		Venda vendaConsultada = vendaDao.consultar(venda.getId());
		assertNotNull(vendaConsultada);
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void cancelarVenda() {
		String codigoVenda = "A3";
		Venda venda = criarVenda(codigoVenda);
		Venda retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		retorno.setStatus(Status.CANCELADA);
		vendaDao.cancelarVenda(venda);
		
		Venda vendaConsultada = vendaDao.consultar(venda.getId());
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}
	
	@Test
	public void finalizarVenda() {
		String codigoVenda = "A10";
		Venda venda = criarVenda(codigoVenda);
		Venda retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		Venda vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void tentarAdicionarProdutosVendaFinalizada() {
		String codigoVenda = "A11";
		Venda venda = criarVenda(codigoVenda);
		Venda retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		Venda vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
		
		vendaConsultada.adicionarProduto(this.produto, 1);
		
	}

	private void excluirVenda() {
		Collection<Venda> vendas = vendaExclusaoDao.buscarTodos();
		
		vendas.forEach(venda -> vendaExclusaoDao.excluir(venda));
	}

	private void excluirProdutos() {
		Collection<Produto> produtos = produtoDao.buscarTodos();
		
		produtos.forEach(prod -> produtoDao.excluir(prod));
	}

	private Produto criarProduto(String codigo, BigDecimal valor) {
		Produto produto = new Produto();
		
		produto.setCodigo(codigo);
		produto.setDescricao("Descricao Prod 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		
		return produto;
	}

	private Cliente criarCliente() {
		Cliente cliente = new Cliente();
		
		cliente.setCid("Feira de Santana");
		cliente.setCpf(rd.nextLong());
		cliente.setEnd("Endereco");
		cliente.setEst("BA");
		cliente.setNum(246);
		cliente.setTel(751111111111L);
		cliente.setNome("Wellington Santos");
		clienteDao.cadastrar(cliente);
		
		return cliente;
	}
}
