package br.com.wellscosta.generic;

import br.com.wellscosta.annotation.TipoChave;
import br.com.wellscosta.domain.Persistente;
import br.com.wellscosta.reflaction.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T>{

    public Map<Class, Map<Long, T>> map;

    public GenericDAO() {
        if (this.map == null) {
            this.map = new HashMap<>();
        }
    }

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T objetoCadastrado);

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());

        Long chave = getChave(entity);
        if (mapaInterno.containsKey(chave)) {
            return false;
        } else {
            mapaInterno.put(chave, entity);
            return true;
        }
    }

    @Override
    public Boolean excluir(Long valor) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());

        T objetoCadastrado = mapaInterno.get(valor);

        if (objetoCadastrado != null) {
            mapaInterno.remove(valor, objetoCadastrado);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());

        T objetoCadastrado = mapaInterno.get(getChave(entity));

        if (objetoCadastrado != null) {
            atualizarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(Long valor) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());

        T objetoCadastrado = mapaInterno.get(valor);

        return objetoCadastrado;
    }
}
