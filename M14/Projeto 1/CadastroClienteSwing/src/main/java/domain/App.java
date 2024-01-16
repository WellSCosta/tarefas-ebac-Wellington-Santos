package domain;

import dao.ClienteMapDAO;
import dao.IClienteDAO;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro | 2 para consulta | 3 para exclusão | 4 para alteração | 5 para sair",
                "Home", JOptionPane.QUESTION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção invalida! digite 1 para cadastro | 2 para consulta | 3 para exclusão | 4 para alteração | 5 para sair",
                    "Home", JOptionPane.QUESTION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            }else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, " +
                                "Endereço, Número, Cidade, Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Exclusao", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, " +
                                "Endereço, Número, Cidade, Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }


            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro | 2 para consulta | 3 para exclusão | 4 para alteração | 5 para sair",
                    "Home", JOptionPane.QUESTION_MESSAGE);
        }



    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
                dadosSeparados[4], dadosSeparados[5],dadosSeparados[6]);

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                    "SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado",
                    "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso: " + cliente.toString(),
                    "SUCESSO",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado",
                    "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);

        iClienteDAO.alterar(cliente);
    }

    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados));

        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ",
                "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isExclusao(String opcao) {
        if (opcao.equals("3")) {
            return true;
        }
        return false;
    }

    private static boolean isConsulta(String opcao) {
        if (opcao.equals("2")) {
            return true;
        }
        return false;
    }

    private static boolean isCadastro(String opcao) {
        if (opcao.equals("1")) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if (opcao.equals("5")) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoValida(String opcao) {
        if (opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5")) {
            return true;
        }else {
            return false;
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "SAIR",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
//Wellington, 08616161546, 75991012167, Rua Olhos Claros, 246, Feira de Santana, BA
