package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;

import br.com.taking.ProjetoGestaoRH.model.Languages;
public interface LanguagesService {
	
	List<Languages> listarTodos();
	
    Languages incluir(Languages languages);
	
	Languages obterPorId(int id);
	
	Languages atualizar(int id, Languages languagesNew);
	
	void deletar (int id);



}
