package main;

import org.junit.Test;

import main.br.com.wellscosta.dao.ClienteDAO;
import main.br.com.wellscosta.dao.IClienteDAO;
import main.br.com.wellscosta.domain.Cliente;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    private IClienteDAO dao;

    @Test
    public void cadastrarTest() throws SQLException {
        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Wellington Santos");
        Integer countCad = dao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        System.out.println(clienteBD.toString());

        Integer qtdeDel = dao.excluir(clienteBD);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }

    @Test
    public void consultarTest() throws SQLException {
        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Wellington Santos");
        Integer countCad = dao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        System.out.println(clienteBD.toString());

        Integer qtdeDel = dao.excluir(clienteBD);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }

    @Test
    public void excluirTest() throws SQLException {
        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Wellington Santos");
        Integer countCad = dao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        System.out.println(clienteBD.toString());

        Integer qtdeDel = dao.excluir(clienteBD);
        assertTrue(qtdeDel == 1);
        assertNotNull(qtdeDel);
    }
    
    @Test
    public void atualizarTest() throws SQLException {
        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Wellington Santos");
        Integer countCad = dao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = dao.consultar("01");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("02");
        clienteBD.setNome("Laina de Castro");

        
        Integer countUpdate = dao.atualizar(clienteBD);
        assertTrue(countUpdate == 1);

        Cliente clienteBD1 = dao.consultar("01");
        assertNull(clienteBD1);

        Cliente clienteBD2 = dao.consultar("02");
        assertNotNull(clienteBD2);

        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());
        assertEquals(clienteBD.getId(), clienteBD2.getId());

        for(int i = 0; i < countUpdate; i++) {
            dao.excluir(clienteBD);
        }
    }

    @Test
    public void buscarTodosTest() throws SQLException {
        dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Wellington Santos");
        Integer countCad = dao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clientes = new Cliente();
        clientes.setCodigo("02");
        clientes.setNome("Laina de Castro");
        Integer countCad1 = dao.cadastrar(clientes);
        assertTrue(countCad1 == 1);

        List<Cliente> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for(Cliente cli : list) {
            System.out.println(cli.toString());
            dao.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = dao.buscarTodos();
        assertEquals(list.size(), 0);
    }
}
