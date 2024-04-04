package main.br.com.wellscosta.dao;

import main.br.com.wellscosta.dao.jdbc.ConnectionFactory;
import main.br.com.wellscosta.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{

    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "INSERT INTO tb_produto (id, nome, codigo) VALUES (nextval('sq_produto'), ?, ?)";
            stm = connection.prepareStatement(sql);

            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getCodigo());

            return stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        Produto produto = null;
        ResultSet rs = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM tb_produto WHERE codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);

            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setId(rs.getLong("id"));
            }
            return produto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "DELETE FROM tb_produto WHERE codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());

            return stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produtoBD) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "UPDATE tb_produto SET nome = ?, codigo = ? WHERE id = ?";
            stm = connection.prepareStatement(sql);

            stm.setString(1, produtoBD.getNome());
            stm.setString(2, produtoBD.getCodigo());
            stm.setLong(3, produtoBD.getId());

            return stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
        }
    }

    @Override
    public List<Produto> consultarTodos() throws SQLException {
        List<Produto> list;
        Connection connection = null;
        PreparedStatement stm = null;
        Produto produto;
        ResultSet rs = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM tb_produto";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            list = new ArrayList<>();
            while (rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setId(rs.getLong("id"));

                list.add(produto);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        }
    }
}
