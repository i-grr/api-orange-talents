package io.github.i_grr.api.orange.talents.model.dto.response;

import io.github.i_grr.api.orange.talents.model.Endereco;
import io.github.i_grr.api.orange.talents.model.dto.request.EnderecoRequestDto;

public class EnderecoResponseDto {
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;

	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	public static EnderecoResponseDto from(Endereco endereco) {
		EnderecoResponseDto enderecoResponseDto = new EnderecoResponseDto();
		enderecoResponseDto.setLogradouro(endereco.getLogradouro());
		enderecoResponseDto.setNumero(endereco.getNumero());
		enderecoResponseDto.setComplemento(endereco.getComplemento());
		enderecoResponseDto.setBairro(endereco.getBairro());
		enderecoResponseDto.setCidade(endereco.getCidade());
		enderecoResponseDto.setEstado(endereco.getEstado());
		enderecoResponseDto.setCep(endereco.getCep());
		return enderecoResponseDto;
	}
	
	public static EnderecoResponseDto from(EnderecoRequestDto enderecoRequest, CepResponseDto cepResponse) {
		EnderecoResponseDto enderecoResponseDto = new EnderecoResponseDto();
		enderecoResponseDto.setLogradouro(cepResponse.getLogradouro());
		enderecoResponseDto.setNumero(enderecoRequest.getNumero());
		enderecoResponseDto.setComplemento(enderecoRequest.getComplemento());
		enderecoResponseDto.setBairro(cepResponse.getBairro());
		enderecoResponseDto.setCidade(cepResponse.getLocalidade());
		enderecoResponseDto.setEstado(cepResponse.getUf());
		enderecoResponseDto.setCep(enderecoRequest.getCep());
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
