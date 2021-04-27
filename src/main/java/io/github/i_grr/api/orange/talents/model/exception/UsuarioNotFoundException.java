package io.github.i_grr.api.orange.talents.model.exception;

import java.text.MessageFormat;

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(Long id) {
		super(MessageFormat.format("Não foi possível localizar o usuário com o id {0}", id));
	}
	
}
