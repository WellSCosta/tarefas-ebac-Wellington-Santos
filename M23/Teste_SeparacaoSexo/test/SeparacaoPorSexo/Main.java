package SeparacaoPorSexo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main {
    public static void main(String[] args) {
        List<String> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os dados das pessoas (nome, sexualidade), digite 'ok' para encerrar:");

        String entrada;
        while(!(entrada = scanner.nextLine().trim()).equalsIgnoreCase("ok")) {
            pessoas.add(entrada);
        }

        List<String> mulheres = pessoas.stream()
                .map(pessoa -> pessoa.split(","))
                .filter(pessoa -> pessoa.length == 2 && pessoa[1].trim().equalsIgnoreCase("F"))
                .map(pessoa -> pessoa[0].trim())
                .collect(Collectors.toList());


        System.out.println("\nLista de Mulheres: ");
        mulheres.forEach(System.out::println);
    }

    @Test
    public void testListaApenasMulheres() {
        List<String> pessoas = Arrays.asList("Elaine, F", "Wellington, M", "Laina, F", "William, M", "Bel, F");

        List<String> mulheres = pessoas.stream()
                .map(pessoa -> pessoa.split(","))
                .filter(pessoa -> pessoa.length == 2 && pessoa[1].trim().equalsIgnoreCase("F"))
                .map(pessoa -> pessoa[0].trim())
                .collect(Collectors.toList());

        //Testando a lista atual com a lista criada somente com as mulheres da lista principal
        List<String> somenteMulheres = Arrays.asList("Elaine" , "Laina", "Bel");
        assertEquals(somenteMulheres, mulheres);
    }
}
