package main.br.com.wellscosta.dao;

import main.br.com.wellscosta.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws SQLException;

    Cliente consultar(String codigo) throws SQLException;

    Integer excluir(Cliente cliente) throws SQLException;

    Integer atualizar(Cliente cliente) throws SQLException;

    List<Cliente> buscarTodos() throws SQLException;
}
