/**
 * 
 */
package br.com.wellscosta;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.wellscosta.dao.IProdutoDAO;
import br.com.wellscosta.dao.ProdutoDAO;
import br.com.wellscosta.domain.Produto;

/**
 * 
 */
public class ProdutoTest {
	
	IProdutoDAO prodDAO;
	
	public ProdutoTest() {
		prodDAO = new ProdutoDAO();
	}
	
	@Test
	public void cadastrar() {
		Produto prod = new Produto();
		
		prod.setCodigo("A1");
		prod.setDescricao("BIC");
		prod.setNome("Caneta");
		
		prod = prodDAO.cadastrar(prod);
		
		assertNotNull(prod);
		assertNotNull(prod.getId());
		
	}

}
