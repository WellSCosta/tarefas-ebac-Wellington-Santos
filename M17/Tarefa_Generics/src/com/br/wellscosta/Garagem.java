package com.br.wellscosta;

import java.util.ArrayList;
import java.util.List;

public class Garagem <T extends Carro> {

    private List<T> carros;

    public Garagem() {
        this.carros = new ArrayList<>();
    }

    public void adicionarCarro(T carro) {
        carros.add(carro);
        System.out.println(carro.getModelo() + " adicionado à garagem");
    }

    public void exibir() {
        System.out.println("Carros na garagem: ");

        for (T carro : carros) {
            System.out.println(carro.getModelo());
        }
    }


}
