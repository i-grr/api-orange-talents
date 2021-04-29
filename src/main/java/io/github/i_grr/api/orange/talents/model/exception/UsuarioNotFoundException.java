package io.github.i_grr.api.orange.talents.model.exception;

import java.text.MessageFormat;

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(final Long id) {
		super(MessageFormat.format("Desculpe, o usuário com o id {0} não foi encontrado!", id));
	}
	
}
