/**
 *
 */
package br.com.wellscosta.dao;

import br.com.wellscosta.dao.generic.GenericDAO;
import br.com.wellscosta.domain.Produto;

/**
 * @author WellSCosta
 */
public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO{

	public ProdutoDAO() {
		super(Produto.class);
	}

}
