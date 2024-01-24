package PadroesDeProjetos.Fabrica;

public class App {
    public static void main(String[] args) {
        Customer cliente = new Customer("b", true);
        Fabrica fabrica = getFabrica(cliente);

        fabrica.criar(cliente.getGradeRequest());
    }

    private static Fabrica getFabrica(Customer cliente) {
        if (cliente.getTemComtratoCompania()) {
            return new comContrato();
        } else {
            return new semContrato();
        }
    }
}
