package PadroesDeProjetos.Fabrica;

public abstract class Fabrica {

    public Carro criar(String grade) {
        Carro carro = entregarCarro(grade);

        carro = prepararCarro(carro);
        return carro;
    }

    private Carro prepararCarro(Carro carro) {
        carro.ligar();
        carro.limpar();
        carro.tanqueGaso();
        carro.verificarMecanico();

        return carro;
    }

    abstract Carro entregarCarro(String grade);
}
