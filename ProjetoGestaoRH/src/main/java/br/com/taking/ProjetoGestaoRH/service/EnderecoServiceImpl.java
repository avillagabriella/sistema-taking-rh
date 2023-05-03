package br.com.taking.ProjetoGestaoRH.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.taking.ProjetoGestaoRH.service.dto.EnderecoDto;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    
	
	
	
	@Override
	public EnderecoDto obterPorCep(String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://viacep.com.br/ws/{cepUrl}/json";
		Map<String, String> parametros = new HashMap<>();
		parametros.put("cepUrl", cep);
	    EnderecoDto dto = restTemplate.getForObject(url, EnderecoDto.class, parametros);
		
		  return dto;
	}

	
}
