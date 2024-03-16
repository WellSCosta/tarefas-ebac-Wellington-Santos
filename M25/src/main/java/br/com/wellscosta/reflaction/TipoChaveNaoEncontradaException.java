/**
 * 
 */
package br.com.wellscosta.reflaction;

/**
 * @author Wellington
 */
public class TipoChaveNaoEncontradaException extends Exception{
	
	public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
