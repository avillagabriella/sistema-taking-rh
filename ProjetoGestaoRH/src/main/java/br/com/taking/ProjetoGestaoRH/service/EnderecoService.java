package br.com.taking.ProjetoGestaoRH.service;

import br.com.taking.ProjetoGestaoRH.service.dto.EnderecoDto;

public interface EnderecoService {

	EnderecoDto obterPorCep(String cep);
	
}
