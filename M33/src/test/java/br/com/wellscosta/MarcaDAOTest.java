/**
 * 
 */
package br.com.wellscosta;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.wellscosta.dao.IMarcaDAO;
import br.com.wellscosta.dao.MarcaDAO;
import br.com.wellscosta.domain.Marca;

/**
 * @author Wellington
 */
public class MarcaDAOTest {
	
	private IMarcaDAO marcaDAO;
	
	public MarcaDAOTest() {
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("A1");
		marca.setDescricao("DESCRICAO");
		marca.setNome("MARCA");
		
		marca = marcaDAO.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
	}
}
