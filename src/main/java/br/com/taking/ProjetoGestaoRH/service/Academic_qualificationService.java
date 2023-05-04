package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;
import br.com.taking.ProjetoGestaoRH.model.Academic_qualification;

public interface Academic_qualificationService {
	
	List<Academic_qualification> listarTodos();
	
   Academic_qualification incluir(Academic_qualification academic);
	
	Academic_qualification obterPorId(int id);
	
	Academic_qualification atualizar(int id, Academic_qualification academicNew);
	
	void deletar(int id);

}
