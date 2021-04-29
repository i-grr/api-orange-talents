package io.github.i_grr.api.orange.talents.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.i_grr.api.orange.talents.model.Endereco;
import io.github.i_grr.api.orange.talents.model.Usuario;
import io.github.i_grr.api.orange.talents.model.dto.EnderecoDto;
import io.github.i_grr.api.orange.talents.model.dto.UsuarioDto;
import io.github.i_grr.api.orange.talents.model.dto.UsuarioSimpleDto;
import io.github.i_grr.api.orange.talents.model.dto.request.EnderecoRequestDto;
import io.github.i_grr.api.orange.talents.model.dto.request.UsuarioRequestDto;
import io.github.i_grr.api.orange.talents.model.dto.response.CepResponseDto;
import io.github.i_grr.api.orange.talents.model.dto.response.EnderecoResponseDto;
import io.github.i_grr.api.orange.talents.service.CepService;
import io.github.i_grr.api.orange.talents.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuarios")
@Api(value = "API REST Usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final CepService cepService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService, CepService cepService) {
		this.usuarioService = usuarioService;
		this.cepService = cepService;
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra um usuário")
	public ResponseEntity<UsuarioSimpleDto> addUsuario(@RequestBody @Valid final UsuarioRequestDto usuarioRequestDto) {
		Usuario usuario = usuarioService.addUsuario(Usuario.from(usuarioRequestDto));
		return new ResponseEntity<>(UsuarioSimpleDto.from(usuario), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Retorna um usuário e seus endereços através do id")
	@GetMapping(value = "{id}")
	public ResponseEntity<UsuarioDto> getUsuario(@PathVariable final Long id) {
		Usuario usuarios = usuarioService.getUsuario(id);
		return new ResponseEntity<>(UsuarioDto.from(usuarios), HttpStatus.OK);
	}
	
	@PostMapping(value = "{usuarioId}/enderecos")
	@ApiOperation(value = "Cadastra um endereço em um usuário através do seu id")
	public ResponseEntity<EnderecoResponseDto> addEnderecoToUsuario(@PathVariable final Long usuarioId,
														    @RequestBody @Valid final EnderecoRequestDto enderecoRequest) {
		CepResponseDto cepResponse = cepService.getCepResponseDto(enderecoRequest.getCep());
		EnderecoDto enderecoDto = EnderecoDto.from(enderecoRequest, cepResponse);
		usuarioService.addEnderecosToUsuario(usuarioId, Endereco.from(enderecoDto));
		return new ResponseEntity<>(EnderecoResponseDto.from(enderecoDto), HttpStatus.CREATED);
	}
	
}
