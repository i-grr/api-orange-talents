package io.github.i_grr.api.orange.talents.model.dto;

import javax.validation.constraints.NotBlank;

import io.github.i_grr.api.orange.talents.model.Endereco;

public class EnderecoDto {
	
	private Long id;
	
	@NotBlank(message = "O campo logradouro é obrigatório")
	private String logradouro;
	
	@NotBlank(message = "O campo numero é obrigatório")
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "O campo bairro é obrigatório")
	private String bairro;
	
	@NotBlank(message = "O campo cidade é obrigatório")
	private String cidade;
	
	@NotBlank(message = "O campo estado é obrigatório")
	private String estado;
	
	@NotBlank(message = "O campo CEP é obrigatório")
	private String cep;
	
	public static EnderecoDto from(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto();
		enderecoDto.setId(endereco.getId());
		enderecoDto.setLogradouro(endereco.getLogradouro());
		enderecoDto.setNumero(endereco.getNumero());
		enderecoDto.setComplemento(endereco.getComplemento());
		enderecoDto.setBairro(endereco.getBairro());
		enderecoDto.setCidade(endereco.getCidade());
		enderecoDto.setEstado(endereco.getEstado());
		enderecoDto.setCep(endereco.getCep());
		return enderecoDto;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
