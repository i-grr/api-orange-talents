package io.github.i_grr.api.orange.talents.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.github.i_grr.api.orange.talents.model.dto.request.UsuarioRequestDto;
import io.github.i_grr.api.orange.talents.model.dto.response.UsuarioResponseDto;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Column(name = "email_uk", nullable = false, unique = true)
	private String email;
	
	@Column(name = "cpf_uk", nullable = false, unique = true, length = 11)
	private String cpf;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@OneToMany(fetch = FetchType.LAZY,
			   cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "usuario_id")
	private List<Endereco> enderecos = new ArrayList<>();

	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}
	
	public static Usuario from(UsuarioRequestDto usuarioRequest) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioRequest.getNome());
		usuario.setEmail(usuarioRequest.getEmail());
		usuario.setCpf(usuarioRequest.getCpf());
		usuario.setDataNascimento(usuarioRequest.getDataNascimento());
		return usuario;
	}
	
	public static Usuario from(UsuarioResponseDto usuarioResponse) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioResponse.getId());
		usuario.setNome(usuarioResponse.getNome());
		usuario.setEmail(usuarioResponse.getEmail());
		usuario.setCpf(usuarioResponse.getCpf());
		usuario.setDataNascimento(usuarioResponse.getDataNascimento());
		return usuario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
