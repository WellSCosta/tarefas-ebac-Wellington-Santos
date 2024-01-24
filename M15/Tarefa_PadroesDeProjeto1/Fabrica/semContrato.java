package PadroesDeProjetos.Fabrica;

public class semContrato extends Fabrica{
    @Override
    Carro entregarCarro(String grade) {
        if (grade.equalsIgnoreCase("A")) {
            return new Brasilia("Brasilia", 100, "amarelo", "cheio");

        } else if (grade.equalsIgnoreCase("B")) {
            return new Fusca("Fusca", 100, "preto", "cheio");

        } else {
            return null;
        }
    }
}
