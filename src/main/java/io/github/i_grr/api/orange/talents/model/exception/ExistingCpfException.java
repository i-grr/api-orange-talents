package io.github.i_grr.api.orange.talents.model.exception;

import java.text.MessageFormat;

public class ExistingCpfException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExistingCpfException(final String cpf) {
		super(MessageFormat.format("Já existe um usuário cadastrado com o CPF {0}", cpf));
	}

}
