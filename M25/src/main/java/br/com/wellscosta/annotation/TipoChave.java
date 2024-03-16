package br.com.wellscosta.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
