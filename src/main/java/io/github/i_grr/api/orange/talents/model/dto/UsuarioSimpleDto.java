package io.github.i_grr.api.orange.talents.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.i_grr.api.orange.talents.model.Usuario;

public class UsuarioSimpleDto {
	
	private Long id;
	
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O campo email é obrigatório")
	@Email(message = "O email informado não é válido")
	private String email;
	
	@NotBlank(message = "O campo CPF é obrigatório")
	@CPF(message = "O CPF informado não é válido")
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O campo data de nascimento é obrigatório")
	private LocalDate dataNascimento;
	
	public static UsuarioSimpleDto from(Usuario usuario) {
		UsuarioSimpleDto usuarioSimpleDto = new UsuarioSimpleDto();
		usuarioSimpleDto.setId(usuario.getId());
		usuarioSimpleDto.setNome(usuario.getNome());
		usuarioSimpleDto.setEmail(usuario.getEmail());
		usuarioSimpleDto.setCpf(usuario.getCpf());
		usuarioSimpleDto.setDataNascimento(usuario.getDataNascimento());
		return usuarioSimpleDto;
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
	
}
