package io.github.i_grr.api.orange.talents.model.dto.response;

import io.github.i_grr.api.orange.talents.model.dto.EnderecoDto;

public class EnderecoResponseDto {

	private String logradouro;
	
	private String numero;
	
	private String complemento;

	private String bairro;

	private String cidade;

	private String estado;

	private String cep;
	
	public static EnderecoResponseDto from(EnderecoDto enderecoDto) {
		EnderecoResponseDto enderecoResponseDto = new EnderecoResponseDto();
		enderecoResponseDto.setLogradouro(enderecoDto.getLogradouro());
		enderecoResponseDto.setNumero(enderecoDto.getNumero());
		enderecoResponseDto.setComplemento(enderecoDto.getComplemento());
		enderecoResponseDto.setBairro(enderecoDto.getBairro());
		enderecoResponseDto.setCidade(enderecoDto.getCidade());
		enderecoResponseDto.setEstado(enderecoDto.getEstado());
		enderecoResponseDto.setCep(enderecoDto.getCep());
		return enderecoResponseDto;
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
