import com.br.wellscosta.Caminhonete;
import com.br.wellscosta.Garagem;
import com.br.wellscosta.SUV;
import com.br.wellscosta.Sedan;

public class Main {
    public static void main(String[] args) {
        Sedan civic = new Sedan("Civic");
        Sedan prisma = new Sedan("Prisma");
        Sedan siena = new Sedan("Siena");

        SUV suv = new SUV("CR-V");
        Caminhonete caminhonete = new Caminhonete("Hilux");

        Garagem<Sedan> garagemSedan = new Garagem<>();
        garagemSedan.adicionarCarro(civic);
        garagemSedan.adicionarCarro(prisma);
        garagemSedan.adicionarCarro(siena);

        // garagemSedan.adicionarCarro(caminhonete); // Erro, pois só aceita carros Sedan

        garagemSedan.exibir();
    }
}