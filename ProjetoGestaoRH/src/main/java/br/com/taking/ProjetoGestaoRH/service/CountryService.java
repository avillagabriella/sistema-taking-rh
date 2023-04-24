package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Country;

public interface CountryService {
	
	List<Country> listarTodos();
	
	Country incluir (Country country);
	
	Country obterPorId(int id);
	
	Country atualizar(int id, Country countryNew);
	
	void deletar (int id);


}
