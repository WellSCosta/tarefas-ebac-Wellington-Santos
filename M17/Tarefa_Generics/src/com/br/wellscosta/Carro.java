package com.br.wellscosta;

public abstract class Carro {

    private String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    abstract void ligar();
    abstract void acelerar();
    abstract void frear();
    abstract void desligar();
}
