import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Nome do aluno: ");
        String aluno = s.next();
        System.out.println("-------------------------");

        float totNota = 0;
        for (int n = 1; n <= 4; n++) {
            System.out.print("Digite a " + n + "º nota: ");
            float nota = s.nextFloat();
            totNota += nota;
        }
        float media = totNota / 4;
        System.out.println(" ");

        if (media >= 7) {
            System.out.println("Parabéns " + aluno + ", você está Aprovado!");
        }else if (media >= 5) {
            System.out.println("Cuidado " + aluno + ", você está em Recuperação!");
        }else {
            System.out.println("Estude mais " + aluno + ", você está Reprovado!");
        }
        System.out.printf("Sua media é de: %.1f", media);
    }
}