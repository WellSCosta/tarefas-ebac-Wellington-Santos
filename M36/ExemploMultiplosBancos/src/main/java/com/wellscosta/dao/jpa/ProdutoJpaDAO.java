/**
 * 
 */
package com.wellscosta.dao.jpa;

import com.wellscosta.dao.generic.jpa.GenericJpaDB1DAO;
import com.wellscosta.domain.jpa.ProdutoJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
