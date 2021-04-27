package io.github.i_grr.api.orange.talents.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.i_grr.api.orange.talents.model.Endereco;
import io.github.i_grr.api.orange.talents.model.exception.EnderecoNotFoundException;
import io.github.i_grr.api.orange.talents.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public Endereco addEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> getEnderecos() {
		return StreamSupport
				.stream(enderecoRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Endereco getEndereco(Long id) {
		return enderecoRepository.findById(id).orElseThrow(() ->
				new EnderecoNotFoundException(id));
	}
	
}
