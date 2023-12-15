package Tarefa00;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoNomes {
    public static void main(String[] args) {
        separandoStringGenero();
        separandoStringOrdenando();
    }

    private static void separandoStringGenero() {
        Scanner scanner = new Scanner(System.in);
        List<String> listaDeHomens = new ArrayList<>();
        List<String> listaDeMulheres = new ArrayList<>();
        while(true) {
            System.out.print("Digite um nome e gênero (Joao-M) ou 'sair' para encerrar: ");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            } else {
                String[] partes = input.split("-");

                if (partes.length == 2) {
                    String nome = partes[0];
                    String genero = partes[1];
                    if (genero.equalsIgnoreCase("M")) {
                        listaDeHomens.add(nome);
                    } else {
                        listaDeMulheres.add(nome);
                    }
                }
            }
        }
        System.out.println(listaDeHomens);
        System.out.println(listaDeMulheres);
    }

    private static void separandoStringOrdenando() {
        Scanner scanner = new Scanner(System.in);
        boolean teste = true;
        List<String> lista = null;
        lista = new ArrayList<>();

        while (teste) {
            System.out.print("Digite nomes separados por vírgula: ");
            String input = scanner.nextLine();                                 //Input


            String[] nomes = input.split(" , ");                        //Separando a String
            Collections.addAll(lista, nomes);

            Collections.sort(lista);                                          //Ordenando


            System.out.print("Quer digitar outro nome? [S/N]: ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println(lista);
    }
}
