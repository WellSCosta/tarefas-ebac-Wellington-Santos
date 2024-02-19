package com.br.wellscosta;

public class Sedan extends Carro{

    public Sedan(String modelo) {
        super(modelo);
    }

    @Override
    void ligar() {
        System.out.println(getModelo() + " Sedan ligando");
    }

    @Override
    void acelerar() {
        System.out.println(getModelo() + " Sedan acelerando...");
    }

    @Override
    void frear() {
        System.out.println(getModelo() + " Sedan freando...");
    }

    @Override
    void desligar() {
        System.out.println(getModelo() + " Sedan desligando");
    }
}
