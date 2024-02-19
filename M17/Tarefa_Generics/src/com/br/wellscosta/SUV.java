package com.br.wellscosta;

public class SUV extends Carro{

    public SUV(String modelo) {
        super(modelo);
    }

    @Override
    void ligar() {
        System.out.println(getModelo() + " SUV ligando");
    }

    @Override
    void acelerar() {
        System.out.println(getModelo() + " SUV acelerando...");
    }

    @Override
    void frear() {
        System.out.println(getModelo() + " SUV freando...");
    }

    @Override
    void desligar() {
        System.out.println(getModelo() + " SUV desligando");
    }
}
