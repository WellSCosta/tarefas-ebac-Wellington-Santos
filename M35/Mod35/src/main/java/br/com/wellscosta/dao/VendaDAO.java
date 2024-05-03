/**
 *
 */
package br.com.wellscosta.dao;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.wellscosta.dao.generic.GenericDAO;
import br.com.wellscosta.domain.Cliente;
import br.com.wellscosta.domain.Produto;
import br.com.wellscosta.domain.Venda;

/**
 * @author WellSCosta
 */
public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

	public VendaDAO() {
		super(Venda.class);
	}
	
	@Override
	public Venda cadastrar(Venda entity) {
		openConnection();
		entity.getProdutos().forEach(prod -> {
			Produto produto = entityManager.merge(prod.getProduto());
			prod.setProduto(produto);
			});
		Cliente cliente = entityManager.merge(entity.getCliente());
		entity.setCliente(cliente);
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		closeConnection();
		
		return entity;
	}
	
	@Override
	public void excluir(Venda entity) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void finalizarVenda(Venda venda) {
		super.alterar(venda);
		
	}

	@Override
	public void cancelarVenda(Venda venda) {
		super.alterar(venda);
		
	}

	@Override
	public Venda consultarComCollection(Long id) {
		openConnection();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
		
		Root<Venda> root = query.from(Venda.class);
		root.fetch("cliente");
		root.fetch("produtos");
		
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Venda> tpQuery = 
				entityManager.createQuery(query);
		Venda venda = tpQuery.getSingleResult();  
		
		return venda;
	}

}
