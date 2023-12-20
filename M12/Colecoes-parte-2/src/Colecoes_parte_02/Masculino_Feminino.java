package Colecoes_parte_02;

import java.util.*;

public class Masculino_Feminino {
    public static void main(String[] args) {
        separarPorSexo();
    }

    private static void separarPorSexo() { //Wellington, M, Laina, F, Nilton, M, William, M, Elaine, F, Jose, M
        Scanner scanner = new Scanner(System.in);
        List<String> pessoas = new ArrayList<>();
        System.out.print("Digite nome e sexo separados por virgula (ex: Joao, M, Maria, F): ");
        String entrada = scanner.nextLine();

        String[] partes = entrada.split(", ");
        for (int i = 0; i < partes.length; i += 2) {
            String nome = partes[i];
            String sexo = partes[i + 1];
            //System.out.println(nome);
            //System.out.println(sexo);

            if (!"M".equalsIgnoreCase(sexo) && !"F".equalsIgnoreCase(sexo)) {
                System.out.println("Sexo Invalido: " + sexo + " para o nome " + nome);
                continue;
            }
            pessoas.add(nome + "," + sexo);
        }
        //System.out.println(pessoas);

        Map<String, List<String>> grupos = new HashMap<>();
        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        for (String pessoa: pessoas) {
            String[] detalhes = pessoa.split(",");
            String nome = detalhes[0];
            String sexo = detalhes[1];
            grupos.get(sexo).add(nome);
        }

        System.out.println("\nGrupo Masculino");
        for (String nome: grupos.get("M")) {
            System.out.println(nome);
        }

        System.out.println("\nGrupo Feminino");
        for (String nome: grupos.get("F")) {
            System.out.println(nome);
        }
    }
}
