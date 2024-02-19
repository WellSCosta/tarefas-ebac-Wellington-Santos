package com.br.wellscosta;

public class Caminhonete extends Carro{

    public Caminhonete(String modelo) {
        super(modelo);
    }

    @Override
    void ligar() {
        System.out.println(getModelo() + " Caminhonete ligando");
    }

    @Override
    void acelerar() {
        System.out.println(getModelo() + " Caminhonete acelerando...");
    }

    @Override
    void frear() {
        System.out.println(getModelo() + " Caminhonete freando...");
    }

    @Override
    void desligar() {
        System.out.println(getModelo() + " Caminhonete desligando");
    }
}
