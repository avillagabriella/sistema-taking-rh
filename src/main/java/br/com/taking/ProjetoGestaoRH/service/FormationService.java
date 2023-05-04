package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Formation;

public interface FormationService {
	
	List<Formation> listarTodos();
	
	
	   Formation incluir (Formation formation);
		
		Formation obterPorId(int id);
		
		Formation atualizar(int id, Formation formationNew);
		
		void deletar (int id);

}
