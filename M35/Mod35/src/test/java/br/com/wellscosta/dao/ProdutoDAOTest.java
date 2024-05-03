/**
 *
 */
package br.com.wellscosta.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;

import br.com.wellscosta.domain.Produto;

/**
 * @author WellSCosta
 */
public class ProdutoDAOTest {
	
	IProdutoDAO produtoDao;
	
	public ProdutoDAOTest() {
		produtoDao = new ProdutoDAO();
	}
	
	@After
	public void end() {
		
		Collection<Produto> produtos = produtoDao.buscarTodos();
		produtos.forEach(prod -> produtoDao.excluir(prod));
	}
	
	@Test
	public void cadastrarProduto() {
		Produto produto = criarProduto("A1");
		
		Produto retorno = produtoDao.cadastrar(produto);
		assertNotNull(retorno);
	}
	
	@Test
	public void consultarProduto() {
		Produto produto = criarProduto("A1");
		
		Produto retorno = produtoDao.cadastrar(produto);
		assertNotNull(retorno);
		
		Produto produtoConsultado = produtoDao.consultar(retorno.getId());
		assertNotNull(produtoConsultado);
		
	}
	
	@Test
	public void atualizarProduto() {
		Produto produto = criarProduto("A1");
		
		Produto retorno = produtoDao.cadastrar(produto);
		assertNotNull(retorno);
		
		Produto produtoConsultado = produtoDao.consultar(retorno.getId());
		assertNotNull(produtoConsultado);
		
		produtoConsultado.setNome("Caneta");
		produtoDao.alterar(produtoConsultado);
		
		Produto produtoAtualizado = produtoDao.consultar(produtoConsultado.getId());
		assertNotNull(produtoAtualizado);
		assertEquals("Caneta", produtoAtualizado.getNome());
	}
	
	@Test
	public void excluirProduto() {
		Produto produto = criarProduto("A1");
		
		Produto retorno = produtoDao.cadastrar(produto);
		assertNotNull(retorno);
		
		Produto produtoConsultado = produtoDao.consultar(retorno.getId());
		assertNotNull(produtoConsultado);
		
		produtoDao.excluir(produtoConsultado);
		
		Produto produtoConsultado1 = produtoDao.consultar(retorno.getId());
		assertNull(produtoConsultado1);
	}
	
	@Test
	public void buscarTodos() {
		
		Produto produto = criarProduto("A1");
		Produto retorno = produtoDao.cadastrar(produto);
		Produto produtoConsultado = produtoDao.consultar(retorno.getId());
		assertNotNull(produtoConsultado);
		
		
		Produto produto1 = criarProduto("A2");
		Produto retorno1 = produtoDao.cadastrar(produto1);
		Produto produtoConsultado1 = produtoDao.consultar(retorno1.getId());
		assertNotNull(produtoConsultado1);
		
		Collection<Produto> produtos = produtoDao.buscarTodos();
		assertNotNull(produtos);
		assertEquals(2, produtos.size());
	}

	private Produto criarProduto(String codigo) {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Faber Castel - Preta");
		produto.setNome("Caneta Nanquim");
		produto.setValor(BigDecimal.TEN);
		
		return produto;
	}

}
