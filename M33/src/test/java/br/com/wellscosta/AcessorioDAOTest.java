/**
 * 
 */
package br.com.wellscosta;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.wellscosta.dao.AcessorioDAO;
import br.com.wellscosta.dao.CarroDAO;
import br.com.wellscosta.dao.IAcessorioDAO;
import br.com.wellscosta.dao.ICarroDAO;
import br.com.wellscosta.dao.IMarcaDAO;
import br.com.wellscosta.dao.MarcaDAO;
import br.com.wellscosta.domain.Acessorio;
import br.com.wellscosta.domain.Carro;
import br.com.wellscosta.domain.Marca;

/**
 * @author Wellington
 */
public class AcessorioDAOTest {
	
	private ICarroDAO carroDAO;
	
	private IMarcaDAO marcaDAO;
	
	private IAcessorioDAO acessorioDAO;
	
	public AcessorioDAOTest() {
		carroDAO = new CarroDAO();
		acessorioDAO = new AcessorioDAO();
		marcaDAO = new MarcaDAO();
	}

	
	@Test
	public void cadastrar() {
		Acessorio acessorio = new Acessorio();
		
		Carro carro = criarCarro("A1");
		
		acessorio.setCodigo("A1");
		acessorio.setNome("ACESSORIO");
		acessorio.setDescricao("DESCRICAO");
		acessorio.setCarro(carro);
		
		acessorio = acessorioDAO.cadastrar(acessorio);
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
	}


	private Carro criarCarro(String codigo) {
		Carro carro = new Carro();
		
		Marca marca = criarMarca("A1");
		
		carro.setCodigo("A1");
		carro.setNome("CARRO");
		carro.setDescricao("Descricao");
		carro.setMarca(marca);
		
		return carroDAO.cadastrar(carro);
	}


	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setDescricao("DESCRICAO");
		marca.setNome("MARCA");
		
		return marcaDAO.cadastrar(marca);
	}
}
