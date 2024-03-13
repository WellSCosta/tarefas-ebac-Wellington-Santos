package SeparacaoPorSexo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testListaApenasMulheres() {
        List<String> pessoas = Arrays.asList("Elaine, F", "Wellington, M", "Laina, F", "William, M", "Bel, F");

        List<String> mulheres = pessoas.stream()
                .map(pessoa -> pessoa.split(","))
                .filter(pessoa -> pessoa.length == 2 && pessoa[1].trim().equalsIgnoreCase("F"))
                .map(pessoa -> pessoa[0].trim())
                .collect(Collectors.toList());

        //Testando a lista atual com a lista criada somente com as mulheres da lista principal
        List<String> somenteMulheres = Arrays.asList("Elaine" , "Laina", "Bel");
        assertEquals(somenteMulheres, mulheres);
    }
}
