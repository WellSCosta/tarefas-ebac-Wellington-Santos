package main.br.com.wellscosta.dao;

import main.br.com.wellscosta.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {

    Integer cadastrar(Produto produto) throws SQLException;

    Produto consultar(String codigo) throws SQLException;

    Integer excluir(Produto produto) throws SQLException;

    Integer atualizar(Produto produtoBD) throws SQLException;

    List<Produto> consultarTodos() throws SQLException;
}
