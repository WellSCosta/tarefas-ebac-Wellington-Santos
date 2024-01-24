package PadroesDeProjetos.Fabrica;

public class comContrato extends Fabrica{
    @Override
    Carro entregarCarro(String grade) {
        if (grade.equalsIgnoreCase("A")) {
            return new Corola("Corola", 100, "branco", "cheio");

        } else if (grade.equalsIgnoreCase("B")) {
            return new Camaro("Camaro", 120, "amarelo", "cheio");

        } else {
            return null;
        }
    }
}
