package PadroesDeProjetos.Fabrica;

public class Carro {

    private String nome;
    private int potencia;
    private String cor;
    private String gasolina;

    public Carro(String nome, int potencia, String cor, String gasolina) {
        this.nome = nome;
        this.potencia = potencia;
        this.cor = cor;
        this.gasolina = gasolina;
    }

    public void ligar(){
        System.out.println(nome);
        System.out.println("O motor está ligado, e está pronto pra usar " + potencia + " cavalos de potencia" );
    }
    public void limpar(){
        System.out.println("Carro esta limpo, e a cor " + cor.toLowerCase() + " está brilhando");
    }
    public void verificarMecanico(){
        System.out.println("Carro está sendo verificado pelo mecanico. Tudo parece está de acordo!");
    }
    public void tanqueGaso(){
        System.out.println("Gasolina atual: " + gasolina.toLowerCase());
    }
}
