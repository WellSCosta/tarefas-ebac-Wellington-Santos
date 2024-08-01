/**
 * 
 */
package com.wellscosta.dao.jpa;

import com.wellscosta.dao.generic.jpa.IGenericJapDAO;
import com.wellscosta.domain.jpa.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
