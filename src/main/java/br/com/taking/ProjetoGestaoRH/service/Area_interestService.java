package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Area_interest;

public interface Area_interestService {
	
    List<Area_interest> listar();
	
	Area_interest incluir(Area_interest areaInteresse);
	
	Area_interest ObterPorId(int id);
	
	Area_interest Atualizar(int id, Area_interest areaInteresseNew);
	
	void Deletar (int id);

}