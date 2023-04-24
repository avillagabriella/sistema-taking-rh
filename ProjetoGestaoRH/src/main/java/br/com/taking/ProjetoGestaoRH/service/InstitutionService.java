package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Institution;

public interface InstitutionService {
	
	List<Institution> listarTodos();
	
    Institution incluir(Institution institution);
	
    Institution obterPorId(int id);
	
    Institution atualizar(int id, Institution  institutionNew);
	
	void deletar (int id);


}
