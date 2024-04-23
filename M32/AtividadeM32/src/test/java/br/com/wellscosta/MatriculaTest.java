/**
 * 
 */
package br.com.wellscosta;

import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import br.com.wellscosta.dao.IMatriculaDAO;
import br.com.wellscosta.dao.MatriculaDAO;
import br.com.wellscosta.domain.Matricula;

/**
 * 
 */
public class MatriculaTest {
	
	private IMatriculaDAO matDAO;
	
	public MatriculaTest() {
		matDAO = new MatriculaDAO();
	}
	
	@Test
	public void cadastrarTest() {
		
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setNome("Matricula");
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		
		mat = matDAO.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
	}
}
