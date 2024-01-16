package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ClienteMapDAO implements IClienteDAO{

    private Map<Long, Cliente> map; //Criando o MAP (Long = cpf = key, Cliente = atributo guardado no MAP)

    /*Construtor:
    Instancia o MAP com o HashMap(não garante a ordem dos elementos)*/
    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {  //Se já tem o determinado CPF como chave
            return false; //CPF já cadastrado
        }
        this.map.put(cliente.getCpf(), cliente); //Adiciona o cliente no map, usando seu CPF como chave
        return true; //Foi adicionado
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf); //Obtem um cliente cadastrado usando o cpf como chave e armazena no objeto clienteCadastrado

        if (clienteCadastrado != null) { //Se o cliente retornado pela chave for diferente de nulo
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado); //remove o cliente do MAP
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());

        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setEstado(cliente.getEstado());
            clienteCadastrado.setTel(cliente.getTel());
        } else {
            JOptionPane.showMessageDialog(null, "CPF Incorreto, Tente Novamente", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
