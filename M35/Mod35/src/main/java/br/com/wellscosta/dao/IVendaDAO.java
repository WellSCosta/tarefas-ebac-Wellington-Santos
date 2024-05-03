/**
 *
 */
package br.com.wellscosta.dao;

import br.com.wellscosta.dao.generic.IGenericDAO;
import br.com.wellscosta.domain.Venda;

/**
 * @author WellSCosta
 */
public interface IVendaDAO extends IGenericDAO<Venda, Long>{
	
	public void finalizarVenda(Venda venda);
	
	public void cancelarVenda(Venda venda);
	
	/**
	 * Usando este método para evitar a exception org.hibernate.LazyInitializationException
	 * Ele busca todos os dados de objetos que tenham colletion pois a mesma por default é lazy
	 * Mas você pode configurar a propriedade da collection como fetch = FetchType.EAGER na anotação @OneToMany e usar o consultar genérico normal
	 * 
	 * OBS: Não é uma boa prática utiliar FetchType.EAGER pois ele sempre irá trazer todos os objetos da collection
	 * mesmo sem precisar utilizar.
	 * 
	 * 
	 * @see Venda produtos
	 * 
	 * @param id
	 * @return
	 */
	public Venda consultarComCollection(Long id);
}
