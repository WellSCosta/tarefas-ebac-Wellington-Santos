/**
 * 
 */
package br.com.wellscosta;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import br.com.wellscosta.dao.CarroDAO;
import br.com.wellscosta.dao.ICarroDAO;
import br.com.wellscosta.dao.IMarcaDAO;
import br.com.wellscosta.dao.MarcaDAO;
import br.com.wellscosta.domain.Carro;
import br.com.wellscosta.domain.Marca;
/**
 * @author Wellington
 */
public class CarroDAOTest {
	
	private ICarroDAO carroDAO;
	
	private IMarcaDAO marcaDAO;
		
	public CarroDAOTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		
		Marca marca = criarMarca("A1");
		
		carro.setCodigo("A1");
		carro.setNome("CARRO");
		carro.setDescricao("Descricao");
		carro.setMarca(marca);
		
		carro = carroDAO.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setDescricao("DESCRICAO");
		marca.setNome("MARCA");
		
		return marcaDAO.cadastrar(marca);
	}

}
