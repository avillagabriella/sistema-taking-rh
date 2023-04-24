package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Disability_type;

public interface Disability_typeService {
	
	List<Disability_type> listarTodos();
	
   Disability_type incluir(Disability_type  disabilityType);
	
   Disability_type  obterPorId(int id);
	
   Disability_type  atualizar(int id, Disability_type  disabilityTypeNew);
	
	void deletar (int id);


}
