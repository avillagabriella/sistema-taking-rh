package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import br.com.taking.ProjetoGestaoRH.model.WorkExperience;

public interface WorkExperienceService {

	List<WorkExperience> listarTodos();
		
	WorkExperience incluir(WorkExperience workExperience);
	
	WorkExperience obterPorId(int id);
	
	WorkExperience atualizar(int id, WorkExperience workExperienceNew);
	
	void deletar (int id);


	
}
