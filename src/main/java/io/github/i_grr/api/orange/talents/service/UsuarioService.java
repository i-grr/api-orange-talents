package io.github.i_grr.api.orange.talents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.i_grr.api.orange.talents.model.Endereco;
import io.github.i_grr.api.orange.talents.model.Usuario;
import io.github.i_grr.api.orange.talents.model.exception.ExistingCpfException;
import io.github.i_grr.api.orange.talents.model.exception.ExistingEmailException;
import io.github.i_grr.api.orange.talents.model.exception.UsuarioNotFoundException;
import io.github.i_grr.api.orange.talents.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		if (usuarioRepository.existsByCpf(usuario.getCpf()))
			throw new ExistingCpfException(usuario.getCpf());
		
		if (usuarioRepository.existsByEmail(usuario.getEmail()))
			throw new ExistingEmailException(usuario.getEmail());
			
		return usuarioRepository.save(usuario);
	}
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() ->
			new UsuarioNotFoundException(id));
	}
	
	public Usuario addEnderecosToUsuario(Long usuarioId, Endereco endereco) {
		Usuario usuario = getUsuario(usuarioId);
		usuario.addEndereco(endereco);
		return usuarioRepository.save(usuario);
	}
	
}
