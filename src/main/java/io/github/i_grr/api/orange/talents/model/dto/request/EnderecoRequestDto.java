package io.github.i_grr.api.orange.talents.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EnderecoRequestDto {
	
	@NotBlank(message = "O campo numero é obrigatório")
	private String numero;
	
	private String complemento;

	@NotBlank(message = "O campo CEP é obrigatório")
	@Pattern(regexp = "\\d{5}\\d{3}", message = "O CEP informado não é válido.")
	private String cep;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
