/**
 *
 */
package br.com.wellscosta.mock.dao;

import br.com.wellscosta.dao.IVendaDAO;
import br.com.wellscosta.dao.generic.GenericDAO;
import br.com.wellscosta.domain.Venda;

/**
 * @author WellSCosta
 * 
 * Classe utilizada somente no teste para fazer a exclusão das vendas
 */
public class VendaExclusaoDAO extends GenericDAO<Venda, Long> implements IVendaDAO{

	public VendaExclusaoDAO() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
		
	}

	@Override
	public void cancelarVenda(Venda venda) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
		
	}

	@Override
	public Venda consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
