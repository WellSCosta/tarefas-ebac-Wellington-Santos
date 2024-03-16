package br.com.wellscosta.generic;

import br.com.wellscosta.domain.Persistente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;

import java.lang.reflect.InvocationTargetException;

public interface IGenericDAO<T extends Persistente> {

    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    Boolean excluir(Long valor);

    void alterar(T entity) throws TipoChaveNaoEncontradaException;

    T consultar(Long valor);
}
