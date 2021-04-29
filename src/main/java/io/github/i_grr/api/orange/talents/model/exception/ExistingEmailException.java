package io.github.i_grr.api.orange.talents.model.exception;

import java.text.MessageFormat;

public class ExistingEmailException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExistingEmailException(final String email) {
		super(MessageFormat.format("Já existe um usuário cadastrado com o email {0}", email));
	}

}
