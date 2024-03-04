package br.com.wellscosta.reflaction;

import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) {
        lerValorAnotacao();
    }

    private static void lerValorAnotacao() {
        Anotacao anotacao = new Anotacao();
        Field[] fields = anotacao.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Tabela.class)) {
                Tabela tab = field.getAnnotation(Tabela.class);
                System.out.println("Anotação: " + tab.toString());
                System.out.println("O valor da anotação é: " + tab.value());
            }
        }
    }
}
