package main;

import main.br.com.wellscosta.dao.IProdutoDAO;
import main.br.com.wellscosta.dao.ProdutoDAO;
import main.br.com.wellscosta.domain.Produto;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;



public class ProdutoTest {

    private IProdutoDAO dao;

    @Test
    public void cadastrarTest() throws SQLException {
        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Notebook");
        Integer countCad = dao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        System.out.println(produtoBD.toString());

        Integer qtdeDel = dao.excluir(produtoBD);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }

    @Test
    public void consultarTest() throws SQLException {
        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Notebook");
        Integer countCad = dao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        System.out.println(produtoBD.toString());

        Integer qtdeDel = dao.excluir(produtoBD);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }

    @Test
    public void excluirTest() throws SQLException {
        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Notebook");
        Integer countCad = dao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        System.out.println(produtoBD.toString());

        Integer qtdeDel = dao.excluir(produtoBD);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }

    @Test
    public void consultarTodosTest() throws SQLException {
        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Notebook");
        Integer countCad = dao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto1 = new Produto();
        produto1.setCodigo("02");
        produto1.setNome("Caderno");
        Integer countCad1 = dao.cadastrar(produto1);
        assertTrue(countCad1 == 1);

        List<Produto> list = dao.consultarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto pro : list) {
            dao.excluir(pro);
            countDel ++;
        }
        assertEquals(list.size(), countDel);

        list = dao.consultarTodos();
        assertEquals(list.size(), 0);
    }

    @Test
    public void atualizarTest() throws SQLException {
        dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Notebook");
        Integer countCad = dao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        System.out.println(produtoBD.toString());

        produtoBD.setNome("Caderno");
        produtoBD.setCodigo("02");

        Integer countUpdate = dao.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = dao.consultar("01");
        assertNull(produtoBD1);

        Produto produtoBD2 = dao.consultar("02");
        assertNotNull(produtoBD2);

        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());

        Integer qtdeDel = dao.excluir(produtoBD2);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }
}
