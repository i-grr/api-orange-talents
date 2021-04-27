package io.github.i_grr.api.orange.talents.model.exception;

import java.text.MessageFormat;

public class EnderecoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnderecoNotFoundException(Long id) {
		super(MessageFormat.format("Não foi possível localizar o endereço com o id {0}", id));
	}
	
}
