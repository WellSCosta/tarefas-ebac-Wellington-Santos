public class Operacoes {
    public static void main(String[] args) {
        mediaNotas();
    }

    public static void mediaNotas() {
        float num1 = 10;
        float num2 = 5.5f;
        float num3 = 2.3f;
        float num4 = 7.5f;
        float num5 = (num1 + num2 + num3 + num4) / 4;

        System.out.println("--- NOTAS ---");
        System.out.println("Aluno 1: " + num1);
        System.out.println("Aluno 2: " + num2);
        System.out.println("Aluno 3: " + num3);
        System.out.println("Aluno 4: " + num4);
        System.out.println("-------------");

        System.out.println(" ");

        System.out.println("Média da Classe : " + num5);
    }
}
