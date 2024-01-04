package TarefaM13;

public class Principal {
    public static void main(String[] args) {
        PF pf = new PF(11111111111111l, "Wellington", "M");
        PJ pj = new PJ(22222222222222222l, "Laina", "F");

        System.out.println("Pessoa Fisica: " + pf.toString());
        System.out.println("\nPessoa Juridica: " + pj.toString());
    }
}
