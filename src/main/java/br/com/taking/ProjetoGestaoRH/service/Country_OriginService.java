package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;


import br.com.taking.ProjetoGestaoRH.model.Country_Origin;

public interface Country_OriginService {
	
	List<Country_Origin> listarTodos();
	
    Country_Origin incluir(Country_Origin country);
	
    Country_Origin  obterPorId(int id);
	
    Country_Origin atualizar(int id,  Country_Origin countryNew);
	
	void deletar (int id);


}
