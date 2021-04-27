package io.github.i_grr.api.orange.talents.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.i_grr.api.orange.talents.model.Endereco;
import io.github.i_grr.api.orange.talents.model.Usuario;
import io.github.i_grr.api.orange.talents.model.exception.UsuarioNotFoundException;
import io.github.i_grr.api.orange.talents.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final EnderecoService enderecoService;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, EnderecoService enderecoService) {
		this.usuarioRepository = usuarioRepository;
		this.enderecoService = enderecoService;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getEUsuarios() {
		return StreamSupport
				.stream(usuarioRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() ->
		new UsuarioNotFoundException(id));
	}
	
	public Usuario addEnderecosToUsuario(Long usuarioId, Long enderecoId) {
		Usuario usuario = getUsuario(usuarioId);
		Endereco endereco = enderecoService.getEndereco(enderecoId);
		usuario.addEndereco(endereco);
		return usuario;
	}
	
}
