package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import br.com.taking.ProjetoGestaoRH.model.City;

public interface CityService {
	
	List<City> listarTodos();

	City incluir(City city);
	
	City obterPorId(int id);
	
	City atualizar(int id, City cityNew);
	
	void deletar (int id);


}
