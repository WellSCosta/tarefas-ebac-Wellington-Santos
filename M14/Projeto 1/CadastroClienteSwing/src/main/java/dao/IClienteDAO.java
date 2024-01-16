package dao;

import domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente); //Vai criar um novo cliente, pedindo todas as informações e devolvendo um valor true

    public void excluir(Long cpf);             //Vai pedir o cpf para fazer a exclusao

    public void alterar(Cliente cliente);      //Vai pedir todas as informações do cliente para alterar

    public Cliente consultar(Long cpf);        //Vai pedir o cpf para consultar o cliente e devolver as informações

    public Collection<Cliente> buscarTodos(); //Não pede nada, e retorna todos os clientes na Collection
}
