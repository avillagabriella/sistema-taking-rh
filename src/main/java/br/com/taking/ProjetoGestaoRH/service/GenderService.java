package br.com.taking.ProjetoGestaoRH.service;

import java.util.List;


import br.com.taking.ProjetoGestaoRH.model.Gender;

public interface GenderService {
	
	List<Gender> listarTodos();
	
	
    Gender incluir(Gender candidato);
	
	Gender obterPorId(int id);
	
    Gender atualizar(int id, Gender genderNew);
	
	void deletar (int id);
	
	
 

}


