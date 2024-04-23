/**
 * 
 */
package br.com.wellscosta;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.wellscosta.dao.CursoDAO;
import br.com.wellscosta.dao.ICursoDAO;
import br.com.wellscosta.domain.Curso;

/**
 * 
 */
public class CursoTest {

private ICursoDAO cursoDAO;
	
	public CursoTest() {
		cursoDAO = new CursoDAO();
	}
	
	@Test
	public void cadastrarTest() {
		
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("Curso Teste");
		curso.setNome("Curso Backend JAVA");
		
		curso = cursoDAO.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
		
	}
}
