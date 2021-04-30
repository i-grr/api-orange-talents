package io.github.i_grr.api.orange.talents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.github.i_grr.api.orange.talents.model.dto.response.EnderecoResponseDto;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String logradouro;
	
	@Column(nullable = false, length = 8)
	private String numero;
	
	private String complemento;
	
	@Column(nullable = false, length = 50)
	private String bairro;
	
	@Column(nullable = false, length = 50)
	private String cidade;
	
	@Column(nullable = false, length = 50)
	private String estado;
	
	@Column(nullable = false, length = 8)
	private String cep;
	
	@ManyToOne
	private Usuario usuario;
	
	// Métodos Getters e Setters
	
	public static Endereco from(EnderecoResponseDto enderecoResponse) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(enderecoResponse.getLogradouro());
		endereco.setNumero(enderecoResponse.getNumero());
		endereco.setComplemento(enderecoResponse.getComplemento());
		endereco.setBairro(enderecoResponse.getBairro());
		endereco.setCidade(enderecoResponse.getCidade());
		endereco.setEstado(enderecoResponse.getEstado());
		endereco.setCep(enderecoResponse.getCep());
		return endereco;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
