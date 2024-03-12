package SeparacaoPorSexo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
}
