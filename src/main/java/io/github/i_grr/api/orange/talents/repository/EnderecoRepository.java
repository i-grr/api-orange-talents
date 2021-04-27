package io.github.i_grr.api.orange.talents.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.i_grr.api.orange.talents.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

}
