package io.github.i_grr.api.orange.talents.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.i_grr.api.orange.talents.model.dto.response.CepResponseDto;

@FeignClient(name = "cepService", url = "https://viacep.com.br/ws")
public interface CepService {

	@RequestMapping("/{cep}/json")
	CepResponseDto getCepResponseDto(@PathVariable final String cep);
	
}
