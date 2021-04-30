package io.github.i_grr.api.orange.talents.model.dto.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.i_grr.api.orange.talents.model.Usuario;

public class UsuarioResponseDto {
	
	private Long id;
	
	private String nome;
	
	private String email;

	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private List<EnderecoResponseDto> enderecos = new ArrayList<>();
	
	public static UsuarioResponseDto from(Usuario usuario) {
		UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
		usuarioResponseDto.setId(usuario.getId());
		usuarioResponseDto.setNome(usuario.getNome());
		usuarioResponseDto.setEmail(usuario.getEmail());
		usuarioResponseDto.setCpf(usuario.getCpf());
		usuarioResponseDto.setDataNascimento(usuario.getDataNascimento());
		usuarioResponseDto.setEnderecos(usuario.getEnderecos().stream().map(EnderecoResponseDto::from).collect(Collectors.toList()));
		return usuarioResponseDto;
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

	public List<EnderecoResponseDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoResponseDto> enderecos) {
		this.enderecos = enderecos;
	}
	
}
