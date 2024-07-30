package com.wellscosta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wellscosta.domain.Cliente;

@Repository
public interface ICLienteRepository extends CrudRepository<Cliente, Long> {

}
